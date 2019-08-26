package ok.demo;

public class Compresses {

    /**
     * Compresses a string using a simplified algorithm which replaces sequential
     * duplicate characters in the string with a character and the count of times
     * the character is repeated. For example: Input: aaaabbccc Output: a4b2c3
     * Input: a Output: a1 Input: aaaabaa Output: a4b1a2
     * 
     * @param toCompress
     *            String to be compressed.
     * @return Compressed version of the string.
     */
    /* Put your new function here */

    public static void main(String[] args) {

        System.out.println(getCompressedString("aaaabbccc"));
        System.out.println(assertEquals(getCompressedString("aaaabbccc"), "a4b2c3"));
        System.out.println(assertEquals(getCompressedString("aaaa"), "a4"));
        System.out.println(assertEquals(getCompressedString("a"), "a1"));
        System.out.println(assertEquals(getCompressedString(null), null));
        System.out.println(assertEquals(getCompressedString(""), ""));
        System.out.println(getCompressedString("aaaaaaaaaaa"));
        System.out.println(assertEquals(getCompressedString("aaaaaaaaaaa"), "a9a2"));
        System.out.println(assertEquals(getCompressedString("aaaaaaaaaaa33"), "a9a232"));

        // throw new AssertionError("no test cases have been written yet");
    }

    private static Boolean assertEquals(String one, String two) {
        if (one == null && two == null) {
            return true;
        } else {
            return one.equals(two);
        }
    }

    private static String getCompressedString(String in) {

        if (in == null)
            return null;

        if (in.trim().length() < 1) {
            return in;
        }

        if (in.trim().length() == 1) {
            return in + "1";
        }

        StringBuilder out = new StringBuilder();
        int count = 1;
        char lastChar = in.charAt(0);

        for (int i = 1; i < in.length(); i++) {
            if (lastChar == in.charAt(i)) {
                if (count == 9) {
                    out.append(lastChar);
                    out.append(count);
                    lastChar = in.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            } else {
                out.append(lastChar);
                out.append(count);
                lastChar = in.charAt(i);
                count = 1;
            }
        }

        out.append(lastChar + "" + count);
        return out.toString();
    }
}
