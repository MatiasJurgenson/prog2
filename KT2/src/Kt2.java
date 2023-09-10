import java.util.Arrays;

/**
 * Õpilase nimi: Matias Jürgenson
 * Programmeerimine 2 - KT 2 19.04.2023. Palume mitte "package" märksõna lisada,
 * koodis meetodite signatuure muuta, ega (ka tühje) meetodeid kustutada!
 * Kui meetodi sisu ei realiseeri, siis jäta rida "throw new UnsupportedOperationException("Implementeerimata!");" alles
 * Kui realiseerid, siis kustuta see ära. 
 */
public class Kt2 {

    public static int vahelduvSumma(int [] a){
        //throw new UnsupportedOperationException("Implementeerimata!");
        return vahelduvSummaAbi(a, 0, 0);
    }

    /**
     * abimeetod VahelduvSumma-le, mis teeb ära vajalikud tehted summa leidmiseks
     * @param a etteantud massiiv
     * @param indeks mitmendat arvu vaadatakse
     * @param summa tehte hetke summa
     * @return lõppsumma
     */
    public static int vahelduvSummaAbi(int[] a, int indeks, int summa){
        //kui jõuti lõppu
        if (indeks == a.length) return summa;
        if (indeks % 2 == 1) {
            //kui indeks on paaritu lahutadakse summast indeksil olev arv
            return vahelduvSummaAbi(a, indeks + 1, summa - a[indeks]);
        } else {
            //kui indeks on paaris liidetakse summale juurde indeksil olev arv
            return vahelduvSummaAbi(a, indeks + 1, summa + a[indeks]);
        }

    }

    public static int mitteKõrvuti(int[] a) {
        //throw new UnsupportedOperationException("Implementeerimata!");
        return mitteKõrvutiAbi(a, 0, "");
    }

    /**
     * abimeetod mitteKõrvuti-le, mis väljastab ja tagastab kõik võimalik osajärjendid, mille arvud pole kõrvuti
     * @param a etteantud massiiv
     * @param indeks mitmendat massiivi elemendti vaadatakse
     * @param sõne mittekõrvuti olevate arvude sõne
     * @return mitu sellist osajärjendit on
     */
    public static int mitteKõrvutiAbi(int[] a, int indeks, String sõne) {
        //kui jõutu lõppu väljastadakse osajärjend ja antakse edasi teada, et selline leidus
        if (indeks >= a.length) {
            if (sõne.length() == 0) {
                System.out.println("[]");
            } else {
                System.out.println("[" + sõne.substring(2) + "]");
            }
            return 1;
        }
        //kui arvu vastaval indeksil ei võeta arvesse (ei lisata osajärjendisse), minnakse ühe indeksi võrra edasi
        //kui aga võetakse arvesse (lisatakse osajärjendisse), siis minnakse 2 võrra edasi,
        //et osajärjendisse ei tekkiks kahte või rohkem kõrvuti olevat arvu
        return mitteKõrvutiAbi(a, indeks + 1, sõne) +
                    mitteKõrvutiAbi(a, indeks + 2, sõne + ", " + a[indeks]);
    }

    public static void põimi(int[] a, int[] b) {
        //throw new UnsupportedOperationException("Implementeerimata!");
        int[] c = new int[0];
        //massiivide ühendamine
        int[] tulemus = kokku(a, b, 0, 0, c);
        Arrays.sort(tulemus);
        väljasta(tulemus, 0);
    }

    /**
     * abimeetod massiivis olevate arvude välasjtamiseks
     * @param a etteantud massiiv
     * @param indeks mitmendat arvu väljastadakse
     */
    public static void väljasta(int[] a, int indeks) {
        //kui jõuti lõppu lõpetadakse töö
        if (indeks == a.length) return;
        //muidu välastadakse väärtus ja minnakse edasi
        System.out.println(a[indeks]);
        väljasta(a, indeks + 1);
    }

