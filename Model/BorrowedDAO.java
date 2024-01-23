
package Model;

import ConnectSql.DAOConnectSQL;
import Controller.BorrowedGui;
import Controller.ReaderGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BorrowedDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    // mượn sách
            public void AddLoanSlip(BorrowedGui add) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into LoanSlip(LoanSlip,ID) values(?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, add.getLoanSlip());
            stmt.setString(2, add.getIdReader());
            //
            stmt.executeUpdate();         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
            public void AddBorrowed(BorrowedGui add) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into LoanDetails(LoanSlip,IDBook,date,Number,Time,s,Status) values(?,?,?,?,?,1,'Unpaid')";
        try {
            stmt = con.prepareStatement(sql);
            //
            
            stmt.setString(1, add.getLoanSlip());
            stmt.setString(2, add.getIdBook());
            stmt.setString(3, add.getDate());
            stmt.setInt(4, add.getNumber());
            stmt.setString(5, add.getTime());
            
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Successfully borrowed");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not yet borrowed");
            System.out.println(e);
        }
    }
            public void Check_IDReader(BorrowedGui borrowedGui){
             con = DAOConnectSQL.getConnection();
             String sql = "select ID from Reader Where ID = ?";
             
             try{
                 stmt = con.prepareStatement(sql);
                 //
                 stmt.setString(1, borrowedGui.getIdReader());
                 //
                rs = stmt.executeQuery();
                if(rs.next()){
                    borrowedGui.setNotificationReader("Yes");
                }else{
                    borrowedGui.setNotificationReader("No");
                }
             }catch(Exception e){
                 System.out.println(e);
             }
         }            
            public void Check_Book(BorrowedGui borrowedGui){
             con = DAOConnectSQL.getConnection();
             String sql = "select IDBook from Books Where IDBook = ?";
             
             try{
                 stmt = con.prepareStatement(sql);
                 //
                 stmt.setString(1, borrowedGui.getIdBook());
                 //
                rs = stmt.executeQuery();
                if(rs.next()){
                    borrowedGui.setNotificationBook("Yes");
                }else{
                    borrowedGui.setNotificationBook("No");
                }
             }catch(Exception e){
                 System.out.println(e);
             }
         }
             
            public void RepaitLoanSlip (BorrowedGui borrowedGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update LoanSlip set ID = ? where LoanSlip = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, borrowedGui.getIdReader());     
            stmt.setString(2, borrowedGui.getLoanSlip());           
            //
            stmt.executeUpdate();   
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }
            
               public void RepaitLoanDetails (BorrowedGui borrowedGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update LoanDetails set IDBook = ?, date = ?, Number = ?, time = ? where LoanSlip = ("
                + " select LoanSlip "
                + " from LoanSlip"
                + " where LoanSlip = ? )";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, borrowedGui.getIdBook()); 
            stmt.setString(2, borrowedGui.getDate());         
            stmt.setInt(3, borrowedGui.getNumber());         
            stmt.setString(4, borrowedGui.getTime());         
            stmt.setString(5, borrowedGui.getLoanSlip());         
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Corrected the information of "+borrowedGui.getLoanSlip()+" successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, borrowedGui.getLoanSlip()+"'s information has not been fixed");
            System.out.println(e);
        }
    }
               
                public ArrayList<BorrowedGui> ListBorrower() {
        ArrayList<BorrowedGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ls.LoanSlip, Name, r.ID, NameBook,b.Idbook,Date, DATEADD(DAY , 14 , DATE) 'DATEE',Number,Time,Status\n" +
                    "from Reader r inner join LoanSlip ls on\n" +
                    "r.ID = ls.ID inner join LoanDetails ld on\n" +
                    "ld.LoanSlip = ls.LoanSlip inner join Books b on\n" +
                    "b.IDBook = ld.Idbook"
                + " where s > 0";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                BorrowedGui borrowedGui = new BorrowedGui();
                borrowedGui.setLoanSlip(rs.getString("LoanSlip"));
                borrowedGui.setNameReader(rs.getString("Name"));
                borrowedGui.setIdReader(rs.getString("ID"));
                borrowedGui.setNameBook(rs.getString("NameBook"));
                borrowedGui.setDate(rs.getString("Date"));
                borrowedGui.setNumber(rs.getInt("Number"));
                borrowedGui.setIdBook(rs.getString("Idbook"));
                borrowedGui.setPaymentAppointmentDate(rs.getString("DATEE"));
                borrowedGui.setTime(rs.getString("Time"));
                borrowedGui.setStatus(rs.getString("Status"));
                list.add(borrowedGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
                
           public void DeleteLoanSlip(BorrowedGui borrowedGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "delete from LoanSlip where LoanSlip = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, borrowedGui.getLoanSlip());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Information deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete failure");
        }
    }
            public ArrayList<BorrowedGui> SearchBorrowed(String search) {
      ArrayList<BorrowedGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ls.LoanSlip, Name, r.ID, NameBook,b.Idbook,Date, DATEADD(DAY , 14 , DATE) 'DATEE' ,Number,Time,Status\n" +
                    "from Reader r inner join LoanSlip ls on\n" +
                    "r.ID = ls.ID inner join LoanDetails ld on\n" +
                    "ld.LoanSlip = ls.LoanSlip inner join Books b on\n" +
                    "b.IDBook = ld.Idbook "
                + " where ld.s > 0 and (ls.LoanSlip like N'%"+search+"%' OR"
                + " Name like N'%"+search+"%' OR "
                + " r.ID like '%"+search+"%' OR "
                + " Date like N'%"+search+"%' OR "
                + " b.Idbook like '%"+search+"%' OR "
                + " Time like N'%"+search+"%')";
              
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                BorrowedGui borrowedGui = new BorrowedGui();
                borrowedGui.setLoanSlip(rs.getString("LoanSlip"));
                borrowedGui.setNameReader(rs.getString("Name"));
                borrowedGui.setIdReader(rs.getString("ID"));
                borrowedGui.setNameBook(rs.getString("NameBook"));
                borrowedGui.setDate(rs.getString("Date"));
                borrowedGui.setNumber(rs.getInt("Number"));
                borrowedGui.setIdBook(rs.getString("Idbook"));
                borrowedGui.setPaymentAppointmentDate(rs.getString("DATEE"));
                borrowedGui.setTime(rs.getString("Time"));
                 borrowedGui.setStatus(rs.getString("Status"));
                list.add(borrowedGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
           
           
}
           

