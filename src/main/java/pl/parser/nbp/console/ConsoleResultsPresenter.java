package pl.parser.nbp.console;

import pl.parser.nbp.ResultsPresenter;

import java.util.List;

public class ConsoleResultsPresenter implements ResultsPresenter
{
    @Override
    public void presentErrorMessage(String errorMessage)
    {
        System.out.print(errorMessage);
    }

    @Override
    public void presentResults(List<Double> results)
    {
        for (Double result : results)
        {
            System.out.println(result);
        }
    }
}
