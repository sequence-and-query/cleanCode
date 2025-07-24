package misssion1;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CarType_Q      = 0;
    private static final int Engine_Q       = 1;
    private static final int BrakeSystem_Q  = 2;
    private static final int SteeringSystem_Q = 3;
    private static final int Run_Test       = 4;

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private static final int BOSCH_S = 1, MOBIS = 2;

    private static final String SHOW_CAR_TYPE_MENU = "        ______________\n       /|            |\n  ____/_|_____________|____\n |                      O  |\n '-(@)----------------(@)--'\n===============================\n어떤 차량 타입을 선택할까요?\n 1. Sedan\n 2. SUV\n 3. Truck\n ===============================";
    private static final String SHOW_ENGIN_MENU = "어떤 엔진을 탑재할까요?\n0. 뒤로가기\n1. GM\n2. TOYOTA\n3. WIA\n4. 고장난 엔진\n===============================";
    private static final String SHOW_BRAKE_MENU = "어떤 제동장치를 선택할까요?\n0. 뒤로가기\n1. MANDO\n2. CONTINENTAL\n3. BOSCH\n===============================";
    private static final String SHOW_STEERING_MENU = "어떤 조향장치를 선택할까요?\n0. 뒤로가기\n1. BOSCH\n2. MOBIS\n===============================";
    private static final String SHOW_RUN_TEST_MENU = "멋진 차량이 완성되었습니다.\n어떤 동작을 할까요?\n0. 처음 화면으로 돌아가기\n1. RUN\n2. Test\n===============================";

    private static int[] userSelections = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = CarType_Q;

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            String currentMenuBar = getMenu(step);
            System.out.println(currentMenuBar);

            System.out.print("INPUT > ");
            String buf = sc.nextLine().trim();

            if (isExit(buf)) {
                System.out.println("바이바이");
                break;
            }

            int answer;

            if(isDigit(buf)) {
                answer = Integer.parseInt(buf);
            }
            else{
                System.out.println("ERROR :: 숫자만 입력 가능");
                delay(800);
                continue;
            }

            if (!isValidRange(step, answer)) {
                delay(800);
                continue;
            }

            if (answer == 0) {
                step = getBeforeStep(step);
                continue;
            }

            switch (step) {
                case CarType_Q:
                    selectCarType(answer);
                    delay(800);
                    step = Engine_Q;
                    break;
                case Engine_Q:
                    selectEngine(answer);
                    delay(800);
                    step = BrakeSystem_Q;
                    break;
                case BrakeSystem_Q:
                    selectBrakeSystem(answer);
                    delay(800);
                    step = SteeringSystem_Q;
                    break;
                case SteeringSystem_Q:
                    selectSteeringSystem(answer);
                    delay(800);
                    step = Run_Test;
                    break;
                case Run_Test:
                    if (answer == 1) {
                        runProducedCar();
                        delay(2000);
                    } else if (answer == 2) {
                        System.out.println("Test...");
                        delay(1500);
                        testProducedCar();
                        delay(2000);
                    }
                    break;
            }
        }

        sc.close();
    }

    private static boolean isExit(String buf) {
        return buf.equalsIgnoreCase("exit");
    }

    private static String getMenu(int step) {
        switch (step) {
            case CarType_Q: return SHOW_CAR_TYPE_MENU;
            case Engine_Q: return SHOW_ENGIN_MENU;
            case BrakeSystem_Q: return SHOW_BRAKE_MENU;
            case SteeringSystem_Q: return SHOW_STEERING_MENU;
            case Run_Test: return SHOW_RUN_TEST_MENU;
        }

        return null;
    }

    private static boolean isDigit(String buf) {
        try{
            int answer = Integer.parseInt(buf);
        }catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static int getBeforeStep(int step) {
        if (step == Run_Test) {
            return CarType_Q;
        } else if (step > CarType_Q) {
            return step - 1;
        }

        return step;
    }

    private static boolean isValidRange(int step, int ans) {
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

    private static void selectCarType(int a) {
        userSelections[CarType_Q] = a;
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", getUserSelectCarName());
    }
    private static void selectEngine(int a) {
        userSelections[Engine_Q] = a;
        String name = getUserSelectEngineName();
        System.out.printf("%s 엔진을 선택하셨습니다.\n", name);
    }
    private static void selectBrakeSystem(int a) {
        userSelections[BrakeSystem_Q] = a;
        String name = getUserSelectBrakeName();
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", name);
    }
    private static void selectSteeringSystem(int a) {
        userSelections[SteeringSystem_Q] = a;
        String name = getUserSelectSteeringName();
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", name);
    }


    private static boolean isValidCheck() {
        if (userSelections[CarType_Q] == SEDAN && userSelections[BrakeSystem_Q] == CONTINENTAL) return false;
        if (userSelections[CarType_Q] == SUV   && userSelections[Engine_Q] == TOYOTA)       return false;
        if (userSelections[CarType_Q] == TRUCK && userSelections[Engine_Q] == WIA)          return false;
        if (userSelections[CarType_Q] == TRUCK && userSelections[BrakeSystem_Q] == MANDO)  return false;
        if (userSelections[BrakeSystem_Q] == BOSCH_B && userSelections[SteeringSystem_Q] != BOSCH_S) return false;
        return true;
    }

    private static void runProducedCar() {
        if (!isValidCheck()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (userSelections[Engine_Q] == 4) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        System.out.printf("Car Type : %s\n", getUserSelectCarName());
        System.out.printf("Engine   : %s\n", getUserSelectEngineName());
        System.out.printf("Brake    : %s\n", getUserSelectBrakeName());
        System.out.printf("Steering : %s\n", getUserSelectSteeringName());
        System.out.println("자동차가 동작됩니다.");
    }

    private static String getUserSelectCarName() {
        String[] carNames = {"", "Sedan", "SUV", "Truck"};
        String carName = null;

        try{
            carName = carNames[userSelections[CarType_Q]];
        }catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }

        return carName;
    }

    private static String getUserSelectEngineName() {
        String[] engNames = {"", "GM", "TOYOTA", "WIA"};
        String engineName = null;

        try{
            engineName = engNames[userSelections[Engine_Q]];
        }catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }

        return engineName;
    }

    private static String getUserSelectBrakeName() {
        String brakeName = null;
        try{
            brakeName = userSelections[BrakeSystem_Q] == 1 ? "Mando" : userSelections[BrakeSystem_Q] == 2 ? "Continental" : "Bosch";
        }catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }

        return brakeName;
    }

    private static String getUserSelectSteeringName() {
        String steeringSystemName = null;

        try{
            steeringSystemName = userSelections[SteeringSystem_Q] == 1 ? "Bosch" : "Mobis";
        }catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }

        return steeringSystemName;
    }

    private static void testProducedCar() {
        if (userSelections[CarType_Q] == SEDAN && userSelections[BrakeSystem_Q] == CONTINENTAL) {
            fail("Sedan에는 Continental제동장치 사용 불가");
        } else if (userSelections[CarType_Q] == SUV && userSelections[Engine_Q] == TOYOTA) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if (userSelections[CarType_Q] == TRUCK && userSelections[Engine_Q] == WIA) {
            fail("Truck에는 WIA엔진 사용 불가");
        } else if (userSelections[CarType_Q] == TRUCK && userSelections[BrakeSystem_Q] == MANDO) {
            fail("Truck에는 Mando제동장치 사용 불가");
        } else if (userSelections[BrakeSystem_Q] == BOSCH_B && userSelections[SteeringSystem_Q] != BOSCH_S) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private static void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
