package forme.komitenti;

import JPA.KomitentiJpaController;
import entitiKlase.Komitenti;
import forme.glavnaForma;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ifKomitenti extends javax.swing.JInternalFrame {

    private EntityManagerFactory emf;

    public ifKomitenti() {
        initComponents();
        prepuniTabelu();
        tabKomitenti.getColumn("ID").setPreferredWidth(10);
        tabKomitenti.getColumn("Naziv").setPreferredWidth(100);
        tabKomitenti.getColumn("Adresa").setPreferredWidth(400);        
    }
    
    public ifKomitenti(EntityManagerFactory emfPoslat) {
        initComponents();
        emf = emfPoslat;
        prepuniTabelu();
        tabKomitenti.getColumn("ID").setPreferredWidth(10);
        tabKomitenti.getColumn("Naziv").setPreferredWidth(100);
        tabKomitenti.getColumn("Adresa").setPreferredWidth(400);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabKomitenti = new javax.swing.JTable();
        btnOsvezi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Svi komitenti");

        tabKomitenti.setAutoCreateRowSorter(true);
        tabKomitenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naziv", "Adresa"
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
        jScrollPane1.setViewportView(tabKomitenti);

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
                    .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
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
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        prepuniTabelu();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int izabraniRed = tabKomitenti.getSelectedRow();
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati red koji želite da izmenite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idIzabranog = 0;
        try
        {
            idIzabranog = Integer.parseInt(tabKomitenti.getValueAt(izabraniRed, 0).toString());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Greška ID nije ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
               
        
        ifIzmeniKomitenta ik = new ifIzmeniKomitenta(idIzabranog, emf);
        ik.setVisible(true);
        
        this.getDesktopPane().add(ik);
        ik.moveToFront();
        try {
            ik.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void prepuniTabelu() {
        KomitentiJpaController kont = new KomitentiJpaController(emf);
        List<Komitenti> lista = kont.findKomitentiEntities();
        DefaultTableModel model = (DefaultTableModel) tabKomitenti.getModel();
        obrisiTabelu();
        lista.stream().forEach((komitent) -> {
            model.addRow(new Object[]{komitent.getId(), komitent.getNaziv(), komitent.getAdresa()});
        });
    }
    
    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tabKomitenti.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabKomitenti;
    // End of variables declaration//GEN-END:variables
}
