package pl.parser.nbp.processors;

import pl.parser.nbp.structures.DataType;

import java.util.List;

public class ArithmeticMeanCalculator extends AbstractDataProcessor
{
    public ArithmeticMeanCalculator(DataType tableType, String xmlNodeName)
    {
        super(tableType, xmlNodeName);
    }

    @Override
    public double processData(List<Number> dataSet)
    {
        double sum = 0;
        for (Number dataItem : dataSet)
        {
            sum += dataItem.doubleValue();
        }
        return sum / dataSet.size();
    }
}
