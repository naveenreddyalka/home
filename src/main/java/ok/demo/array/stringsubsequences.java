package ok.demo.array;

public class stringsubsequences {

    public static void main(String[] args) {
        String[]  s = sub("abcd");
        System.out.println(s);
    }

    private static String[] sub(String str) {
       
        if (str == null || str.length() == 0 || str.length() == 1) {
            String[] r = new String[str.length()];
            r[0] = str;
            return r;
        } else {
            String left = str.substring(0, str.length() - 1) ;
            String[] r = sub(left);
            String[] newr = new String[(r.length * 2) + 1];
            for (int i = 0; i < r.length; i++) {
                newr[i] = r[i];
            }

            for (int i = r.length; i < r.length * 2; i++) {
                newr[i] = r[i - r.length] + str.substring(str.length() - 1);
            }
            newr[(r.length) * 2] = str.substring(str.length() - 1);
            return newr;
        }

    }
}
