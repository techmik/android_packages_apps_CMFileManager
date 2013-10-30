package javax.naming;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package javax.naming:
//            RefAddr

public class Reference
    implements Cloneable, Serializable
{

    protected String className;
    protected Vector addrs;
    protected String classFactory;
    protected String classFactoryLocation;
    private static final long serialVersionUID = 0xe8c69ea2a8e98d09L;

    public Reference(String s)
    {
        addrs = null;
        classFactory = null;
        classFactoryLocation = null;
        className = s;
        addrs = new Vector();
    }

    public Reference(String s, String s1, String s2)
    {
        this(s);
        classFactory = s1;
        classFactoryLocation = s2;
    }

    public Reference(String s, RefAddr refaddr)
    {
        addrs = null;
        classFactory = null;
        classFactoryLocation = null;
        className = s;
        addrs = new Vector();
        addrs.addElement(refaddr);
    }

    public Reference(String s, RefAddr refaddr, String s1, String s2)
    {
        this(s, refaddr);
        classFactory = s1;
        classFactoryLocation = s2;
    }

    public void add(int i, RefAddr refaddr)
    {
        addrs.insertElementAt(refaddr, i);
    }

    public void add(RefAddr refaddr)
    {
        addrs.addElement(refaddr);
    }

    public void clear()
    {
        addrs.setSize(0);
    }

    public Object clone()
    {
        Reference reference = new Reference(className, classFactory, classFactoryLocation);
        Enumeration enumeration = getAll();
        reference.addrs = new Vector();
        for(; enumeration.hasMoreElements(); reference.addrs.addElement(enumeration.nextElement())) { }
        return reference;
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof Reference))
        {
            Reference reference = (Reference)obj;
            if(reference.className.equals(className) && reference.size() == size())
            {
                Enumeration enumeration = getAll();
                Enumeration enumeration1 = reference.getAll();
                while(enumeration.hasMoreElements()) 
                {
                    if(!enumeration.nextElement().equals(enumeration1.nextElement()))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public RefAddr get(int i)
    {
        return (RefAddr)addrs.elementAt(i);
    }

    public RefAddr get(String s)
    {
        int i = addrs.size();
        for(int j = 0; j < i; j++)
        {
            RefAddr refaddr = (RefAddr)addrs.elementAt(j);
            if(refaddr.getType().compareTo(s) == 0)
            {
                return refaddr;
            }
        }

        return null;
    }

    public Enumeration getAll()
    {
        return addrs.elements();
    }

    public String getClassName()
    {
        return className;
    }

    public String getFactoryClassLocation()
    {
        return classFactoryLocation;
    }

    public String getFactoryClassName()
    {
        return classFactory;
    }

    public int hashCode()
    {
        int i = className.hashCode();
        for(Enumeration enumeration = getAll(); enumeration.hasMoreElements();)
        {
            i += enumeration.nextElement().hashCode();
        }

        return i;
    }

    public Object remove(int i)
    {
        Object obj = addrs.elementAt(i);
        addrs.removeElementAt(i);
        return obj;
    }

    public int size()
    {
        return addrs.size();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("Reference Class Name: " + className + "\n");
        int i = addrs.size();
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(get(j).toString());
        }

        return stringbuffer.toString();
    }
}
