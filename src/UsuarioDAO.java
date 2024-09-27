import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    // Registrar un nuevo usuario
    public boolean registrarUsuario(User user) {
        String sql = "INSERT INTO usuarios (username, password, email, nombre) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); // Puedes encriptar la contraseña aquí
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Iniciar sesión de usuario
    public User iniciarSesion(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password); // Debes comparar contraseñas encriptadas si es el caso
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar perfil de usuario
    public boolean actualizarUsuario(User user) {
        String sql = "UPDATE usuarios SET password = ?, email = ?, nombre = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getNombre());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener un usuario por su nombre de usuario
    public User obtenerUsuarioPorUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
