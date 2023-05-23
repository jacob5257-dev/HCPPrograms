import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while (i < 0) {
            i++;
        }
        do {
            j++;
        } while (j < 0);
        System.out.println(i + " " + j);
    }
}