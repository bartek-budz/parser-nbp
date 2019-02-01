package pl.parser.nbp;

import org.apache.log4j.Logger;
import pl.parser.nbp.exception.EmptyDataSetFatalError;
import pl.parser.nbp.exception.ParserNBPFatalError;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Runner
{
    private InputParameters inputParameters;
    private DataSetProvider dataSetProvider;
    private List<DataProcessor> dataProcessors;
    private ResultsPresenter resultsPresenter;

    private final Logger logger = Logger.getLogger(Runner.class.getName());

    public Runner(InputParameters inputParameters, DataSetProvider dataSetProvider, List<DataProcessor> dataProcessors, ResultsPresenter resultsPresenter)
    {
        this.inputParameters = inputParameters;
        this.dataSetProvider = dataSetProvider;
        this.dataProcessors = dataProcessors;
        this.resultsPresenter = resultsPresenter;
    }

    public void run()
    {
        try
        {
            resultsPresenter.presentResults(process(dataSetProvider.provideDataSet(getDataTypes(), inputParameters.getCurrency(), inputParameters.getDateBeg(), inputParameters.getDateEnd())));
        }
        catch (ParserNBPFatalError e)
        {
            logger.fatal(inputParameters, e);
            resultsPresenter.presentErrorMessage(String.format("Fatal error: %s", e.getMessage()));
        }
    }

    private Set<DataType> getDataTypes()
    {
        Set<DataType> dataTypes = EnumSet.noneOf(DataType.class);
        for (DataProcessor processor : dataProcessors)
        {
            dataTypes.add(processor.getTableType());
        }
        return dataTypes;
    }

    protected List<Double> process(DataSet dataSet) throws EmptyDataSetFatalError
    {
        List<Double> results = new ArrayList<>();
        for (DataProcessor processor : dataProcessors)
        {
            results.add(processor.processData(dataSet));
        }
        return results;
    }
}
