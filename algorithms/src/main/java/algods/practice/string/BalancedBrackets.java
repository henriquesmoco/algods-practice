package algods.practice.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BalancedBrackets {

    private final BracketMatcher matcher = new BracketMatcher()
            .addBracketPair('(', ')')
            .addBracketPair('[', ']');

    /*
    Iterate chars,
        if opening bracket add to stack,
        if closing bracket pop from stack and check if pair match
     */
    public boolean isBalanced(String str) {

        final Deque<Character> brackets = new ArrayDeque<>();
        final char[] chars = str.toCharArray();
        boolean balanced = false;

        for (char ch : chars) {
            if (matcher.isOpeningBracket(ch)) {
                brackets.push(ch);
            } else if (matcher.isClosingBracket(ch)) {
                balanced = !brackets.isEmpty() && matcher.isMatchingPair(brackets.pop(), ch);
                if (!balanced) {
                    break;
                }
            }
        }
        return balanced && brackets.isEmpty();
    }

    private static class BracketMatcher {
        private final Map<Character, Character> pairs = new HashMap<>();

        public BracketMatcher() {}

        public BracketMatcher addBracketPair(char opening, char closing) {
            pairs.put(opening, closing);
            return this;
        }

        public boolean isMatchingPair(char openingBracket, char closingBracket) {
            return pairs.containsKey(openingBracket) && pairs.get(openingBracket) == closingBracket;
        }

        public boolean isOpeningBracket(char ch) {
            return pairs.containsKey(ch);
        }

        public boolean isClosingBracket(char ch) {
            return pairs.containsValue(ch);
        }
    }
}
