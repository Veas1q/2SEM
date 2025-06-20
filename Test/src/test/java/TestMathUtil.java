
import org.example.MathUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestMathUtil {

    static MathUtil mathUtil;

    @BeforeAll
    static void init() {
        mathUtil = new MathUtil();
    }

    @Test
    void testSort() {
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8},
                mathUtil.sort(new int[] {8,3,2,5,4,6,7,1}));
    }

    @Test
    void testSum() {
        int expected = 10; // эталонное заранее вычисленное значение
        int actual = MathUtil.sum(5, 5);

        assertEquals(expected, actual);

        assertEquals(0, MathUtil.sum(-5, 5));
        assertEquals(-2, MathUtil.sum(-1, -1));
        assertEquals(-1,
                MathUtil.sum(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @CsvFileSource(files = "test_data.csv")
/*
    @CsvSource({
            "5,    5,   10",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
*/
    void testSum1(int a, int b, int expectedResult) {
        assertEquals(expectedResult, MathUtil.sum(a, b));
    }

    @Test
    void testCompare() {
        assertTrue(MathUtil.compare(5,4) > 0);
        assertTrue(MathUtil.compare(4,4) == 0);
        assertTrue(MathUtil.compare(4,9) < 0);
    }

    @Test
    void testDivide() {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> {MathUtil.divide(7, 0);});
    }



    @AfterAll
    static void destroy() {

    }
}
