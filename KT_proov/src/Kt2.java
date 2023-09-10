import java.util.Arrays;
//todo see on näidis kt
public class Kt2 {
    public static void main(String[] args) {
        System.out.println("Ülesanne 1");

        int[] massiiv1 = new int[]{1, -2, 3};
        int[] tulemus1 = korruta2ga(massiiv1);
        System.out.println(Arrays.toString(tulemus1) + " -> " + Arrays.toString(tulemus1));

        int[] massiiv2 = new int[]{5, 0, 2, -1};
        int[] tulemus2 = korruta2ga(massiiv2);
        System.out.println(Arrays.toString(tulemus1) + " -> " + Arrays.toString(tulemus2));

        System.out.println("\nÜlesanne 2");

        int n1 = 3;
        System.out.println("nullSumma(n), kui n = " + n1 + ":");
        nullSumma(n1);

        int n2 = 4;
        System.out.println("nullSumma(n), kui n = " + n2 + ":");
        nullSumma(n2);

        System.out.println("\nÜlesanne 3");
        int[] massiiv3 = {1, 2, -3, 4, -5, 6};
        int k = 3;
        int komplektideArv = valikK(massiiv3, k);
        System.out.println("valikK(" + Arrays.toString(massiiv3) + ", " + k + ") = " + komplektideArv);
    }

    /**
     * Ülesanne 1
     *
     * @param a Antud massiiv.
     * @return Uus massiiv, milles on antud massiivi elemendid kuni esimese nullini korrutatud 2-ga ja sellest edasi
     * muutmata kujul.
     */
    public static int[] korruta2ga(int[] a) {
        // Anname abimeetodile algse massiivi ja indeksi, millega selle läbmist reguleerida. Lisame tõeväärtuse, kas
        // nulli on juba kohatud algväärtusega false. Anname uue tühja massiivi, millesse lisandub tulemus.
        return korruta2gaRek(0, a, false, new int[a.length]);
    }

    /**
     * Kasutame unaarse rekursiooni strateegiat, kus meetodi väljakutses töötleme ühe elemendi ning ülejäänud elementide
     * täötlemise delegeerime rekursioonile.
     *
     * @param i            Mitmenda elemendi kohta otsust teeme.
     * @param a            Kõikide elementide massiiv.
     * @param nulliKohatud Meenutame, kas oleme varasemalt juba 0-i kohanud.
     * @param uusMassiiv   Jooksvalt koostatav uus massiiv.
     * @return Koopia massiivist a, kus esimese 0-ni on elemendid 2-kordistatud.
     */
    private static int[] korruta2gaRek(int i, int[] a, boolean nulliKohatud, int[] uusMassiiv) {
        if (i == a.length) // Kui kõik elemendid on töödeldud, siis oleme valmis ja ..
            return uusMassiiv; // .. saame tagastada massiivi.
        // Kui on veel elemente, mida töödelda, siis käesolevas meetodi väljakutses töötleme ühe elemendi..
        if (a[i] == 0) // Esiteks kui järgnev element on 0, siis ..
            nulliKohatud = true; // .. jätame meelde, et oleme nulli kohanud.
        if (nulliKohatud) // Olenevalt kas oleme varasemalt nulli kohanud, siis ..
            uusMassiiv[i] = a[i]; // .. kas jätame elemendi samaks,
        else // .. või kui null on veel kohtamata, siis ..
            uusMassiiv[i] = 2 * a[i]; // .. korrutame elemendi kahega enne tulemusse lisamist.
        // Elemnentide töötlemise alates indeksist i+1 delegeerime juba rekursioonile.
        return korruta2gaRek(i + 1, a, nulliKohatud, uusMassiiv);
    }

    /**
     * Ülesanne 2
     * <p>
     * Väljastab ekraanile kõik võimalused esitada arv 0 liidetavate −1 ja 1 summadena, kus liidetavate koguarv ei tohi
     * ületada arvu n, kuid peab olema suurem 0-st
     *
     * @param n Liidetavate koguarv, mida pole lubatud ületada.
     */
    public static void nullSumma(int n) {
        // Delegeerime töö abimeetodile, mis peab argumendina meeles koostatavat summat sõnena ja arvuna.
        nullSummaRek(n, "", 0);
    }

