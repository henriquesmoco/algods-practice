package algods.practice.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedBracketsTest {

    @Test
    void isBalanced_WithEmptyString_returnFalse() {
        BalancedBrackets brackets = new BalancedBrackets();

        boolean result = brackets.isBalanced("");

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = { "()", "[]" })
    void isBalanced_WithSingleBalancedBrackets_returnTrue(String input) {
        BalancedBrackets brackets = new BalancedBrackets();

        boolean result = brackets.isBalanced(input);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "(())", "[[]]" })
    void isBalanced_WithDoubleBalancedBrackets_returnTrue(String input) {
        BalancedBrackets brackets = new BalancedBrackets();

        boolean result = brackets.isBalanced(input);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "(", "[", ")" })
    void isBalanced_WithSingleUnbalancedParentheses_returnTrue(String input) {
        BalancedBrackets brackets = new BalancedBrackets();

        boolean result = brackets.isBalanced(input);

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = { "(()", "[]]", "()]", "[())" })
    void isBalanced_WithDoubleUnbalancedParentheses_returnTrue(String input) {
        BalancedBrackets brackets = new BalancedBrackets();

        boolean result = brackets.isBalanced(input);

        assertThat(result).isFalse();
    }

}