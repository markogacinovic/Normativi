package forme;

import forme.artikli.ifArtikli;
import forme.artikli.ifUnosArtikla;
import forme.normativi.ifNormativi;
import forme.komitenti.ifNoviKomitent;
import forme.komitenti.ifKomitenti;
import forme.normativi.ifUnosNormativa;
import forme.radniNalozi.ifRadniNalozi;
import forme.radniNalozi.ifUnosRadnogNaloga;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;


public class glavnaForma extends javax.swing.JFrame {

    EntityManagerFactory emf;

    public glavnaForma() {
        initComponents();
        try
        {
            emf = Persistence.createEntityManagerFactory("NormativiPU");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Nije uspostavljena veza sa bazom! Program će se zatvoriti!", "Greška", JOptionPane.ERROR_MESSAGE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpPozadina = new javax.swing.JDesktopPane();
        mbiMeni = new javax.swing.JMenuBar();
        mKomitenti = new javax.swing.JMenu();
        miNoviKomitent = new javax.swing.JMenuItem();
        miSviKomitenti = new javax.swing.JMenuItem();
        mArtikli = new javax.swing.JMenu();
        miNovArtikal = new javax.swing.JMenuItem();
        miSviArtikli = new javax.swing.JMenuItem();
        mNormativi = new javax.swing.JMenu();
        miNovNormativ = new javax.swing.JMenuItem();
        miSviNormativi = new javax.swing.JMenuItem();
        mRadniNalozi = new javax.swing.JMenu();
        miNovRadniNalog = new javax.swing.JMenuItem();
        miSviRadniNalozi = new javax.swing.JMenuItem();
        mPomoc = new javax.swing.JMenu();
        miOProgramu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NORMATIVI - BS Sistem");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout dpPozadinaLayout = new javax.swing.GroupLayout(dpPozadina);
        dpPozadina.setLayout(dpPozadinaLayout);
        dpPozadinaLayout.setHorizontalGroup(
            dpPozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
        );
        dpPozadinaLayout.setVerticalGroup(
            dpPozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        mKomitenti.setText("Komitenti");

        miNoviKomitent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        miNoviKomitent.setText("Nov");
        miNoviKomitent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviKomitentActionPerformed(evt);
            }
        });
        mKomitenti.add(miNoviKomitent);

