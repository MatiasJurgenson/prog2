public class Main {

    public static int yl1atsükkel(int[] massiiv) {
        int summa = 0;
        for (int arv : massiiv) {
            summa += arv;
        }
        return summa;
    }
    public static int yl1aunaarne(int[] massiiv, int indeks) {
        if (indeks == massiiv.length) {
            return 0;
        }
        return massiiv[indeks] + yl1aunaarne(massiiv, indeks + 1);
    }
    public static int yl1abinaarne(int[] massiiv) {
        return 0;
    }
    public static int yl1btsükkel(int[] massiiv) {
        int min = Integer.MAX_VALUE;
        for (int arv : massiiv) {
            min = Math.min(min, arv);
        }
        return min;
    }
    public static int yl1bunaarne(int[] massiiv, int indeks) {
        if (indeks == massiiv.length) {
            return Integer.MAX_VALUE;
        }
        return Math.min(massiiv[indeks], + yl1bunaarne(massiiv, indeks + 1));
    }
    public static double yl6(double[] massiiv, int indeks) {
        if (indeks == massiiv.length) {
            return 1;
        }
        if (massiiv[indeks] == 0) {
            massiiv[indeks] = 1;

        }
        return massiiv[indeks] * yl6(massiiv, indeks + 1);
    }

    public static void main(String[] args) {
        double[] massiiv = {0.0, 4.0, 2.7};
        System.out.println(yl6(massiiv, 0));
    }
}