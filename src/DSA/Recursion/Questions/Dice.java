package DSA.Recursion.Questions;

import java.util.ArrayList;

public class Dice {
    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (i <= target) {
                dice(p + i, target - i);
            }
        }
    }

    static ArrayList<String> diceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            if (i <= target) {
                ans.addAll(diceRet(p + i, target - i));
            }
        }
        return ans;
    }

    static int diceCount(String p, int target) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (i <= target) {
                count = count + diceCount(p + i, target - i);
            }
        }
        return count;
    }

    // For custom faces(8, 9, etc)
    static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= face; i++) {
            if (i <= target) {
                diceFace(p + i, target - i, face);
            }
        }
    }

    static ArrayList<String> diceFaceRet(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= face; i++) {
            if (i <= target) {
                ans.addAll(diceFaceRet(p + i, target - i, face));
            }
        }
        return ans;
    }

    static int diceFaceCount(String p, int target, int face) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= face; i++) {
            if (i <= target) {
                count = count + diceFaceCount(p + i, target - i, face);
            }
        }
        return count;
    }
}