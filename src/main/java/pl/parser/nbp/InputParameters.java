package pl.parser.nbp;

import pl.parser.nbp.exception.FailedToParseDateFatalError;

import java.util.Date;

public interface InputParameters
{
    String getCurrency();

    Date getDateBeg() throws FailedToParseDateFatalError;

    Date getDateEnd() throws FailedToParseDateFatalError;
}
