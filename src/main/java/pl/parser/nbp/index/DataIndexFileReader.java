package pl.parser.nbp.index;

import pl.parser.nbp.exception.UnableToAccessFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataIndexFileReader
{
    private String url;

    public DataIndexFileReader(String url)
    {
        this.url = url;
    }

    public List<String> readLines() throws UnableToAccessFileException
    {
        ArrayList<String> result;
        try
        {
            result = new ArrayList<>();
            InputStream stream = new URL(url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = br.readLine()) != null)
            {
                result.add(line);
            }
            br.close();
        }
        catch (IOException e)
        {
            throw new UnableToAccessFileException(url);
        }
        return result;
    }
}
