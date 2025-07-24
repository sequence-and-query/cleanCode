package mission2.steeringsystem;

public class Bosch implements SimpleSteeringSystem{
    @Override
    public String getSteeringSystemName() {
        return SteeringSystemType.Bosch;
    }
}
