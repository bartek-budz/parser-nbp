package pl.parser.nbp.xml;

import pl.parser.nbp.DataIndexProvider;
import pl.parser.nbp.DataSetProvider;
import pl.parser.nbp.exception.EmptyDataSetFatalError;
import pl.parser.nbp.exception.FailedToParseDataSetFatalError;
import pl.parser.nbp.exception.ParserNBPFatalError;
import pl.parser.nbp.exception.UnableToAccessFileException;
import pl.parser.nbp.structures.DataIndex;
import pl.parser.nbp.structures.DataIndexItem;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

import java.util.Date;
import java.util.Set;

public class XMLDataSetProvider implements DataSetProvider
{
    private DataIndexProvider dataIndexProvider;
    private XMLParser xmlParser;

    public XMLDataSetProvider(DataIndexProvider dataIndexProvider, XMLParser xmlParser)
    {
        this.dataIndexProvider = dataIndexProvider;
        this.xmlParser = xmlParser;
    }

    @Override
    public DataSet provideDataSet(Set<DataType> dataTypes, String currency, Date fromDate, Date toDate) throws ParserNBPFatalError
    {
        DataSet dataSet = new DataSet();
        DataIndex dataIndex = dataIndexProvider.provideDataIndex();
        DataIndex subDataIndex = dataIndex.getSubIndex(dataTypes, fromDate, toDate);
        if (!subDataIndex.isEmpty())
        {
            for (DataIndexItem dataIndexItem : subDataIndex)
            {
                try
                {
                    dataSet.put(dataIndexItem.getType(), xmlParser.parse(dataIndexItem.getXmlUrl(), currency));
                }
                catch (UnableToAccessFileException e)
                {
                    throw new FailedToParseDataSetFatalError(dataIndexItem.getXmlUrl());
                }
            }
            return dataSet;
        }
        else
        {
            throw new EmptyDataSetFatalError();
        }
    }
}
