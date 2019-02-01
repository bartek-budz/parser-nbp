package pl.parser.nbp;

import pl.parser.nbp.exception.FailedToParseDataIndexFatalError;
import pl.parser.nbp.structures.DataIndex;

public interface DataIndexProvider
{
    DataIndex provideDataIndex() throws FailedToParseDataIndexFatalError;
}
