/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Editor.Archivo;
import analizado.Analizador;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit;
/**
 *
 * @author Alexander
 */
public class Vista extends javax.swing.JFrame {
    Archivo editor = new Archivo();
    
    
        private String Fuentes[];
    /**
     * Creates new form Vista
     */
    public Vista() {
          
        initComponents();
        this.setLocationRelativeTo(null);
        Fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        jComboBox2 = new javax.swing.JComboBox<>();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btnNew = new javax.swing.JButton();
        btnLanguage = new javax.swing.JButton();
        btnLex = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        MFile = new javax.swing.JMenu();
        MINew = new javax.swing.JMenuItem();
        MIOpen = new javax.swing.JMenuItem();
        MISave = new javax.swing.JMenuItem();
        subLenguaje = new javax.swing.JMenu();
        OptionIngles = new javax.swing.JRadioButtonMenuItem();
        OptionEspañol = new javax.swing.JRadioButtonMenuItem();
        MHelp = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiladores");
        setName("Modelador"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        txtEditor.setEnabled(false);
        txtEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEditorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtEditor);
        txtEditor.getAccessibleContext().setAccessibleName("");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/new1.png"))); // NOI18N
        btnNew.setToolTipText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnLanguage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/translate.png"))); // NOI18N
        btnLanguage.setToolTipText("Language");

        btnLex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/analize.png"))); // NOI18N
        btnLex.setToolTipText("Analyze");
        btnLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLexActionPerformed(evt);
            }
        });

        menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        MFile.setText("File");
        MFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MFileActionPerformed(evt);
            }
        });

        MINew.setText("New");
        MINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MINewActionPerformed(evt);
            }
        });
        MFile.add(MINew);

        MIOpen.setText("Open");
        MIOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIOpenActionPerformed(evt);
            }
        });
        MFile.add(MIOpen);

        MISave.setText("Save");
        MISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MISaveActionPerformed(evt);
            }
        });
        MFile.add(MISave);

        menu.add(MFile);

        subLenguaje.setText("Language");
        subLenguaje.setInheritsPopupMenu(true);

        buttonGroup1.add(OptionIngles);
        OptionIngles.setSelected(true);
        OptionIngles.setText("Inglish");
        OptionIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionInglesActionPerformed(evt);
            }
        });
        subLenguaje.add(OptionIngles);

        buttonGroup1.add(OptionEspañol);
        OptionEspañol.setText("Spanish");
        OptionEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionEspañolActionPerformed(evt);
            }
        });
        subLenguaje.add(OptionEspañol);

        menu.add(subLenguaje);

        MHelp.setText("Analyze");
        MHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MHelpMouseClicked(evt);
            }
        });
        MHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHelpActionPerformed(evt);
            }
        });
        menu.add(MHelp);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnLex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MINewActionPerformed
       nuevo();
        // TODO add your handling code here:
    }//GEN-LAST:event_MINewActionPerformed

    private void MFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MFileActionPerformed

    private void MIOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIOpenActionPerformed
              open();
    }//GEN-LAST:event_MIOpenActionPerformed

    private void MISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MISaveActionPerformed
   save();
// TODO add your handling code here:
    }//GEN-LAST:event_MISaveActionPerformed

    private void txtEditorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorKeyPressed
        //Analizador anali =new Analizador();
        //anali.analizar(txtEditor.getText());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditorKeyPressed

    private void OptionEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionEspañolActionPerformed
        español();
        // TODO add your handling code here:
    }//GEN-LAST:event_OptionEspañolActionPerformed

    private void OptionInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionInglesActionPerformed
        ingles();
    }//GEN-LAST:event_OptionInglesActionPerformed

    private void MHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHelpActionPerformed
     
        Lexemas  lexema = new Lexemas();
        lexema.cargar(txtEditor.getText());
        lexema.imprimir();
        lexema.setVisible(true);

    }//GEN-LAST:event_MHelpActionPerformed

    private void MHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MHelpMouseClicked
        Lexemas  lexema = new Lexemas();
        lexema.cargar(txtEditor.getText());
        lexema.imprimir();
        lexema.setVisible(true);
    }//GEN-LAST:event_MHelpMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLexActionPerformed
        Lexemas  lexema = new Lexemas();
        lexema.cargar(txtEditor.getText());
        lexema.imprimir();
        lexema.armar();
        lexema.setVisible(true);
    }//GEN-LAST:event_btnLexActionPerformed

    
    
    private void nuevo(){
     editor.NuevoArchivo();
        txtEditor.setEnabled(true);
        txtEditor.setText("");
};
    private void ingles(){
     
    };
    private void español(){
        this.MFile.setText("Archivo");
        this.MHelp.setText("Analizar");
        this.MINew.setText("Nuevo");
        this.MIOpen.setText("Abrir");
        this.MISave.setText("Guardar");
    };
    private void open(){
      JFileChooser ruta = new JFileChooser();
        int opc = ruta.showOpenDialog(this);
        txtEditor.setEnabled(true);
        if(opc == JFileChooser.APPROVE_OPTION){
            txtEditor.setText(editor.AbrirArchivo(ruta.getSelectedFile().getPath()));
        }   
    };
    private void save(){
               String path = "";
        if(editor.Nuevo()){
            JFileChooser ruta = new JFileChooser();
            int opc = ruta.showSaveDialog(this);
            if(opc == JFileChooser.APPROVE_OPTION){
                path = ruta.getSelectedFile().getPath();
            }           
        }
        try{
            editor.GuardarArchivo(txtEditor.getText(), path);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Guardar archivo", "Error!", 2);
        }
    };
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Iconos/icons8-editar-columna-29.png"));


        return retValue;
    }
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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MFile;
    private javax.swing.JMenu MHelp;
    private javax.swing.JMenuItem MINew;
    private javax.swing.JMenuItem MIOpen;
    private javax.swing.JMenuItem MISave;
    private javax.swing.JRadioButtonMenuItem OptionEspañol;
    private javax.swing.JRadioButtonMenuItem OptionIngles;
    private javax.swing.JButton btnLanguage;
    private javax.swing.JButton btnLex;
    private javax.swing.JButton btnNew;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu subLenguaje;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables
}
