import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SubClass a = new SubClass("a");
    }
}

class SuperClass {
    private String name;

    public SuperClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class SubClass extends SuperClass {
    private String type;
    public SubClass(String name) {
        type = name;
    }
}