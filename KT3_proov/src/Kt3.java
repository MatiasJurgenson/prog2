public class Kt3 {

    /**
     *
     * @param a Esimene kontrollitav sõne.
     * @param b Teine kontrollitav sõne.
     * @return Tõeväärtus, kas on võimalik ühest sõnest saada teine tsüklilise nihutamise teel.
     */
    public static boolean nihutamine(String a, String b) {
        // Esiteks peavad mõlemad sõned olema sama pikad. Seejärel saame saadavust kontrollida selle järgi, et kui
        // kordame ühte sõne 2 korda, siis kas teine sõne leidub tulemuse sees. Põhimõte selles, et sõne kordamine
        // näitab, mis sümbolid järgneksid või eelneksid peale nihutamist.
        // Näiteks "tere" kohta saame, et "teretere" sees leidub "eret". (sest "t[eret]ere")
        return a.length() == b.length() && (a + a).contains(b);
    }

    /**
     *
     * @param a Antud lause.
     * @return Uus sõne, kus lauses asendatud iga suurtähega algav sõna sama pika sõnaga, mille esimeseks täheks on X ja
     * järgmisteks x. Kirjavahemärke ".", ",", "?", "!" ei asendata.
     */
    public static String salasta(String a) {
        String[] sõnad = a.split(" "); // Jagame sõnade massiiviks.
        for (int i = 0; i < sõnad.length; i++) { // Käime kõik sõnad läbi.
            String sõna = sõnad[i];
            if (Character.isUpperCase(sõna.charAt(0))) { // Kontrollime, kas algab suurtähega.
                String uus = "X"; // Alustame salastatud sõna suure X-iga.
                for (int j = 1; j < sõna.length(); j++) { // Lisame tsükliga järgnevad sümbolid.
                    char sümbol = sõna.charAt(j);
                    if (sümbol == '.' || sümbol == ',' || sümbol == '?' || sümbol == '!') uus += sümbol;
                    else uus += 'x'; // Mitte-kirjavahemärgid asendame väikese 'x'-sümboliga.
                }
                sõnad[i] = uus; // Kirjutame sõnade massiivi uue sisu.
            }
        }
        return String.join(" ", sõnad); // Paneme sõnade massiivi kokku tagasi.
    }

    /**
     *
     * @param s Sõne, mille kohta otsustatakse sõnede "a" ja "b" põiming olemist.
     * @param a Esimene põimitav sõne.
     * @param b Teine põimitav sõne.
     * @return Tõeväärtus, kas antud sõne "s" on kahe teise antud sõne "a" ja "b" sümbolite mingi põiming.
     */
    public static boolean kasPõime(String s, String a, String b) {
        // Et olla põiming, kontrollime esmalt, kas kahe põimitava sõne pikkuste summa klapib potentsiaalse põimingu
        // kogupikkusega. Kui jah, siis delegeerime suurema töö rekursioonile.
        return s.length() == a.length() + b.length() && kasPõimeRek(0, s, 0, 0, a, b);
    }

    /**
     * Rekursiivne abimeetod. Mõte seisneb sellest, et proovime järjest igale "sõne" sümbolile valida vaste sõnede
     * "lähtesõne1" ja "lähtesõne2" sümbolitest. Kui jõuame lõppu, siis õnnestus, Kui mingi sümbol jääb vahepealt
     * leidmata, siis tagastatakse sealt väär.
     * @param i
     * @param sõne
     * @param i1
     * @param i2
     * @param lähtesõne1
     * @param lähtesõne2
     * @return Kas on võimalik läbida sümbolid sõnest "sõne" alates indeksist i nõnda, et valitud sümbolid on põiming
     * sõnede lähtesõne1 ja lähtesõne2 sümbolitest, vastavalt alates indekstitest i1 ja i2.
     */
    private static boolean kasPõimeRek(int i, String sõne, int i1, int i2, String lähtesõne1, String lähtesõne2) {
        if (i == sõne.length()) return true; // Igale "sõne" sümbolile vate leitud, töö valmis ja tagastame tõene.
        boolean onPõiming = false; // Muul juhul määrame vaikimisi, et ei ole põiming.
        // Ja asume kontrollima, kas esimesest või teisest lähtesõnest sümbol valides on võimalik "sõne" kokku põimida.
        // Kui esimeses lähtesõnes on läbimata sümboleid ja praegune sümbol on "sõne"-ga ühine, siis ..
        if (i1 < lähtesõne1.length() && sõne.charAt(i) == lähtesõne1.charAt(i1))
            // .. rekursioon kontrollib, kas jätkates jõutakse põiminguni.
            onPõiming = kasPõimeRek(i + 1, sõne, i1 + 1, i2, lähtesõne1, lähtesõne2);
        // Kui veel ei leitud põimingut, teises lähtesõnes on läbimata sümboleid ja sümbol on "sõne"-ga ühine, siis ..
        if (!onPõiming && i2 < lähtesõne2.length() && sõne.charAt(i) == lähtesõne2.charAt(i2))
            // .. rekursioon kontrollib, kas jätkates jõutakse põiminguni.
            onPõiming = kasPõimeRek(i + 1, sõne, i1, i2 + 1, lähtesõne1, lähtesõne2);
        return onPõiming; // Siia jõuab tõene, kui oli võimalik lähtesõnedest esimene sümbol valida ja põiminguni jõuda.
        // Üherealine alternatiiv boonuseks (kõik tõeväärtuste kontrollid saab üksteise järele kokku panna):
        // return i == sõne.length() || (i1 < lähtesõne1.length() && sõne.charAt(i) == lähtesõne1.charAt(i1) && kasPõimeRek(i + 1, sõne, i1 + 1, i2, lähtesõne1, lähtesõne2)) || (i2 < lähtesõne2.length() && sõne.charAt(i) == lähtesõne2.charAt(i2) && kasPõimeRek(i + 1, sõne, i1, i2 + 1, lähtesõne1, lähtesõne2));
    }

    public static void main(String[] args) {
        System.out.println("Ülesanne 1:");
        String sõne1 = "tere";
        String sõne2 = "eret";
        String sõne3 = "reet";
        System.out.println("On võimalik nihutada: " + sõne1 + " -> " + sõne2 + " = " + nihutamine(sõne1, sõne2));
        System.out.println("On võimalik nihutada: " + sõne1 + " -> " + sõne3 + " = " + nihutamine(sõne1, sõne3));

        System.out.println("\nÜlesanne 2:");
        String lause = "EV, kohtuotsus Agu Sihvka süüasjas.";
        System.out.println("Salastatult: " + lause + " -> " + salasta(lause));

        System.out.println("\nÜlesanne 3:");
        String sõne4 = "dabec";
        String sõne5 = "abc";
        String sõne6 = "de";
        System.out.println("Põime: " + sõne5 + " + " + sõne6 + " -> " + sõne4 + " = " + kasPõime(sõne4, sõne5, sõne6));
    }
}

