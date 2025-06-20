import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.Taks2.count;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {

    @Test
    void test(){
        int[] res =  count(new byte[] {1,1,1,0,0,3,3,3,4,4,4,5,5,6});
        int[] expectedRes = new int[256];
        for (int i = 6; i < 256; i++) {
            expectedRes[i] = 0;
        }
        expectedRes[0 + 128] = 2;
        expectedRes[1 + 128] = 3;
        expectedRes[3 + 128] = 3;
        expectedRes[4 + 128] = 3;
        expectedRes[5 + 128] = 2;
        expectedRes[6 + 128] = 1;

        for (int i = 0; i < 256; i++) {
            assertEquals(expectedRes[i], res[i]);

        }

    }
}
