package mission2.brakesystem;

public class Bosch implements SimpleBrakeSystem{
    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Bosch;
    }
}
