/**
 * Tester class for the Train and Cargo classes.
 * Demonstrates constructors, methods with and without parameters,
 * and prints before/after states to show internal state changes.
 */
public class TrainTester {
    public static void main(String[] args) {
        // Create Cargo objects
        Cargo cargo1 = new Cargo("coal");
        Cargo cargo2 = new Cargo("passengers");

        // Create two Train objects: one no-arg, one full constructor
        Train train1 = new Train();
        Train train2 = new Train(45.0, "Chicago", "East", cargo1, "Amtrak", 65.0);

        // Print initial states
        System.out.println("--- Initial Trains ---");
        System.out.println(train1);
        System.out.println();
        System.out.println(train2);
        System.out.println();

        // Load cargo2 onto train2
        train2.loadCargo(cargo2);

        // For train1: use a method WITH parameter and a WITHOUT parameter
        train1.moveForward(30.0); // increase speed
        train1.stop(); // set speed to 0

        // For train2: use a method WITH parameter and a WITHOUT parameter
        train2.brake(10.0); // reduce speed
        train2.offloadCargo(); // offload cargo
        train2.refuel(20.0); // demonstrate refuel (also a method with parameter)

        // Print states after actions
        System.out.println("--- After Actions ---");
        System.out.println(train1);
        System.out.println();
        System.out.println(train2);
    }
}
