//import java.util.ArrayList;
//import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.changer(m.s, m.n);
        System.out.println(m);
    }

    private String s;
    private int n;

    public Main() {
        this.s = "world";
        this.n = 6;
    }

    public void changer(String x, int y) {
        x = x + "peace";
        y = y * 2;
    }

    public String toString() {
        return s + " " + n;
    }
}