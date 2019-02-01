package pl.parser.nbp.xml;

import java.text.NumberFormat;
import java.util.Locale;

public class XMLFormat
{
    private String itemNodeName;
    private String currencyNodeName;
    private NumberFormat numberFormat;

    public XMLFormat(String itemNodeName, String currencyNodeName, Locale locale)
    {
        this.itemNodeName = itemNodeName;
        this.currencyNodeName = currencyNodeName;
        this.numberFormat = NumberFormat.getNumberInstance(locale);
    }

    public String getItemNodeName()
    {
        return itemNodeName;
    }

    public String getCurrencyNodeName()
    {
        return currencyNodeName;
    }

    public NumberFormat getNumberFormat()
    {
        return numberFormat;
    }
}
