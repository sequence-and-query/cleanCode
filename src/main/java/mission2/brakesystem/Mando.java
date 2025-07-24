package mission2.brakesystem;

public class Mando implements SimpleBrakeSystem{
    @Override
    public int getBrakeSystemCode() {
        return 1;
    }

    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Mando;
    }
}
