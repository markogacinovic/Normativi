package forme.artikli;

import JPA.ArtikliJpaController;
import JPA.GrupenormativaJpaController;
import JPA.JedinicemereJpaController;
import JPA.NormativiJpaController;
import JPA.NormativizaartikalJpaController;
import JPA.exceptions.NonexistentEntityException;
import entitiKlase.Artikli;
import entitiKlase.Grupenormativa;
import entitiKlase.Jedinicemere;
import entitiKlase.Normativi;
import entitiKlase.Normativizaartikal;
import entitiKlase.NormativizaartikalPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ifUnosArtikla extends javax.swing.JInternalFrame {

    EntityManagerFactory emf;

    public ifUnosArtikla() {
        initComponents();
    }

    public ifUnosArtikla(EntityManagerFactory poslatiEmf) {
        initComponents();
        emf = poslatiEmf;
        prepuniKomboG();
        prepuniKomboN();
        obrisiTabelu();
    }

    public ifUnosArtikla(EntityManagerFactory poslatiEmf, String sifraArtikla) {
        //slučaj kada se dolazi iz pregleda svih artikala
        initComponents();
        emf = poslatiEmf;
        prepuniKomboG();
        prepuniKomboN();
        obrisiTabelu();
        txtSifra.setText(sifraArtikla); 
        bntUcitajActionPerformed(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNormativi = new javax.swing.JTable();
        lblGrupaNormativa = new javax.swing.JLabel();
        cbGrupaNormativa = new javax.swing.JComboBox();
        lblSifraNormativa = new javax.swing.JLabel();
        cbSifraNormativa = new javax.swing.JComboBox();
        lblKolicina = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodajNormativ = new javax.swing.JButton();
        btnIzbaci = new javax.swing.JButton();
        lblJM = new javax.swing.JLabel();
        btnSnimi = new javax.swing.JButton();
        bntUcitaj = new javax.swing.JButton();
        btnStorniraj = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Unos artikla");

        lblSifra.setLabelFor(txtSifra);
        lblSifra.setText("Šifra");

        lblNaziv.setLabelFor(txtNaziv);
        lblNaziv.setText("Naziv");

        tbNormativi.setAutoCreateRowSorter(true);
        tbNormativi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Šifra", "Grupa", "Naziv", "Količina", "JM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbNormativi);

        lblGrupaNormativa.setLabelFor(cbGrupaNormativa);
        lblGrupaNormativa.setText("Grupa normativa");

        cbGrupaNormativa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGrupaNormativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGrupaNormativaActionPerformed(evt);
            }
        });

        lblSifraNormativa.setText("Šifra normativa");

        cbSifraNormativa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSifraNormativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSifraNormativaActionPerformed(evt);
            }
        });

        lblKolicina.setText("Količina normativa u artiklu");

        btnDodajNormativ.setText("Dodaj normativ");
        btnDodajNormativ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNormativActionPerformed(evt);
            }
        });

        btnIzbaci.setText("Izbaci normativ");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        lblJM.setText("JM");

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        bntUcitaj.setText("Učitaj");
        bntUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUcitajActionPerformed(evt);
            }
        });

        btnStorniraj.setText("Storniraj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSifra)
                            .addComponent(lblNaziv))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntUcitaj, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnStorniraj, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGrupaNormativa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbGrupaNormativa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSifraNormativa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSifraNormativa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblKolicina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJM))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSnimi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajNormativ, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIzbaci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifra)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntUcitaj)
                    .addComponent(btnStorniraj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrupaNormativa)
                    .addComponent(cbGrupaNormativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSifraNormativa)
                    .addComponent(cbSifraNormativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKolicina)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajNormativ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzbaci))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSnimi)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbGrupaNormativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGrupaNormativaActionPerformed
        prepuniKomboN();
    }//GEN-LAST:event_cbGrupaNormativaActionPerformed

    private void cbSifraNormativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSifraNormativaActionPerformed
        if (cbSifraNormativa.getSelectedIndex() != -1)
        {
            NormativiJpaController kont = new NormativiJpaController(emf);
            Normativi n = kont.findNormativPoSifri(cbSifraNormativa.getSelectedItem().toString());
            JedinicemereJpaController kontJM = new JedinicemereJpaController(emf);
            Jedinicemere j = kontJM.findJedinicemere(n.getIdJediniceMere());
            lblJM.setText(j.getNaziv());
        }
    }//GEN-LAST:event_cbSifraNormativaActionPerformed

    private void btnDodajNormativActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNormativActionPerformed
        Double kolicina = 0.00;
        try
        {
            kolicina = Double.parseDouble(txtKolicina.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Količina nije u pravilnom formatu!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        NormativiJpaController kont = new NormativiJpaController(emf);
        Normativi n = kont.findNormativPoSifri(cbSifraNormativa.getSelectedItem().toString());
        
        int index = imaID(n.getId());
        
        if (index != -1)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Taj normativ je već dodat! Da li želite da saberete količine?", "Upozorenje!",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
                double pom1 = Double.parseDouble(model.getValueAt(index, 4).toString());
                kolicina = kolicina + pom1;
                model.setValueAt(kolicina, index, 4);
                return;
            }
            return;
        }
        
        JedinicemereJpaController kontJM = new JedinicemereJpaController(emf);
        Jedinicemere j = kontJM.findJedinicemere(n.getIdJediniceMere());
        
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        model.addRow(new Object[]{n.getId(), n.getSifra(), cbGrupaNormativa.getSelectedItem().toString(), n.getNaziv(), kolicina,j.getNaziv()});
    }//GEN-LAST:event_btnDodajNormativActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        int izabraniRed = tbNormativi.convertRowIndexToModel(tbNormativi.getSelectedRow());
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati normativ koji želite da izbacite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        model.removeRow(izabraniRed);
    }//GEN-LAST:event_btnIzbaciActionPerformed

    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        if (txtNaziv.getText().equals("") || txtSifra.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Morate uneti naziv i šifru artikla!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        if(model.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Morate uneti minimum jedan normativ artikla!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArtikliJpaController kont = new ArtikliJpaController(emf);
        Artikli a = new Artikli();
        a.setNaziv(txtNaziv.getText());
        a.setSifra(txtSifra.getText());
        
        NormativizaartikalJpaController kontNA = new NormativizaartikalJpaController(emf);
        //treba mi provera da li već postoji taj artikal, ako postoji da ponudi izmenu
        Artikli aStari = kont.findArtikalPoSifri(a.getSifra());
        if (aStari != null)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Artikal sa tom šifrom već postoji. Da li želite da ga izmenite?", "Upozorenje!",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                aStari.setNaziv(txtNaziv.getText());
                try {
                    kont.edit(aStari);
                } catch (Exception ex) {
                    Logger.getLogger(ifUnosArtikla.class.getName()).log(Level.SEVERE, null, ex);
                }
                //potrebno je iz baze izbrisati sve postojeće veze artikla sa normativima i posle dodati nove
                brisiNormativeZaArtikal(aStari.getId());
                snimiNormativeZaArtikal(aStari.getId());
                JOptionPane.showMessageDialog(null, "Uspešno snimljen artikal!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            }
           
        }
        else
        {
            kont.create(a);
            snimiNormativeZaArtikal(a.getId());
            JOptionPane.showMessageDialog(null, "Uspešno unet novi artikal!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        }
                
    }//GEN-LAST:event_btnSnimiActionPerformed

    private void bntUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUcitajActionPerformed
        ArtikliJpaController kont = new ArtikliJpaController(emf);
        Artikli aStari = kont.findArtikalPoSifri(txtSifra.getText().trim());
        if (aStari != null)
        {
            txtSifra.setText(aStari.getSifra());
            txtNaziv.setText(aStari.getNaziv());

            NormativizaartikalJpaController kontNA = new NormativizaartikalJpaController(emf);
            List<Normativizaartikal> lnza = kontNA.findNormativiPoIDArtikla(aStari.getId());
            
            DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        
            NormativiJpaController kontN = new NormativiJpaController(emf);
            GrupenormativaJpaController kontG = new GrupenormativaJpaController(emf);
            JedinicemereJpaController kontJM = new JedinicemereJpaController(emf);
            
            obrisiTabelu();
        
            lnza.stream().forEach((nza) -> {
                    Normativi nor = kontN.findNormativi(nza.getNormativizaartikalPK().getIdnormativa());
                    Grupenormativa gn = kontG.findGrupenormativa(nor.getIdGrupe());
                    Jedinicemere jm = kontJM.findJedinicemere(nor.getIdJediniceMere());
                    model.addRow(new Object[]{nza.getNormativizaartikalPK().getIdnormativa(), nor.getSifra(), gn.getNaziv(), nor.getNaziv(), nza.getKolicina(),jm.getNaziv()});
            });
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ne postoji artikal sa tom šifrom!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntUcitajActionPerformed

    private void snimiNormativeZaArtikal(int idArtikla)
    {
        int i =0;
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        NormativizaartikalJpaController kontNA = new NormativizaartikalJpaController(emf);
        while (i <= model.getRowCount()-1)
        {
            Normativizaartikal na = new Normativizaartikal();
            NormativizaartikalPK naPK = new NormativizaartikalPK();
            int idNormativa = Integer.parseInt(model.getValueAt(i, 0).toString());
            naPK.setIdartikla(idArtikla);
            naPK.setIdnormativa(idNormativa);
            na.setNormativizaartikalPK(naPK);
            double kolicina = Double.parseDouble(model.getValueAt(i, 4).toString());
            BigDecimal bd = BigDecimal.valueOf(kolicina);
            na.setKolicina(bd);
            try {
                kontNA.create(na);
            } catch (Exception ex) {
                Logger.getLogger(ifUnosArtikla.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    
    private void brisiNormativeZaArtikal(int idArtikla)
    {
        NormativizaartikalJpaController kontNA = new NormativizaartikalJpaController(emf);
        List<Normativizaartikal> lnza = kontNA.findNormativiPoIDArtikla(idArtikla);
        lnza.stream().forEach((nza) -> {
            try {
                kontNA.destroy(nza.getNormativizaartikalPK());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ifUnosArtikla.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void prepuniKomboG() {
        GrupenormativaJpaController kont = new GrupenormativaJpaController(emf);
        List<Grupenormativa> lista = kont.findGrupenormativaEntities();
        cbGrupaNormativa.removeAllItems();
        lista.stream().forEach((grupa) -> {
            cbGrupaNormativa.addItem(grupa.getNaziv());
        });
    }
    
    private void prepuniKomboN() {
        if (cbGrupaNormativa.getSelectedIndex() != -1)
        {
            NormativiJpaController kont = new NormativiJpaController(emf);
            GrupenormativaJpaController kontG = new GrupenormativaJpaController(emf);
            Grupenormativa g = kontG.findGrupuNormativaPoNazivu(cbGrupaNormativa.getSelectedItem().toString());
            List<Normativi> lista = kont.findNormativiPoIDGrupe(g.getId());
            
            cbSifraNormativa.removeAllItems();
            List<String> lista2 = new ArrayList();
            lista.stream().forEach((normativ) -> {
                lista2.add(normativ.getSifra());
            });
            Collections.sort(lista2);
            lista2.stream().forEach((clan) -> {
                cbSifraNormativa.addItem(clan);
            });
        }
    }

    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    private int imaID(int id) {
        int izlaz = -1;
        boolean nadjen = false;
        int i = 0;
        int pom;
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntUcitaj;
    private javax.swing.JButton btnDodajNormativ;
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnSnimi;
    private javax.swing.JButton btnStorniraj;
    private javax.swing.JComboBox cbGrupaNormativa;
    private javax.swing.JComboBox cbSifraNormativa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGrupaNormativa;
    private javax.swing.JLabel lblJM;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JLabel lblSifraNormativa;
    private javax.swing.JTable tbNormativi;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSifra;
    // End of variables declaration//GEN-END:variables
}
