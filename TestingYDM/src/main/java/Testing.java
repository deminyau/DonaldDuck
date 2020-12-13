

    import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

    public class Testing {
        public static void main(String[] args) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.setValue(10,"","Software engineering");
            dataset.setValue(20,"","Artificial intelligence");
            dataset.setValue(20,"","Computer and System network");
            dataset.setValue(20,"","Multimedia");
            dataset.setValue(20,"","Information System");
            JFreeChart chart = ChartFactory.createBarChart("CourseName", "", "Number of graduates", dataset, PlotOrientation.VERTICAL, false, true, false);
            chart.setBackgroundPaint(Color.white);
            chart.getTitle().setPaint(Color.BLUE);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.GREEN);
            ChartFrame frame1 = new ChartFrame("Count",chart);
            frame1.setVisible(true);
            frame1.setSize(800,800);

        }
    }

