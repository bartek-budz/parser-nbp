package pl.parser.nbp.xml;

import java.io.IOException;
import java.io.InputStream;

public class ResourcesXMLReader extends XMLReader
{
    @Override
    protected InputStream getInputStream(String filePath) throws IOException
    {
        return this.getClass().getResourceAsStream(filePath);
    }
}
