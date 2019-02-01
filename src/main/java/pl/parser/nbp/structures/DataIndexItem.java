package pl.parser.nbp.structures;

import java.util.Date;

public class DataIndexItem
{
    private DataType type;
    private Date date;
    private String xmlUrl;

    public DataIndexItem(DataType type, Date date, String xmlUrl)
    {
        this.type = type;
        this.date = date;
        this.xmlUrl = xmlUrl;
    }

    public DataType getType()
    {
        return type;
    }

    public Date getDate()
    {
        return date;
    }

    public String getXmlUrl()
    {
        return xmlUrl;
    }
}
