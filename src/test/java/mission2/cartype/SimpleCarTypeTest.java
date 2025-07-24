package mission2.cartype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleCarTypeTest {
    @Test
    public void carFactory() {
        for(int i = 1; i < 4; i++) {
            int expected = i;
            int actual = CarFactory.getInstance().getCarType(i).getTypeCode();
            Assertions.assertEquals(expected, actual);
        }
    }
}
