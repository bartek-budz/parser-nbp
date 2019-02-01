package pl.parser.nbp.exception;

public class ParserNBPFatalError extends Exception
{
    public ParserNBPFatalError(String message)
    {
        super(message);
    }

    public ParserNBPFatalError()
    {
        super();
    }
}
