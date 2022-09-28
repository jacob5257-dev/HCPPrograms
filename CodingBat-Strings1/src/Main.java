public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public String helloName(String name) {
        return "Hello " + name + "!";
    }

    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    public String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    public String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }

    public String extraEnd(String str) {
        String substring = str.substring(str.length() - 2, str.length());
        return substring + substring + substring;
    }

    public String firstTwo(String str) {
        if (str.length() >= 2) return str.substring(0, 2);
        else return str;
    }

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }

    public String comboString(String a, String b) {
        if (a.length() > b.length()) return b + a + b;
        else return a + b + a;
    }

    public String nonStart(String a, String b) {
        return a.substring(1, a.length()) + b.substring(1, b.length());
    }
    public String left2(String str) {
        String x = str.substring(0, 2);
        return str.substring(2, str.length()) + x;
    }
    public String right2(String str) {
        String x = str.substring(str.length() - 2, str.length());
        return x + str.substring(0, str.length() - 2);
    }
    public String theEnd(String str, boolean front) {
        if (front) return str.substring(0, 1);
        else return str.substring(str.length() - 1, str.length());
    }
    public String withouEnd2(String str) {
        if (str.length() < 2) return "";
        return str.substring(1, str.length() - 1);
    }

}