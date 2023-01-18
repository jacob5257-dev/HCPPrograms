import java.util.Random;
/**
 * This class represents a magic 8 ball.
 * @author jacob5257
 * @version 1.0
 * @since 2023-01-18
 * @see Magic8Ball
 * @see Magic8BallTest
 */
public class Magic8Ball {
    /**
     * This method creates a magic 8 ball.
     * @since 2023-01-18
     * @version 1.0
     * @author jacob5257
     * @see Magic8Ball
     * @see Magic8BallTest
     */
    public Magic8Ball() {
    }

    /**
     * This method returns a random response from the 8 ball.
     * @return A random response from the 8 ball.
     */
    public String getResponse() {
        // Pulls a random element from the list of responses.
        Random random = new Random();
        //List of potential responses by the 8 ball
        String[] responses = {"It is certain", "Reply hazy, try again", "Don't count on it", "It is decidedly so", "Ask again later", "My reply is no", "Without a doubt", "Better not tell you now", "My sources say no", "Yes definitely", "Cannot predict now", "Outlook not so good", "You may rely on it", "Concentrate and ask again", "Very doubtful", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes"};
        return responses[random.nextInt(responses.length)];
    }
}