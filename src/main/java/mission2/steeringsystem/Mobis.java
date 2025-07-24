package mission2.steeringsystem;

public class Mobis implements SimpleSteeringSystem {
    @Override
    public int getSteeringSystemCode() {
        return 2;
    }

    @Override
    public String getSteeringSystemName() {
        return SteeringSystemType.Mobis;
    }
}
