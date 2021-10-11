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
import javax.crypto.spec.*; 
import java.security.*; 
import java.security.spec.InvalidKeySpecException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;


public class descifrar extends javax.swing.JFrame {

    
    public descifrar() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        llave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Descifrado DES");

        jButton1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("DESIFRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jLabel1.setText("Clave de 8 caracteres");

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
        jLabel3.setText("DESCIFRADO ");

        direccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(llave))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txt)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(llave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cifrado ci=new cifrado();
        ci.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
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
                    
                    //DESCIFRAR
                    String clave=llave.getText();
                    SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
                    DESKeySpec kspec=new DESKeySpec(clave.getBytes());
                    SecretKey ks=skf.generateSecret(kspec);
                    
                    Cipher cifrado=Cipher.getInstance("DES/ECB/PKCS5Padding");
                    
                    cifrado.init(Cipher.DECRYPT_MODE, ks);
                    
                    byte[] buffer=new byte[1000];
                    
                    byte[] bufferPlano; //aqui voy a almacenar el resultado descifrado
        
                    FileInputStream in=new FileInputStream(fichero);

                    FileOutputStream out=new FileOutputStream(fichero+".descifrado.txt");

                    int bytesleidos=in.read(buffer, 0, 1000);
                    while(bytesleidos != -1){
                        
                        bufferPlano=cifrado.update(buffer, 0, bytesleidos);
                     
                        out.write(bufferPlano);
                        
                        bytesleidos=in.read(buffer, 0, 1000);
                    }
                   
                    bufferPlano=cifrado.doFinal();
                    out.write(bufferPlano);

                    in.close();
                    out.close();
                    
                    JOptionPane.showMessageDialog(null, "El archivo descifrado se creó correctamente");
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
        }JOptionPane.showMessageDialog(null, "La clave debe de ser de 8 caracteres exactos");
    }//GEN-LAST:event_txtActionPerformed

    private void llaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_llaveActionPerformed

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
            java.util.logging.Logger.getLogger(descifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(descifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(descifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(descifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new descifrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField llave;
    private javax.swing.JButton txt;
    // End of variables declaration//GEN-END:variables
}
