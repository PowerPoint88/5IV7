package CIFRADO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*; //GENERA LAS LLAVES DEL CIFRADO
import java.security.*; //TRAE LAS INSTANCIAS DEL CIFRADO
import java.security.spec.InvalidKeySpecException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class cifrado extends javax.swing.JFrame {

    
    public cifrado() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        llave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cifrado DES");
        setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("CIFRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jLabel1.setText("Clave de 8 caracteres:");

        llave.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        llave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llaveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jLabel2.setText("Eliga el archivo a descifrar");

        txt.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        txt.setText("...");
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("CIFRAR");

        direccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(llave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(llave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        descifrar des=new descifrar();
        des.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    //BOTON PARA CIFRAR
    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
       
        // CODIGO PARA QUE FUNCIONE
        while(llave.getText().length()==8){
            JFileChooser fc=new JFileChooser();
            
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.TXT", "txt");
            
            fc.setFileFilter(filtro);

            int seleccion=fc.showOpenDialog(this);

            if(seleccion == JFileChooser.APPROVE_OPTION){
                
                File fichero=fc.getSelectedFile();

                direccion.setText(fichero.getAbsolutePath());
                try(FileReader fr=new FileReader(fichero)){
                    String cadena="";
                    int valor=fr.read();
                    while(valor != -1){
                        cadena=cadena+(char) valor;
                        valor=fr.read();
                    }
                    
                    //CIFRADO
                    String clave=llave.getText();
                    SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
                    DESKeySpec kspec=new DESKeySpec(clave.getBytes());
                    SecretKey ks=skf.generateSecret(kspec);
                    
                    Cipher cifrado=Cipher.getInstance("DES/ECB/PKCS5Padding");
                    
                    cifrado.init(Cipher.ENCRYPT_MODE, ks);
                    
                    byte[] buffer=new byte[1000]; 
        
                    byte[] bufferCifrado; //ALMACENAR EL RESULTADO
                    
                    FileInputStream in=new FileInputStream(fichero);
        
                    FileOutputStream out=new FileOutputStream(fichero+".cifrado.txt");
                    
                    int bytesleidos=in.read(buffer, 0, 1000);
                    while(bytesleidos != -1){
                        
                        bufferCifrado=cifrado.update(buffer, 0, bytesleidos);
                        
                        out.write(bufferCifrado);
                       
                        bytesleidos=in.read(buffer, 0, 1000);
                    }
                    //COMPLETAR EL FICHERO CON  EL CIFRADO
                    bufferCifrado=cifrado.doFinal();
                    out.write(bufferCifrado); 

                    in.close();
                    out.close();
                    
                    JOptionPane.showMessageDialog(null, "El archivo cifrado se creo correctamente");
                    llave.setText("");
                    
                    
                    
                }catch (FileNotFoundException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(cifrado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }JOptionPane.showMessageDialog(null, "La clave debe ser de 8 caracteres exactos");
    }//GEN-LAST:event_txtActionPerformed

    private void llaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveActionPerformed

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed

    
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
            java.util.logging.Logger.getLogger(cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cifrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField llave;
    private javax.swing.JButton txt;
    // End of variables declaration//GEN-END:variables

    private void mostrarBytes(byte[] encoded) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
