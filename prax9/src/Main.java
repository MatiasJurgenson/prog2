import java.util.Arrays;

public class Main {

    public static void yl1(int[] a) {
        int [][] tulemus = yl1(a, 0, new int[0], new int[0]);
        System.out.println(Arrays.toString(tulemus[0]));
        System.out.println(Arrays.toString(tulemus[1]));

    }

    public static int[][] yl1(int[] a, int indeks, int[] b, int[] c) {
        if (indeks == a.length) return new int[][] {b, c};
        if (indeks % 2 == 0) {
            return yl1(a, indeks + 1, lisa(b, a[indeks]), c);
        }
        return yl1(a, indeks + 1, b, lisa(c, a[indeks]));
    }

    public static int[] lisa(int[] massiiv, int väärtus) {
        int[] uus = new int[massiiv.length + 1];
        System.arraycopy(massiiv, 0, uus, 0, massiiv.length);
        uus[massiiv.length] = väärtus;
        return uus;
    }

    public static int[] ÜhendaMassiivid(int[] massiiv1, int[] massiiv2) { // 1,2,3 ja 4,5,6
        int[] tulemus = new int[massiiv1.length + massiiv2.length];
        int indeks = 0;

        for (int i = 0; i < massiiv1.length; i++) {
            tulemus[indeks++] = massiiv1[i];
        }

        for (int i = 0; i < massiiv2.length; i++) {
            tulemus[indeks++] = massiiv2[i];
        }

        return tulemus; //1,2,3,4,5,6
    }


    public static void main(String[] args) {
        yl1(new int[] {1,2,3,4,5});
    }
}