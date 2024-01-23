
package view;
import Model.LoginDAO;
import Controller.LoginGui;
import java.awt.Color;
public class LoginHome extends javax.swing.JFrame {

    public LoginHome() {
        initComponents();
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        
        this.icon2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        txtTaiKhoan = new javax.swing.JTextField();
        PassMatKhau = new javax.swing.JPasswordField();
        txttb = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login Library");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 510, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 204));
        jLabel2.setText("Account (Email)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 100, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 170, 130, 40);

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon("D:\\Kì 2\\Java\\BaiTapCuoiKy\\ThuVien\\src\\img\\user (2).png")); // NOI18N
        btnDangNhap.setText("Login");
        btnDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        btnDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDangNhapKeyPressed(evt);
            }
        });
        jPanel1.add(btnDangNhap);
        btnDangNhap.setBounds(200, 240, 120, 40);

        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(102, 255, 204));
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DoiMatKhau (2).png"))); // NOI18N
        btnDoiMatKhau.setText("Change Password");
        btnDoiMatKhau.setContentAreaFilled(false);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau);
        btnDoiMatKhau.setBounds(305, 300, 190, 25);

        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTaiKhoan.setText("Enter your account or Email");
        txtTaiKhoan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTaiKhoanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTaiKhoanFocusLost(evt);
            }
        });
        txtTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTaiKhoanMouseClicked(evt);
            }
        });
        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });
        jPanel1.add(txtTaiKhoan);
        txtTaiKhoan.setBounds(150, 110, 270, 30);

        PassMatKhau.setText("00000000");
        PassMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PassMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PassMatKhauFocusLost(evt);
            }
        });
        PassMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassMatKhauMouseClicked(evt);
            }
        });
        PassMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PassMatKhauKeyPressed(evt);
            }
        });
        jPanel1.add(PassMatKhau);
        PassMatKhau.setBounds(150, 180, 270, 30);

        txttb.setForeground(new java.awt.Color(255, 0, 0));
        txttb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttb.setToolTipText("");
        jPanel1.add(txttb);
        txttb.setBounds(50, 60, 410, 30);

        icon1.setForeground(new java.awt.Color(204, 255, 204));
        icon1.setIcon(new javax.swing.ImageIcon("D:\\Kì 2\\Java\\BaiTapCuoiKy\\ThuVien\\src\\img\\outline_visibility_black_18dp.png")); // NOI18N
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon1MousePressed(evt);
            }
        });
        jPanel1.add(icon1);
        icon1.setBounds(430, 180, 18, 30);

        icon2.setBackground(new java.awt.Color(204, 255, 204));
        icon2.setForeground(new java.awt.Color(204, 255, 204));
        icon2.setIcon(new javax.swing.ImageIcon("D:\\Kì 2\\Java\\BaiTapCuoiKy\\ThuVien\\src\\img\\outline_visibility_off_black_18dp.png")); // NOI18N
        icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon2MousePressed(evt);
            }
        });
        jPanel1.add(icon2);
        icon2.setBounds(430, 180, 18, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TvTong (1).jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-10, 0, 550, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if(txtTaiKhoan.getText().equals("") || txtTaiKhoan.getText().equals("Enter your account or Email")){

        }else{
            LoginGui admin = new LoginGui();
            admin.setAccount(txtTaiKhoan.getText());
            admin.setNewPassword(PassMatKhau.getText());
            //
            LoginDAO dn = new LoginDAO();
            dn.Check_login(admin);
            switch(admin.getTbDN()){
                case "Logged in successfully" :
                this.setVisible(false);
                break;
                case "Login failed" :
                txttb.setText(admin.getTbDN());
                break;
            }
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDangNhapKeyPressed

    }//GEN-LAST:event_btnDangNhapKeyPressed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        new ChangePassword().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void txtTaiKhoanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaiKhoanFocusGained

    }//GEN-LAST:event_txtTaiKhoanFocusGained

    private void txtTaiKhoanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaiKhoanFocusLost
        if(txtTaiKhoan.getText().equals("")){
            txtTaiKhoan.setText("Enter your account or Email");
            txttb.setText("Enter account");
            txtTaiKhoan.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtTaiKhoanFocusLost

    private void txtTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTaiKhoanMouseClicked
        txtTaiKhoan.setText("");
        txtTaiKhoan.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_txtTaiKhoanMouseClicked

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed

    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void PassMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PassMatKhauFocusGained

    }//GEN-LAST:event_PassMatKhauFocusGained

    private void PassMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PassMatKhauFocusLost

    }//GEN-LAST:event_PassMatKhauFocusLost

    private void PassMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassMatKhauMouseClicked
        PassMatKhau.setText("");
    }//GEN-LAST:event_PassMatKhauMouseClicked

    private void PassMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PassMatKhauKeyPressed

    }//GEN-LAST:event_PassMatKhauKeyPressed

    private void icon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MousePressed
        icon2.setVisible(true);
        icon1.setVisible(false);
        PassMatKhau.setEchoChar((char)0);
    }//GEN-LAST:event_icon1MousePressed

    private void icon2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon2MousePressed
         icon1.setVisible(true);
        icon2.setVisible(false);
        PassMatKhau.setEchoChar('*');
    }//GEN-LAST:event_icon2MousePressed

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
            java.util.logging.Logger.getLogger(LoginHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PassMatKhau;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTaiKhoan;
    public javax.swing.JLabel txttb;
    // End of variables declaration//GEN-END:variables
}
