package StatisticsAndImputers;

import java.io.FileNotFoundException;

public class ConnectorPart3 {

    public void displaypart3a() throws FileNotFoundException {
        MathMethod mm = new MathMethod();
        mm.ComputeMath();
    }
    
    public void displaypart3b() throws FileNotFoundException{
        FillMissingValue fmv = new FillMissingValue();
        fmv.FillValue();
    }
}
