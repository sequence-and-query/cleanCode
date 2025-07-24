package mission2.brakesystem;

public class Continental implements SimpleBrakeSystem{
    @Override
    public int getBrakeSystemCode() {
        return 2;
    }

    @Override
    public String getBrakeSystemName() {
        return BrakeSystemType.Continental;
    }
}
