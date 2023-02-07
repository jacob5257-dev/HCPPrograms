public class Cannonball {
    private double v; // v = velocity of the cannonball
    private double s = 0; // s = position of the cannonball
    private double g = 9.81; // g = acceleration due to gravity
    private double t = 0; // t = time
    private double deltaT = 0.01; // delta t = how much time passes in each iteration in seconds
    private double maxHeight = s;

    public Cannonball(double v, double s, double g) {
        this.v = v;
        this.s = s;
        this.g = g;
        this.maxHeight = s;
    }

    public Cannonball(double v) {
        this.v = v;
    }

    public double getVelocity() {
        return v;
    }

    public double getPosition() {
        return s;
    }

    public double getTime() {
        return t;
    }

    public void updatePosition() {
        s = s + v * deltaT;
        // round to 2 decimal places
        s = Math.round(s * 100.0) / 100.0;
        if (s > maxHeight) {
            maxHeight = s;
        }
    }

    public void updateVelocity() {
        v = v - g * deltaT;
        // round to 2 decimal places
        v = Math.round(v * 100.0) / 100.0;
    }

    public double updateSimulation() {
        updatePosition();
        updateVelocity();
        t += deltaT;
        // round to two decimal places
        t = Math.round(t * 100.0) / 100.0;
        if (s <= 0) {
            s = 0;
            return t;
        }
        return -1.0;
    }

    public double getFormulaValue() {
        return Math.round(-0.5 * g * Math.pow(t, 2) + v * t) / 100.0;
    }

    public double getMaxHeight() {
        return maxHeight;
    }
}