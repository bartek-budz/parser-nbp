package pl.parser.nbp.processors;

import org.junit.Test;
import pl.parser.nbp.DataProcessor;
import pl.parser.nbp.structures.DataType;

public class ArithmeticMeanCalculatorTest extends AbstractDataProcessorTestCase
{
    @Override
    protected DataProcessor createDataProcessor()
    {
        return new ArithmeticMeanCalculator(DataType.BUY_AND_SELL_AVERAGE_RATE, "test");
    }

    @Test
    public void processData() throws Exception
    {
        double[] set1 = {1.2, 4.3, 13.0, 17.11, 21.99};
        double[] set2 = {1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0};
        double[] set3 = {-12.13, -45.67, -89.0, 98.76, 54.32, 1.0};
        testProcessData(set1, 11.52);
        testProcessData(set2, 10.4);
        testProcessData(set3, 7.644);
    }
}
