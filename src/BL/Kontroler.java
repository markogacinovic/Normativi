package BL;

import JPA.ArtikliradnognalogaJpaController;
import JPA.RadninaloziJpaController;
import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Artikliradnognaloga;
import entitiKlase.ArtikliradnognalogaPK;
import entitiKlase.Radninalozi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import net.sf.jasperreports.engine.JasperCompileManager; //nije potrebno jer koristim vec iskompajliran jasper
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Kontroler {
    
    
    public boolean ispravanDatum(String poslatDatum)
    {
        Date datum;
        try
        {
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            datum = format.parse(poslatDatum);
        }
        catch(Exception e)
        { 
            return false;
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(datum);
        int month = cal.get(Calendar.MONTH) + 1; //da mi je znati zašto ovde vraća za jedan manje

        String dan = cal.get(Calendar.DAY_OF_MONTH) + "";
        if (dan.length()== 1)
        {
            dan = "0" + dan;
        }
        String mesec = month + "";
        if (mesec.length() == 1)
        {
            mesec = "0" + mesec; 
        }
        String pom = dan + "." + mesec + "." + cal.get(Calendar.YEAR);
        return pom.equals(poslatDatum);
    }
    
    public String vratiDatumUNasemFormatu(Date datum) {
        if (datum == null)
        {
            return "";
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(datum);
        int month = cal.get(Calendar.MONTH) + 1; //da mi je znati zašto ovde vraća za jedan manje

        String dan = cal.get(Calendar.DAY_OF_MONTH) + "";
        if (dan.length()== 1)
        {
            dan = "0" + dan;
        }
        String mesec = month + "";
        if (mesec.length() == 1)
        {
            mesec = "0" + mesec; 
        }
        String pom = dan + "." + mesec + "." + cal.get(Calendar.YEAR);

        return pom;
    }
    
    public int stampajIzvestaj(String izvestaj, HashMap hm)
    {
        try {           
            
            String folderSaIzvestajima = "C:\\Programi\\Normativi\\rpt\\";
            String folderExportPDF = "C:\\Programi\\Normativi\\PDF\\";
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String ts = sdf.format(timestamp);
                       
            String jrxmlFileName = folderSaIzvestajima + izvestaj + ".jrxml";
            String jasperFileName = folderSaIzvestajima + izvestaj + ".jasper";
            String pdfFileName = folderExportPDF + ts + izvestaj + ".pdf";

            //nema potrebe da se compile-ira svaki put
            //JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);

            String dbUrl = "jdbc:mysql://localhost:3306/bs_sistem?zeroDateTimeBehavior=convertToNull&amp;useUnicode=yes&amp;characterEncoding=UTF-8";
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbUname = "root";
            String dbPwd = "";

            Class.forName(dbDriver);
            Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

            JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);

            JasperViewer.viewReport(jprint, false);

            JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);

           } catch (Exception e) {
            return 1;
        }
        return 0;
    }
    
    public int snimiRadniNalog(EntityManagerFactory emf, Radninalozi rn, List<Artikliradnognaloga> lARN) {
        int izlaz = 0;
        EntityManager em = emf.createEntityManager();
          
        RadninaloziJpaController kontRN = new RadninaloziJpaController(emf); 
        try
        {
            kontRN.create(rn);
            em.getTransaction().begin();      
            ArtikliradnognalogaJpaController kontARN = new ArtikliradnognalogaJpaController(emf);
            lARN.stream().forEach((arn) -> {
                ArtikliradnognalogaPK kljuc = arn.getArtikliradnognalogaPK();
                kljuc.setIdradnognaloga(rn.getId());
                arn.setArtikliradnognalogaPK(kljuc);
                kontARN.create(arn, em);
            });
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            try {
                kontRN.destroy(rn.getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
            em.getTransaction().rollback();
            rn.setId(null);
            izlaz = 1;
        }
        finally
        {
            if (em != null) {
                em.close();
            }
        }
        return izlaz;
    }
    
    public int updateRadnogNaloga(EntityManagerFactory emf, Radninalozi rn, List<Artikliradnognaloga> lARN) {
        int izlaz = 0;
        EntityManager em = emf.createEntityManager();
          
        RadninaloziJpaController kontRN = new RadninaloziJpaController(emf); 
        try
        {
            em.getTransaction().begin();  
            kontRN.edit(rn, em);
               
            ArtikliradnognalogaJpaController kontARN = new ArtikliradnognalogaJpaController(emf);
            
            //brisanje starih
            List<Artikliradnognaloga> lARNStari = kontARN.findArtikleNaloga(rn.getId());
            StringBuilder greska = new StringBuilder ();
            lARNStari.stream().forEach((arn) -> {
                kontARN.destroy(greska, arn.getArtikliradnognalogaPK(), em);
            });
            
            if (greska.length()==0)
            {
                em.getTransaction().commit();
                //insert novih
                em.getTransaction().begin();
                lARN.stream().forEach((arn) -> {
                    ArtikliradnognalogaPK kljuc = arn.getArtikliradnognalogaPK();
                    kljuc.setIdradnognaloga(rn.getId());
                    arn.setArtikliradnognalogaPK(kljuc);
                    kontARN.create(arn, em);
                });
                em.getTransaction().commit();
            }
            else
            {
                em.getTransaction().rollback();
                izlaz = 1;
            }
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            izlaz = 1;
        }
        finally
        {
            if (em != null) {
                em.close();
            }
        }
        return izlaz;
    }
            
}
