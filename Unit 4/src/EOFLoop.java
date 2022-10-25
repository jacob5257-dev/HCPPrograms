import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EOFLoop {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("Unit 4/src/names.dat");
        Scanner file = new Scanner(reader);
        while (file.hasNext()) {
            System.out.println(file.next());
        }
        file.close();
    }
}