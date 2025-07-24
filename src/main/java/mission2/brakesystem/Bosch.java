package mission2.brakesystem;

public class Bosch implements SimpleBrakeSystem{
    @Override
    public int getBrakeSystemCode() {
        return 3;
    }

    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Bosch;
    }
}
