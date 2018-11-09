import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PalindromeTest {
    class TestCase {
        String input;
        boolean output;

        public TestCase(String input, boolean output) {
            this.input = input;
            this.output = output;
        }

        public String getInput() {
            return input;
        }

        public boolean isOutput() {
            return output;
        }
    }


    @Test
    public void isPalindrome() {

        List<TestCase> testCaseList = new ArrayList<TestCase>();
        testCaseList.add(new TestCase("", false));
        testCaseList.add(new TestCase("1", true));
        testCaseList.add(new TestCase("12", false));
        testCaseList.add(new TestCase("11", true));
        testCaseList.add(new TestCase("121", true));
        testCaseList.add(new TestCase("123", false));
        testCaseList.add(new TestCase("1221", true));

        for (TestCase cur : testCaseList) {
            boolean res = Palindrome.isPalindrome(cur.input);
            assertTrue(String.format("Test case failed %s, should return %b got %b", cur.input, cur.output, res), res == cur.output);
        }

    }

}