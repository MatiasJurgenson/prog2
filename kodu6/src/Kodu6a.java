import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 6a
 * Teema: rekursioon
 *
 * Autor: Matias Jürgenson
 *
 **********************************/
class Kodu6a {

    /**
     * leiab järjendist a saadavad aritmeetilised avaldised, mille väärtused kuuluvad etteantud lõiku [x; y],
     * tehtete + ja − korral.
     * @param a arvumassiiv
     * @param x lõigu algus
     * @param y lõigu lõpp
     * @return massiiv aritmeetilistest avaldistest, mille väärtused kuuluvad etteantud lõiku [x; y]
     */
	public static String[] avaldisedLõigus1(int[] a, int x, int y){

        //kui arvumassiiv tühi siis tagastab tühja sõna massiivi
        if (a.length == 0) {
            return new String[]{};
        }

        //uus järjend abimeetodi jaoks
        ArrayList<String> avaldised = new ArrayList<>();
        avaldisedLõigus1(a, x, y, 1, a[0], Integer.toString(a[0]) , avaldised);

        //järjend tehakse massiiviks üle
        String[] uus = new String[avaldised.size()];
        for (int i = 0; i < avaldised.size(); i++) {
            uus[i] = avaldised.get(i);
        }

        //massiiv sorteeritakse
        Arrays.sort(uus, new Comparator<String>() {
            public int compare(String tehe1, String tehe2) {
                int vastus1 = Integer.parseInt(tehe1.substring(tehe1.indexOf("=") + 1));
                int vastus2 = Integer.parseInt(tehe2.substring(tehe2.indexOf("=") + 1));
                return Integer.compare(vastus1, vastus2);
            }
        });

        return uus;
	}

    /**
     * leiab järjendist a saadavad aritmeetilised avaldised, mille väärtused kuuluvad etteantud lõiku [x; y],
     * tehtete + ja − korral.
     * @param a arvumassiiv
     * @param x lõigu algus
     * @param y lõigu lõpp
     * @param indeks mitmendat a elemendti vaadatakse
     * @param tehe massiivist saadud arvude summa
     * @param lause tehtud arvutused
     * @param avaldised järjend aritmeetilistest avaldistest, mille väärtused kuuluvad etteantud lõiku [x; y]
     * @return järjrnd aritmeetilistest avaldistest, mille väärtused kuuluvad etteantud lõiku [x; y]
     */
    public static ArrayList<String> avaldisedLõigus1(int[] a, int x, int y, int indeks, int tehe, String lause, ArrayList<String> avaldised){

        //kui peale viimast arvutamist tehe ei ole vahemikus, siis seda tehet ei lisata
        if (indeks == a.length && (tehe < x || tehe > y)) {
            return avaldised;
        }

        //kui tehe on vahemikus lisatakse järjendisse
        if (indeks == a.length) {
            avaldised.add(lause + "=" + tehe);
            return avaldised;
        }

        //teeb läbi kõik arvutused + ja - korral
        avaldisedLõigus1(a, x, y, indeks + 1, tehe + a[indeks], lause + "+" + a[indeks], avaldised);
        avaldisedLõigus1(a, x, y, indeks + 1, tehe - a[indeks], lause + "-" + a[indeks], avaldised);

        return avaldised;
    }

    public static void main(String[] args) {
        int[] a = {2,12,5,2};
        int[] b = {};
        int x1 = -15;
        int y1 = 15;
        int x2 = -30;
        int y2 = 30;

        System.out.println(Arrays.toString(avaldisedLõigus1(a, x1, y1)));
        System.out.println(Arrays.toString(avaldisedLõigus1(a, x2, y2)));
        System.out.println(Arrays.toString(avaldisedLõigus1(b, x1, y1)));
        System.out.println(Arrays.toString(avaldisedLõigus1(b, x2, y2)));

    }//peameetod


}//Kodu6a
