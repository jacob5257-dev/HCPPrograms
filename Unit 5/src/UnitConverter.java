import java.util.List;

public class UnitConverter {
    // Order: inches, feet, miles, meters, millimeters, centimeters, kilometers
    private final List<Double> conversionsToMeters;
    private final List<Double> conversionsFromMeters;
    private final int selectedIndex;
    private final double value;

    public UnitConverter(int units, double value) {
        this.selectedIndex = units;
        this.value = value;
        this.conversionsToMeters = List.of(0.0254, 0.3048, 1609.34, 1.0, 0.001, 0.01, 1000.0);
        this.conversionsFromMeters = List.of(39.3701, 3.28084, 0.000621371, 1.0, 1000.0, 100.0, 0.001);
    }

    public double toMeters() {
        if (this.selectedIndex == -1) throw new RuntimeException("Invalid unit!");
        return this.value * this.conversionsToMeters.get(this.selectedIndex);
    }

    public double fromMeters() {
        if (this.selectedIndex == -1) throw new RuntimeException("Invalid unit!");
        return this.value * this.conversionsFromMeters.get(this.selectedIndex);
    }
}
