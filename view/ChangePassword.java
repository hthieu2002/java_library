package view;

import Model.LoginDAO;
import Controller.LoginGui;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JFrame {
 
    public ChangePassword() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDoiMatKhau = new javax.swing.JButton();
        txtNhapTK = new javax.swing.JTextField();
        passMatKhauCu = new javax.swing.JPasswordField();
        passMatKhauMoi = new javax.swing.JPasswordField();
        passNhapLaiMatkhauMoi = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        nenChinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change Password");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Change Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 510, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 204));
        jLabel1.setText("Account ( Email )");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 204));
        jLabel3.setText("Old password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 204));
        jLabel4.setText("New password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 204));
        jLabel5.setText("Enter a new password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 254, 140, 30));

        btnDoiMatKhau.setBackground(new java.awt.Color(153, 255, 255));
        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        btnDoiMatKhau.setText("Change");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 110, 30));

        txtNhapTK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNhapTK.setText("Enter your account");
        txtNhapTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapTKMouseClicked(evt);
            }
        });
        jPanel1.add(txtNhapTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 280, 30));

        passMatKhauCu.setText("jPasswordField1");
        passMatKhauCu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMatKhauCuMouseClicked(evt);
            }
        });
        jPanel1.add(passMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 280, 30));

        passMatKhauMoi.setText("jPasswordField2");
        passMatKhauMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMatKhauMoiMouseClicked(evt);
            }
        });
        passMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passMatKhauMoiActionPerformed(evt);
            }
        });
        jPanel1.add(passMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 280, 30));

        passNhapLaiMatkhauMoi.setText("jPasswordField3");
        passNhapLaiMatkhauMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passNhapLaiMatkhauMoiMouseClicked(evt);
            }
        });
        jPanel1.add(passNhapLaiMatkhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 280, 30));

        btnDangNhap.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(0, 255, 204));
        btnDangNhap.setText("Login");
        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 340, 120, -1));

        nenChinh.setIcon(new javax.swing.ImageIcon("D:\\Kì 2\\Java\\BaiTapCuoiKy\\ThuVien\\src\\img\\DoiMatKhau.jpg")); // NOI18N
        jPanel1.add(nenChinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
         new LoginHome().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtNhapTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapTKMouseClicked
        txtNhapTK.setText("");
    }//GEN-LAST:event_txtNhapTKMouseClicked

    private void passMatKhauCuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMatKhauCuMouseClicked
        passMatKhauCu.setText("");
    }//GEN-LAST:event_passMatKhauCuMouseClicked

    private void passMatKhauMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMatKhauMoiMouseClicked
      passMatKhauMoi.setText("");
    }//GEN-LAST:event_passMatKhauMoiMouseClicked

    private void passNhapLaiMatkhauMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passNhapLaiMatkhauMoiMouseClicked
        passNhapLaiMatkhauMoi.setText("");
    }//GEN-LAST:event_passNhapLaiMatkhauMoiMouseClicked

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
       
            if(txtNhapTK.getText().equals("Enter your account") || passMatKhauCu.getText().equals("") 
        || passMatKhauMoi.getText().equals("") || passNhapLaiMatkhauMoi.getText().equals("") || txtNhapTK.getText().equals(""))
        {
        }else{
            if(passMatKhauMoi.getText().equals(passNhapLaiMatkhauMoi.getText())){
                 LoginGui admin = new LoginGui();
                admin.setAccount(txtNhapTK.getText());
                admin.setOldPassword(passMatKhauCu.getText());
                admin.setNewPassword(passMatKhauMoi.getText());
                    try {
                        if(new LoginDAO().UpdatePassStaff(admin)){
                            JOptionPane.showMessageDialog(null, "success "+" new password of your < " +admin.getNewPassword()+" >");
                        }else{
                            JOptionPane.showMessageDialog(null, "Failure");
                        }    
                    } catch (Exception ex) {
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }else{
                     JOptionPane.showMessageDialog(null, "Wrong Password !!!"); 
                } 
        }
           
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void passMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passMatKhauMoiActionPerformed

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nenChinh;
    private javax.swing.JPasswordField passMatKhauCu;
    private javax.swing.JPasswordField passMatKhauMoi;
    private javax.swing.JPasswordField passNhapLaiMatkhauMoi;
    private javax.swing.JTextField txtNhapTK;
    // End of variables declaration//GEN-END:variables
}
