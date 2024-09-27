public class Motorcycle {
    private int id;
    private String username;
    private String plate;
    private String brand;
    private String model;
    private String fuelType;  // gasolina, electricidad, hidrógeno

    public Motorcycle(int id, String username, String plate, String brand, String model, String fuelType) {
        this.id = id;
        this.username = username;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}