package mission2.engine;

public class WIA implements SimpleEngine{
    @Override
    public int getEngineCode() {
        return 3;
    }

    @Override
    public String getEngineName() {
        return EngineType.WIA;
    }
}
