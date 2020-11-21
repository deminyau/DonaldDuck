package DataFrame;

public class ConnectorPart_1 {
    
    public void display1(){
        ConstructDataFrame cd = new ConstructDataFrame();
        cd.ReadFile();
        cd.ScanFileCsvAndWriteTocsvFile();
    }
    
    public void display2(){
        ScanNewData snd = new ScanNewData();
        snd.ScanNewDataFromOutputFile();
    }
}
