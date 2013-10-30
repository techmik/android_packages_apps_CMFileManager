package javax.naming.spi;

import javax.naming.directory.Attributes;

// Referenced classes of package javax.naming.spi:
//            DirStateFactory

public static class attrs
{

    private Object obj;
    private Attributes attrs;

    public Attributes getAttributes()
    {
        return attrs;
    }

    public Object getObject()
    {
        return obj;
    }

    public (Object obj1, Attributes attributes)
    {
        obj = obj1;
        attrs = attributes;
    }
}
