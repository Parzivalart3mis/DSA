package DSA.Recursion.String;

public class Stream {
    //Skip a character
    // Passing the answer string in the argument
    static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            skip(p, up.substring(1));
        }
        skip(p + ch, up.substring(1));
    }
    //Skip a character
    // Create the answer variable in the function body
    // Return the processed string
    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1));
        }
        return ch + skip(up.substring(1));
    }
    //Skip a string
    static String skipString(String up, String change) {
        if (up.isEmpty()) {
            return "";
        }
        int length = change.length();
        if (up.startsWith(change)) {
            return skipString(up.substring(length), change);
        }
        return up.charAt(0) + skipString(up.substring(length), change);
    }
}
