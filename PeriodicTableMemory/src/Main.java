import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] elements = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminium", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Caesium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium", "Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium", "Copernicium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which element would you like to start with (1 - 118)? ");
        int start = scanner.nextInt();
        System.out.print("Which element would you like to end with (1 - 118)? ");
        int end = scanner.nextInt();
        while (true) {
            int random = (int) (Math.random() * (end - start + 1) + start);
            double choice = Math.random();
            if (choice < 0.5) {
                System.out.print("What is the periodic number of " + elements[random - 1] + "? ");
                int answer = scanner.nextInt();
                if (answer == random) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The correct answer is " + random + ".");
                }
            } else {
                System.out.print("What is the name of element " + random + "? ");
                String answer = scanner.next();
                if (answer.equals("exit")) {
                    break;
                }
                if (answer.equals(elements[random - 1].toLowerCase())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The correct answer is " + elements[random - 1] + ".");
                }
            }
        }
        System.exit(0);
    }
}