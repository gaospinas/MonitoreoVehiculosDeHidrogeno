import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/monitoreoVehiculos"; // Cambia a tu base de datos
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = "Aguacate89@1"; // Cambia por tu contraseña

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
