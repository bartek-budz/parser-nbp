package pl.parser.nbp.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSet
{
    private final Map<DataType, List<Map<String, Number>>> container = new HashMap<>();

    public void put(DataType tableType, Map<String, Number> dataSetItem)
    {
        List<Map<String, Number>> list = container.get(tableType);
        if (list == null)
        {
            list = new ArrayList<>();
            container.put(tableType, list);
        }
        list.add(dataSetItem);
    }

    public List<Number> getSubSet(DataType tableType, String xmlNodeName)
    {
        List<Number> list = new ArrayList<>();
        for (Map<String, Number> dataSetItem : container.get(tableType))
        {
            Number value = dataSetItem.get(xmlNodeName);
            if (value != null)
            {
                list.add(value);
            }
        }
        return list;
    }
}
