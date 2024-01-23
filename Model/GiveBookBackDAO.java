package Model;

import ConnectSql.DAOConnectSQL;
import Controller.BorrowedGui;
import Controller.GiveBookBackGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GiveBookBackDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    //trả
      public void AddPaySlip(GiveBookBackGui add) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into PaySlip(PaySlip,LoanSlip) values(?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(2, add.getLoanSlip());
            stmt.setString(1, add.getPaySlip());
            //
            stmt.executeUpdate();         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
            public void AddGiveBookBack(GiveBookBackGui add) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into PayDetails(PaySlip,IDBook,payDay,amountToPay,time) values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, add.getPaySlip());
            stmt.setString(2, add.getIdbook());
            stmt.setString(3, add.getDate());
            stmt.setInt(4, add.getNumber());
           stmt.setString(5, add.getTime());
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Successfully borrowed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not yet borrowed");
            System.out.println(e);
        }
    }
            
              public ArrayList<GiveBookBackGui> ListBorrower() {
        ArrayList<GiveBookBackGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ps.PaySlip,ps.LoanSlip,Name,pd.IdBook,PayDay,amountToPay,pd.Time, ld.Number - amountToPay 'MissingQuantity'\n" +
                     "from Reader r inner join LoanSlip ls \n" +
                     "on r.ID = ls.ID inner join LoanDetails ld\n" +
                     "on ld.LoanSlip = ls.LoanSlip inner join PaySlip ps\n" +
                     "on ls.LoanSlip = ps.LoanSlip inner join payDetails pd\n" +
                     "on ps.PaySlip = pd.paySlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                GiveBookBackGui bookBackGui = new GiveBookBackGui();
                bookBackGui.setPaySlip(rs.getString("PaySlip"));
                bookBackGui.setLoanSlip(rs.getString("LoanSlip"));
                bookBackGui.setNameReader(rs.getString("Name"));
                bookBackGui.setIdbook(rs.getString("IdBook"));
                bookBackGui.setDate(rs.getString("PayDay"));
                bookBackGui.setNumber(rs.getInt("amountToPay"));
                bookBackGui.setTime(rs.getString("Time"));
                bookBackGui.setMissingQuantity(rs.getInt("MissingQuantity"));
                list.add(bookBackGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
              
              public void RepaitLoanDetails (GiveBookBackGui borrowedGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update LoanDetails set s = 0, status = 'Paid'\n" +
                    "where LoanSlip = (\n" +
                    " select LoanSlip\n" +
            "	from LoanSlip\n" +
"	where LoanSlip = ? \n" +
")";
        try {
            stmt = con.prepareStatement(sql);
            //       
            stmt.setString(1, borrowedGui.getLoanSlip());         
            //
            stmt.executeUpdate();      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
              
          public void Check_LoanSlip(GiveBookBackGui giveBookBackGui){
          con = DAOConnectSQL.getConnection();
          String sql = "select loanslip from loanslip where loanslip = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, giveBookBackGui.getLoanSlip());
            //
            rs = stmt.executeQuery();
          if(rs.next()) {
               giveBookBackGui.setTbloanSlip("Yes");
        }else{
              giveBookBackGui.setTbloanSlip("No");
          }
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }      
 
          
           public void Check_IDbook(GiveBookBackGui giveBookBackGui){
          con = DAOConnectSQL.getConnection();
          String sql = "select IDbook from Books where IDbook = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, giveBookBackGui.getIdbook());
            //
            rs = stmt.executeQuery();
          if(rs.next()) {
               giveBookBackGui.setTbIDBook("Yes");
        }else{
              giveBookBackGui.setTbIDBook("No");
          }
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
           
              public void update (GiveBookBackGui borrowedGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update PayDetails set amountToPay = ?, time = ? where PaySlip = ("
                + " select PaySlip "
                + " from PaySlip"
                + " where PaySlip = ? )";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setInt(1, borrowedGui.getNumber()); 
             stmt.setString(2, borrowedGui.getTime()); 
            stmt.setString(3, borrowedGui.getPaySlip()); 
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paid successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unpaid");
            System.out.println(e);
        }
}
              
               public ArrayList<GiveBookBackGui> Search(String Search) {
        ArrayList<GiveBookBackGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ps.PaySlip,ps.LoanSlip,Name,pd.IdBook,PayDay,amountToPay,pd.Time, ld.Number - amountToPay 'MissingQuantity'\n" +
                     "from Reader r inner join LoanSlip ls \n" +
                     "on r.ID = ls.ID inner join LoanDetails ld\n" +
                     "on ld.LoanSlip = ls.LoanSlip inner join PaySlip ps\n" +
                     "on ls.LoanSlip = ps.LoanSlip inner join payDetails pd\n" +
                     "on ps.PaySlip = pd.paySlip "
                + " where ps.PaySlip like N'%"+ Search +"%' OR "
                + "ps.LoanSlip like N'%"+ Search +"%' OR "
                + "Name like N'%"+ Search +"%' OR "
                + "pd.IdBook like N'%"+ Search +"%' OR "
                + "pd.Time like '%"+ Search +"%' OR "
                + "PayDay like N'%"+ Search +"%' ";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                GiveBookBackGui bookBackGui = new GiveBookBackGui();
                bookBackGui.setPaySlip(rs.getString("PaySlip"));
                bookBackGui.setLoanSlip(rs.getString("LoanSlip"));
                bookBackGui.setNameReader(rs.getString("Name"));
                bookBackGui.setIdbook(rs.getString("IdBook"));
                bookBackGui.setDate(rs.getString("PayDay"));
                bookBackGui.setNumber(rs.getInt("amountToPay"));
                bookBackGui.setTime(rs.getString("Time"));
                bookBackGui.setMissingQuantity(rs.getInt("MissingQuantity"));
                list.add(bookBackGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
