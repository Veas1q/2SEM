import org.example.MathUtil;

public class TestMathUtil {
    void testSum() {
        int expected = 10; // эталонное заранее вычисленное значение
        int actual = MathUtil.sum(5,5);
        assertEquals(expected, actual);

        assertEquals(0, MathUtil.sum(-5, 10));
        assertEquals(-2, MathUtil.sum(-1,-1));
    }
    public static int comapre(int a, int b){
        if (a > b) return 1;
        else if (a < b) return 0;
        else return -1;
    }
}
