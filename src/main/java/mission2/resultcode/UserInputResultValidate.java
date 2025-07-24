package mission2.resultcode;

public class UserInputResultValidate {
    private final int CarType_Q = 0;
    private final int Engine_Q = 1;
    private final int BrakeSystem_Q = 2;
    private final int SteeringSystem_Q = 3;
    private final int Run_Test = 4;

    public UserInputResult isValid(String userInput, int step) {
        UserInputResult userInputResult = new UserInputResult();

        userInputResult.setResultCode(true);
        userInputResult.setResultMessage(null);

        if(!isDigit(userInput)) {
            userInputResult.setResultCode(false);
            userInputResult.setResultMessage("ERROR :: 숫자만 입력 가능");

            return userInputResult;
        }

        int ans = Integer.parseInt(userInput);

        switch (step) {
            case CarType_Q:
                if (ans < 1 || ans > 3) {
                    userInputResult.setResultCode(false);
                    userInputResult.setResultMessage("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                }
                break;
            case Engine_Q:
                if (ans < 0 || ans > 4) {
                    userInputResult.setResultCode(false);
                    userInputResult.setResultMessage("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                }
                break;
            case BrakeSystem_Q:
                if (ans < 0 || ans > 3) {
                    userInputResult.setResultCode(false);
                    userInputResult.setResultMessage("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                }
                break;
            case SteeringSystem_Q:
                if (ans < 0 || ans > 2) {
                    userInputResult.setResultCode(false);
                    userInputResult.setResultMessage("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                }
                break;
            case Run_Test:
                if (ans < 0 || ans > 2) {
                    userInputResult.setResultCode(false);
                    userInputResult.setResultMessage("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                }
                break;
        }

        return userInputResult;
    }

    public boolean isDigit(String buf) {
        try {
            int answer = Integer.parseInt(buf);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public boolean isValidRange(int step, int ans) {
        switch (step) {
            case CarType_Q:
                if (ans < 1 || ans > 3) {
                    System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case Engine_Q:
                if (ans < 0 || ans > 4) {
                    System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                    return false;
                }
                break;
            case BrakeSystem_Q:
                if (ans < 0 || ans > 3) {
                    System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case SteeringSystem_Q:
                if (ans < 0 || ans > 2) {
                    System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                    return false;
                }
                break;
            case Run_Test:
                if (ans < 0 || ans > 2) {
                    System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                    return false;
                }
                break;
        }
        return true;
    }
}
