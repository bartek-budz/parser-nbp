package pl.parser.nbp.structures;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataIndex implements Iterable<DataIndexItem>
{
    private final HashSet<DataIndexItem> container = new HashSet<>();

    public boolean add(DataIndexItem dataIndexItem)
    {
        return container.add(dataIndexItem);
    }

    @Override
    public Iterator<DataIndexItem> iterator()
    {
        return container.iterator();
    }

    public boolean isEmpty()
    {
        return container.isEmpty();
    }

    public DataIndex getSubIndex(Set<DataType> types, Date beg, Date end)
    {
        DataIndex subSet = new DataIndex();
        for (DataIndexItem entry : container)
        {
            if ((types.contains(entry.getType())) && (!(entry.getDate().before(beg) || entry.getDate().after(end))))
            {
                subSet.add(entry);
            }
        }
        return subSet;
    }
}
