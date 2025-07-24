package mission2.cartype;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private static CarFactory carFactory = null;
    private static Map<Integer, SimpleCarType> carTypeMap;

    private CarFactory() {
        carTypeMap = new HashMap<>();
        carTypeMap.put(1, new Sedan());
        carTypeMap.put(2, new SUV());
        carTypeMap.put(3, new Truck());
    }

    public static CarFactory getInstance() {
        if(carFactory == null) {
            carFactory = new CarFactory();
        }

        return carFactory;
    }

    public SimpleCarType getCarType(int typeCode) {
        return carTypeMap.get(typeCode);
    }
}
