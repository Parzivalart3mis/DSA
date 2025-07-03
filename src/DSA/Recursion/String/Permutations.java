package DSA.Recursion.String;

import java.util.ArrayList;

public class Permutations {
    static void permmutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = up.substring(0,i); // First part of the processed string
            String s = up.substring(i, p.length()); // Second part of the processed string
            permmutations(f + ch + s, up.substring(1)); // Doing recursion call by passing the processed as first + ch + second
        }
    }

    static ArrayList<String> permmutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        // Local to each recursion call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = up.substring(0,i); // First part of the processed string
            String s = up.substring(i, p.length()); // Second part of the processed string
            ans.addAll(permmutationsList(f + ch + s, up.substring(1))); // Doing recursion call by passing the processed as first + ch + second
        }
        return ans;
    }

    static int permmutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = up.substring(0,i); // First part of the processed string
            String s = up.substring(i, p.length()); // Second part of the processed string
            count = count + permmutationsCount(f + ch + s, up.substring(1)); // Doing recursion call by passing the processed as first + ch + second
        }
        return count;
    }
}