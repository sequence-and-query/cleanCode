package mission2.cartype;

public class Truck implements SimpleCarType {
    @Override
    public int getTypeCode() {
        return 3;
    }

    @Override
    public String getTypeName() {
        return CarType.Truck;
    }
}
