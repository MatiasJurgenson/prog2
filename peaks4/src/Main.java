import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Abi.väljasta(yl1a(5));
    }

    public static char[][] yl1a(int n) {
        char[][] m = new char[n][n];
        Arrays.fill(m[0], '#');
        for (int i = 0; i <n-1; i++) {
            m[i][0] = '#';
            m[i][n-1] = '#';
        }
        Arrays.fill(m[n-1], '#');
        return m;
    }
}