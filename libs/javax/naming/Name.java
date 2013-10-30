package javax.naming;

import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package javax.naming:
//            InvalidNameException

public interface Name
    extends Cloneable, Serializable
{

    public abstract Name add(int i, String s)
        throws InvalidNameException;

    public abstract Name add(String s)
        throws InvalidNameException;

    public abstract Name addAll(int i, Name name)
        throws InvalidNameException;

    public abstract Name addAll(Name name)
        throws InvalidNameException;

    public abstract Object clone();

    public abstract int compareTo(Object obj);

    public abstract boolean endsWith(Name name);

    public abstract String get(int i);

    public abstract Enumeration getAll();

    public abstract Name getPrefix(int i);

    public abstract Name getSuffix(int i);

    public abstract boolean isEmpty();

    public abstract Object remove(int i)
        throws InvalidNameException;

    public abstract int size();

    public abstract boolean startsWith(Name name);
}
