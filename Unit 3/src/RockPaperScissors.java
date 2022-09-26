import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Rock = 1, Paper = 2, Scissors = 3, Quit = 4: ");
        String user1_input = myObj.nextLine();
        String[] choices = {"Error", "Rock", "Paper", "Scissors", "Quit"};
        System.out.println("Rock = 1, Paper = 2, Scissors = 3, Quit = 4: ");
        String user2_input = myObj.nextLine();

        int user1_number;
        int user2_number;
        try {
            user1_number = Integer.parseInt(user1_input);
            user2_number = Integer.parseInt(user2_input);
        } catch (Exception e) {
            throw new RuntimeException("Invalid input!");
        }
        if (user1_number < 0 || user2_number < 0 || user1_number > 4 || user2_number > 4) throw new RuntimeException("Invalid input!");
        String user1_choice = choices[user1_number];
        String user2_choice = choices[user2_number];
        //2 beats 1, 3 beats 2, 1 beats 3

        if (user1_number == user2_number) System.out.println("It's a tie! You both picked " + user1_choice);
        if (user1_number == 1 && user2_number == 3) System.out.println("User 1 wins! " + user1_choice + " beats " + user2_choice);
        if (user1_number == 3 && user2_number == 1) System.out.println("User 2 wins! " + user2_choice + " beats " + user1_choice);
        if (user1_number > user2_number) System.out.println("Player 1 wins! " + user1_choice + " beats " + user2_choice);
        if (user2_number > user1_number) System.out.println("Player 2 wins! " + user2_choice + " beats " + user1_choice);

    }
}
