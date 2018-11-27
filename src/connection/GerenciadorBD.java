package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorBD {
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException {
        stmt.clearParameters();
        con.close();
    }
    
    private GerenciadorBD() {
    }
            
    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SIEE?useTimezone=true&serverTimezone=UTC&useSSL=false",
                    "rafael", "root");
    }
}
