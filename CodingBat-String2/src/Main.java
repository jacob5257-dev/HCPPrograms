public class Main {
    public String doubleChar(String str) {
        String return_str = "";
        for (int i = 0; i < str.length(); i++) {
            return_str += str.charAt(i);
            return_str += str.charAt(i);
        }
        return return_str;
    }

}