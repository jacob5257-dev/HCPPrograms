public class PrimesTableTest {
    public static void main(String[] args) {
        /*
         * Write a program that prints out the first 100 primes in a 10x10 table.
         * Use the PrimesTable class to get a list of the first 100 primes and print them in a 10x10 grid.
         * Use printf to format your output and use a counter to output a newline after every 10 primes.  So you should have 10 rows with 10 primes in every row.
         * 
         */
        PrimesTable pt = new PrimesTable(1);
        int[] primes = new int[100];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = pt.nextPrime();
        }
        int counter = 0;
        for (int i = 0; i < primes.length; i++) {
            System.out.printf("%5d", primes[i]);
            counter++;
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
        }
        
    }
    
}
