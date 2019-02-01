package pl.parser.nbp.processors;

import pl.parser.nbp.structures.DataType;

import java.util.List;

public class VarianceCalculator extends AbstractDataProcessor
{
    public VarianceCalculator(DataType tableType, String xmlNodeName)
    {
        super(tableType, xmlNodeName);
    }

    @Override
    public double processData(List<Number> dataSet)
    {
        double mean = new ArithmeticMeanCalculator(getTableType(), getXmlNodeName()).processData(dataSet);
        double sumOfSquaredDifferences = 0;
        for (Number dataSetItem : dataSet)
        {
            sumOfSquaredDifferences += Math.pow(dataSetItem.doubleValue() - mean, 2);
        }
        double variance = sumOfSquaredDifferences / dataSet.size();
        return (float) variance;
    }
}