    /**
     * abimeetod kahe massiivi ühendamiseks teise, nii et korduvaid arve poleks
     * @param a etteantud esimene massiiv
     * @param b etteantud teine massiiv
     * @param indeksA mitmendat a elementi vaadatakse
     * @param indeksB mitmendat b elementi vaadatakse
     * @param c massiiv kuhu mittekorduvad väärtused lisatakse
     * @return kahe massiivi ühend, ilma korduvate arvudega
     */
    public static int[] kokku(int[] a, int[] b, int indeksA, int indeksB, int[] c) {
        //kui jõuti b lõppu siis on mõlemad massiivid läbivaadatud
        if (indeksB == b.length) return c;
        //kui jõuti a lõppu lisatakse b massiivi mittekorduvad elemndid c-sse
        if (indeksA == a.length) {
            //kui b massiivi indeksil olev väärtus on juba olemas
            if(sisaldab(c, 0, b[indeksB])) {
                //kui sisaldab minnakse järgmise arvu juurde
                return kokku(a, b, indeksA, indeksB + 1, c);
            } else {
                //kui ei sisalda lisatakse c-sse see juurde
                return kokku(a, b, indeksA, indeksB + 1, lisa(c , b[indeksB]));
            }
        //muidu vaadatakse a massiivi
        } else {
            //kui a massiivi indeksil olev väärtus on juba olemas
            if(sisaldab(c, 0, a[indeksA])) {
                //kui sisaldab minnakse järgmise arvu juurde
                return kokku(a, b, indeksA + 1, indeksB, c);
            } else {
                //kui ei sisalda lisatakse c-sse see juurde
                return kokku(a, b, indeksA + 1, indeksB, lisa(c , a[indeksA]));
            }
        }
    }

    /**
     * abimeetod, mis vaatab kas massiiv sisaldab mingit väärtust
     * @param a etteantud massiv
     * @param indeks mitmendat massiivi a elementi vaadatakse
     * @param väärtus väärtus, mida kontrollitakse, kas see on massiivi sees
     * @return kas massiiv sisaldab arvu või mitte (true/flase)
     */
    public static boolean sisaldab(int[] a, int indeks, int väärtus) {
        //kui jõuti lõppu siis ei sisalda
        if (indeks == a.length) return false;
        //kui indeksil on väärtus tagastakse true
        if (a[indeks] == väärtus) return true;
        //muidu minnakse edasi
        return sisaldab(a, indeks + 1, väärtus);
    }

    /**
     * abimeetod uue arvu lisamiseks massiivi
     * @param massiiv etteantud massiiv
     * @param arv väärtus, mida sisestadakse
     * @return uus massiiv kuhu on väärtus juurde lisatud
     */
    public static int[] lisa(int[] massiiv, int arv) {
        //luuakse uus massiiv, mis on ühe võrra suurem
        int[] uus = new int[massiiv.length + 1];
        //uute massiivi pannakse vana massiiv
        System.arraycopy(massiiv, 0, uus, 0, massiiv.length);
        //lisatakse uus väärtus uue massiivi lõppu
        uus[massiiv.length] = arv;
        return uus;
    }

    public static void main(String[] args) {
        // Siin võib vabas vormis oma lahendust testida.
        // Automaattestid tõid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)

        //ül1
        int[] a = {7,2,3};
        int[] b = {3,1};
        int[] c = {};
        System.out.println(vahelduvSumma(a));
        System.out.println(vahelduvSumma(b));
        System.out.println(vahelduvSumma(c));

        //ül2
        int[] d = {1,2,3,4,5};
        int[] e = {1,2,2};
        System.out.println(mitteKõrvuti(d));
        System.out.println(mitteKõrvuti(e));

        //ül3
        int[] k = {1,2,3};
        int[] k2 = {1,2,2,3};
        int[] l = {4,4};
        int[] m = {3,4,5};
        int[] n = {2,3};

        System.out.println();
        põimi(k, l);
        System.out.println();
        põimi(k, m);
        System.out.println();
        põimi(n, k2);



    }
}