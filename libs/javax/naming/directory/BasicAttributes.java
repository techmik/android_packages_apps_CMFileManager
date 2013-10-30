package javax.naming.directory;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.directory:
//            Attribute, Attributes, BasicAttribute

public class BasicAttributes
    implements Attributes
{
    class AttrEnumImpl
        implements NamingEnumeration
    {

        Enumeration elements;

        public void close()
            throws NamingException
        {
            elements = null;
        }

        public boolean hasMore()
            throws NamingException
        {
            return hasMoreElements();
        }

        public boolean hasMoreElements()
        {
            return elements.hasMoreElements();
        }

        public Object next()
            throws NamingException
        {
            return nextElement();
        }

        public Object nextElement()
        {
            return elements.nextElement();
        }

        public AttrEnumImpl()
        {
            elements = attrs.elements();
        }
    }

    class IDEnumImpl
        implements NamingEnumeration
    {

        Enumeration elements;

        public void close()
            throws NamingException
        {
            elements = null;
        }

        public boolean hasMore()
            throws NamingException
        {
            return hasMoreElements();
        }

        public boolean hasMoreElements()
        {
            return elements.hasMoreElements();
        }

        public Object next()
            throws NamingException
        {
            return nextElement();
        }

        public Object nextElement()
        {
            Attribute attribute = (Attribute)elements.nextElement();
            return attribute.getID();
        }

        public IDEnumImpl()
        {
            elements = attrs.elements();
        }
    }


    private boolean ignoreCase;
    transient Hashtable attrs;
    private static final long serialVersionUID = 0x451d18d6a95539d8L;

    public BasicAttributes()
    {
        ignoreCase = false;
        attrs = new Hashtable(11);
    }

    public BasicAttributes(String s, Object obj)
    {
        this();
        put(new BasicAttribute(s, obj));
    }

    public BasicAttributes(String s, Object obj, boolean flag)
    {
        this(flag);
        put(new BasicAttribute(s, obj));
    }

    public BasicAttributes(boolean flag)
    {
        ignoreCase = false;
        attrs = new Hashtable(11);
        ignoreCase = flag;
    }

    public Object clone()
    {
        BasicAttributes basicattributes;
        try
        {
            basicattributes = (BasicAttributes)super.clone();
        }
        catch(CloneNotSupportedException _ex)
        {
            basicattributes = new BasicAttributes(ignoreCase);
        }
        basicattributes.attrs = (Hashtable)attrs.clone();
        return basicattributes;
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof Attributes))
        {
            Attributes attributes = (Attributes)obj;
            if(ignoreCase != attributes.isCaseIgnored())
            {
                return false;
            }
            if(size() == attributes.size())
            {
                try
                {
                    for(NamingEnumeration namingenumeration = attributes.getAll(); namingenumeration.hasMore();)
                    {
                        Attribute attribute = (Attribute)namingenumeration.next();
                        Attribute attribute1 = get(attribute.getID());
                        if(!attribute.equals(attribute1))
                        {
                            return false;
                        }
                    }

                }
                catch(NamingException _ex)
                {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public Attribute get(String s)
    {
        Attribute attribute = (Attribute)attrs.get(ignoreCase ? ((Object) (s.toLowerCase())) : ((Object) (s)));
        return attribute;
    }

    public NamingEnumeration getAll()
    {
        return new AttrEnumImpl();
    }

    public NamingEnumeration getIDs()
    {
        return new IDEnumImpl();
    }

    public int hashCode()
    {
        int i = ignoreCase ? 1 : 0;
        try
        {
            for(NamingEnumeration namingenumeration = getAll(); namingenumeration.hasMore();)
            {
                i += namingenumeration.next().hashCode();
            }

        }
        catch(NamingException _ex) { }
        return i;
    }

    public boolean isCaseIgnored()
    {
        return ignoreCase;
    }

    public Attribute put(String s, Object obj)
    {
        return put(((Attribute) (new BasicAttribute(s, obj))));
    }

    public Attribute put(Attribute attribute)
    {
        String s = attribute.getID();
        if(ignoreCase)
        {
            s = s.toLowerCase();
        }
        return (Attribute)attrs.put(s, attribute);
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        int i = objectinputstream.readInt();
        attrs = i < 1 ? new Hashtable(2) : new Hashtable(i * 2);
        while(--i >= 0) 
        {
            put((Attribute)objectinputstream.readObject());
        }
    }

    public Attribute remove(String s)
    {
        String s1 = ignoreCase ? s.toLowerCase() : s;
        return (Attribute)attrs.remove(s1);
    }

    public int size()
    {
        return attrs.size();
    }

    public String toString()
    {
        if(attrs.size() == 0)
        {
            return "No attributes";
        } else
        {
            return attrs.toString();
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(attrs.size());
        for(Enumeration enumeration = attrs.elements(); enumeration.hasMoreElements(); objectoutputstream.writeObject(enumeration.nextElement())) { }
    }
}
