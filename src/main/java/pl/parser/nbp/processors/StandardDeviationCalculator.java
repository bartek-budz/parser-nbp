package pl.parser.nbp.processors;

import pl.parser.nbp.structures.DataType;

import java.util.List;

public class StandardDeviationCalculator extends AbstractDataProcessor
{
    public StandardDeviationCalculator(DataType tableType, String xmlNodeName)
    {
        super(tableType, xmlNodeName);
    }

    @Override
    public double processData(List<Number> dataSet)
    {
        double variance = new VarianceCalculator(getTableType(), getXmlNodeName()).processData(dataSet);
        return Math.sqrt(variance);
    }
}
