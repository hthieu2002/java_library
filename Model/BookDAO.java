package Model;

import ConnectSql.DAOConnectSQL;
import Controller.BookGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BookDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    // phương thức thêm sách
    public void addSach(BookGui bookGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into books(IdBook,NameBook,Category,PublishDate,dates,PublishingCompany,QuantityRemaining,Note,IDAuthor) values(?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, bookGui.getIdBook());
            stmt.setString(2, bookGui.getNameBook());
            stmt.setString(3, bookGui.getCategory());// thể loại
            stmt.setString(4, bookGui.getPublishDate());// ngày xuất bản
            stmt.setString(5, bookGui.getDates());
            stmt.setString(6, bookGui.getPublishingCompany()); // nhà xuất bản
            stmt.setInt(7, bookGui.getNumber()); // QuantityRemaining < số lượng còn >
            stmt.setString(8, bookGui.getNote());
            stmt.setString(9, bookGui.getNameAuthor()); // id author
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Successfully added book information");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Book information has not been saved");
        }
    }
    
    // phuong thuc hien thi sach
     public ArrayList<BookGui> ShowBook() {
        ArrayList<BookGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT * FROM books order by idbook";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BookGui bookGui = new BookGui();
                bookGui.setIdBook(rs.getString("Idbook"));
                bookGui.setNameBook(rs.getString("NameBook"));
                bookGui.setCategory(rs.getString("Category"));//thể loại
                bookGui.setDates(rs.getString("Dates"));
                bookGui.setPublishingCompany(rs.getString("PublishingCompany")); // nhà xuất bản
                bookGui.setPublishDate(rs.getString("PublishDate")); // ngày xuất bản
                bookGui.setNumber(rs.getInt("QuantityRemaining")); 
                bookGui.setNameAuthor(rs.getString("IdAuthor"));
                bookGui.setNote(rs.getString("Note")); 
                list.add(bookGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      // sửa tt sach
     public void Repait(BookGui bookGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update books set idbook=?,NameBook =?,Category=?,PublishDate=?,Dates=?,PublishingCompany=?,QuantityRemaining=?,Note=?,IDAuthor = ? "
                + " where idbook= ? ";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, bookGui.getIdBook());
            stmt.setString(2, bookGui.getNameBook());
            stmt.setString(3, bookGui.getCategory());// thể loại
            stmt.setString(4, bookGui.getPublishDate());// ngày xuất bản
            stmt.setString(5, bookGui.getDates());
            stmt.setString(6, bookGui.getPublishingCompany()); // nhà xuất bản
            stmt.setInt(7, bookGui.getNumber()); // QuantityRemaining < số lượng còn >
            stmt.setString(8, bookGui.getNote());
            stmt.setString(9, bookGui.getNameAuthor()); // id author
            stmt.setString(10, bookGui.getIdBook());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edited information of "+bookGui.getIdBook()+" successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edit information "+bookGui.getIdBook()+" failed");
        }
    }
     
     // xoa tt sach
     public void DeleteBook(BookGui bookGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "delete from books where idbook = ? and NameBook = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, bookGui.getIdBook());
            stmt.setString(2, bookGui.getNameBook());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete failed");
        }
    }
     
         public ArrayList<BookGui> Search(String search) {
        ArrayList<BookGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT * FROM books "
                + " where Idbook like N'%"+search+"%' OR NameBook like N'%"+search+"%' OR Category like N'%"+search+"%' OR "
                + " Dates like '%"+search+"%' OR PublishingCompany like N'%"+search+"%' OR IdAuthor like N'%"+search+"%'"
                + " order by idbook";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BookGui bookGui = new BookGui();
                bookGui.setIdBook(rs.getString("Idbook"));
                bookGui.setNameBook(rs.getString("NameBook"));
                bookGui.setCategory(rs.getString("Category"));//thể loại
                bookGui.setDates(rs.getString("Dates"));
                bookGui.setPublishingCompany(rs.getString("PublishingCompany")); // nhà xuất bản
                bookGui.setPublishDate(rs.getString("PublishDate")); // ngày xuất bản
                bookGui.setNumber(rs.getInt("QuantityRemaining")); 
                bookGui.setNameAuthor(rs.getString("IdAuthor"));
                bookGui.setNote(rs.getString("Note")); 
                list.add(bookGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
