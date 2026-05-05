package org.example.balancedbrackets;

import java.util.*;

public class BalancesBrackets {
    private final Map<Character, Character> openCloseBrackets = new HashMap<>();

    public BalancesBrackets() {
        openCloseBrackets.put('(', ')');
        openCloseBrackets.put('[', ']');
        openCloseBrackets.put('{', '}');
    }

    public boolean isBracketsBalanced(String brackets) {
        char[] chars = brackets.toCharArray();
        Character[] bracketsList = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != '.') {
                bracketsList[i] = chars[i];
            }
        }

        Deque<Character> stringQueue = new ArrayDeque<>();
        int size = bracketsList.length;

        if(size == 0 || size % 2 != 0){
            return false;
        }

        for (Character bracket : bracketsList) {
            if(openCloseBrackets.containsKey(bracket)) {
                stringQueue.push(bracket);
            } else if(openCloseBrackets.get(stringQueue.peek()).equals(bracket)) {
                stringQueue.poll();
            }
        }
        return stringQueue.isEmpty();
    }

    public static void main (String[] args) {
        BalancesBrackets balancesBrackets = new BalancesBrackets();

        if(balancesBrackets.isBracketsBalanced("[(()[])]")){
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
