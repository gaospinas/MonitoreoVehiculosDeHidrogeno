import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nombre_de_tu_bd"; // Cambia a tu base de datos
    private static final String USER = "tu_usuario"; // Cambia por tu usuario
    private static final String PASSWORD = "tu_contraseña"; // Cambia por tu contraseña

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
