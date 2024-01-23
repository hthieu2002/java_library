package Model;

import ConnectSql.DAOConnectSQL;
import Controller.AuthorGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AuthorDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    // Add
    public void AddAuthor(AuthorGui tg) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into Author(IdAuthor,name,gender,dateOfBirth,Address,phoneNumber) values(?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, tg.getIDAuthor());
            stmt.setString(2, tg.getName());
            stmt.setString(3, tg.getGender());
            stmt.setString(4, tg.getDateOfBirth());
            stmt.setString(5, tg.getAddress());
            stmt.setString(6, tg.getPhoneNumber());
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "More successful author information");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Add failed author information");
        }
    }
    // show
    public ArrayList<AuthorGui> ShowAuthor() {
        ArrayList<AuthorGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT * FROM Author order by IDAuthor";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AuthorGui authorGui = new AuthorGui();
                authorGui.setIDAuthor(rs.getString("IDAuthor"));
                authorGui.setName(rs.getString("Name"));
                authorGui.setGender(rs.getString("Gender"));
                authorGui.setDateOfBirth(rs.getString("DateOfBirth"));
                authorGui.setAddress(rs.getString("Address"));
                authorGui.setPhoneNumber(rs.getString("PhoneNumber"));

                list.add(authorGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Repair
     public void RepairAuthor(AuthorGui authorGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "update Author set IdAuthor=?,Name =?,Gender=?,DateOfBirth=?,Address=?,PhoneNumber=? where IdAuthor=?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, authorGui.getIDAuthor());
            stmt.setString(2, authorGui.getName());
            stmt.setString(3, authorGui.getGender());
            stmt.setString(4, authorGui.getDateOfBirth());
            stmt.setString(5, authorGui.getAddress());
            stmt.setString(6, authorGui.getPhoneNumber());
            stmt.setString(7, authorGui.getIDAuthor());           
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit information "+authorGui.getIDAuthor()+" successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edit information "+authorGui.getIDAuthor()+" challenges");
          
        }
    }
     
     // Delete
     public void DeleteAuthor(AuthorGui authorGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "delete from Author where IdAuthor = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, authorGui.getIDAuthor());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete data successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete data failed");
        }
    }
 
     //sreach
     public ArrayList<AuthorGui> Search (String Sreach) {
        ArrayList<AuthorGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT * FROM Author "
                + " Where  IDAuthor like N'%"+Sreach+"%' OR Name like N'%"+Sreach+"%' OR DateOfBirth like '%"+Sreach+"%' OR Address like N'%"+Sreach+"%' OR PhoneNumber like '%"+Sreach+"%'"
                + " order by IDAuthor";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AuthorGui authorGui = new AuthorGui();
                authorGui.setIDAuthor(rs.getString("IDAuthor"));
                authorGui.setName(rs.getString("Name"));
                authorGui.setGender(rs.getString("Gender"));
                authorGui.setDateOfBirth(rs.getString("DateOfBirth"));
                authorGui.setAddress(rs.getString("Address"));
                authorGui.setPhoneNumber(rs.getString("PhoneNumber"));

                list.add(authorGui);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     
     
}
