package pl.parser.nbp.console;

import pl.parser.nbp.InputParameters;
import pl.parser.nbp.exception.FailedToParseDateFatalError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleInputParameters implements InputParameters
{
    private String currency;
    private String dateBeg;
    private String dateEnd;
    private SimpleDateFormat format;

    public ConsoleInputParameters(String currency, String dateBeg, String dateEnd, String datePattern)
    {
        this.currency = currency;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.format = new SimpleDateFormat(datePattern);
    }

    @Override
    public String getCurrency()
    {
        return currency;
    }

    @Override
    public Date getDateBeg() throws FailedToParseDateFatalError
    {
        try
        {
            return format.parse(dateBeg);
        }
        catch (ParseException e)
        {
            throw new FailedToParseDateFatalError(dateBeg);
        }
    }

    @Override
    public Date getDateEnd() throws FailedToParseDateFatalError
    {
        try
        {
            return format.parse(dateEnd);
        }
        catch (ParseException e)
        {
            throw new FailedToParseDateFatalError(dateEnd);
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s", currency, dateBeg, dateEnd);
    }
}
