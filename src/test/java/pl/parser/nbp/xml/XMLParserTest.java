package pl.parser.nbp.xml;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.exception.UnableToAccessFileException;

import java.util.Locale;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class XMLParserTest
{
    private XMLParser parser;
    private XMLFormat format;
    private XMLReader reader;

    @Before
    public void setUp() throws Exception
    {
        format = new XMLFormat("pozycja", "kod_waluty", new Locale("pl", "Pl", "Polish"));
        reader = new ResourcesXMLReader();
        parser = new XMLParser(format, reader);
    }

    @Test
    public void parse() throws Exception
    {
        testParse("USD", 3.0272, 3.0884);
        testParse("CHF", 2.6121, 2.6649);
        testParse("GBP", 5.7338, 5.8496);
    }

    protected void testParse(String currency, Number buyPrice, Number sellPrice) throws UnableToAccessFileException
    {
        Map<String, Number> rates = parser.parse("/c003z050105.xml", currency);
        assertEquals(3, rates.size());
        assertEquals(buyPrice, rates.get("kurs_kupna"));
        assertEquals(sellPrice, rates.get("kurs_sprzedazy"));
    }
}
