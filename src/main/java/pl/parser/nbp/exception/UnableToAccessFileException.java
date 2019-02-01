package pl.parser.nbp.exception;

public class UnableToAccessFileException extends Exception
{
    private String filePath;

    public UnableToAccessFileException(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public String getMessage()
    {
        return String.format("Unable to access file: %s", filePath);
    }
}
