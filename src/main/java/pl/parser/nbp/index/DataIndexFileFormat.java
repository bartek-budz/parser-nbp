package pl.parser.nbp.index;

import pl.parser.nbp.structures.DataType;

import java.util.Map;

public class DataIndexFileFormat
{
    private String fileNamePattern;
    private String typePattern;
    private String datePattern;
    private String dateFormat;
    private String xmlUrlFormat;

    private Map<String, DataType> types;

    public DataIndexFileFormat(String fileNamePattern, String typePattern, String datePattern, String dateFormat, String xmlUrlFormat, Map<String, DataType> types)
    {
        this.fileNamePattern = fileNamePattern;
        this.typePattern = typePattern;
        this.datePattern = datePattern;
        this.dateFormat = dateFormat;
        this.xmlUrlFormat = xmlUrlFormat;
        this.types = types;
    }

    public String getFileNamePattern()
    {
        return fileNamePattern;
    }

    public String getTypePattern()
    {
        return typePattern;
    }

    public String getDatePattern()
    {
        return datePattern;
    }

    public String getDateFormat()
    {
        return dateFormat;
    }

    public String getXmlUrlFormat()
    {
        return xmlUrlFormat;
    }

    public Map<String, DataType> getTypes()
    {
        return types;
    }
}
