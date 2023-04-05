import java.util.List;
import java.util.ArrayList;

public class Main {
<<<<<<< HEAD



=======
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        // Add numbers 1-10 to the list
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        List<Integer> reversed = new ArrayList<>();
        // Add the numbers in reverse order to the new list
        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }
        System.out.println(reversed);
    }
>>>>>>> 5ff3b5548617a11ee47e7af71b122df622c9b005
}