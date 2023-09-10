import java.util.Arrays;
/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 4b
 * Teema: massiivid
 *
 * Autor: Matias Jürgenson
 *
 **********************************/
public class Kodu4b {

    /**
     * tagastab tabelina nii, et tabeli veergude
     * arv oleks võrdne ridade arvuga ja võimalikult väike.
     * Kui massiivi elemendid saavad otsa, jäävad tabeli viimased read lühemaks või
     * tühjaks jääda
     * @param a arvude massiiv
     * @return tabel, kuhu on arvumassiiv sisestatud
     */
    public static int[][] taidaMassiiv(int[] a) {
        // mitu arvu on arvumassiivis
        int arvudeArv = a.length;

        // leiab mis on kõige parem suurus massiivile
        int ruutmaariksiSuurus = (int)Math.ceil(Math.sqrt(arvudeArv));

        // kui mitu rida on lõppuni täidetud
        int maxRead = arvudeArv / ruutmaariksiSuurus;

        // pooliku rea pikkus
        int poolikRida = arvudeArv % ruutmaariksiSuurus;

        // teeb uue massiivi sobiliku ridade arvuga
        int[][] massiiv = new int[ruutmaariksiSuurus][];

        // arvumassiivi indeks
        int aIndeks = 0;

        // täidab kõik lõppuni täidetud read
        for (int rida = 0; rida < maxRead; rida++) {

            //täidab null massiivi uue kindla suurusega massiviga
            massiiv[rida] = new int[ruutmaariksiSuurus];
            for (int veerg = 0; veerg < ruutmaariksiSuurus; veerg++) {
                massiiv[rida][veerg] = a[aIndeks++];
            }
        }

        //kui kõik read pole lõppuni täidetud, lisab poolikud ja/või tühjad read
        if (maxRead != ruutmaariksiSuurus) {
            //täidab null massiivi uue kindla suurusega massiviga
            massiiv[maxRead] = new int[poolikRida];

            //täidab pooliku rea
            for (int veerg = 0; veerg < poolikRida; veerg++) {
                massiiv[maxRead][veerg] = a[aIndeks++];
            }

            //lisab kõik tühjad read
            for (int rida = maxRead + 1; rida < ruutmaariksiSuurus; rida++) {
                //täidab null massiivi uue kindla suurusega massiviga
                massiiv[rida] = new int[0];

            }
        }
        return massiiv;
    }

    /**
     * tagastab massiivi elemendid ühemõõtmelise massiivina viisil,
     * kuhu elemendid on salvestatud peadiagonaaliga paralleelsete
     * diagonaalide kaupa järjestuses vasakult paremale
     * @param b kahemõõtmeline massiiv
     * @return ühemõõtmeline massiiv
     */
    public static int[] diagonaalid(int[][] b) {
        //alustab vasakult alt nurgast, liigub üles, siis paremale lõppu

        //mitu rida on b-s
        int ridadeArv = b.length;

        int massiiviArvudeArv = 0;

        //leiab mitu arvu on massiiviis
        for (int rida = 0; rida < ridadeArv; rida++) {
            massiiviArvudeArv += b[rida].length;
        }

        //loob uue massiivi ja selle indeksi
        int[] diagonaalMassiiv = new int[massiiviArvudeArv];
        int dmIndeks = 0;

        //alustab diagonaalide lugemist alt vasakult ja liigub ülesse poole
        for (int rida = 0; rida < ridadeArv; rida++) {
            int vastandRida = ridadeArv - 1 - rida;

            //kui on tühirida siis liigub edasi
            if (b[vastandRida].length == 0) {
                continue;
            }

            //loeb diagonaali
            for (int diagonaal = 0; diagonaal < ridadeArv; diagonaal++) {

                //kontrollib et indeks poleks liiga suur või kui on poolik rida või tühi rida, siis liiub edasi
                if (vastandRida + diagonaal == ridadeArv || b[vastandRida + diagonaal].length <= diagonaal) {
                    break;
                }

                //paneb diagonaalis oleva arvu massiivi
                diagonaalMassiiv[dmIndeks++] = b[vastandRida + diagonaal][diagonaal];
            }
        }
        //alustab diagonaalide lugemist ülevalt 2-st veerust
        for (int veerg = 1; veerg < ridadeArv; veerg++) {

            //loeb diagonaali
            for (int diagonaal = 0; diagonaal < ridadeArv; diagonaal++) {

                //kontrollib et indeks poleks liiga suur või kui on poolik rida või tühi rida, siis liiub edasi
                if (veerg + diagonaal == ridadeArv || b[diagonaal].length <= diagonaal) {
                    break;
                }

                //paneb diagonaalis oleva arvu massiivi
                diagonaalMassiiv[dmIndeks++] = b[diagonaal][veerg + diagonaal];
            }
        }

       return diagonaalMassiiv;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] error = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        int[][] c = taidaMassiiv(error);
        System.out.println(Arrays.deepToString(c));
        //...
        int[][] d = taidaMassiiv(b);
        System.out.println(Arrays.deepToString(d));
        int[] f = diagonaalid(d);
        System.out.println(Arrays.toString(f));
        int[] e = diagonaalid(c);
        System.out.println(Arrays.toString(e));

        //...
    }//main

}//klass