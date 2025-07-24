package mission2.engine;

public class TOYOTA implements SimpleEngine {
    @Override
    public int getEngineCode() {
        return 2;
    }

    @Override
    public String getEngineName() {
        return EngineType.TOYOTA;
    }
}
