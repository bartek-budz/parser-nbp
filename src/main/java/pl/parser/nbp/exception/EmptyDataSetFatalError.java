package pl.parser.nbp.exception;

public class EmptyDataSetFatalError extends ParserNBPFatalError
{
    public EmptyDataSetFatalError()
    {
        super("No data found for specified currency and/or data period.");
    }
}
