package forme.komitenti;

import JPA.KomitentiJpaController;
import entitiKlase.Komitenti;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

public class ifNoviKomitent extends javax.swing.JInternalFrame {

    EntityManagerFactory emf;

    public ifNoviKomitent() {
        initComponents();
        this.getRootPane().setDefaultButton(btnSnimi);
    }
    
    public ifNoviKomitent(EntityManagerFactory emfPoslat) {
        initComponents();
        this.getRootPane().setDefaultButton(btnSnimi);
        emf = emfPoslat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        lblAdresa = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtAdresa = new javax.swing.JTextField();
        btnSnimi = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Novi komitent");

        lblNaziv.setText("Naziv");

        lblAdresa.setText("Adresa");

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNaziv)
                    .addComponent(lblAdresa))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSnimi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNaziv)
                        .addComponent(txtAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSnimi)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        if(txtNaziv.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Morate uneti naziv komitenta!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Komitenti komitent = new Komitenti();
        komitent.setNaziv(txtNaziv.getText());
        komitent.setAdresa(txtAdresa.getText());
        try
        {
            KomitentiJpaController kont = new KomitentiJpaController(emf);
            kont.create(komitent);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Komitent nije snimljen!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Uspešno snimljen novi komitent.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        txtNaziv.setText("");
        txtAdresa.setText("");
        txtNaziv.requestFocus();
    }//GEN-LAST:event_btnSnimiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnimi;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}
