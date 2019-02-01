package pl.parser.nbp;

import pl.parser.nbp.exception.EmptyDataSetFatalError;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

public interface DataProcessor
{
    double processData(DataSet dataSet) throws EmptyDataSetFatalError;

    DataType getTableType();
}
