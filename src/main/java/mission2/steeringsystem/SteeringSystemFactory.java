package mission2.steeringsystem;

import java.util.HashMap;
import java.util.Map;

public class SteeringSystemFactory {
    private static SteeringSystemFactory steeringSystemFactory = null;
    private static Map<Integer, SimpleSteeringSystem> steeringSystemMap;

    private SteeringSystemFactory() {
        steeringSystemMap = new HashMap<>();

        steeringSystemMap.put(1, new Bosch());
        steeringSystemMap.put(2, new Mobis());
    }

    public static SteeringSystemFactory getInstance() {
        if(steeringSystemFactory == null) {
            steeringSystemFactory = new SteeringSystemFactory();
        }

        return steeringSystemFactory;
    }

    public SimpleSteeringSystem getSteeringSystem(int typeCode) {
        return steeringSystemMap.get(typeCode);
    }
}
