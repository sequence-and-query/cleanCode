package mission2.car;

import lombok.Data;
import mission2.brakesystem.BrakeSystemType;
import mission2.brakesystem.SimpleBrakeSystem;
import mission2.cartype.CarType;
import mission2.cartype.SimpleCarType;
import mission2.engine.EngineType;
import mission2.engine.SimpleEngine;
import mission2.resultcode.CarBuildResult;
import mission2.steeringsystem.SimpleSteeringSystem;
import mission2.steeringsystem.SteeringSystemType;

@Data
public class Car {
    SimpleCarType carType;
    SimpleEngine engine;
    SimpleBrakeSystem brakeSystem;
    SimpleSteeringSystem steeringSystem;

    public CarBuildResult assemble() {
        CarBuildResult carBuildResult = new CarBuildResult();

        if(CarType.Sedan.equals(carType.getTypeName()) && BrakeSystemType.Continental.equals(brakeSystem.getBrakeSystemName())) {
            carBuildResult.setResultCode(false);
            carBuildResult.setResultMessage(fail("Sedan에는 Continental제동장치 사용 불가"));
        }
        else if(CarType.SUV.equals(carType.getTypeName()) && EngineType.TOYOTA.equals(engine.getEngineName())) {
            carBuildResult.setResultCode(false);
            carBuildResult.setResultMessage(fail("SUV에는 TOYOTA엔진 사용 불가"));
        }
        else if(CarType.Truck.equals(carType.getTypeName()) && EngineType.WIA.equals(engine.getEngineName())) {
            carBuildResult.setResultCode(false);
            carBuildResult.setResultMessage(fail("Truck에는 WIA엔진 사용 불가"));
        }
        else if(CarType.Truck.equals(carType.getTypeName()) && BrakeSystemType.Mando.equals(brakeSystem.getBrakeSystemName())) {
            carBuildResult.setResultCode(false);
            carBuildResult.setResultMessage(fail("Truck에는 Mando제동장치 사용 불가"));
        }
        else if(BrakeSystemType.Bosch.equals(brakeSystem.getBrakeSystemName()) && !SteeringSystemType.Bosch.equals(steeringSystem.getSteeringSystemName())) {
            carBuildResult.setResultCode(false);
            carBuildResult.setResultMessage(fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가"));
        }
        else{
            carBuildResult.setResultCode(true);
            carBuildResult.setResultMessage("자동차 부품 조합 테스트 결과 : PASS");
        }

        return carBuildResult;
    }

    private String fail(String message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("자동차 부품 조합 테스트 결과 : FAIL\n");
        stringBuilder.append(message);

        return stringBuilder.toString();
    }

    public boolean isValid() {
        if(CarType.Sedan.equals(carType.getTypeName()) && BrakeSystemType.Continental.equals(brakeSystem.getBrakeSystemName())) {
            return false;
        }
        else if(CarType.SUV.equals(carType.getTypeName()) && EngineType.TOYOTA.equals(engine.getEngineName())) {
            return false;
        }
        else if(CarType.Truck.equals(carType.getTypeName()) && EngineType.WIA.equals(engine.getEngineName())) {
            return false;
        }
        else if(CarType.Truck.equals(carType.getTypeName()) && BrakeSystemType.Mando.equals(brakeSystem.getBrakeSystemName())) {
            return false;
        }
        else if(BrakeSystemType.Bosch.equals(brakeSystem.getBrakeSystemName()) && !SteeringSystemType.Bosch.equals(steeringSystem.getSteeringSystemName())) {
            return false;
        }
        else{
            return true;
        }
    }
}
