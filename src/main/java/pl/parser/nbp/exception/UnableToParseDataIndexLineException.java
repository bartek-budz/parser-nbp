package pl.parser.nbp.exception;

public class UnableToParseDataIndexLineException extends Exception
{
    private String line;

    public UnableToParseDataIndexLineException(String line)
    {
        this.line = line;
    }

    @Override
    public String getMessage()
    {
        return String.format("Unable to parse data index line: %s with specified format.", line);
    }
}
