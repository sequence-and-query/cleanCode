package mission2.resultcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserInputResultValidateTest {
    private final int CarType_Q = 0;
    private final int Engine_Q = 1;
    private final int BrakeSystem_Q = 2;
    private final int SteeringSystem_Q = 3;
    private final int Run_Test = 4;

    UserInputResultValidate userInputResultValidate = new UserInputResultValidate();

    @Test
    public void carTypeSelectError() {
        UserInputResult userInputResult = userInputResultValidate.isValid("4", CarType_Q);

        boolean expected = false;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void engineTypeSelectError() {
        UserInputResult userInputResult = userInputResultValidate.isValid("-1", Engine_Q);

        boolean expected = false;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void brakeTypeSelectError() {
        UserInputResult userInputResult = userInputResultValidate.isValid("4", BrakeSystem_Q);

        boolean expected = false;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void steeringTypeSelectError() {
        UserInputResult userInputResult = userInputResultValidate.isValid("-1", SteeringSystem_Q);

        boolean expected = false;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void runTestSelectError() {
        UserInputResult userInputResult = userInputResultValidate.isValid("-1", Run_Test);

        boolean expected = false;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validTest() {
        UserInputResult userInputResult = userInputResultValidate.isValid("1", CarType_Q);

        boolean expected = true;
        boolean actual = userInputResult.isResultCode();

        Assertions.assertEquals(expected, actual);
    }
}