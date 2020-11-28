package Manipulation;

import java.io.IOException;

public class ConnectorPart2 {
    public void DisplayPart1(){
        ConcatenateDataFrame cdf = new ConcatenateDataFrame();
        cdf.ReadFile1();
        cdf.ReadFile2();
        cdf.ConcatenateData();
    }
    
    public void DisplayPart2() throws IOException{
        ObtainRowOrColumnData od = new ObtainRowOrColumnData();
        od.ObtainRecordInColumn();
        od.ObtainRecordInRow();
    }
    
    public void DisplayPart3(){
        DataSorting ds = new DataSorting();
        ds.ReadFile4();
        ds.Sorting();
    }
    
    public void DisplayPart4() throws IOException{
        RemoveDuplicatedRowInData rdr = new RemoveDuplicatedRowInData();
        rdr.DeleteDuplicatedRow();
    }
    
    public void DisplayPart5() throws IOException{
        RemoveNullDataFrame rndf = new RemoveNullDataFrame();
        rndf.ReadFile3();
        rndf.deleteRecord();
    }
}
