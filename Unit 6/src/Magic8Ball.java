import java.util.Random;

/*
 * Class Magic8Ball
 * Runs a simulated magic 8 ball with JOptionPane.
 * Magic8Ball.main() = runs program. Shows dialog box until cancel button is clicked.
 */
public class Magic8Ball {
    public Magic8Ball() {
    }


    public String getResponse() {
        Random random = new Random();
        //List of potential responses by the 8 ball
        String[] responses = {"It is certain", "Reply hazy, try again", "Don't count on it", "It is decidedly so", "Ask again later", "My reply is no", "Without a doubt", "Better not tell you now", "My sources say no", "Yes definitely", "Cannot predict now", "Outlook not so good", "You may rely on it", "Concentrate and ask again", "Very doubtful", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes"};
        return responses[random.nextInt(responses.length)];
    }
}