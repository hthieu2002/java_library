package ConnectSql;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAOConnectSQL {
    
    public DAOConnectSQL(){
        getConnection();
    }
        private static Connection con;
    public static Connection getConnection() {
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con  = DriverManager.getConnection("jdbc:sqlserver:");
        } catch (Exception e) {
                System.out.println("Connect Error");
        }
        return con;
    }
    
}

