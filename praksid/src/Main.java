public class Main {

    public static void main(String[] args) {
        kaks();
    }

    public static void viisä(int n) {
        System.out.println("#".repeat(n));
        for(int i = 0; i < n -2; i++) {
            System.out.println("#" + " ".repeat(n - 2) + "#");
        }
        System.out.println("#".repeat(n));

    }
    public static void viisc(int n) {
        int tühikud = 0;
        for(int i = 0; i <= n; i++) {
            System.out.println(" ".repeat(tühikud) + "#".repeat(i));
            tühikud += i;

        }
    }
    //uwu
    public static void viisg(int n) {
        System.out.println(" ".repeat(n-1) + "#");
        for(int i = 0; i < n-1; i++) {
            System.out.println(" ".repeat(n-2-i) + "#" + " ".repeat(i) + "#");
        }
        for(int i = n-3; i >= 0; i--) {
            System.out.println("#" + " ".repeat(i) + "#");
        }
        System.out.println("#");
    }

    public static void kaks() {
        int a = 1089;
        System.out.println((a / 100));
    }
}