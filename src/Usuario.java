public class Usuario {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nombre;

    // Constructor para un nuevo usuario
    public Usuario(String username, String password, String email, String nombre) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
    }

    // Constructor para un usuario existente (incluye ID)
    public Usuario(int id, String username, String password, String email, String nombre) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
