public class Main {
    public static void main(String[] args) {
        /*
        In Pig Latin, you take the first letter and put it at the end of the word and add the letters “ay” to the end. For example, “pig” becomes “igpay”.

Create a program that takes a word and transforms it to Pig Latin using String methods. You may need the word’s length, a substring that does not include the first letter, and a substring that is just the first letter (you can get the ith letter of a string using substring(i,i+1) so for example the letter at index 3 would be substring(3,4)).
         */
        String originalWord = "failure";
        String pigLatin;

        char firstChar = originalWord.charAt(0);
        pigLatin = originalWord.substring(1) + firstChar + "ay";

        System.out.println(pigLatin);

    }
}