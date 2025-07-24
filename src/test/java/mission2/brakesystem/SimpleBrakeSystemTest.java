package mission2.brakesystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleBrakeSystemTest {
    @Test
    public void brakeSystemFactory() {
        for(int i = 1; i < 4; i++) {
            int expected = i;
            int actual = BrakeSystemFactory.getInstance().getBrakeSystem(i).getBrakeSystemCode();

            Assertions.assertEquals(expected, actual);
        }
    }
}
