package mission2.cartype;

public class SUV implements SimpleCarType {
    @Override
    public int getTypeCode() {
        return 2;
    }

    @Override
    public String getTypeName() {
        return CarType.SUV;
    }
}
