package mission2.engine;

public class GM implements SimpleEngine{

    @Override
    public int getEngineCode() {
        return 1;
    }

    @Override
    public String getEngineName() {
        return EngineType.GM;
    }
}
