package mission2.engine;

import java.util.HashMap;
import java.util.Map;

public class EngineFactory {
    private static EngineFactory engineFactory = null;
    private static Map<Integer, SimpleEngine> engineMap;

    private EngineFactory() {
        engineMap = new HashMap<>();
        engineMap.put(1, new GM());
        engineMap.put(2, new TOYOTA());
        engineMap.put(3, new WIA());
        engineMap.put(4, new BrokenEngine());
    }

    public static EngineFactory getInstance() {
        if(engineFactory == null) {
            engineFactory = new EngineFactory();
        }

        return engineFactory;
    }

    public SimpleEngine getEngine(int engineTypeCode) {
        return engineMap.get(engineTypeCode);
    }
}
