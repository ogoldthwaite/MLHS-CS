package myHashMapOpenAddressing;

import java.util.AbstractMap.SimpleEntry;

public class DeletedEntry<K, V> extends SimpleEntry<K, V>
{
    private static final long serialVersionUID = 8598779753593966300L;

    public DeletedEntry()
    {
        super(null, null);
    }
}
