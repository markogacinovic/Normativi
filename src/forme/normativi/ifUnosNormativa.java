package forme.normativi;

import JPA.GrupenormativaJpaController;
import JPA.JedinicemereJpaController;
import JPA.NormativiJpaController;
import entitiKlase.Grupenormativa;
import entitiKlase.Jedinicemere;
import entitiKlase.Normativi;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

public class ifUnosNormativa extends javax.swing.JInternalFrame {

    EntityManagerFactory emf;
    
    public ifUnosNormativa() {
        initComponents();
        prepuniKomboJM();
        prepuniKomboG();
        this.getRootPane().setDefaultButton(btnSnimi);       
    }
    
    public ifUnosNormativa(EntityManagerFactory emfPoslati) {
        initComponents();
        emf = emfPoslati;
        prepuniKomboJM();
        prepuniKomboG();
        this.getRootPane().setDefaultButton(btnSnimi);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblJedinicaMere = new javax.swing.JLabel();
        cbJediniceMere = new javax.swing.JComboBox();
        lblGrupa = new javax.swing.JLabel();
        cbGrupe = new javax.swing.JComboBox();
        btnSnimi = new javax.swing.JButton();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Unos normativa");

        lblSifra.setText("Šifra");

        txtSifra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSifraFocusLost(evt);
            }
        });

        lblNaziv.setText("Naziv");

        lblJedinicaMere.setText("Jedinica mere");

        cbJediniceMere.setEditable(true);

        lblGrupa.setText("Grupa");

        cbGrupe.setEditable(true);

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        lblCena.setText("Cena");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCena)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJedinicaMere)
                            .addComponent(lblSifra)
                            .addComponent(lblNaziv)
                            .addComponent(lblGrupa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbGrupe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCena)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSnimi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbJediniceMere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifra)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrupa)
                    .addComponent(cbGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJedinicaMere)
                    .addComponent(cbJediniceMere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCena)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSnimi)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        //prvo kontrolišemo unos
        String izabranaJM = cbJediniceMere.getEditor().getItem().toString().trim();
        String izabranaGrupa = cbGrupe.getEditor().getItem().toString().trim();
        if (txtSifra.getText().equals("") || txtNaziv.getText().equals("") || izabranaJM.equals("") || izabranaGrupa.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Niste uneli sve podatke!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean cenaOK = false;
        BigDecimal d = BigDecimal.valueOf(0.00);
        try
        {
           d = BigDecimal.valueOf(Double.parseDouble(txtCena.getText())); 
            cenaOK = true;
        }
        catch(Exception e)
        {
            //ovo nije strašna greška ako je prazan string
            if (!txtCena.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Cena nije uneta u pravilnom formatu!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //kraj kontrole unosa
        
        JedinicemereJpaController kontJM = new JedinicemereJpaController(emf);
        Jedinicemere jm = kontJM.findJedinicuMerePoNazivu(izabranaJM);
        
        if (jm == null)
        {
            jm = new Jedinicemere();
            jm.setNaziv(izabranaJM);
            kontJM.create(jm);
            prepuniKomboJM();
            cbJediniceMere.setSelectedItem(izabranaJM);
        }
        
        GrupenormativaJpaController kontGN = new GrupenormativaJpaController(emf);
        Grupenormativa gn = kontGN.findGrupuNormativaPoNazivu(izabranaGrupa);
        
        if (gn == null)
        {
            gn = new Grupenormativa();
            gn.setNaziv(izabranaGrupa);
            kontGN.create(gn);  
            prepuniKomboG();
            cbGrupe.setSelectedItem(izabranaGrupa);
        }
        
        Normativi n = new Normativi();
        n.setIdGrupe(gn.getId());
        n.setIdJediniceMere(jm.getId());
        n.setNaziv(txtNaziv.getText());
        n.setSifra(txtSifra.getText());
        if(cenaOK)
        {
            n.setCena(d); 
        }

        NormativiJpaController kont = new NormativiJpaController(emf);
        Normativi nStari = kont.findNormativPoSifri(n.getSifra());
        if (nStari != null)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Normativ sa tom šifrom već postoji! Da li želite da ga izmenite?", "Upozorenje!",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                //update

                n.setId(nStari.getId());
                try {
                    kont.edit(n);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Greška kod pamćenja izmene normativa!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Uspešno izmenjen normativ.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            return;
        }
                
        try
        {
            kont.create(n); 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Greška kod pamćenja normativa!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Uspešno zapamćen normativ.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);        
    }//GEN-LAST:event_btnSnimiActionPerformed

    private void txtSifraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSifraFocusLost
        NormativiJpaController kont = new NormativiJpaController(emf);
        Normativi nStari = kont.findNormativPoSifri(txtSifra.getText().trim());
        if (nStari != null)
        {
            txtSifra.setText(nStari.getSifra());
            txtNaziv.setText(nStari.getNaziv());
            try
            {
                txtCena.setText(nStari.getCena().toString());    
            }
            catch(Exception e)
            {
                //nije uneta cena
                txtCena.setText("");
            }
            JedinicemereJpaController kontJM = new JedinicemereJpaController(emf);
            Jedinicemere jm = kontJM.findJedinicemere(nStari.getIdJediniceMere());
            
            cbJediniceMere.setSelectedItem(jm.getNaziv());
            
            GrupenormativaJpaController kontGN = new GrupenormativaJpaController(emf);
            Grupenormativa gn = kontGN.findGrupenormativa(nStari.getIdGrupe());
            
            cbGrupe.setSelectedItem(gn.getNaziv());            
        }

    }//GEN-LAST:event_txtSifraFocusLost

    private void prepuniKomboJM() {
        JedinicemereJpaController kont = new JedinicemereJpaController(emf);
        List<Jedinicemere> lista = kont.findJedinicemereEntities();
        cbJediniceMere.removeAllItems();
        lista.stream().forEach((jedinicaMere) -> {
            cbJediniceMere.addItem(jedinicaMere.getNaziv());
        });
    }
    
    private void prepuniKomboG() {
        GrupenormativaJpaController kont = new GrupenormativaJpaController(emf);
        List<Grupenormativa> lista = kont.findGrupenormativaEntities();
        cbGrupe.removeAllItems();
        lista.stream().forEach((grupa) -> {
            cbGrupe.addItem(grupa.getNaziv());
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnimi;
    private javax.swing.JComboBox cbGrupe;
    private javax.swing.JComboBox cbJediniceMere;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblGrupa;
    private javax.swing.JLabel lblJedinicaMere;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSifra;
    // End of variables declaration//GEN-END:variables

  
}
