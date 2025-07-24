package mission2;


import mission2.brakesystem.BrakeSystemFactory;
import mission2.car.Car;
import mission2.cartype.CarFactory;
import mission2.engine.EngineFactory;
import mission2.resultcode.UserInputResultValidate;
import mission2.steeringsystem.SteeringSystemFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarBuilderTest {
    @Mock
    UserInputResultValidate userInputResultValidate;

    @Spy
    CarBuilder carBuilder;

    @Test
    @DisplayName("각 항목별로 메뉴가 정상적으로 출력되는가")
    public void getMenuTest() {
        String expected = "        ______________\n       /|            |\n  ____/_|_____________|____\n |                      O  |\n '-(@)----------------(@)--'\n===============================\n어떤 차량 타입을 선택할까요?\n 1. Sedan\n 2. SUV\n 3. Truck\n ===============================";
        String actual = carBuilder.getMenu(0);

        Assertions.assertEquals(expected, actual);

        expected = "어떤 엔진을 탑재할까요?\n0. 뒤로가기\n1. GM\n2. TOYOTA\n3. WIA\n4. 고장난 엔진\n===============================";
        actual = carBuilder.getMenu(1);

        Assertions.assertEquals(expected, actual);

        expected = "어떤 제동장치를 선택할까요?\n0. 뒤로가기\n1. MANDO\n2. CONTINENTAL\n3. BOSCH\n===============================";
        actual = carBuilder.getMenu(2);

        Assertions.assertEquals(expected, actual);

        expected = "어떤 조향장치를 선택할까요?\n0. 뒤로가기\n1. BOSCH\n2. MOBIS\n===============================";
        actual = carBuilder.getMenu(3);

        Assertions.assertEquals(expected, actual);

        expected = "멋진 차량이 완성되었습니다.\n어떤 동작을 할까요?\n0. 처음 화면으로 돌아가기\n1. RUN\n2. Test\n===============================";
        actual = carBuilder.getMenu(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("부서진 엔진을 선택하면 자동차가 움직이지 않는가")
    public void runTest() {
        Car car = new Car();
        car.setCarType(CarFactory.getInstance().getCarType(1));
        car.setEngine(EngineFactory.getInstance().getEngine(4));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(1));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        String expect = "엔진이 고장나있습니다.\n자동차가 움직이지 않습니다.";
        String actual = carBuilder.run(car);

        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Exit이 정상적으로 되는가")
    public void ExitTest() {
        Mockito.doReturn("exit").when(carBuilder).readLine(Mockito.any());

        carBuilder.start();

        Mockito.verify(carBuilder, Mockito.times(0)).testCar(Mockito.any());
    }

    @Test
    @DisplayName("자동차를 정상적으로 빌드하면 Exception 발생하지 않는지")
    public void normalBuildTest() {
        Mockito.doReturn("1")
                .doReturn("2")
                .doReturn("3")
                .doReturn("1")
                .doReturn("1")
                .doReturn("2")
                .doReturn("exit").when(carBuilder).readLine(Mockito.any());
        Mockito.doNothing().when(carBuilder).delay(Mockito.anyInt());

        Assertions.assertDoesNotThrow(carBuilder::start);
    }

    @Test
    @DisplayName("선택 중 나가면 Exception 발생하는지")
    public void exitAfterSelection() {
        Mockito.doReturn("1").doReturn("2").doReturn("exit").when(carBuilder).readLine(Mockito.any());

        Assertions.assertDoesNotThrow(carBuilder::start);
    }

    @Test
    @DisplayName("잘못된 입력을 주면 Exception 발생하는지")
    public void invalidUserInput() {
        Mockito.doReturn("a").doReturn("1").doReturn("exit").when(carBuilder).readLine(Mockito.any());

        Mockito.doNothing().when(carBuilder).delay(Mockito.anyInt());

        Assertions.assertDoesNotThrow(carBuilder::start);
    }

    @Test
    @DisplayName("중간에 0을 입력해도 Exception 발생하는지")
    public void doBeforeStep() {
        Mockito.doReturn("1")
                .doReturn("0")
                .doReturn("1")
                .doReturn("2")
                .doReturn("1")
                .doReturn("1")
                .doReturn("1")
                .doReturn("0")
                .doReturn("exit")
                .when(carBuilder).readLine(Mockito.any());

        Mockito.doNothing().when(carBuilder).delay(Mockito.anyInt());

        Assertions.assertDoesNotThrow(carBuilder::start);
    }
}
