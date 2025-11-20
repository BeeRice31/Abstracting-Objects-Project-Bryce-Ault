/**
 * The Train class represents a real-world train with basic characteristics
 * such as speed, destination, direction, cargo, company, and fuel level.
 * @collaborator Copilot - Helped generate and debug methods and constructors
 */
public class Train {
    private double speed;         // current speed in mph
    private String destination;   // where the train is headed
    private String direction;     // e.g. "North", "South"
    private Cargo cargo;          // cargo carried by the train
    private String trainCompany;  // company operating the train
    private double fuelLevel;     // fuel level in percent (0-100)

    /**
     * No-argument constructor. Sets default values.
     */
    public Train() {
        this.speed = 0.0;
        this.destination = "Unknown";
        this.direction = "North";
        this.trainCompany = "Generic Rail";
        this.fuelLevel = 100.0;
        this.cargo = new Cargo();
    }

    /**
     * Full constructor. Initializes all instance variables.
     *
     * @param speed        initial speed in mph (non-negative)
     * @param destination  initial destination
     * @param direction    initial direction (e.g. "North")
     * @param cargo        Cargo object for the train
     * @param trainCompany company operating the train
     * @param fuelLevel    initial fuel level (0-100)
     */
    public Train(double speed, String destination, String direction, Cargo cargo, String trainCompany, double fuelLevel) {
        this.speed = Math.max(0.0, speed);
        this.destination = destination;
        this.direction = direction;
        this.cargo = (cargo != null) ? cargo : new Cargo();
        this.trainCompany = trainCompany;
        this.fuelLevel = Math.max(0.0, Math.min(100.0, fuelLevel));
    }

    /**
     * Method to load new cargo onto the train.
     *
     * @param cargo Cargo object to be loaded onto the train
     */
    public void loadCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Returns the current speed in mph.
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the train speed (non-negative).
     * @param speed new speed in mph
     */
    public void setSpeed(double speed) {
        this.speed = Math.max(0.0, speed);
    }

    /**
     * Returns the destination.
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination.
     * @param destination new destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns the direction.
     * @return direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the direction.
     * @param direction new direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Returns the Cargo object.
     * @return cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * Sets the Cargo object.
     * @param cargo new Cargo
     */
    public void setCargo(Cargo cargo) {
        this.cargo = (cargo != null) ? cargo : new Cargo();
    }

    /**
     * Returns the train company name.
     * @return trainCompany
     */
    public String getTrainCompany() {
        return trainCompany;
    }

    /**
     * Sets the train company name.
     * @param trainCompany company name
     */
    public void setTrainCompany(String trainCompany) {
        this.trainCompany = trainCompany;
    }

    /**
     * Returns the fuel level (0-100 percent).
     * @return fuelLevel
     */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     * Sets the fuel level (clamped to 0-100).
     * @param fuelLevel new fuel level
     */
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = Math.max(0.0, Math.min(100.0, fuelLevel));
    }

    /**
     * Increases the train's speed by deltaSpeed (cannot be negative).
     * Also consumes a small amount of fuel based on the change in speed.
     *
     * @param deltaSpeed amount to increase speed by (mph)
     */
    public void moveForward(double deltaSpeed) {
        if (deltaSpeed <= 0) {
            return;
        }
        this.speed += deltaSpeed;
        // Simple fuel consumption model: 0.1% per mph increased
        this.fuelLevel -= deltaSpeed * 0.1;
        if (this.fuelLevel < 0.0) {
            this.fuelLevel = 0.0;
        }
    }

    /**
     * Decreases the train's speed by deltaSpeed (not below 0).
     * @param deltaSpeed amount to reduce speed by (mph)
     */
    public void brake(double deltaSpeed) {
        if (deltaSpeed <= 0) {
            return;
        }
        this.speed = Math.max(0.0, this.speed - deltaSpeed);
    }

    /**
     * Stops the train by setting speed to 0.
     */
    public void stop() {
        this.speed = 0.0;
    }

    /**
     * Refuels the train by a given amount (capped at 100).
     * @param amount amount to add to fuel level (percent)
     */
    public void refuel(double amount) {
        if (amount <= 0) {
            return;
        }
        this.fuelLevel = Math.min(100.0, this.fuelLevel + amount);
    }

    /**
     * Offloads the cargo, setting the cargo type to "empty".
     */
    public void offloadCargo() {
        if (this.cargo == null) {
            this.cargo = new Cargo();
        } else {
            this.cargo.setCargoType("empty");
        }
    }

    /**
     * Returns a multi-line description of the train including cargo info.
     * @return descriptive string
     * Created by Copilot
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Company: ").append(trainCompany).append("\n");
        sb.append("Destination: ").append(destination).append("\n");
        sb.append("Direction: ").append(direction).append("\n");
        sb.append("Speed: ").append(String.format("%.1f mph", speed)).append("\n");
        sb.append("Fuel Level: ").append(String.format("%.1f%%", fuelLevel)).append("\n");
        sb.append("Cargo: ").append((cargo != null) ? cargo.toString() : "none");
        return sb.toString();
    }
}
