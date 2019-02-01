package pl.parser.nbp.processors;

import org.junit.Test;
import pl.parser.nbp.DataProcessor;
import pl.parser.nbp.structures.DataType;

public class StandardDeviationCalculatorTest extends AbstractDataProcessorTestCase
{
    @Override
    protected DataProcessor createDataProcessor()
    {
        return new StandardDeviationCalculator(DataType.BUY_AND_SELL_AVERAGE_RATE, "test");
    }

    @Test
    public void processData() throws Exception
    {
        double[] set1 = {2, 4, 4, 4, 5, 5, 7, 9};
        double[] set2 = {1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0};
        double[] set3 = {-12.13, -45.67, -89.0, 98.76, 54.32, 1.0};
        testProcessData(set1, 2);
        testProcessData(set2, 4.960783708246107);
        testProcessData(set3, 32.57078192123943);
    }
}
