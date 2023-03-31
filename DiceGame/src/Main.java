import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String playerCountString = JOptionPane.showInputDialog("How many players?");
        int playerCount = 0;
        try { 
            playerCount = Integer.parseInt(playerCountString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of players");
            System.exit(1);
        }
        String diceSidesString = JOptionPane.showInputDialog("How many sides on the dice?");
        int diceSides = 0;
        try { 
            diceSides = Integer.parseInt(diceSidesString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of sides");
            System.exit(1);
        }
        Dice dice = new Dice(diceSides);
        Player[] players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Player(dice);
        }
        while (true) {
            /*
             * For every player, do the following:
             * 1. Ask if they want to roll the dice or skip their turn
             * 2. If they want to roll the dice, roll the dice and add the roll to the player's sum
             * 3. If they want to skip their turn, do nothing
             * 4. If the player's sum is greater than 21, remove them from the players array
             * 5. If the player's sum is 21 or there are no other players in the game, end the game and declare that player the winner.
             */
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    continue;
                }
                String rollOrSkip = JOptionPane.showInputDialog("Player " + (i + 1) + ", do you want to roll the dice or skip your turn?");
                if (rollOrSkip.equals("roll")) {
                    players[i].rollDice();
                    JOptionPane.showMessageDialog(null, "Player " + (i + 1) + " rolled a " + players[i].getLastRoll() + " and has a sum of " + players[i].getSum() + ".");
                    if (players[i].getSum() > 21) {
                        players[i] = null;
                        JOptionPane.showMessageDialog(null, "Player " + (i + 1) + " has been removed from the game for rolling a total greater than 21.");
                    } else if (players[i].getSum() == 21) {
                        JOptionPane.showMessageDialog(null, "Player " + (i + 1) + " wins!");
                        System.exit(0);
                    }
                } else if (rollOrSkip.equals("skip")) {
                    continue;
                } else {
                    System.out.println("Invalid input");
                    System.exit(1);
                }
            }
        }
    }
}