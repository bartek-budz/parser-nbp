package pl.parser.nbp.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.parser.nbp.exception.UnableToAccessFileException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class XMLParser
{
    private XMLFormat xmlFormat;
    private XMLReader xmlReader;

    public XMLParser(XMLFormat xmlFormat, XMLReader xmlReader)
    {
        this.xmlFormat = xmlFormat;
        this.xmlReader = xmlReader;
    }

    public Map<String, Number> parse(String xmlUrl, String currency) throws UnableToAccessFileException
    {
        Map<String, Number> map = new HashMap<>();
        try
        {
            NodeList xmlEntry = xmlReader.readXml(xmlUrl).getElementsByTagName(xmlFormat.getItemNodeName());
            for (int i = 0; i < xmlEntry.getLength(); i++)
            {
                parseItem((Element) xmlEntry.item(i), currency, map);
            }
            return map;
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            throw new UnableToAccessFileException(xmlUrl);
        }
    }

    private void parseItem(Element item, String currency, Map<String, Number> data)
    {
        if (checkCurrency(item, currency))
        {
            NodeList nodes = item.getChildNodes();
            for (int j = 0; j < nodes.getLength(); j++)
            {
                parseNode(nodes.item(j), data);
            }
        }
    }

    protected boolean checkCurrency(Element item, String currency)
    {
        NodeList currencyNode = item.getElementsByTagName(xmlFormat.getCurrencyNodeName());
        return (currencyNode.getLength() == 1) && (currencyNode.item(0).getTextContent().equals(currency));
    }

    private void parseNode(Node node, Map<String, Number> data)
    {
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Number value = parseValue(node.getFirstChild().getNodeValue());
            if (value != null)
            {
                data.put(node.getNodeName(), value);
            }
        }
    }

    protected Number parseValue(String value)
    {
        try
        {
            return xmlFormat.getNumberFormat().parse(value);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
}
