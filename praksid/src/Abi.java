// Tõsta see klass oma projekti juurkausta, et siinseid abimeetodeid mujal klassides kasutada.
public class Abi { // Jaan Janno 2023 - jaan.janno@ut.ee
    /***
     * @param ridu Ridade arv koostatavas maatriksis.
     * @param veerge Veergude arv koostatavas maatriksis.
     * @return Tühikusümboleid sisaldav 2-mõõtmeline maatriks.
     */
    public static char[][] tühi(int ridu, int veerge) {
        char[][] maatriks = new char[ridu][veerge];
        for (int i = 0; i < ridu; i++)
            for (int j = 0; j < veerge; j++)
                maatriks[i][j] = ' ';
        return maatriks;
    }

    /***
     * @param ridu Ridade arv koostatavas maatriksis.
     * @param veerge Veergude arv koostatavas maatriksis.
     * @return Juhuslikke sümboleid sisaldav 2-mõõtmeline maatriks.
     */
    public static char[][] juhuslik(int ridu, int veerge) {
        char[][] maatriks = new char[ridu][veerge];
        for (int i = 0; i < ridu; i++)
            for (int j = 0; j < veerge; j++)
                maatriks[i][j] = (char) ('a' + (26 * Math.random()));
        return maatriks;
    }

    /***
     * @param ridu Ridade arv koostatavas maatriksis.
     * @param veerge Veergude arv koostatavas maatriksis.
     * @param min Minimaalne juhusliku arvu väärtus.
     * @param max Maksimaalne juhusliku arvu väärtus.
     * @return Juhuslikke arve sisaldav 2-mõõtmeline maatriks.
     */
    public static int[][] juhuslik(int ridu, int veerge, int min, int max) {
        int[][] maatriks = new int[ridu][veerge];
        for (int i = 0; i < ridu; i++)
            for (int j = 0; j < veerge; j++)
                maatriks[i][j] = (int) (min + (max - min + 1) * Math.random());
        return maatriks;
    }

    /***
     * Väljastab parameetriks antud maatriksi.
     * @param maatriks Väljastatav sümbolimaatriks.
     */
    public static void väljasta(char[][] maatriks) {
        for (char[] rida : maatriks) {
            for (char sümbol : rida)
                System.out.print(sümbol);
            System.out.println();
        }
    }

    /***
     * Väljastab parameetriks antud maatriksi.
     * @param maatriks Väljastatav arvumaatriks.
     */
    public static void väljasta(int[][] maatriks) {
        for (int[] rida : maatriks) {
            for (int arv : rida)
                System.out.print(arv);
            System.out.println();
        }
    }

    /***
     * @param maatriks Algne maatriks, mis säilib muutumatuna.
     * @return Uus maatriks, mis on sama sisuga, mis argument.
     */
    public static char[][] koopia(char[][] maatriks) {
        char[][] koopia = new char[maatriks.length][maatriks[0].length];
        for (int i = 0; i < koopia.length; i++)
            for (int j = 0; j < koopia[0].length; j++)
                koopia[i][j] = maatriks[i][j];
        return koopia;
    }

    /***
     * @param maatriks Algne maatriks, mis säilib muutumatuna.
     * @return Uus maatriks, mis on sama sisuga, mis argument.
     */
    public static int[][] koopia(int[][] maatriks) {
        int[][] koopia = new int[maatriks.length][maatriks[0].length];
        for (int i = 0; i < koopia.length; i++)
            for (int j = 0; j < koopia[0].length; j++)
                koopia[i][j] = maatriks[i][j];
        return koopia;
    }
}
