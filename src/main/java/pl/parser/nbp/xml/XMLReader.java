package pl.parser.nbp.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class XMLReader
{
    public Document readXml(String xmlUrl) throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(getInputStream(xmlUrl));
        document.getDocumentElement().normalize();
        return document;
    }

    protected InputStream getInputStream(String filePath) throws IOException
    {
        return new URL(filePath).openStream();
    }
}
