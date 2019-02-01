package pl.parser.nbp.processors;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.parser.nbp.DataProcessor;
import pl.parser.nbp.exception.EmptyDataSetFatalError;
import pl.parser.nbp.structures.DataSet;
import pl.parser.nbp.structures.DataType;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractDataProcessorTestCase
{
    @Mock
    private DataSet mockedDataSet;
    private List<Number> numbers;

    @Before
    public void setUp() throws Exception
    {
        numbers = new ArrayList<>();
        when(mockedDataSet.getSubSet(Matchers.any(DataType.class), anyString())).thenReturn(numbers);
    }

    protected void testProcessData(double[] numbers, double expectedResult) throws EmptyDataSetFatalError
    {
        for (double number : numbers)
        {
            this.numbers.add(number);
        }
        DataProcessor dataProcessor = createDataProcessor();
        assertEquals(expectedResult, dataProcessor.processData(mockedDataSet));
    }

    protected abstract DataProcessor createDataProcessor();

    @After
    public void tearDown() throws Exception
    {
        numbers = null;
    }
}
