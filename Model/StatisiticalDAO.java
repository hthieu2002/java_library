package Model;

import ConnectSql.DAOConnectSQL;
import Controller.StatisiticalGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StatisiticalDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    //book
    
     public ArrayList<StatisiticalGui> ShowStatisiticalBook() {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + "  order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     // tìm kiếm id book
     
     
      public ArrayList<StatisiticalGui> SearchStatisiticalBookIDBook(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where Idbook like N'%"+Search+"%'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      
      // tìm kiếm tên book
      
      
       public ArrayList<StatisiticalGui> SearchStatisiticalBookNameBook(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where NameBook like N'%"+Search+"%'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       
       // tim kiem ten tac giả
       
       
        public ArrayList<StatisiticalGui> SearchStatisiticalBookNameAuthor(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where Name like N'%"+Search+"%'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        
        // tim kiem the loai
        
        
         public ArrayList<StatisiticalGui> SearchStatisiticalBookCategory(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where category like N'%"+Search+"%'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         
         // tim kiem so luong
         
         
          public ArrayList<StatisiticalGui> SearchStatisiticalBookNumber(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where QuantityRemaining = '"+Search+"'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
          
          // tim kiem note
          
          
           public ArrayList<StatisiticalGui> SearchStatisiticalBookNote(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select IDBook, NameBook ,Name,category,QuantityRemaining,Note\n" +
                    " from books inner join author on Books.IDAuthor = Author.IDAuthor"
                + " Where Note like N'%"+Search+"%'"
                + " order by IDBook";
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setIdbook(rs.getString("IDBook"));
                statisiticalGui.setNamebook(rs.getString("NameBook"));
                statisiticalGui.setNameAthour(rs.getString("Name"));
                statisiticalGui.setCategory(rs.getString("category"));
                statisiticalGui.setNumber(rs.getString("QuantityRemaining"));
                statisiticalGui.setNote(rs.getString("Note"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     /*
      ----------------------------------------------------------------------------------------------------------------------------
      */
       public ArrayList<StatisiticalGui> ShowStatisiticalBorrowed() {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
       // tim kiem ma phieu muon
         public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedLoanSlip(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (ld.LoanSlip like '%"+ Search +"%')"+
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         // tim kiếm tên đọc giả
         
           public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedNameReader(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (Name like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
           
           // tim kiếm tuổi
           
             public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedAge(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (Age like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
             
             // tim kiếm địa chỉ
             
               public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedAddress(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (Address like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
               
               // tim kiếm tên sách
               
                 public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedNameBook(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (NameBook like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
                 
                 // tim kiếm ngày mượn
                 
                 
                   public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedDateBorrowed(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (Date like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
                   
                   // tim kiếm thơi gian mượn
                   
                     public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedTime(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (time like '%"+ Search +"%')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
                     
                     // tim kiếm số lượng mượn
                     
                       public ArrayList<StatisiticalGui> SearchStatisiticalBorrowedNumber(String Search) {
        ArrayList<StatisiticalGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "select ld.LoanSlip , Name, DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age',\n" +
                     " Address,NameBook,Date,time,Number\n" +
                     " from Reader r inner join LoanSlip ls on ls.ID = r.ID\n" +
                     " inner join LoanDetails ld on ld.LoanSlip = ls.LoanSlip\n" +
                     " inner join Books b on b.IDBook = ld.Idbook"
                + " where ld.s > 0 and (Number = '"+ Search +"')"+ 
                     " order by ld.LoanSlip";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                StatisiticalGui statisiticalGui = new StatisiticalGui();
                statisiticalGui.setLoanSlip(rs.getString("LoanSlip"));
                statisiticalGui.setNameReader(rs.getString("Name"));
                statisiticalGui.setAge(rs.getString("Age"));
                statisiticalGui.setAddress(rs.getString("Address"));
                statisiticalGui.setNameBooks(rs.getString("NameBook"));
                statisiticalGui.setDate(rs.getString("Date"));
                statisiticalGui.setTime(rs.getString("time"));
                statisiticalGui.setNumberr(rs.getString("Number"));

                list.add(statisiticalGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
