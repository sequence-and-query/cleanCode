package mission2.brakesystem;

import java.util.HashMap;
import java.util.Map;

public class BrakeSystemFactory {
    private static BrakeSystemFactory brakeSystemFactory = null;
    private static Map<Integer, SimpleBrakeSystem> brakeMap;

    private BrakeSystemFactory() {
        brakeMap = new HashMap<>();

        brakeMap.put(1, new Mando());
        brakeMap.put(2, new Continental());
        brakeMap.put(3, new Bosch());
    }

    public static BrakeSystemFactory getInstance() {
        if(brakeSystemFactory == null) {
            brakeSystemFactory = new BrakeSystemFactory();
        }

        return brakeSystemFactory;
    }

    public SimpleBrakeSystem getBrakeSystem(int typeCode) {
        return brakeMap.get(typeCode);
    }
}
