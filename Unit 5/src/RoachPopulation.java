/**
 * A class that models a population of roaches.
 * @author jacob5257
 * @version 1.0
 * @since 2023-02-02
 * @see RoachPopulation
 */
public class RoachPopulation {
    // Variable that stores the population of roaches
    private int population;

    /**
     * Constructs a roach population with a given initial population.
     * @param initialPopulation The initial population of the roaches
     */
    public RoachPopulation(int initialPopulation) {
        population = initialPopulation;
    }

    /**
     * Doubles the population of roaches.
     * @return The new population of roaches
     */
    public void waitForDoubling() {
        population *= 2;
    }

    /**
     * Reduces the population of roaches by 10%.
     * @return The new population of roaches
     */
    public void spray() {
        population *= 0.9;
    }

    /**
     * Gets the current population of roaches.
     * @return The current population of roaches
     */
    public int getRoaches() {
        return population;
    }
}
