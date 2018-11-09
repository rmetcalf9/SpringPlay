import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MainAppTest {

    class AddTestInstance {
        int a;
        int b;
        int expectedResult;
        public AddTestInstance(int a, int b, int expectedResult) {
            this.a = a;
            this.b = b;
            this.expectedResult = expectedResult;
        }
    }

    @Test
    public void addTwoNumbers() {
        List<AddTestInstance> testCases = new ArrayList<AddTestInstance>();
        testCases.add(new AddTestInstance(0,0,0));
        testCases.add(new AddTestInstance(1,0,1));
        testCases.add(new AddTestInstance(2,0,2));
        testCases.add(new AddTestInstance(3,0,3));
        testCases.add(new AddTestInstance(4,0,4));
        testCases.add(new AddTestInstance(5,0,5));
        testCases.add(new AddTestInstance(10,0,10));
        testCases.add(new AddTestInstance(5,1,6));
        testCases.add(new AddTestInstance(10,1,11));

        MainApp ma = new MainApp();
        for (AddTestInstance ati : testCases) {
            int actualResult = ma.addTwoNumbers(ati.a,ati.b);
            assertTrue(String.format("Wrong result from addition of %d and %d (got %d expected %d)", ati.a, ati.b, actualResult, ati.expectedResult), actualResult == ati.expectedResult);

        }
    }
}