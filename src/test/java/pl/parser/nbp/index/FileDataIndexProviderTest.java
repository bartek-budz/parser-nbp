package pl.parser.nbp.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileDataIndexProviderTest
{
    @Mock
    private DataIndexFileReader reader;
    @Mock
    private DataIndexFileFormat format;

    @Before
    public void setUp()
    {
        when(format.getDateFormat()).thenReturn("yymmdd");
        when(format.getDatePattern()).thenReturn("^[abch]\\d{3}z(\\d{6})$");
        when(format.getTypePattern()).thenReturn("^([abch])\\d{3}z\\d{6}$");
    }

    @Test
    public void testParseData()
    {
        String typePattern = "^([abch])\\d{3}z\\d{6}$";
        FileDataIndexProvider builder = new FileDataIndexProvider(reader, format);
        assertEquals("a", builder.parseData("a017z020124", typePattern));
        assertEquals("b", builder.parseData("b024z080611", typePattern));
        assertEquals("c", builder.parseData("c118z080618", typePattern));
        assertEquals("h", builder.parseData("h121z080623", typePattern));
        assertEquals("", builder.parseData("a123", typePattern));

        String datePattern = "^[abch]\\d{3}z(\\d{6})$";
        assertEquals("020124", builder.parseData("a017z020124", datePattern));
        assertEquals("080611", builder.parseData("b024z080611", datePattern));
        assertEquals("080618", builder.parseData("c118z080618", datePattern));
        assertEquals("080623", builder.parseData("h121z080623", datePattern));
        assertEquals("", builder.parseData("h121x080623", datePattern));
    }

    @After
    public void tearDown()
    {
        reset(reader);
        reset(format);
    }
}
