public class Main {

    static boolean nihutamine(String a, String b) {
        if (a.length() == b.length()) {
            for (int i = 1; i < a.length(); i++) {
                if ((a.substring(i) + a.substring(0, i)).equals(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    static String salasta(String a) {
        //todo lih vaata kt3 faili

        return null;
    }

    public static void main(String[] args) {
        System.out.println(nihutamine("tere", "eret"));
        System.out.println(nihutamine("tere", "reet"));
    }
}