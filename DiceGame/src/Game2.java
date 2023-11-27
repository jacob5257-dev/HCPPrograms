import java.util.*;
import javax.swing.JOptionPane;

public class Game2 {
    public static void main(String[] args) { //skipcq: JAVA-R1000
        String playerCountString = JOptionPane.showInputDialog("How many players?");
        int playerCount = 0;
        try { 
            playerCount = Integer.parseInt(playerCountString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of players");
            System.exit(1);
        }
        Player2[] players = new Player2[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Player2(JOptionPane.showInputDialog("Player " + (i + 1) + ", what is your name?"));
        }

        /*
         * Do the following:
         * 1. Create a die with the numbers +1, +2, +4, +8, +10, their negative counterparts, x2, /2, reset, and reset opponent.
         * 2. While neither user has reached a sum exactly equal to 100, do the following:
         * a. Roll the dice for the player
         * b. Change the player's score based on the roll
         * c. If their score is exactly 100, they win. Otherwise, turn moves to the next player.
         */

        CustomDice dice = new CustomDice(Arrays.asList("+1", "+2", "+4", "+8", "+10", "-1", "-2", "-4", "-8", "-10", "x2", "/2", "reset", "reset next player"));
        while (true) {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    continue;
                }
                dice.roll();
                switch (dice.getLastRoll()) {
                    case "+1" -> players[i].addScore(1);
                    case "+2" -> players[i].addScore(2);
                    case "+4" -> players[i].addScore(4);
                    case "+8" -> players[i].addScore(8);
                    case "+10" -> players[i].addScore(10);
                    case "-1" -> players[i].addScore(-1);
                    case "-2" -> players[i].addScore(-2);
                    case "-4" -> players[i].addScore(-4);
                    case "-8" -> players[i].addScore(-8);
                    case "-10" -> players[i].addScore(-10);
                    case "x2" -> players[i].addScore(players[i].getScore());
                    case "/2" -> players[i].addScore(players[i].getScore() / 2);
                    case "reset" -> players[i].resetScore();
                    case "reset next player" -> {
                        try {
                            players[i + 1].resetScore();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            try {
                                assert players[0] != null;
                                players[0].resetScore();
                            } catch (ArrayIndexOutOfBoundsException e2) {
                                JOptionPane.showMessageDialog(null, "No other players to reset!");
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Player " + (i + 1) + " rolled a " + dice.getLastRoll() + " and has a sum of " + players[i].getScore() + ".");
                if (players[i].getScore() == 100 || players[i].getScore() == -100) {
                    JOptionPane.showMessageDialog(null, "Player " + (i + 1) + " wins!");
                    System.exit(0);
                }
            }
        }
    }    
}
