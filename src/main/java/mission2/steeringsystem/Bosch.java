package mission2.steeringsystem;

public class Bosch implements SimpleSteeringSystem{
    @Override
    public int getSteeringSystemCode() {
        return 1;
    }

    @Override
    public String getSteeringSystemName() {
        return SteeringSystemType.Bosch;
    }
}
