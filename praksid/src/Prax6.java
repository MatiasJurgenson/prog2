public class Prax6 {
    public static void  yl1(int n) {
        yl1(n, "");
    }

    public static void  yl1(int n, String s) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.println(s.substring(1));
            return;
        }

        yl1(n - 3, s + "+3");
        yl1(n - 2, s + "+2");
    }

    public static int yl2(int n) {
        return yl2(n, "");
    }

    public static int yl2(int n, String s) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            System.out.println(s.substring(1));
            return 1;
        }

        return yl2(n - 5, s + "+5") + yl2(n - 4, s + "+4") + yl2(n - 3, s + "+3");

    }

    public static boolean yl3(int[] hinnad) {
        return yl3(hinnad, 0, 0);
    }

    public static boolean yl3(int[] hinnad, int index, int summa) {
        if (50 <= summa && summa <= 55) {
            return true;
        }
        if (summa > 55) {
            return false;
        }
        if (index == hinnad.length) {
            return false;
        }

        return yl3(hinnad, index + 1, summa) || yl3(hinnad, index + 1, summa + hinnad[index]);
    }

    public static void main(String[] args) {
        yl1(8);
        System.out.println("---------------------");
        System.out.println(yl2(9));
        System.out.println("---------------------");
        int[] hinnad = new int[] {60,   15, 10, 30, 20};
        System.out.println(yl3(hinnad));
    }
}
