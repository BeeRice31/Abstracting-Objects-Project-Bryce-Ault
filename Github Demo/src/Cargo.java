/**
 * The Cargo class represents the cargo carried by a Train.
 * It stores the cargo type (for example: "coal", "passengers", "grain", "empty").
 * @collaborator Copilot - Helped generate and debug methods
 */
public class Cargo {
    private String cargoType; // e.g. "coal", "passengers", "grain", "empty"

    /**
     * No-argument constructor. Sets a default cargo type of "empty".
     */
    public Cargo() {
        this.cargoType = "empty";
    }

    /**
     * Constructor that sets the cargo type.
     * @param cargoType type of cargo
     */
    public Cargo(String cargoType) {
        this.cargoType = (cargoType != null) ? cargoType : "empty";
    }

    /**
     * Returns the cargo type.
     * @return cargoType
     */
    public String getCargoType() {
        return cargoType;
    }

    /**
     * Sets the cargo type.
     * @param cargoType new cargo type
     */
    public void setCargoType(String cargoType) {
        this.cargoType = (cargoType != null) ? cargoType : "empty";
    }

    /**
     * Returns a short description of the cargo.
     * @return descriptive string
     */
    @Override
    public String toString() {
        return cargoType;
    }
}
