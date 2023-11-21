import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://pedidosbd.crbh9zpqeihj.us-east-1.rds.amazonaws.com:3306/pedidosbd";
        String user = "ana";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}

