package javax.naming.directory;

import javax.naming.Binding;

// Referenced classes of package javax.naming.directory:
//            Attributes

public class SearchResult extends Binding
{

    private Attributes attrs;
    private static final long serialVersionUID = 0x80e805ecc9ed1c5cL;

    public SearchResult(String s, Object obj, Attributes attributes)
    {
        super(s, obj);
        attrs = attributes;
    }

    public SearchResult(String s, Object obj, Attributes attributes, boolean flag)
    {
        super(s, obj, flag);
        attrs = attributes;
    }

    public SearchResult(String s, String s1, Object obj, Attributes attributes)
    {
        super(s, s1, obj);
        attrs = attributes;
    }

    public SearchResult(String s, String s1, Object obj, Attributes attributes, boolean flag)
    {
        super(s, s1, obj, flag);
        attrs = attributes;
    }

    public Attributes getAttributes()
    {
        return attrs;
    }

    public void setAttributes(Attributes attributes)
    {
        attrs = attributes;
    }

    public String toString()
    {
        return super.toString() + ":" + getAttributes();
    }
}
