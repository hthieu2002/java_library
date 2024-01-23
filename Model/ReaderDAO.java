package Model;

import ConnectSql.DAOConnectSQL;
import Controller.ReaderGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReaderDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    //method to add readers
    
      public void AddReader(ReaderGui add) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into Reader(id,name,DateOfBirth,gender,address,Job,PhoneNumber,RegisterDate) values(?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, add.getID());
            stmt.setString(2, add.getName());
            stmt.setString(3, add.getDateOfBirth());
            stmt.setString(4, add.getGender());
            stmt.setString(5, add.getAddress());
            stmt.setString(6, add.getWork());
            stmt.setString(7, add.getPhoneNumber());
            stmt.setString(8, add.getRegisterDate());
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Successfully added information");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "More failure information");
            System.out.println(e);
        }
    }
      
      // reader display method
     public ArrayList<ReaderGui> ListReader() {
        ArrayList<ReaderGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT *,DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age', DATEADD(MONTH , 1 ,RegisterDate) 'ExpirationDate'"
                + " FROM Reader order by Id";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ReaderGui Rg = new ReaderGui();
                Rg.setID(rs.getString("ID"));
                Rg.setName(rs.getString("Name"));
                Rg.setDateOfBirth(rs.getString("DateOfBirth"));
                Rg.setGender(rs.getString("Gender"));
                Rg.setAge(rs.getString("Age"));
                Rg.setAddress(rs.getString("Address"));
                Rg.setWork(rs.getString("Job"));
                Rg.setPhoneNumber(rs.getString("PhoneNumber"));
                Rg.setRegisterDate(rs.getString("RegisterDate"));
                Rg.setExpirationDate(rs.getString("ExpirationDate"));

                list.add(Rg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
       // Repait reader
 public void RepaitInfomationReader(ReaderGui repait) {
        con = DAOConnectSQL.getConnection();
        String sql = "update Reader set id=?,Name=?,DateOfBirth=?,gender=?,address=?,job=?,PhoneNumber=? ,RegisterDate=? where Id=?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, repait.getID());
            stmt.setString(2, repait.getName());
            stmt.setString(3, repait.getDateOfBirth());
            stmt.setString(4, repait.getGender());
            stmt.setString(5, repait.getAddress());           
            stmt.setString(6, repait.getWork());
            stmt.setString(7, repait.getPhoneNumber());
            stmt.setString(8, repait.getRegisterDate());
            stmt.setString(9, repait.getID());
            
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Corrected the information of "+repait.getID()+" successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, repait.getID()+"'s information has not been fixed");
            System.out.println(e);
        }
    }
     // delete infomation reader
     public void DeleteReader(ReaderGui dr) {
        con = DAOConnectSQL.getConnection();
        String sql = "delete from reader where Id = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, dr.getID());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Information deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Delete failure");
        }
    }
     
     
     //sreach infomation to reader
       public ArrayList<ReaderGui> SearchReader(String seach) {
        ArrayList<ReaderGui> list = new ArrayList<>();
        con = DAOConnectSQL.getConnection();
        String sql = "SELECT *,DATENAME(year, GETDATE()) - year(DateOfBirth) 'Age', DATEADD(MONTH , 1 ,RegisterDate) 'ExpirationDate'"
                + " FROM Reader "
                + " where ID like '%"+seach+"%' OR Name like N'%"+seach+"%' OR DateOfBirth like '%"+seach+"%' OR Gender like N'%"+seach+"%' OR Address like '%"+seach+"%' OR "
                + " Job like N'%"+seach+"%' OR PhoneNumber like N'%"+seach+"%' OR RegisterDate like N'%"+seach+"%'"
                + " order by Id";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ReaderGui Rg = new ReaderGui();
                Rg.setID(rs.getString("ID"));
                Rg.setName(rs.getString("Name"));
                Rg.setDateOfBirth(rs.getString("DateOfBirth"));
                Rg.setGender(rs.getString("Gender"));
                Rg.setAge(rs.getString("Age"));
                Rg.setAddress(rs.getString("Address"));
                Rg.setWork(rs.getString("Job"));
                Rg.setPhoneNumber(rs.getString("PhoneNumber"));
                Rg.setRegisterDate(rs.getString("RegisterDate"));
                Rg.setExpirationDate(rs.getString("ExpirationDate"));

                list.add(Rg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }    
}
