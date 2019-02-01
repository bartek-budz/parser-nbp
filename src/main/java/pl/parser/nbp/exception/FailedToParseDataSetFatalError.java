package pl.parser.nbp.exception;

public class FailedToParseDataSetFatalError extends ParserNBPFatalError
{
    private String xmlUrl;

    public FailedToParseDataSetFatalError(String xmlUrl)
    {
        this.xmlUrl = xmlUrl;
    }

    @Override
    public String getMessage()
    {
        return String.format("Failed to parse data set file: %s", xmlUrl);
    }
}
