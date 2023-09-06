public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.shuffle();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        player1.setCards(table.deal(), table.deal());
        player2.setCards(table.deal(), table.deal());
        player3.setCards(table.deal(), table.deal());
        player4.setCards(table.deal(), table.deal());
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(player4);

    }
}