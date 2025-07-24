package mission2.cartype;

public class Sedan implements SimpleCarType{
    @Override
    public int getTypeCode() {
        return 1;
    }

    @Override
    public String getTypeName() {
        return CarType.Sedan;
    }
}
