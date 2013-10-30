package javax.naming;

import java.io.*;
import java.util.*;

// Referenced classes of package javax.naming:
//            InvalidNameException, Name, NameImpl

public class CompositeName
    implements Name
{

    private transient NameImpl impl;
    private static Properties compositeSyntax;
    private static final long serialVersionUID = 0x17251a4b93d67afeL;

    public CompositeName()
    {
        impl = new NameImpl(compositeSyntax);
    }

    public CompositeName(String s)
        throws InvalidNameException
    {
        impl = new NameImpl(compositeSyntax, s);
    }

    protected CompositeName(Enumeration enumeration)
    {
        impl = new NameImpl(compositeSyntax, enumeration);
    }

    public Name add(int i, String s)
        throws InvalidNameException
    {
        impl.add(i, s);
        return this;
    }

    public Name add(String s)
        throws InvalidNameException
    {
        impl.add(s);
        return this;
    }

    public Name addAll(int i, Name name)
        throws InvalidNameException
    {
        if(name instanceof CompositeName)
        {
            impl.addAll(i, name.getAll());
            return this;
        } else
        {
            throw new InvalidNameException("Not a composite name: " + name.toString());
        }
    }

    public Name addAll(Name name)
        throws InvalidNameException
    {
        if(name instanceof CompositeName)
        {
            impl.addAll(name.getAll());
            return this;
        } else
        {
            throw new InvalidNameException("Not a composite name: " + name.toString());
        }
    }

    public Object clone()
    {
        return new CompositeName(getAll());
    }

    public int compareTo(Object obj)
    {
        if(!(obj instanceof CompositeName))
        {
            throw new ClassCastException("Not a CompositeName");
        } else
        {
            return impl.compareTo(((CompositeName)obj).impl);
        }
    }

    public boolean endsWith(Name name)
    {
        if(name instanceof CompositeName)
        {
            return impl.endsWith(name.size(), name.getAll());
        } else
        {
            return false;
        }
    }

    public boolean equals(Object obj)
    {
        return obj != null && (obj instanceof CompositeName) && impl.equals(((CompositeName)obj).impl);
    }

    public String get(int i)
    {
        return impl.get(i);
    }

    public Enumeration getAll()
    {
        return impl.getAll();
    }

    public Name getPrefix(int i)
    {
        Enumeration enumeration = impl.getPrefix(i);
        return new CompositeName(enumeration);
    }

    public Name getSuffix(int i)
    {
        Enumeration enumeration = impl.getSuffix(i);
        return new CompositeName(enumeration);
    }

    public int hashCode()
    {
        return impl.hashCode();
    }

    public boolean isEmpty()
    {
        return impl.isEmpty();
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        impl = new NameImpl(compositeSyntax);
        int i = objectinputstream.readInt();
        try
        {
            while(--i >= 0) 
            {
                add((String)objectinputstream.readObject());
            }
        }
        catch(InvalidNameException _ex)
        {
            throw new StreamCorruptedException("Invalid name");
        }
    }

    public Object remove(int i)
        throws InvalidNameException
    {
        return impl.remove(i);
    }

    public int size()
    {
        return impl.size();
    }

    public boolean startsWith(Name name)
    {
        if(name instanceof CompositeName)
        {
            return impl.startsWith(name.size(), name.getAll());
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return impl.toString();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeInt(size());
        for(Enumeration enumeration = getAll(); enumeration.hasMoreElements(); objectoutputstream.writeObject(enumeration.nextElement())) { }
    }

    static 
    {
        compositeSyntax = new Properties();
        compositeSyntax.put("jndi.syntax.direction", "left_to_right");
        compositeSyntax.put("jndi.syntax.separator", "/");
        compositeSyntax.put("jndi.syntax.ignorecase", "false");
        compositeSyntax.put("jndi.syntax.escape", "\\");
        compositeSyntax.put("jndi.syntax.beginquote", "\"");
        compositeSyntax.put("jndi.syntax.beginquote2", "'");
    }
}