        miSviKomitenti.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        miSviKomitenti.setLabel("Svi");
        miSviKomitenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSviKomitentiActionPerformed(evt);
            }
        });
        mKomitenti.add(miSviKomitenti);

        mbiMeni.add(mKomitenti);

        mArtikli.setText("Artikli");

        miNovArtikal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        miNovArtikal.setText("Nov");
        miNovArtikal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovArtikalActionPerformed(evt);
            }
        });
        mArtikli.add(miNovArtikal);

        miSviArtikli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSviArtikli.setText("Svi");
        miSviArtikli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSviArtikliActionPerformed(evt);
            }
        });
        mArtikli.add(miSviArtikli);

        mbiMeni.add(mArtikli);

        mNormativi.setText("Normativi");

        miNovNormativ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        miNovNormativ.setText("Nov");
        miNovNormativ.setToolTipText("");
        miNovNormativ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovNormativActionPerformed(evt);
            }
        });
        mNormativi.add(miNovNormativ);

        miSviNormativi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        miSviNormativi.setText("Svi");
        miSviNormativi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSviNormativiActionPerformed(evt);
            }
        });
        mNormativi.add(miSviNormativi);

        mbiMeni.add(mNormativi);

        mRadniNalozi.setText("Radni nalozi");

        miNovRadniNalog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        miNovRadniNalog.setText("Nov");
        miNovRadniNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovRadniNalogActionPerformed(evt);
            }
        });
        mRadniNalozi.add(miNovRadniNalog);

        miSviRadniNalozi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        miSviRadniNalozi.setText("Svi");
        miSviRadniNalozi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSviRadniNaloziActionPerformed(evt);
            }
        });
        mRadniNalozi.add(miSviRadniNalozi);

        mbiMeni.add(mRadniNalozi);

        mPomoc.setText("Pomoć");

        miOProgramu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        miOProgramu.setText("O programu");
        miOProgramu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOProgramuActionPerformed(evt);
            }
        });
        mPomoc.add(miOProgramu);

        mbiMeni.add(mPomoc);

        setJMenuBar(mbiMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpPozadina)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpPozadina)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviKomitentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKomitentActionPerformed
        ifNoviKomitent nk = new ifNoviKomitent(emf);
        nk.setVisible(true);
        dpPozadina.add(nk);
        nk.moveToFront();
        try {
            nk.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miNoviKomitentActionPerformed

    private void miSviKomitentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSviKomitentiActionPerformed
        ifKomitenti sk = new ifKomitenti(emf);
        sk.setVisible(true);
        dpPozadina.add(sk);
        sk.moveToFront();
        try {
            sk.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miSviKomitentiActionPerformed

    private void miNovNormativActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovNormativActionPerformed
        ifUnosNormativa un = new ifUnosNormativa(emf);
        un.setVisible(true);
        dpPozadina.add(un);
        un.moveToFront();
        try {
            un.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miNovNormativActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try
        {
            emf.close();
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_formWindowClosing

    private void miSviNormativiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSviNormativiActionPerformed
        ifNormativi sn = new ifNormativi(emf);
        sn.setVisible(true);
        dpPozadina.add(sn);
        sn.moveToFront();
        try {
            sn.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miSviNormativiActionPerformed

    private void miNovArtikalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovArtikalActionPerformed
        ifUnosArtikla ua = new ifUnosArtikla(emf);
        ua.setVisible(true);
        dpPozadina.add(ua);
        ua.moveToFront();
        try {
            ua.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miNovArtikalActionPerformed

    private void miSviArtikliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSviArtikliActionPerformed
        ifArtikli a = new ifArtikli(emf);
        a.setVisible(true);
        dpPozadina.add(a);
        a.moveToFront();
        try {
            a.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miSviArtikliActionPerformed

    private void miOProgramuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOProgramuActionPerformed
        JOptionPane.showMessageDialog(null, "Normativi v1.3\nAutor Marko Gaćinović\nmarko.gacinovic@gmail.com\nJanuar 2018", "O programu", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_miOProgramuActionPerformed

    private void miNovRadniNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovRadniNalogActionPerformed
        ifUnosRadnogNaloga urn = new ifUnosRadnogNaloga(emf);
        urn.setVisible(true);
        dpPozadina.add(urn);
        urn.moveToFront();
        try {
            urn.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miNovRadniNalogActionPerformed

    private void miSviRadniNaloziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSviRadniNaloziActionPerformed
        ifRadniNalozi rn = new ifRadniNalozi(emf);
        rn.setVisible(true);
        dpPozadina.add(rn);
        rn.moveToFront();
        try {
            rn.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(glavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miSviRadniNaloziActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(glavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(glavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(glavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(glavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new glavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpPozadina;
    private javax.swing.JMenu mArtikli;
    private javax.swing.JMenu mKomitenti;
    private javax.swing.JMenu mNormativi;
    private javax.swing.JMenu mPomoc;
    private javax.swing.JMenu mRadniNalozi;
    private javax.swing.JMenuBar mbiMeni;
    private javax.swing.JMenuItem miNovArtikal;
    private javax.swing.JMenuItem miNovNormativ;
    private javax.swing.JMenuItem miNovRadniNalog;
    private javax.swing.JMenuItem miNoviKomitent;
    private javax.swing.JMenuItem miOProgramu;
    private javax.swing.JMenuItem miSviArtikli;
    private javax.swing.JMenuItem miSviKomitenti;
    private javax.swing.JMenuItem miSviNormativi;
    private javax.swing.JMenuItem miSviRadniNalozi;
    // End of variables declaration//GEN-END:variables
}
