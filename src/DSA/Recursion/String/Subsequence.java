package DSA.Recursion.String;

import java.util.ArrayList;

public class Subsequence {
    // Printing the subsequence
    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1)); // Taking the character
        subseq(p, up.substring(1)); // Ignoring the character
    }

    // Returning the subsequence in an ArrayList(Creating the ArrayList in the function body)
    static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(p + ch, up.substring(1)); // Taking the character
        ArrayList<String>right =  subseqRet(p, up.substring(1)); // Ignoring the character

        left.addAll(right);
        return left;
    }

    // Printing the subsequence with their ASCII values
    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1)); // Taking the character
        subseqAscii(p, up.substring(1)); // Ignoring the character
        subseqAscii(p + (ch + 0), up.substring(1));
    }

    // Returning the Subsequence with ASCII values in an ArrayList
    static ArrayList<String> subseqRetAscii(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRetAscii(p + ch, up.substring(1)); // Taking the character
        ArrayList<String>right =  subseqRetAscii(p, up.substring(1)); // Ignoring the character
        ArrayList<String> ascii = subseqRetAscii(p + (ch + 0), up.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
