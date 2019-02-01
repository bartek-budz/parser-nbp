package pl.parser.nbp;

import pl.parser.nbp.exception.ParserNBPFatalError;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

import java.util.Date;
import java.util.Set;

public interface DataSetProvider
{
    DataSet provideDataSet(Set<DataType> dataTypes, String currency, Date fromDate, Date toDate) throws ParserNBPFatalError;
}
