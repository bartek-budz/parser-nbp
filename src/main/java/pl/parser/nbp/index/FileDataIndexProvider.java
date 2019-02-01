package pl.parser.nbp.index;

import pl.parser.nbp.DataIndexProvider;
import pl.parser.nbp.exception.FailedToParseDataIndexFatalError;
import pl.parser.nbp.exception.UnableToAccessFileException;
import pl.parser.nbp.exception.UnableToParseDataIndexLineException;
import pl.parser.nbp.structures.DataIndex;
import pl.parser.nbp.structures.DataIndexItem;
import pl.parser.nbp.structures.DataType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataIndexProvider implements DataIndexProvider
{
    private DataIndexFileReader reader;
    private DataIndexFileFormat format;

    public FileDataIndexProvider(DataIndexFileReader reader, DataIndexFileFormat format)
    {
        this.reader = reader;
        this.format = format;
    }

    @Override
    public DataIndex provideDataIndex() throws FailedToParseDataIndexFatalError
    {
        try
        {
            DataIndex dataIndex = new DataIndex();
            for (String line : reader.readLines())
            {
                DataIndexItem entry = parseLine(line);
                dataIndex.add(entry);
            }
            return dataIndex;
        }
        catch (UnableToAccessFileException | UnableToParseDataIndexLineException e)
        {
            throw new FailedToParseDataIndexFatalError(e.getMessage());
        }
    }

    protected DataIndexItem parseLine(String line) throws UnableToParseDataIndexLineException
    {
        String fileName = parseData(line, format.getFileNamePattern());
        String strType = parseData(line, format.getTypePattern());
        String strDate = parseData(line, format.getDatePattern());
        if ((fileName.length() > 0) && (strType.length() > 0) && strDate.length() > 0)
        {
            try
            {
                DataType formattedType = format.getTypes().get(strType);
                Date formattedDate = new SimpleDateFormat(format.getDateFormat()).parse(strDate);
                String xmlUrl = String.format(format.getXmlUrlFormat(), fileName);
                return new DataIndexItem(formattedType, formattedDate, xmlUrl);
            }
            catch (ParseException e)
            {
                throw new UnableToParseDataIndexLineException(line);
            }
        }
        else
        {
            throw new UnableToParseDataIndexLineException(line);
        }
    }

    protected String parseData(String line, String pattern)
    {
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        if (matcher.find() && (matcher.groupCount() == 1))
        {
            return matcher.group(1);
        }
        else
        {
            return "";
        }
    }
}
