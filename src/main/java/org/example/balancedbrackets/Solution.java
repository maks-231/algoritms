package org.example.balancedbrackets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    private final static Map<Character, Character> openCloseBrackets = new HashMap<>();

    static {
        openCloseBrackets.put('(', ')');
        openCloseBrackets.put('[', ']');
        openCloseBrackets.put('{', '}');
    }
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        if(s == null || s.isEmpty() || s.length() % 2 != 0)  {
            return "NO";
        }
        char[] chars = s.toCharArray();
        Character[] bracketsList = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bracketsList[i] = chars[i];
        }

        LinkedList<Character> stringQueue = new LinkedList<>();
        for (Character bracket : bracketsList) {
            if(openCloseBrackets.containsKey(bracket)) {
                stringQueue.addFirst(bracket);
            } else if(!stringQueue.isEmpty() && openCloseBrackets.get(stringQueue.getFirst()).equals(bracket)) {
                stringQueue.remove();
            } else {
                return "NO";
            }
        }
        return stringQueue.isEmpty() ? "YES" : "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();
//                s = s.replaceAll("\\.", "");
//                s = s.replaceAll(",", "");
                String result = Result.isBalanced(s);

                System.out.println(result);

//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
