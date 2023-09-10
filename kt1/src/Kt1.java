import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Õpilase nimi: Matias Jürgenson
 * Programmeerimine 2 - KT 1 15.03.2023. Palume mitte "package" märksõna lisada,
 * koodis meetodite signatuure muuta, ega (ka tühje) meetodeid kustutada!
 */
public class Kt1 {

    public static void kaheksanurk(int n){
        //prindib esimese rea
        System.out.println(" ".repeat(n-1) + "+".repeat(n));
        //konstantne muutuja ridade tühikute jaoks
        int i = 0;
        //prindib esimesed diagonaalid
        for (; i < n - 2; i++) {
            System.out.println(" ".repeat(n-2-i) + "+" + " ".repeat(n + i*2) + "+");
        }
        //printid vertikaalküljed (n-1)-ni
        for (int j = 0; j < n - 1; j++) {
            //print +
            System.out.println("+" + " ".repeat(n + i*2) + "+");
        }
        //prindib vertikaalkülje n-1 ja viimased diagonaalid
        for (; i > -1; i--) {
            System.out.println(" ".repeat(n-2-i) + "+" + " ".repeat(n + i*2) + "+");
        }
        //print viimane rida
        System.out.println(" ".repeat(n-1) + "+".repeat(n));

    }

    public static int[] võrdseSummagaAlamjärjendid(int[] a) {

        //konstant a massiivi pikkuse jaoks
        int pikkus = a.length;

        //vaatab läbi kõik alamjärjendil, mis algavad indeksiga i, mis on väiksemad kui a pikkus - 1
        //ja mis lõppevad indeksiga j
        for (int i = 0; i < pikkus - 1; i++) {
            for (int j = i; j < pikkus-1; j++) {

                //vaatab läbi kõik alamjärjendil, mis algavad indeksiga k
                //ja mis lõppevad indeksiga l
                for (int k = j+1; k < pikkus; k++) {
                    for (int l = k; l < pikkus; l++) {

                        //esimese alamjärjendi summa
                        int summa1 = 0;
                        for (int alam1Pikkus = i; alam1Pikkus <= j; alam1Pikkus++) {
                            summa1 += a[alam1Pikkus];
                        }

                        //teise alamjärjendi summa
                        int summa2 = 0;
                        for (int alam2Pikkus = k; alam2Pikkus <= l; alam2Pikkus++) {
                            summa2 += a[alam2Pikkus];
                        }

                        //kui summad võrdsed siis tagastab indeksid
                        if (summa1 == summa2) {
                            int[] vastus = {i,j,k,l};
                            return vastus;
                        }
                    }
                }
            }
        }
        //kui ei leidu tagastab null
        return null;
    }

    public static void lükeDiagonaalis(int[][] a) {
        //tee koopia
        //for rida
            //try diagonaali vahetada
            //catch vaheta diagonaali algus
        //for veerg
            //try diagonaali vahetada
            //catch vaheta diagonaali algus
    int[][] koopia = a.clone();

        for (int i = 0; i < a.length; i++) {
            for (int diagonaal = 0; diagonaal < a[0].length; diagonaal++) {
                try {
                    a[a.length - i + diagonaal][diagonaal+1] = koopia[a.length - 1 - i + diagonaal][diagonaal];
                } catch (Exception e) {
                    a[a.length - 1 - i][0] = koopia[a.length - 1 - i + diagonaal][diagonaal];
                }
            }
        }
        for (int veerg = 1; veerg < a.length; veerg++) {
            for (int diagonaal = 0; diagonaal < a[0].length; diagonaal++) {
                try {
                    a[diagonaal+diagonaal][veerg+diagonaal] = koopia[diagonaal + 1][veerg+1+diagonaal];
                } catch (Exception e) {
                    a[0][veerg] = koopia[diagonaal + 1][veerg+1+diagonaal];
                }
            }
        }
    }

    public static void main(String[] args) {
        // Siin võib vabas vormis oma lahendust testida.
        // Automaattestid tõid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)
        /* System.out.println("kaheksanurk(4):");
        kaheksanurk(4);
        System.out.println("kaheksanurk(2):");
        kaheksanurk(2);
        System.out.println("kaheksanurk(3):");
        kaheksanurk(3);
        System.out.println("kaheksanurk(6):");
        kaheksanurk(6); */

        int[] a = {11, 3, 14, 9, 16, 13, 15, 18};

        int[] b = võrdseSummagaAlamjärjendid(a);
        System.out.println(Arrays.toString(b));

        int[][] c = {{11, 1, 22, 5}, {0, 43, 7, 6}, {3, 7, 8, 9}, {5, 6, 5, 61}};
        lükeDiagonaalis(c);


    }
}