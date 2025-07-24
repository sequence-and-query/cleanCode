package mission2.engine;

public class BrokenEngine implements SimpleEngine {
    @Override
    public int getEngineCode() {
        return 4;
    }

    @Override
    public String getEngineName() {
        return "null";
    }
}
