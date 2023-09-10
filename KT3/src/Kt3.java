/**
 * Õpilase nimi: Matias Jürgenson
 * Programmeerimine 2 - KT 3 24.05.2023. Palume mitte "package" märksõna lisada,
 * koodis meetodite signatuure muuta, ega (ka tühje) meetodeid kustutada!
 * Kui meetodi sisu ei realiseeri, siis jäta rida "throw new UnsupportedOperationException("Implementeerimata!");" alles
 * Kui realiseerid, siis kustuta see ära.
 */
public class Kt3 {
    /**
     * tagastab etteantud teksti, eemaldades sõnadest märgid *.,!?, välja arvuatud sõne viimase märgi,
     * kui see järgneb peale sõna ja ei sisalda *.
     * @param s
     * @return tagastatav tekst
     */
    public static String tõlgiLause(String s){
        //throw new UnsupportedOperationException("Implementeerimata!");

        //leiab kõik sõnad
        String[] lause = s.split(" ");

        StringBuilder tagastus = new StringBuilder();
        char märk;

        //käiakse iga sõna lauses läbi
        for (String sõna : lause) {

            //kuna '*' pole vaja siis eelaldame selle
            sõna = sõna.replace("*", "");

            //kui sõna viimane karakter pole täht
            if (!Character.isLetter(sõna.charAt(sõna.length() - 1))) {
                märk = sõna.charAt(sõna.length() - 1);

                //kui sõna viimane märk kuulub [.,!?]
                if (märk == '.' || märk == ',' || märk == '!' || märk == '?') {
                    tagastus.append(" " + sõna.replaceAll("[.,!?]", "") + märk);

                //muidu tagastadakse ilma märgita
                } else {
                    tagastus.append(" " + sõna.replaceAll("[.,!?]", ""));
                }

            //muidu tagastadakse ilma märgita
            } else {
                tagastus.append(" " + sõna.replaceAll("[.,!?]", ""));
            }
        }
        return tagastus.substring(1);
    }

    public static String[] pikimÜhissufiks(String s) {
        throw new UnsupportedOperationException("Implementeerimata!");
    }

    /**
     * kaotab etteantud sõnest sümbolipaare
     * @param s sõne
     * @return järjekord kuidas paarid eemaldati
     */
    public static String kaotaTähepaarid(String s){
        //throw new UnsupportedOperationException("Implementeerimata!");

        String tähestik = "abcdefghijklmnopqrsštuvzžxyzöäõü";
        String tagastus = s;

            //vaatab korduvaid osi tähestikulises järjekorras
            for (int i = 0; i < tähestik.length(); i++) {
                char täht = tähestik.charAt(i);

                //kui on paaris tähte, siis eemaldab vasakul pool oleva esimesena
                String koopia = s.replaceFirst(täht + "{2}", "");
                //kui leidus paar
                if (!koopia.equals(s)) {
                    //lisatakse tagastusse
                    tagastus += "," + koopia;
                    s = koopia;
                    //alustadakse sõne vaatamist uuesti tähestiku algusest
                    break;
                }
            }

            //vaadatakse kas on korduvaid osi
            for (int i = 0; i < s.length() - 1; i++) {
                //kui on tehakse tsükkel uuesti läbi saadud tulemusega
                if (s.charAt(i) == s.charAt(i + 1)) {
                    tagastus = kaotaTähepaarid(s);
                }
            }


        return tagastus;
    }

    public static void main(String[] args) {
        // Siin võib vabas vormis oma lahendust testida.
        // Automaattestid tõid hinnates main meetodit ei käivita. (Samas peab siiski kompileeruma!)

        String[] sisendid1 = {
                "t*!?",
                "ku**ra!t",
                "Tere. ku*.ra!t!!",
                "kuk.u.pra**t*",
                "Tere lammas, mis sa va**hid?*"
        };

        System.out.println("ÜL 1\n");
        for (String sõna : sisendid1) {
            System.out.println(tõlgiLause(sõna));
        }
        System.out.println("\n");

        String[] sisendid2 = {
                "Meil naabriõues kasvas üks kuusk ja teine kask."
        };

        String[] sisendid3 = {
                "majapidamine",
                "terre",
                "terranoona",
                "taaarakaanetaja",
                "uu"
        };

        System.out.println("ÜL 3\n");
        for (String sõna : sisendid3) {
            System.out.println(kaotaTähepaarid(sõna));
        }
        System.out.println("\n");

    }
}