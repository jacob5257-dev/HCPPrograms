public class Main {
    private Object storage;
    public Main(Object storage) {
        this.storage = storage;
    }

    public Object getStorage() {
        return storage;
    }

    public void setStorage(Object storage) {
        this.storage = storage;
    }

    public static void main(String[] args) {
        Main main = new Main(1);
        System.out.println(main.getStorage());
    }
}