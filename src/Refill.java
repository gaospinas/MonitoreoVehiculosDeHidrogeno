import java.util.Date;

public class Refill {
    private int id;
    private int motorcycleId;
    private String fuelType;  // gasolina, electricidad, hidrógeno
    private double quantity;
    private double cost;
    private Date fecha;

    public Refill(int id, int motorcycleId, String fuelType, double quantity, double cost, Date fecha) {
        this.id = id;
        this.motorcycleId = motorcycleId;
        this.fuelType = fuelType;
        this.quantity = quantity;
        this.cost = cost;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(int motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}