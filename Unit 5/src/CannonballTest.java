public class CannonballTest {
    public static void main(String[] args) {
        // Warning! May not work!
        Cannonball cannonball = new Cannonball(100, 0, 9.8);
        double time = 0;
        while (cannonball.updateSimulation() < 0.0) {
            System.out.print("Position: " + cannonball.getPosition() + ", ");
            System.out.print("Velocity: " + cannonball.getVelocity() + ", ");
            System.out.print("Time: " + cannonball.getTime() + ", ");
            System.out.print("Formula: " + cannonball.getFormulaValue());
            System.out.println();
            time = cannonball.updateSimulation();
        }
        System.out.println("Time: " + time);
        System.out.println("Max Height: " + cannonball.getMaxHeight());
    }
}