    /**
     * Väljastab ekraanile kõik võimalused esitada arv 0 liidetavate −1 ja 1 summadena, mis algavad sõnega summaSõne,
     * kus veel juurde liidetavate koguarv ei tohi ületada arvu n ning kokku liidetavate arv peab olema 0-st suurem.
     *
     * @param n         Kui palju liidetavaid on tarvis summaSõnele ja summale veel juurde liita.
     * @param summaSõne Jooksvalt koostatav summasõne.
     * @param summa     Summasõnele vasstav arv, et ei peaks seda pidevalt sõnest välja arvutama.
     */
    private static void nullSummaRek(int n, String summaSõne, int summa) {
        if (summa == 0 && summaSõne.length() > 0) // Kui liidetavaid oli vähemalt 1 ning kokku tuleb summa 0, siis ..
            System.out.println(summaSõne); // .. väljastame summat sisaldava sõne.
        // Seejärel asume summale veel liidetavaid lisama, ..
        if (n > 0 && Math.abs(summa) <= n) { // , kui n seda lubab ja on võimalik n-iga arvestades summa 0-ks teha.
            // (kui summa = -7, aga n = 6, siis pole võimalik 0-ni jõuda isegi kui kõik +1-d valida
            // Lisame summale +1. Laseme rekursioonil leida kõik jätkud, mis selle edasi 0-ks viivad.
            nullSummaRek(n - 1, summaSõne + "+1", summa + 1);
            // Lisame summale -1. Laseme rekursioonil leida kõik jätkud, mis selle edasi 0-ks viivad.
            nullSummaRek(n - 1, summaSõne + "-1", summa - 1);
        }
    }

    /**
     * Ülesanne 3
     *
     * @param mas Antud massiiv.
     * @param k   Maksimaalne elementide valiku kogus.
     * @return Antud massiivi kõigi kuni k positiivsest elemendist koosnevate komplektide arv, kus järjestikustelt
     * kohtadelt elemente komplektidesse ei valita.
     */
    static int valikK(int[] mas, int k) {
        // Delegeerime töö abimeetodile, mis hoiab liseka meeles indeksi, mitmendal positsioonil oleme
        // massiivi läbides ning tõeväärtuse, kas eelmise elemendi komplekti valimise algväärtusega false.
        return valikKRek(0, mas, k, false);
    }

    /**
     * @param i             Mitmenda elemendi kohta komeplti lisamist otsustamas oleme.
     * @param mas           Antud massiiv.
     * @param k             Maksimaalselt mitu elementi on veel lubatud komplekti juurde valida.
     * @param eelmineValiti Kas eelmisel positsioonil olev elementi valiti komplekti.
     * @return antud massiivi kõigi kuni k positiivsest elemendist koosnevate komplektide arvu, kus järjestikustelt
     * kohtadelt elemente komplektidesse ei valita.
     */
    private static int valikKRek(int i, int[] mas, int k, boolean eelmineValiti) {
        // Seame endale eesmärgi, et me ei sisene harudesse, kus on võimatu tulemuseni jõuda ..
        if (i == mas.length) // .. Sel juhul piisab kontrollist, et kõik elemendid on läbitud, et teada, et ..
            return 1; // .. oleme leidnud ühe sobiva komplekti. Tagastame selle sobiva kohta arvu 1.
        // Kui aga on veel elemente, mis on vaatamta, siis teeme otsuse i-nda elemendi kohta.
        // Esimene variant on, et i-ndat elementi ei vali. Jätame abimuutujasse "komplekte" meelde, kui palju
        // komeplekte leiab rekursioon, mis teeb otsuse elementide kohta alates indeksist i+1.
        int komplekte = valikKRek(i + 1, mas, k, false);
        // Teine variant on i-ndal positsioonil element komplekti valida. Sellel on aga tingimused..
        if (mas[i] > 0 && !eelmineValiti && k > 0) // Kui element on positiivne, me ei valinud eelmist kompelkti ..
            // ning k on veel suurem kui 0, siis liidame komplektidele rekursiooni tulemuse, mis teeb otsuse elementide
            // kohta alates indeksist i+1.
            komplekte += valikKRek(i + 1, mas, k - 1, true);
        // Kui on arvesse võetud käesoleva elemendi mitte valimisest tulenevad komeplektid ja võimalusel valimisest
        // tulenevad komeplektid, ja oleme nende tulemused kokku liitnud, siis saame tagastada summa:
        return komplekte;
    }
}
