package forme.artikli;

import JPA.ArtikliJpaController;
import entitiKlase.Artikli;
import forme.glavnaForma;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ifArtikli extends javax.swing.JInternalFrame {

    private EntityManagerFactory emf;

    public ifArtikli() {
        initComponents();
    }
    
    public ifArtikli(EntityManagerFactory emfPoslat) {
        initComponents();
        emf = emfPoslat;
        prepuniTabelu();
        tabArtikli.getColumn("ID").setPreferredWidth(10);
        tabArtikli.getColumn("Šifra").setPreferredWidth(100);
        tabArtikli.getColumn("Naziv").setPreferredWidth(400);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabArtikli = new javax.swing.JTable();
        btnOsvezi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Svi artikli");

        tabArtikli.setAutoCreateRowSorter(true);
        tabArtikli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Šifra", "Naziv"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabArtikli);

        btnOsvezi.setText("Osveži");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnOsvezi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzmeni)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        prepuniTabelu();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int izabraniRed = tabArtikli.getSelectedRow();
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati red koji želite da izmenite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sifraIzabranog;
        try
        {
            sifraIzabranog = tabArtikli.getValueAt(izabraniRed, 1).toString();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Greška ID nije ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ifUnosArtikla ua = new ifUnosArtikla(emf, sifraIzabranog);
        ua.setVisible(true);

        this.getDesktopPane().add(ua);
        ua.moveToFront();
        try {
            ua.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void prepuniTabelu() {
        ArtikliJpaController kont = new ArtikliJpaController(emf);
        List<Artikli> lista = kont.findArtikliEntities();
        DefaultTableModel model = (DefaultTableModel) tabArtikli.getModel();
        obrisiTabelu();
        lista.stream().forEach((artikal) -> {
            model.addRow(new Object[]{artikal.getId(), artikal.getSifra(), artikal.getNaziv()});
        });
    }
    
        
    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tabArtikli.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabArtikli;
    // End of variables declaration//GEN-END:variables
}
