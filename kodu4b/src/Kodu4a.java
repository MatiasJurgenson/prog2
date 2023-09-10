
public class Kodu4a {

    public static int[] pikendatudDiagonaal(int[][] a) {
        return null;
    }

    public static int ruutÜhtedest(boolean[][] a) {
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {
                {8, 8, 7, 9, 1},
                {2, 1, 8, 7, 6},
                {4, 9, 5, 3, 2},
                {9, 5, 8, 4, 5},
                {6, 2, 7, 6, 8},
                {3, 8, 8, 7, 1},
                {7, 3, 3, 4, 9},
                {8, 0, 0, 9, 7},
        };

        boolean[][] b = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        int[] c = pikendatudDiagonaal(a);
        //...
        long start = System.currentTimeMillis(); //AEG KÄIMA

        int parimN = ruutÜhtedest(b);

        long stop = System.currentTimeMillis();//AEG KINNI
        System.out.println("Aega kulus " + (stop - start)
                + " milliskundit");
        System.out.println("Parim n=" + parimN);
    }//main

}//klass