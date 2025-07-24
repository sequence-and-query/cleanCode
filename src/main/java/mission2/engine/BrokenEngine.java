package mission2.engine;

public class BrokenEngine implements SimpleEngine {
    @Override
    public String getEngineName() {
        return EngineType.BROKEN_ENGINE;
    }
}
