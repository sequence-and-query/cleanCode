package mission2.brakesystem;

public class Continental implements SimpleBrakeSystem{
    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Continental;
    }
}
