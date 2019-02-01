package pl.parser.nbp.processors;

import pl.parser.nbp.DataProcessor;
import pl.parser.nbp.exception.EmptyDataSetFatalError;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

import java.util.List;

abstract class AbstractDataProcessor implements DataProcessor
{
    private DataType tableType;
    private String xmlNodeName;

    protected AbstractDataProcessor(DataType tableType, String xmlNodeName)
    {
        this.xmlNodeName = xmlNodeName;
        this.tableType = tableType;
    }

    @Override
    public double processData(DataSet dataSet) throws EmptyDataSetFatalError
    {
        List<Number> subSet = dataSet.getSubSet(getTableType(), getXmlNodeName());
        if (subSet.size() > 0)
        {
            return processData(subSet);
        }
        else
        {
            throw new EmptyDataSetFatalError();
        }
    }

    protected String getXmlNodeName()
    {
        return this.xmlNodeName;
    }

    protected abstract double processData(List<Number> data);

    @Override
    public DataType getTableType()
    {
        return tableType;
    }
}
