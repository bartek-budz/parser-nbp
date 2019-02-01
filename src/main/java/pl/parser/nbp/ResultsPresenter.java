package pl.parser.nbp;

import java.util.List;

public interface ResultsPresenter
{
    public void presentErrorMessage(String errorMessage);

    public void presentResults(List<Double> results);
}
