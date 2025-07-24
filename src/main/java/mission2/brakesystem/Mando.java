package mission2.brakesystem;

public class Mando implements SimpleBrakeSystem{
    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Mando;
    }
}
