public class sum_reciprocal {
    public static void main(String[] args) {
        float[] recips = new float[10];
        for (float i = 1; i <= 10; i++) {
            int index = (int) i;
            recips[index - 1] = 1 / i;
        }
        float answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += recips[i];
        }
        System.out.println(answer);
    }
}