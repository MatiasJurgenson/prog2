/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 1b
 * Teema: Kujundite printimine
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

// Kui mõni ülesanne jääb lahendamata, siis ÄRA KUSTUTA MEETODIT! Jäta lihtsalt tühjaks!

public class Kodu1b {

    /**
     * prindib ruudu, mille küljepikkus on n
     * @param n ruudu küljepiiku
     */
    static void ruut(int n) {
        //prindib ruudu ülemise külje, mille pikkus on n, kus iga # vahel on " "
        System.out.println("# ".repeat(n-1) + "#");

        //prindib ruudu küljed vahega n-2, n-2 korda
        for (int i = 0; i < n-2; i++){
            System.out.println("#" + "  ".repeat(n-2) + " #");
        }

        //prindib ruudu alimse külje kui n > 1
        if (n>1) {
            System.out.println("# ".repeat(n-1) + "#");
        }

    }

    /**
     * prindid rombi, kille külepikkus on n
     * @param n rombi küljepikkus
     */
    static void romb(int n) {
        //prindib rombi ülemise poole
        System.out.println(" ".repeat(n-1) + "#");
        for (int i = 0; i < n-1; i++) {
            System.out.println(" ".repeat(n-2-i) + "#" + " ".repeat(i*2+1) + "#");
        }
        //prindib rombi alumise poole
        for (int i = n-2 ; i > 0; i--) {
            System.out.println(" ".repeat(n-i-1) + "#" + " ".repeat(i*2-1) + "#");
        }
        //prindib rombi alumse otsa kui n > 1
        if (n>1) {
            System.out.println(" ".repeat(n - 1) + "#");
        }
    }

    /**
     * prindib telgi, mille kõrguseks on n
     * @param n telgi kõrgus
     */
    static void telk(int n) {
        //prindib telgi ülemse osa
        System.out.println(" ".repeat(n * 2) + "#");
        //prindib telgi kõrguse
        // i on telgi küljed ja c on vahede printimine
        for (int i = 2, c = n-1; i <= n; i++,c-- ) {
            System.out.println(" ".repeat(c*2) + "#".repeat(i) + " ".repeat((i-2)*2+1) + "#".repeat(i));
        }
        //prindib telgi alumise osa
        System.out.println("=".repeat(n*4 + 1));
    }

    /**
     * prindib spiraali mille kõrgus on n
     * @param n spiraali kõrgus
     */
    static void spiraal(int n) {
        if (n < 3){
            for (int i = 0; i < n; i++) {
                System.out.println("#");
            }

        }
        else {
            //spiraali 2 esimest rida
            System.out.println("# ".repeat(n - 2) + "#");
            System.out.println(" ".repeat((n-2) * 2) + "#");

            //jäägist oleneb, mis suunas on spiraali lõpp
            if (n > 4) {
            int lõpp = n % 4;

            switch (lõpp) {
                case 0: //üles
                    // spiraali ülemise poole keskmine osa
                    for (int i = 0, c = (n-5)/4 ; i <= (n-5)/4; i++, c--) {
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+5) + "  #" + "   #".repeat(i));
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(1 + c*8) + "   #".repeat(i+2));
                    }

                    // spiraali alumise poole keskmine osa
                    for (int i = (n-5)/4 + 1, c = 0; i > 0; i--, c++) {
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8) +"#" + "   #".repeat(i));
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+3) + "  #" + "   #".repeat(i-1));
                    }
                    break;
                case 1: //paremale
                    // spiraali ülemise poole keskmine osa
                    for (int i = 0, c = (n-5)/4 -1 ; i < (n-5)/4; i++, c--) {
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+6) + "  #" + "   #".repeat(i));
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(3+ c*8) + "   #".repeat(i+2));
                    }

                    // prindib spiraali keskmise osa
                    // prindib tulbad, siis spiraali lõppu ja siis jälle tulpasi
                    System.out.println("#   ".repeat((n-5)/4) + "# #   #" + "   #".repeat((n-5)/4));

                    // spiraali alumise poole keskmine osa
                    for (int i = (n-5)/4, c = 0; i > 0; i--, c++) {
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8) +"  #" + "   #".repeat(i));
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+4) + "  #" + "   #".repeat(i-1));
                    }
                    break;
                case 2: //alla
                    // spiraali ülemise poole
                    for (int i = 0, c = (n-5)/4 ; i < (n-5)/4 + 1; i++, c--) {
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+3) + "  #" + "   #".repeat(i));
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8) +"#" + "   #".repeat(i+1));
                    }

                    // spiraali alumise poole
                    for (int i = (n-5)/4, c = 1; i > 0; i--, c++) {
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8-7) + "   #".repeat(i+1));
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+1) + "  #" + "   #".repeat(i-1));
                    }
                    break;
                case 3: //vasakule
                    // spiraali ülemise poole keskmine osa
                    for (int i = 0, c = (n-5)/4 ; i < (n-5)/4 + 1; i++, c--) {
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+4) + "  #" + "   #".repeat(i));
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8) +"  #" + "   #".repeat(i+1));
                    }

                    // prindib spiraali keskmise osa
                    // prindib tulbad, siis spiraali lõppu ja siis jälle tulpasi
                    System.out.println("#   ".repeat((n-5)/4) + "#   # #" + "   #".repeat((n-5)/4+1));

                    // spiraali alumise poole keskmine osa
                    for (int i = (n-5)/4, c = 1; i > 0; i--, c++) {
                        //prindib tulpasi siis tühja ala ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i+1) + " ".repeat(c*8-5) + "   #".repeat(i+1));
                        //prindib tulpasi siis prindib joone ja siis jälle tulpasi
                        System.out.println("#   ".repeat(i) + "# ".repeat(c*4+2) + "  #" + "   #".repeat(i-1));
                    }
                    break;
            }
            }
            if (n>3) {
                System.out.println("#" + " ".repeat((n-2) * 2 - 1) + "#");
            }
            System.out.println("# ".repeat(n - 2) + "#");
        }
    }


    public static void main(String[] args) {
        System.out.println("Kodutöö nr 1b. Programmi väljund\n=========================================================:");


        //ruudud
        System.out.println("Ruut, n = 7:");
        ruut(7);
        System.out.println("Ruut, n = 17:");
        ruut(17);

        //rombid
        System.out.println("Romb, n = 4:");
        romb(4);
        System.out.println("Romb, n = 9:");
        romb(9);

        //telgid
        System.out.println("Telk, n = 1:");
        telk(1);
        System.out.println("Telk, n = 3:");
        telk(3);
        System.out.println("Telk, n = 10:");
        telk(10);

        //spiraalid

        System.out.println("Spiraal, n = 4:");
        spiraal(4);





    }
}