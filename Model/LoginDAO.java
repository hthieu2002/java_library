package Model;

import ConnectSql.DAOConnectSQL;
import Controller.LoginGui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import view.Home;
import Controller.RegistrationGui;
import javax.swing.JOptionPane;

public class LoginDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
      
    public void Check_login(LoginGui admin){
          con = DAOConnectSQL.getConnection();
          String sql = "select * from Login where Account = ? and password = ?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, admin.getAccount());
            stmt.setString(2, admin.getNewPassword());
            //
            rs = stmt.executeQuery();
          if(rs.next()) {
                LoginGui getsv = new LoginGui();
                getsv.setAccount(rs.getString("account"));
                getsv.setFullName(rs.getString("fullname"));
                getsv.setGender(rs.getString("gender"));
                getsv.setAge(rs.getString("age"));
                getsv.setHomeTown(rs.getString("HomeTown"));
                getsv.setRegisterDate(rs.getString("WorkingTime"));
                getsv.setPosition(rs.getNString("Position"));
                admin.setTbDN("Logged in successfully");
             
               Home hp = new Home(getsv);
                hp.setVisible(true);
    
        }else{
              admin.setTbDN("Login failed");
          }
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
   
      public boolean UpdatePassStaff(LoginGui admin) throws Exception{
          con = DAOConnectSQL.getConnection();
        String sql = "UPDATE login SET  "
                + "Password = '"+admin.getNewPassword()
               
                +"' WHERE Account = '"+admin.getAccount()+ "' and Password = '"+admin.getOldPassword()+"';";
        PreparedStatement ps = con.prepareStatement(sql);  
        return ps.executeUpdate() > 0;
    }
      
          public void Registration(RegistrationGui registrationGui) {
        con = DAOConnectSQL.getConnection();
        String sql = "insert into Login(Password,Account,FullName,gender,age,HomeTown,WorkingTime,position) values(?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, registrationGui.getPass());
            stmt.setString(2, registrationGui.getAccount());
            stmt.setString(3, registrationGui.getName());
            stmt.setString(4, registrationGui.getGender());
            stmt.setInt(5, registrationGui.getAge());
            stmt.setString(6, registrationGui.getAddress());
            stmt.setString(7, registrationGui.getTime());
            stmt.setString(8, registrationGui.getPosition());
            //
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Sign up successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sign up for the challenge");
            System.out.println(e);
        }
    }
      
}


