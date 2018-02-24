package forme.normativi;

import JPA.GrupenormativaJpaController;
import JPA.JedinicemereJpaController;
import JPA.NormativiJpaController;
import entitiKlase.Normativi;
import forme.glavnaForma;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ifNormativi extends javax.swing.JInternalFrame {

    private EntityManagerFactory emf;
    
    public ifNormativi() {
        initComponents();
        tbNormativi.getColumn("ID").setPreferredWidth(10);
        tbNormativi.getColumn("Šifra").setPreferredWidth(40);
        tbNormativi.getColumn("Grupa").setPreferredWidth(40);
        tbNormativi.getColumn("Naziv").setPreferredWidth(100);
        tbNormativi.getColumn("JM").setPreferredWidth(10);
        tbNormativi.getColumn("Cena").setPreferredWidth(40);
    }

    public ifNormativi(EntityManagerFactory emfPoslat) {
        initComponents();
        emf = emfPoslat;
        prepuniTabelu();
        tbNormativi.getColumn("ID").setPreferredWidth(10);
        tbNormativi.getColumn("Šifra").setPreferredWidth(80);
        tbNormativi.getColumn("Grupa").setPreferredWidth(140);
        tbNormativi.getColumn("Naziv").setPreferredWidth(240);
        tbNormativi.getColumn("JM").setPreferredWidth(10);
        tbNormativi.getColumn("Cena").setPreferredWidth(10);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbNormativi = new javax.swing.JTable();
        btnOsvezi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Svi normativi");

        tbNormativi.setAutoCreateRowSorter(true);
        tbNormativi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Šifra", "Grupa", "Naziv", "JM", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbNormativi);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOsvezi, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnOsvezi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzmeni)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        prepuniTabelu();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int izabraniRed = tbNormativi.getSelectedRow();
        if (izabraniRed == -1)
        {
            JOptionPane.showMessageDialog(null, "Morate izabrati red koji želite da izmenite!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int idIzabranog = 0;
        try
        {
            idIzabranog = Integer.parseInt(tbNormativi.getValueAt(izabraniRed, 0).toString());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Greška ID nije ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
               
        
        ifIzmeniNormativ in = new ifIzmeniNormativ(idIzabranog, emf);
        in.setVisible(true);
        
        this.getDesktopPane().add(in);
        in.moveToFront();
        try {
            in.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    
    private void prepuniTabelu() {
        NormativiJpaController kont = new NormativiJpaController(emf);
        JedinicemereJpaController jmKont = new JedinicemereJpaController(emf); 
        GrupenormativaJpaController gnKont = new GrupenormativaJpaController(emf);
        List<Normativi> lista = kont.findNormativiEntities();
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        obrisiTabelu();
        lista.stream().forEach((normativ) -> {
            model.addRow(new Object[]{normativ.getId(), normativ.getSifra(), gnKont.findGrupenormativa(normativ.getIdGrupe()).getNaziv(), normativ.getNaziv(), jmKont.findJedinicemere(normativ.getIdJediniceMere()).getNaziv(), normativ.getCena()});
        });
    }
    
    private void obrisiTabelu() {
        DefaultTableModel model = (DefaultTableModel) tbNormativi.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbNormativi;
    // End of variables declaration//GEN-END:variables
}
