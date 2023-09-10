public class NäitedAbi { // Jaan Janno 2023 - jaan.janno@ut.ee

    public static void main(String[] args) {
        /*
         Näited abimeetodite kasutamisest:
         */
        int[][] uus = new int[2][3];
        Abi.väljasta(uus); // arvumassiivi väljastamine.

        char[][] tühi = Abi.tühi(4, 5); // tühikuid sisaldava sümbolimassiivi genereerimine.
        tühi[0][0] = 'X';
        tühi[3][4] = 'X';
        Abi.väljasta(tühi); // sümbolimassiivi väljastamine.

        char[][] juhuslik1 = Abi.juhuslik(6, 6); // juhusliku sümbolimassiivi genereerimine.
        Abi.väljasta(juhuslik1);

        int[][] juhuslik2 = Abi.juhuslik(4, 4, 0, 9); // juhusliku arvumassiivi genereerimine.
        Abi.väljasta(juhuslik2);

        char[][] koopia1 = Abi.koopia(juhuslik1); // Koopia loomine sümbolimaatriksist.
        int[][] koopia2 = Abi.koopia(juhuslik2); // Koopia loomine arvumaatriksist.

        /*
         Näiteid 2-mõõtmelise massiivi töötlusest:
         */
        System.out.println("\nNullidest koosnev massiiv peale muutusi:");
        uus[1][2] = 9; // Reale indeksil 1 ja veerule indeksil 2 sisestame uue väärtuse 9.
        uus[1][0] += 3; // Reale indeksil 1 ja veerule indeksil 0 sisestame liidame 3.
        Abi.väljasta(uus);

        System.out.println("\nKäsitsi tsükliga läbimised:");

        // Läbimine tsükliga rida ja element haaval:
        int summa1 = 0;
        for (int[] arvurida : juhuslik2) {
            for (int arv : arvurida) {
                summa1 += arv; // liidame kõik arvud kokku.
            }
        }
        System.out.println(summa1);

        // Läbimine indekseid jälgides:
        int summa2 = 0;
        for (int i = 0; i < juhuslik2.length; i++) { // indeksid 0-st ridade arvuni.
            for (int j = 0; j < juhuslik2[0].length; j++) { // indeksid 0-st kuni ühe rea pikkuseni.
                int element = juhuslik2[i][j]; // element tsüklimuutujatest olenevast reast/veerust.
                if (i % 2 == 0)
                    summa2 += element; // liidame kõik paarisarvulistel indeksitel asuvad arvud kokku.
            }
        }
        System.out.println(summa2);
    }
}