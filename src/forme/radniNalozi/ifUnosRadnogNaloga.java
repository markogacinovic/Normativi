package forme.radniNalozi;

import BL.Kontroler;
import JPA.ArtikliJpaController;
import JPA.ArtikliradnognalogaJpaController;
import JPA.KomitentiJpaController;
import JPA.RadninaloziJpaController;
import entitiKlase.Artikli;
import entitiKlase.Artikliradnognaloga;
import entitiKlase.ArtikliradnognalogaPK;
import entitiKlase.Komitenti;
import entitiKlase.Radninalozi;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ifUnosRadnogNaloga extends javax.swing.JInternalFrame {

    private EntityManagerFactory emf;
    private Radninalozi rn;
    
    public ifUnosRadnogNaloga() {
        initComponents();
    }
    
    public ifUnosRadnogNaloga(EntityManagerFactory emfPoslat) {
        initComponents();
        emf = emfPoslat;
        prepuniKomboKomitenti();
        prepuniKomboArtikli();
        obrisiTabelu();
        rn = new Radninalozi();
    }
    
    public ifUnosRadnogNaloga(EntityManagerFactory emfPoslat, String brojIzabranog) {
        initComponents();
        emf = emfPoslat;
        prepuniKomboKomitenti();
        prepuniKomboArtikli();
        obrisiTabelu();
        rn = new Radninalozi();
        txtBroj.setText(brojIzabranog);
        btnUcitajActionPerformed(null);        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKomitent = new javax.swing.JLabel();
        cbKomitent = new javax.swing.JComboBox();
        lblBroj = new javax.swing.JLabel();
        txtBroj = new javax.swing.JTextField();
        lblDatumIsporuke = new javax.swing.JLabel();
        txtDatumIsporuke = new javax.swing.JTextField();
        btnSnimi = new javax.swing.JButton();
        lblArtikal = new javax.swing.JLabel();
        cbArtikal = new javax.swing.JComboBox();
        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArtikli = new javax.swing.JTable();
        btnIzbaci = new javax.swing.JButton();
        btnStampa = new javax.swing.JButton();
        btnUcitaj = new javax.swing.JButton();
        lblDatumNaloga = new javax.swing.JLabel();
        txtDatumNaloga = new javax.swing.JTextField();
        lblSortiment = new javax.swing.JLabel();
        txtSortiment = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Unos radnog naloga");

        lblKomitent.setText("Komitent");

        cbKomitent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblBroj.setText("Broj");

        lblDatumIsporuke.setText("Datum isporuke");

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        lblArtikal.setText("Artikal");

        cbArtikal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblKolicina.setText("Količina");

        btnDodaj.setText("Dodaj red");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        tbArtikli.setAutoCreateRowSorter(true);
        tbArtikli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Šifra artikla", "Naziv artikla", "Količina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbArtikli);

        btnIzbaci.setText("Izbaci red");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        btnStampa.setText("Štampaj");
        btnStampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStampaActionPerformed(evt);
            }
        });

        btnUcitaj.setText("Učitaj");
        btnUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajActionPerformed(evt);
            }
        });

        lblDatumNaloga.setText("Datum naloga");

        lblSortiment.setText("Sortiment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzbaci, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSnimi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStampa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblBroj)
                                                .addComponent(lblDatumNaloga)
                                                .addComponent(lblKomitent))
                                            .addGap(12, 12, 12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblDatumIsporuke)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSortiment)
                                        .addGap(32, 32, 32)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDatumNaloga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(btnUcitaj, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbKomitent, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtSortiment)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblArtikal)
                                .addGap(13, 13, 13)
                                .addComponent(cbArtikal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblKolicina)
                                .addGap(18, 18, 18)
                                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBroj)
                    .addComponent(txtBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUcitaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumNaloga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumNaloga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKomitent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKomitent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumIsporuke))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSortiment)
                    .addComponent(txtSortiment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(lblArtikal)
                    .addComponent(cbArtikal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnIzbaci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSnimi)
                    .addComponent(btnStampa))
                .addGap(54, 54, 54))
        );

        lblDatumNaloga.getAccessibleContext().setAccessibleName("lblDatumNaloga");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        Kontroler kont = new Kontroler();
        if (!kont.ispravanDatum(txtDatumNaloga.getText()))
        {
            JOptionPane.showMessageDialog(null, "Datum naloga nije ispravan!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!kont.ispravanDatum(txtDatumIsporuke.getText()))
        {
            JOptionPane.showMessageDialog(null, "Datum isporuke nije ispravan!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
        int brojArtikala = model.getRowCount();
        if (brojArtikala == 0)
        {
            JOptionPane.showMessageDialog(null, "Morate uneti makar jedan artikal!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date datumNaloga = new Date();
        try {
            datumNaloga = format.parse(txtDatumNaloga.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ifUnosRadnogNaloga.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date rokIsporuke = new Date();
        try {
            rokIsporuke = format.parse(txtDatumIsporuke.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ifUnosRadnogNaloga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        KomitentiJpaController kontK = new KomitentiJpaController(emf);
        Komitenti kom = kontK.findKomitentaPoNazivu(cbKomitent.getSelectedItem().toString());

        List<Artikliradnognaloga> lARN = new ArrayList<>();
        for (int i=0; i<brojArtikala; i++)
        {
            Artikliradnognaloga aRN = new Artikliradnognaloga();
            ArtikliradnognalogaPK aRNkljuc = new ArtikliradnognalogaPK();
            int idArtikla = Integer.parseInt(model.getValueAt(i, 0).toString());
            aRNkljuc.setIdartikla(idArtikla);
            //setovanje id radnog naloga ce biti u samom kontroleru po insertu radnog naloga u bazu
            aRN.setArtikliradnognalogaPK(aRNkljuc);
            Double kolicina = Double.parseDouble(model.getValueAt(i, 3).toString());
            BigDecimal bd = BigDecimal.valueOf(kolicina);
            aRN.setKolicina(bd);   
            lARN.add(aRN);
        }
        
        rn.setBroj(txtBroj.getText());
        rn.setDatum(datumNaloga);
        rn.setRokIsporuke(rokIsporuke);
        rn.setIdKomitenta(kom.getId());
        rn.setSortiment(txtSortiment.getText());
        
        //provera da li postoji radni nalog sa tim brojem
        RadninaloziJpaController kontRN = new RadninaloziJpaController(emf);
        Radninalozi rnStari = kontRN.findRadniNalogPoBroju(rn.getBroj());
        int izlaz = 0;
        
        if (rnStari != null)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Artikal sa tom šifrom već postoji. Da li želite da ga izmenite?", "Upozorenje!",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                rnStari.setDatum(datumNaloga);
                rnStari.setRokIsporuke(rokIsporuke);
                rnStari.setIdKomitenta(kom.getId());
                rnStari.setSortiment(txtSortiment.getText());
                
                izlaz = kont.updateRadnogNaloga(emf, rnStari, lARN);
            }
        }
        else
        {
            izlaz = kont.snimiRadniNalog(emf, rn, lARN) ;            
        }     
        if (izlaz != 0)
        {
            JOptionPane.showMessageDialog(null, "Greška prilikom snimanja radnog naloga! Podaci nisu snimljeni u bazu!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Uspešno snimljen radni nalog u bazu!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSnimiActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Double kolicina;
        try
        {
            kolicina = Double.parseDouble(txtKolicina.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Količina nije u pravilnom formatu!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArtikliJpaController kont = new ArtikliJpaController(emf);
        Artikli art = kont.findArtikalPoSifri(cbArtikal.getSelectedItem().toString());
        
        int index = imaID(art.getId());
        
        if (index != -1)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Taj artikal je već dodat! Da li želite da saberete količine?", "Upozorenje!",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
                double pom1 = Double.parseDouble(model.getValueAt(index, 3).toString());
                kolicina = kolicina + pom1;
                model.setValueAt(kolicina, index, 3);
                return;
            }
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
        model.addRow(new Object[]{art.getId(), art.getSifra(), art.getNaziv(), kolicina});
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        int izabraniRed = tbArtikli.convertRowIndexToModel(tbArtikli.getSelectedRow());
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati normativ koji želite da izbacite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
        model.removeRow(izabraniRed);
    }//GEN-LAST:event_btnIzbaciActionPerformed

    private void btnStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStampaActionPerformed
        if (rn.getId() == null)
        {
            JOptionPane.showMessageDialog(null, "Morate prvo snimiti radni nalog da bi ga štampali!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        HashMap hm = new HashMap();
        hm.put("pIdRadnogNaloga", rn.getId());
        
        Kontroler kont = new Kontroler();
        
        kont.stampajIzvestaj("radniNalog", hm);
    }//GEN-LAST:event_btnStampaActionPerformed

    private void btnUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajActionPerformed
        Kontroler kont = new Kontroler();
        RadninaloziJpaController kontRN = new RadninaloziJpaController(emf);
        rn = kontRN.findRadniNalogPoBroju(txtBroj.getText().trim());
        if (rn != null)
        {
            txtDatumNaloga.setText(kont.vratiDatumUNasemFormatu(rn.getDatum()));
            txtDatumIsporuke.setText(kont.vratiDatumUNasemFormatu(rn.getRokIsporuke()));
            txtSortiment.setText(rn.getSortiment());
            KomitentiJpaController kontK = new KomitentiJpaController(emf);
            Komitenti k = kontK.findKomitenti(rn.getIdKomitenta());
            cbKomitent.setSelectedItem(k.getNaziv());
            
            ArtikliradnognalogaJpaController kontARN = new ArtikliradnognalogaJpaController(emf);
            List<Artikliradnognaloga> lARN = kontARN.findArtikleNaloga(rn.getId());
            
            DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
            
            ArtikliJpaController kontA = new ArtikliJpaController(emf);
            
            obrisiTabelu();
        
            lARN.stream().forEach((arn) -> {                    
                    Artikli a = kontA.findArtikli(arn.getArtikliradnognalogaPK().getIdartikla());
                    model.addRow(new Object[]{arn.getArtikliradnognalogaPK().getIdartikla(), a.getSifra(), a.getNaziv(), arn.getKolicina()});
            });
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ne postoji radni nalog sa tim brojem!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUcitajActionPerformed


    private void prepuniKomboKomitenti() {
        KomitentiJpaController kont = new KomitentiJpaController(emf);
        List<Komitenti> lista = kont.findKomitentiEntities();
        cbKomitent.removeAllItems();
        lista.stream().forEach((komitent) -> {
            cbKomitent.addItem(komitent.getNaziv());
        });
    }
    
    private void prepuniKomboArtikli() {
        ArtikliJpaController kont = new ArtikliJpaController(emf);
        List<Artikli> lista = kont.findArtikliEntities();
        cbArtikal.removeAllItems();
        List<String> lista2 = new ArrayList();
        lista.stream().forEach((artikal) -> {
            lista2.add(artikal.getSifra());
        });
        Collections.sort(lista2);
        lista2.stream().forEach((clan) -> {
            cbArtikal.addItem(clan);
        });
    }
    
    private int imaID(int id) {
        int izlaz = -1;
        boolean nadjen = false;
        int i = 0;
        int pom;
        DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
        while (i <= model.getRowCount()-1 && !nadjen) {
            pom = Integer.parseInt(model.getValueAt(i, 0).toString());
            if (pom == id) {
                nadjen = true;
                izlaz = i;
            }
            i++;
        }
        return izlaz;
    }
    
    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tbArtikli.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnSnimi;
    private javax.swing.JButton btnStampa;
    private javax.swing.JButton btnUcitaj;
    private javax.swing.JComboBox cbArtikal;
    private javax.swing.JComboBox cbKomitent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArtikal;
    private javax.swing.JLabel lblBroj;
    private javax.swing.JLabel lblDatumIsporuke;
    private javax.swing.JLabel lblDatumNaloga;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblKomitent;
    private javax.swing.JLabel lblSortiment;
    private javax.swing.JTable tbArtikli;
    private javax.swing.JTextField txtBroj;
    private javax.swing.JTextField txtDatumIsporuke;
    private javax.swing.JTextField txtDatumNaloga;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtSortiment;
    // End of variables declaration//GEN-END:variables
}
