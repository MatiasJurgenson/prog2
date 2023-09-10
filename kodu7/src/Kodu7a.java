import java.util.Arrays;

/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 7a
 * Teema: erinevad rekursioonid
 *
 * Autor: Matias Jürgenson
 *
 **********************************/

class Kodu7a {

    /**
     * Paigutab antud täisarvujärjendi a paaritud arvud ümber järjendi lõppu. Nii tulemuse
     * algusosas (paarisarvud) kui ka lõpuosas (paaritud arvud) on säilitatud arvude esialgne
     * järjestus järjendis a.
     * @param a Täisarvumassiiv
     */
    public static void teePaarisPaaritud(int[] a){
        teePaarisPaaritudAbi(a, 0, 0);
    }

    /**
     * Abifunktsioon teePaarisPaaritud-le, mis paigutab antud täisarvujärjendi a paaritud arvud ümber järjendi lõppu. Nii tulemuse
     * algusosas (paarisarvud) kui ka lõpuosas (paaritud arvud) on säilitatud arvude esialgne
     * järjestus järjendis a.
     * @param a Täisarvumassiiv
     * @param indeks mitmendat arvu a-st vaadata
     * @param koht kuhu paaris arv asetadakse
     */
    public static void teePaarisPaaritudAbi(int[] a, int indeks, int koht){
        //kui jõutakse a lõppu lõpetadakse rekursioon
        if (indeks == a.length) return;

        //kui tegu on paarisarvuga
        if (a[indeks] % 2 == 0) {

            //võetakse selle asukoht
            int ajutine = a[indeks];
            //liigutadakse massiiv ühe võrra edasi hohast kuni leitud paarisarvuni
            System.arraycopy(a, koht, a, koht + 1, indeks - koht);
            a[koht] = ajutine;
            teePaarisPaaritudAbi(a, indeks + 1, koht + 1);

        } else {
            teePaarisPaaritudAbi(a, indeks + 1, koht);
        }
    }

    /**
     * Kasutab unaarset rekursiooni, et leida märgimuutude arvu
     * @param a arvumassiiv
     * @return märgimuutude arv
     */
    public static int muududUnaarne(int[] a){
        return muududUnaarneAbi(a, 0, 0);
    }

    /**
     * abifunktsioon muududUnaarne-le ,mis kasutab unaarset rekursiooni, et leida märgimuutude arvu
     * @param a arvumassiiv
     * @param indeks millist a elementi vaadata
     * @param märk kas eelmine ärk oli + või -
     * @return märgimuutude arv
     */
    public static int muududUnaarneAbi(int[] a, int indeks, int märk){
        int arv = 0;
        //kui võutakse a lõppu
        if (indeks == a.length) return 0;

        if (a[indeks] != 0){
            //kui märk on võrdne 0-iga antakse sellele väärtus -1 või 1 vastavalt indeksil olevale märgiga
            if (märk == 0) {
                if (a[indeks] < 0) {
                    märk = -1;
                } else {
                    märk = 1;
                }
            }
            //kui erimärki arvud muudetakse liidetav arv 1-ks
            if (märk < 0 && a[indeks] > 0 || märk > 0 && a[indeks] < 0) {
                märk *= -1;
                arv = 1;
            }
        }
        return arv + muududUnaarneAbi(a, indeks + 1, märk);
    }

    /**
     * Kasutab binaarset rekursiooni, et leida märgimuutude arvu
     * @param a arvumassiiv
     * @return märgimuutude arv
     */
    public static int muududBinaarne(int[] a){
        return muududBinaarneAbi(a, 0, 0, 0);
    }

    /**
     * abifunktsioon muududUnaarne-le ,mis kasutab unaarset rekursiooni, et leida märgimuutude arvu
     * @param a arvumassiiv
     * @param indeks1 millist a elementi vaadata
     * @param indeks2 millist a elementi vaadata, mis on >= indeks1
     * @param nullistErinev mitu nullist erinevat arvu on leitud
     * @return märgimuutude arv
     */
    public static int muududBinaarneAbi(int[] a, int indeks1, int indeks2, int nullistErinev) {
        //kui jõutakse a lõppu
        if (indeks2 == a.length) return 0;

        //kui on olemas 2 nullist erinevat arvu ja need erimärgiga
        if (nullistErinev == 2 && (a[indeks1] < 0 && a[indeks2] > 0 || a[indeks1] > 0 && a[indeks2] < 0)) {
            System.out.println(a[indeks1] + " " + a[indeks2]);
            return 1;
        }

        //kui indeks2 on 0 siis minnakse edasi
        if (a[indeks2] == 0) {
            return muududBinaarneAbi(a, indeks1, indeks2 + 1, nullistErinev);

        //kui arv pole 0
        } else {
            //kui on juba üks nullist erinev arv olemas
            if (nullistErinev == 1) {
                //toimub hargnemine kus ühel pool vaadatakse kas 2 arvu on võrdsed ja
                //teises harus jätkatakse listis uue arvupaari leidmist
                return muududBinaarneAbi(a, indeks1, indeks2, nullistErinev + 1)
                        + muududBinaarneAbi(a, indeks2, indeks2 + 1, nullistErinev);
            //kui pole ühtegi teist nullist erinevat arvu veel
            } else {
                //hakkatakse vaatama listi indeks2 juurest edasi, et leida teine nullist erinev arv
                return muududBinaarneAbi(a, indeks2, indeks2 + 1, nullistErinev + 1);
            }
        }
        /* algne kood (ei tea kas binaarne)

        //kui arvud erimärki liidetakse 1 juurde
        if (a[indeks1] < 0 && a[indeks2] > 0 || a[indeks1] > 0 && a[indeks2] < 0) {
            return 1 + muududBinaarneAbi(a, indeks2, indeks2 + 1);
        }
        //kui indeks1 on 0 suurendatakse mõlemat indeksi, muidu lihtsalt indeks2-te
        if (a[indeks1] == 0) {
           return muududBinaarneAbi(a, indeks1 + 1, indeks2 + 1);
        } else {
            return muududBinaarneAbi(a, indeks1, indeks2 + 1);
        }
        */
    }


    public static void main(String[] args) {
        int[] a = {-1,0,-7,3,10,4,0,2,-1,-5,6};
        System.out.println(Arrays.toString(a));
        teePaarisPaaritud(a);
        System.out.println(Arrays.toString(a));

        int[] b = {0,0,4,0,0,0,0,0,0,0,-9,0,0,0};
        int[] c = {22,0,-9,8,-9,0,0,-12,18,0,28,0,25,0,25,0,10};

        System.out.println(muududUnaarne(b));
        System.out.println(muududUnaarne(c));
        System.out.println(muududBinaarne(b));
        System.out.println(muududBinaarne(c));

    }//peameetod

}//Kodu7a
