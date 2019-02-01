package pl.parser.nbp.exception;

public class FailedToParseDateFatalError extends ParserNBPFatalError
{
    public FailedToParseDateFatalError(String date)
    {
        super(String.format("Failed to parse \"%s\".", date));
    }
}
