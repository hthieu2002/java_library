
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConnectSql.DAOConnectSQL;
import Model.StatisiticalDAO;
import Controller.StatisiticalGui;
import Util.Model;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class ViewStatistical extends javax.swing.JFrame {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    StatisiticalDAO statisiticalDAO = new StatisiticalDAO();
    StatisiticalGui statisiticalGui = new StatisiticalGui();
    DefaultTableModel model;
    public ViewStatistical() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        tblStatistical.setRowHeight(30);
        model = (DefaultTableModel) tblStatistical.getModel();

        
        new Thread()
        {
          public void run()
          {   
              while(true)
              {
                  
                  Calendar ca = new GregorianCalendar();
                  
                  int hour = ca.get(Calendar.HOUR);
                  int minute = ca.get(Calendar.MINUTE);
                  int second = ca.get(Calendar.SECOND);
                  
                  int PM_AM = ca.get(Calendar.AM_PM);
                  
                  String day_night;
                  
                  if(PM_AM==1)
                  {
                      day_night="PM";
                      
                  }else
                  {
                      day_night="AM";
                  }
                  if(second < 60){
                       Tb.setForeground(new Color(255,0,0));
                  }
                  if(second < 60)
                  {
                        Tb.setForeground(new Color(0,153,153));
                  }
                  if(second < 60){
                        Tb.setForeground(new Color(0,51,204));
                  }
                  String time = hour+":"+minute+":"+second+" "+day_night;
                  
                  JDongHo.setText(time);
              }
              
          }
        }.start();
        
    }

    
     public void ShowBook() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.ShowStatisiticalBook()) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
      public void ShowBorrowed() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.ShowStatisiticalBorrowed()) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        JDongHo = new javax.swing.JLabel();
        Tb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        ccbTimKiem = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatistical = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Statistical");
        setResizable(false);

        JDongHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JDongHo.setText("12:00:00 AM");

        Tb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tb.setForeground(new java.awt.Color(0, 153, 153));
        Tb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tb.setText(" Statistical");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(JDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tb, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tb, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_search_black_18dp.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setText("Enter the information you want to search for");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 204))); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tra.png"))); // NOI18N
        jButton2.setText("Give back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Muon.png"))); // NOI18N
        jButton4.setText("Borrowed");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("D:\\Kì 2\\Java\\BaiTapCuoiKy\\ThuVien\\src\\img\\logout.png")); // NOI18N
        jButton7.setText("Exit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trend1.png"))); // NOI18N
        jButton6.setText(" Statistical");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setText(" Book Statistics");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setText("Book loan statistics");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ccbTimKiem, 0, 141, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tblStatistical.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblStatistical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblStatistical);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(jRadioButton1.isSelected()){
            try{
            String sql = "select NameBook, QuantityRemaining "
                    + "from Books";
        
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(DAOConnectSQL.getConnection(),sql);
            JFreeChart chart = ChartFactory.createBarChart("Books","Name Book","QuantityRemaining", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer = null ; 
            CategoryPlot plot = null ; 
            renderer = new BarRenderer(); 
            ChartFrame frame1= new ChartFrame("Biểu đồ ",chart);
            frame1.setVisible(true);
            frame1.setSize(1333, 802);
            frame1.setLocationRelativeTo(null);
       }catch(Exception e){
           e.printStackTrace();
       }
       }else if (jRadioButton2.isSelected()){
            try{
            String sql = "select Name,  SUM(Number) 'Number'"
                    + "from Reader r inner join loanSlip ls on ls.ID = r.Id inner join LoanDetails ld on ld.loanSlip = ls.LoanSlip "
                    + " where ld.s > 0"
                    + " Group by Name";
        
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(DAOConnectSQL.getConnection(),sql);
            JFreeChart chart = ChartFactory.createBarChart("Books","Name Reader","Number", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer = null ; 
            CategoryPlot plot = null ; 
            renderer = new BarRenderer(); 
            ChartFrame frame1= new ChartFrame("Biểu đồ ",chart);
            frame1.setVisible(true);
            frame1.setSize(1333, 802);
            frame1.setLocationRelativeTo(null);
       }catch(Exception e){
           e.printStackTrace();
       }
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new ViewBorrowed().setVisible(true);
       
       dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ViewGiveBookBack().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        ccbTimKiem.removeAllItems(); 
        ShowBook();
        ccbTimKiem.addItem("ID book");
        ccbTimKiem.addItem("Name book");
        ccbTimKiem.addItem("Name author");
        ccbTimKiem.addItem("Category");
        ccbTimKiem.addItem("Number");
        ccbTimKiem.addItem("Note");   
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        ccbTimKiem.removeAllItems(); 
        ShowBorrowed();
        ccbTimKiem.addItem("Book loan voucher");
        ccbTimKiem.addItem("Name reader");
        ccbTimKiem.addItem("Age");
        ccbTimKiem.addItem("Address");
        ccbTimKiem.addItem("Name book");
        ccbTimKiem.addItem("Borrowed date");
        ccbTimKiem.addItem("Borrowed time");
        ccbTimKiem.addItem("Number");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
       
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            if(ccbTimKiem.getSelectedIndex()== 0){
                SearchIDBook();
            }else if(ccbTimKiem.getSelectedIndex()== 1){
                SearchNameBook();
            }else if(ccbTimKiem.getSelectedIndex()== 2){
                SearchNameAuthor();
            }else if(ccbTimKiem.getSelectedIndex()== 3){
                SearchCategory();
            }else if(ccbTimKiem.getSelectedIndex()== 4){
                SearchNumber();
            }else if(ccbTimKiem.getSelectedIndex()== 5){
                SearchNote();
            }
        }
      if(jRadioButton2.isSelected()){
          if(ccbTimKiem.getSelectedIndex()== 0){
                SearchBorrowedBookloanvoucher();
            }else if(ccbTimKiem.getSelectedIndex()== 1){
                SearchBorrowedNamereader();
            }else if(ccbTimKiem.getSelectedIndex()== 2){
                SearchBorrowedAge();
            }else if(ccbTimKiem.getSelectedIndex()== 3){
                SearchBorrowedAddress();
            }else if(ccbTimKiem.getSelectedIndex()== 4){
                SearchBorrowedNamebook();
            }else if(ccbTimKiem.getSelectedIndex()== 5){
                SearchBorrowedDate();
            }else if(ccbTimKiem.getSelectedIndex()== 6){
                SearchBorrowedtime();
            }else if(ccbTimKiem.getSelectedIndex()== 7){
                SearchBorrowedNumber();
            }
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if(txtTimKiem.getText().equals("Enter the information you want to search for")){
            txtTimKiem.setText("");
            txtTimKiem.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
          if(txtTimKiem.getText().equals("")){
            txtTimKiem.setText("Enter the information you want to search for");
            txtTimKiem.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int cauhoi = JOptionPane.showConfirmDialog(this, "Do you want to exit","Warning", JOptionPane.YES_NO_OPTION);
        if(cauhoi == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStatistical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDongHo;
    private javax.swing.JLabel Tb;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> ccbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStatistical;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
     public void SearchIDBook() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookIDBook(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
     public void SearchNameBook() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookNameBook(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
     public void SearchNameAuthor() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookNameAuthor(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
     public void SearchCategory() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookCategory(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
     public void SearchNumber() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookNumber(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
     public void SearchNote() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID book","Name book","Name author","Category","Number","Note"
        });
        tbModel.setRowCount(0);//hien thi thong tin
        
        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBookNote(txtTimKiem.getText())) {
            Object dataRow[] = new Object[6];
             dataRow[0] = statisiticalGui.getIdbook();
             dataRow[1] = statisiticalGui.getNamebook();
             dataRow[2] = statisiticalGui.getNameAthour();
             dataRow[3] = statisiticalGui.getCategory();
             dataRow[4] = statisiticalGui.getNumber();
             dataRow[5] = statisiticalGui.getNote();

            tbModel.addRow(dataRow);

        }
    }
    /*
     ----------------------------------------------------------------------------------------------------------
     */
       public void SearchBorrowedBookloanvoucher() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedLoanSlip(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
       
        public void SearchBorrowedNamereader() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedNameReader(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
        
         public void SearchBorrowedAge() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedAge(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
         
          public void SearchBorrowedAddress() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedAddress(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
          
           public void SearchBorrowedNamebook() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedNameBook(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
           
            public void SearchBorrowedDate() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedDateBorrowed(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
            
             public void SearchBorrowedtime() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedTime(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
                    public void SearchBorrowedNumber() {
        DefaultTableModel tbModel = (DefaultTableModel) tblStatistical.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Book loan voucher","Name reader","Age","Address","Name book","Borrowed date","Borrowed time","Number"
        });
        tbModel.setRowCount(0);//hien thi thong tin

        for (StatisiticalGui statisiticalGui : statisiticalDAO.SearchStatisiticalBorrowedNumber(txtTimKiem.getText())) {
            Object dataRow[] = new Object[8];
             dataRow[0] = statisiticalGui.getLoanSlip();
             dataRow[1] = statisiticalGui.getNameReader();
             dataRow[2] = statisiticalGui.getAge();
             dataRow[3] = statisiticalGui.getAddress();
             dataRow[4] = statisiticalGui.getNameBooks();
             dataRow[5] = statisiticalGui.getDate();
             dataRow[6] = statisiticalGui.getTime();
             dataRow[7] = statisiticalGui.getNumberr();

            tbModel.addRow(dataRow);

        }
    }
}
