package mission2.car;

import mission2.brakesystem.BrakeSystemFactory;
import mission2.cartype.CarFactory;
import mission2.engine.EngineFactory;
import mission2.resultcode.CarBuildResult;
import mission2.steeringsystem.SteeringSystemFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarTest {
    Car car;

    @BeforeEach
    public void init() {
        car = new Car();
    }

    @Test
    public void normalCarTest() {
        car.setCarType(CarFactory.getInstance().getCarType(1));
        car.setEngine(EngineFactory.getInstance().getEngine(1));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(3));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        Assertions.assertEquals(true, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(true, carBuildResult.isResultCode());
    }

    @Test
    public void sedanWithBrakeContinental() {
        car.setCarType(CarFactory.getInstance().getCarType(1));
        car.setEngine(EngineFactory.getInstance().getEngine(1));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(2));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        Assertions.assertEquals(false, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(false, carBuildResult.isResultCode());

        String expected = "자동차 부품 조합 테스트 결과 : FAIL\nSedan에는 Continental제동장치 사용 불가";
        String actual = carBuildResult.getResultMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void suvWithEngineTOYOTA() {
        car.setCarType(CarFactory.getInstance().getCarType(2));
        car.setEngine(EngineFactory.getInstance().getEngine(2));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(2));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        Assertions.assertEquals(false, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(false, carBuildResult.isResultCode());

        String expected = "자동차 부품 조합 테스트 결과 : FAIL\nSUV에는 TOYOTA엔진 사용 불가";
        String actual = carBuildResult.getResultMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void truckWithEngineWIA() {
        car.setCarType(CarFactory.getInstance().getCarType(3));
        car.setEngine(EngineFactory.getInstance().getEngine(3));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(2));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        Assertions.assertEquals(false, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(false, carBuildResult.isResultCode());

        String expected = "자동차 부품 조합 테스트 결과 : FAIL\nTruck에는 WIA엔진 사용 불가";
        String actual = carBuildResult.getResultMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void truckWithBrakeMando() {
        car.setCarType(CarFactory.getInstance().getCarType(3));
        car.setEngine(EngineFactory.getInstance().getEngine(1));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(1));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(1));

        Assertions.assertEquals(false, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(false, carBuildResult.isResultCode());

        String expected = "자동차 부품 조합 테스트 결과 : FAIL\nTruck에는 Mando제동장치 사용 불가";
        String actual = carBuildResult.getResultMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void boschBrakeWithBoschSteer() {
        car.setCarType(CarFactory.getInstance().getCarType(3));
        car.setEngine(EngineFactory.getInstance().getEngine(1));
        car.setBrakeSystem(BrakeSystemFactory.getInstance().getBrakeSystem(3));
        car.setSteeringSystem(SteeringSystemFactory.getInstance().getSteeringSystem(2));

        Assertions.assertEquals(false, car.isValid());

        CarBuildResult carBuildResult = car.assemble();

        Assertions.assertEquals(false, carBuildResult.isResultCode());

        String expected = "자동차 부품 조합 테스트 결과 : FAIL\nBosch제동장치에는 Bosch조향장치 이외 사용 불가";
        String actual = carBuildResult.getResultMessage();

        Assertions.assertEquals(expected, actual);
    }
}
