public class Main {
    public String doubleChar(String str) {
        String return_str = "";
        for (int i = 0; i < str.length(); i++) {
            return_str += str.charAt(i);
            return_str += str.charAt(i);
        }
        return return_str;
    }

    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.startsWith("hi", i)) count++;
        }
        return count;
    }

    public boolean catDog(String str) {
        int cat_count = 0;
        int dog_count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.startsWith("cat", i)) cat_count++;
            if (str.startsWith("dog", i)) dog_count++;
        }
        return cat_count == dog_count;
    }
}