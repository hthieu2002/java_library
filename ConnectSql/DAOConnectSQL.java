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
            con  = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=261102;database=THUVIEN");
        } catch (Exception e) {
                System.out.println("Connect Error");
        }
        return con;
    }
    
}

