package mission2;

import lombok.Data;
import mission2.brakesystem.BrakeSystemFactory;
import mission2.car.Car;
import mission2.cartype.CarFactory;
import mission2.engine.EngineFactory;
import mission2.resultcode.CarBuildResult;
import mission2.resultcode.UserInputResult;
import mission2.resultcode.UserInputResultValidate;
import mission2.steeringsystem.SteeringSystemFactory;

import java.util.Scanner;

@Data
public class CarBuilder {
    private final String CLEAR_SCREEN = "\033[H\033[2J";

    private final int CarType_Q = 0;
    private final int Engine_Q = 1;
    private final int BrakeSystem_Q = 2;
    private final int SteeringSystem_Q = 3;
    private final int Run_Test = 4;

    private final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private final int GM = 1, TOYOTA = 2, WIA = 3;
    private final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;
    private final int BOSCH_S = 1, MOBIS = 2;

    private final String SHOW_CAR_TYPE_MENU = "        ______________\n       /|            |\n  ____/_|_____________|____\n |                      O  |\n '-(@)----------------(@)--'\n===============================\n어떤 차량 타입을 선택할까요?\n 1. Sedan\n 2. SUV\n 3. Truck\n ===============================";
    private final String SHOW_ENGIN_MENU = "어떤 엔진을 탑재할까요?\n0. 뒤로가기\n1. GM\n2. TOYOTA\n3. WIA\n4. 고장난 엔진\n===============================";
    private final String SHOW_BRAKE_MENU = "어떤 제동장치를 선택할까요?\n0. 뒤로가기\n1. MANDO\n2. CONTINENTAL\n3. BOSCH\n===============================";
    private final String SHOW_STEERING_MENU = "어떤 조향장치를 선택할까요?\n0. 뒤로가기\n1. BOSCH\n2. MOBIS\n===============================";
    private final String SHOW_RUN_TEST_MENU = "멋진 차량이 완성되었습니다.\n어떤 동작을 할까요?\n0. 처음 화면으로 돌아가기\n1. RUN\n2. Test\n===============================";

    private final int[] userSelections = new int[5];

    public void start() {
        Scanner sc = new Scanner(System.in);
        int step = CarType_Q;
        Car car = new Car();

        while (true) {
            System.out.print(CLEAR_SCREEN);
            System.out.flush();

            String currentMenuBar = getMenu(step);
            System.out.println(currentMenuBar);

            System.out.print("INPUT > ");
            String buf = readLine(sc).trim();

            if (isExit(buf)) {
                System.out.println("바이바이");
                break;
            }

            UserInputResultValidate userInputResultValidate = new UserInputResultValidate();
            UserInputResult userInputResult = userInputResultValidate.isValid(buf, step);

            if(!userInputResult.isResultCode()) {
                System.out.println(userInputResult.getResultMessage());
                delay(800);
                continue;
            }

            int answer = Integer.parseInt(buf);

            if (answer == 0) {
                step = getBeforeStep(step);
                continue;
            }

            switch (step) {
                case CarType_Q:
                    car.setCarType(CarFactory.getInstance().getCarType(answer));
                    delay(800);
                    step = Engine_Q;
                    break;
                case Engine_Q:
                    car.setEngine(EngineFactory.getInstance().getEngine(answer));
                    delay(800);
                    step = BrakeSystem_Q;
                    break;
                case BrakeSystem_Q:
                    car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(answer));
                    delay(800);
                    step = SteeringSystem_Q;
                    break;
                case SteeringSystem_Q:
                    car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(answer));
                    delay(800);
                    step = Run_Test;
                    break;
                case Run_Test:
                    if (answer == 1) {
                        System.out.println(run(car));
                        delay(2000);
                    } else if (answer == 2) {
                        System.out.println("Test...");
                        delay(1500);
                        CarBuildResult carBuildResult = testCar(car);
                        System.out.println(carBuildResult.getResultMessage());
                        delay(2000);
                    }
                    break;
            }
        }

        sc.close();
    }

    public String readLine(Scanner scanner) {
        return scanner.nextLine();
    }

    public boolean isExit(String buf) {
        return buf.equalsIgnoreCase("exit");
    }

    public String getMenu(int step) {
        switch (step) {
            case CarType_Q:
                return SHOW_CAR_TYPE_MENU;
            case Engine_Q:
                return SHOW_ENGIN_MENU;
            case BrakeSystem_Q:
                return SHOW_BRAKE_MENU;
            case SteeringSystem_Q:
                return SHOW_STEERING_MENU;
            case Run_Test:
                return SHOW_RUN_TEST_MENU;
        }

        return null;
    }

    public int getBeforeStep(int step) {
        if (step == Run_Test) {
            return CarType_Q;
        } else if (step > CarType_Q) {
            return step - 1;
        }

        return step;
    }

    public String run(Car car) {
        if(!isValid(car)) {
            return "자동차가 동작되지 않습니다";
        }
        if(car.getEngine().getEngineCode() == 4) {
            return "엔진이 고장나있습니다.\n자동차가 움직이지 않습니다.";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Car Type : %s\n", car.getCarType().getTypeName()))
                        .append(String.format("Engine   : %s\n", car.getEngine().getEngineName()))
                                .append(String.format("Brake    : %s\n", car.getBrakeSystem().getBrakeSystemName()))
                                        .append(String.format("Steering : %s\n", car.getSteeringSystem().getSteeringSystemName()))
                                                .append("자동차가 동작됩니다.");

        return stringBuilder.toString();
    }

    public boolean isValid(Car car) {
        return car.isValid();
    }

    public CarBuildResult testCar(Car car) {
        return car.assemble();
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
