package forme.radniNalozi;

import BL.Kontroler;
import JPA.KomitentiJpaController;
import JPA.RadninaloziJpaController;
import entitiKlase.Radninalozi;
import forme.glavnaForma;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ifRadniNalozi extends javax.swing.JInternalFrame {

    EntityManagerFactory emf;
    
    public ifRadniNalozi() {
        initComponents();
    }

    public ifRadniNalozi(EntityManagerFactory emfPoslat) {
        initComponents();
        emf = emfPoslat;
        prepuniTabelu();
        tbRadniNalozi.getColumn("ID").setPreferredWidth(30);
        tbRadniNalozi.getColumn("Broj").setPreferredWidth(80);
        tbRadniNalozi.getColumn("Kupac").setPreferredWidth(200);
        tbRadniNalozi.getColumn("Rok isporuke").setPreferredWidth(100);
        tbRadniNalozi.getColumn("Datum").setPreferredWidth(100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRadniNalozi = new javax.swing.JTable();
        btnOsvezi = new javax.swing.JButton();
        btnStampaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Svi radni nalozi");

        tbRadniNalozi.setAutoCreateRowSorter(true);
        tbRadniNalozi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Broj", "Kupac", "Rok isporuke", "Datum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbRadniNalozi);

        btnOsvezi.setText("Osveži");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        btnStampaj.setText("Štampaj");
        btnStampaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStampajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStampaj, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnOsvezi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIzmeni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStampaj)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        prepuniTabelu();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnStampajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStampajActionPerformed
        int izabraniRed = tbRadniNalozi.getSelectedRow();
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati radni nalog da bi ga štampali!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        HashMap hm = new HashMap();
        DefaultTableModel model = (DefaultTableModel) tbRadniNalozi.getModel();
        int idIzabranog = Integer.parseInt(model.getValueAt(izabraniRed, 0).toString());
        hm.put("pIdRadnogNaloga", idIzabranog);
        
        Kontroler kont = new Kontroler();
        
        kont.stampajIzvestaj("radniNalog", hm);
    }//GEN-LAST:event_btnStampajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int izabraniRed = tbRadniNalozi.getSelectedRow();
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati red koji želite da izmenite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String brojIzabranog;
        try
        {
            brojIzabranog = tbRadniNalozi.getValueAt(izabraniRed, 1).toString();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Greška!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ifUnosRadnogNaloga urn = new ifUnosRadnogNaloga(emf, brojIzabranog);
        urn.setVisible(true);

        this.getDesktopPane().add(urn);
        urn.moveToFront();
        try {
            urn.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

        
    private void prepuniTabelu() {
       
        RadninaloziJpaController kontRN = new RadninaloziJpaController(emf);
        List<Radninalozi> lista = kontRN.findRadninaloziEntities();
        KomitentiJpaController kontK = new KomitentiJpaController(emf);
        Kontroler k = new Kontroler();
        DefaultTableModel model = (DefaultTableModel) tbRadniNalozi.getModel();
        obrisiTabelu();
        lista.stream().forEach((rn) -> {
            model.addRow(new Object[]{rn.getId(), rn.getBroj(), kontK.findKomitenti(rn.getIdKomitenta()).getNaziv(), k.vratiDatumUNasemFormatu(rn.getRokIsporuke()), k.vratiDatumUNasemFormatu(rn.getDatum())});
        });
    }
    
    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tbRadniNalozi.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnStampaj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRadniNalozi;
    // End of variables declaration//GEN-END:variables
}
