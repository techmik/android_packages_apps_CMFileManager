package javax.naming;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

// Referenced classes of package javax.naming:
//            InvalidNameException, Name, NameImpl

public class CompoundName
    implements Name
{

    protected transient NameImpl impl;
    protected transient Properties mySyntax;
    private static final long serialVersionUID = 0x30c10a57ed3791c4L;

    public CompoundName(String s, Properties properties)
        throws InvalidNameException
    {
        mySyntax = properties;
        impl = new NameImpl(properties, s);
    }

    protected CompoundName(Enumeration enumeration, Properties properties)
    {
        mySyntax = properties;
        impl = new NameImpl(properties, enumeration);
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
        if(name instanceof CompoundName)
        {
            impl.addAll(i, name.getAll());
            return this;
        } else
        {
            throw new InvalidNameException("Not a compound name: " + name.toString());
        }
    }

    public Name addAll(Name name)
        throws InvalidNameException
    {
        if(name instanceof CompoundName)
        {
            impl.addAll(name.getAll());
            return this;
        } else
        {
            throw new InvalidNameException("Not a compound name: " + name.toString());
        }
    }

    public Object clone()
    {
        return new CompoundName(getAll(), mySyntax);
    }

    public int compareTo(Object obj)
    {
        if(!(obj instanceof CompoundName))
        {
            throw new ClassCastException("Not a CompoundName");
        } else
        {
            return impl.compareTo(((CompoundName)obj).impl);
        }
    }

    public boolean endsWith(Name name)
    {
        if(name instanceof CompoundName)
        {
            return impl.endsWith(name.size(), name.getAll());
        } else
        {
            return false;
        }
    }

    public boolean equals(Object obj)
    {
        return obj != null && (obj instanceof CompoundName) && impl.equals(((CompoundName)obj).impl);
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
        return new CompoundName(enumeration, mySyntax);
    }

    public Name getSuffix(int i)
    {
        Enumeration enumeration = impl.getSuffix(i);
        return new CompoundName(enumeration, mySyntax);
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
        mySyntax = (Properties)objectinputstream.readObject();
        impl = new NameImpl(mySyntax);
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
        if(name instanceof CompoundName)
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
        objectoutputstream.writeObject(mySyntax);
        objectoutputstream.writeInt(size());
        for(Enumeration enumeration = getAll(); enumeration.hasMoreElements(); objectoutputstream.writeObject(enumeration.nextElement())) { }
    }
}
