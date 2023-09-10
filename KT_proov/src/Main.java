import java.util.Arrays;

public class Main {
    public static int[] korruta2ga(int[] a) {
        return korruta2ga_abi(a, 0);
    }
    private static int[] korruta2ga_abi(int[] a, int i) {
        if (i == a.length || a[i] == 0) return a;
        a[i] *= 2;
        return korruta2ga_abi(a, i+1);
    }


    public static void nullSumma(int n) {
        nullSumma_abi(n, "", 0);
    }
    private static void nullSumma_abi(int n, String s, int sum) {
        if (s.length() > 0 && sum == 0) System.out.println(s);
        if (n == 0) return;
        nullSumma_abi(n-1, s+"-1", sum-1);
        nullSumma_abi(n-1, s+"+1", sum+1);
    }

    public static int valikK(int[] mas, int k) {
        return valikK_abi(mas, k, 0);
    }
    private static int valikK_abi(int[] mas, int k, int j) {
        int n = 0;
        for (int i = j; i < mas.length; i++) {
            if (mas[i] > 0) n += valikK_abi(mas, k-1, i+2);
        }
        if (k >= 0) n++;
        return n;
    }

    public static void main(String[] args) {
        System.out.println("korruta2ga({1, -2, -3}):");
        System.out.println(Arrays.toString(korruta2ga(new int[] {1, -2, -3})));

        System.out.println("korruta2ga({5, 0, 2, -1}):");
        System.out.println(Arrays.toString(korruta2ga(new int[] {5, 0, 2, -1})));

        System.out.println("\n"+"nullSumma(3):");
        nullSumma(3);
        System.out.println("\n"+"nullSumma(4):");
        nullSumma(4);

        System.out.println("\n"+"valikK({1, 2, -3, 4, -5, 6}, 3):");
        System.out.println(valikK(new int[] {1, 2, -3, 4, -5, 6}, 3));
    }
}