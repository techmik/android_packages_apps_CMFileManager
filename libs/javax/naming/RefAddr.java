package javax.naming;

import java.io.Serializable;

public abstract class RefAddr
    implements Serializable
{

    protected String addrType;
    private static final long serialVersionUID = 0xeba0079a0238af4aL;

    protected RefAddr(String s)
    {
        addrType = s;
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof RefAddr))
        {
            RefAddr refaddr = (RefAddr)obj;
            if(addrType.compareTo(refaddr.addrType) == 0)
            {
                Object obj1 = getContent();
                Object obj2 = refaddr.getContent();
                if(obj1 == obj2)
                {
                    return true;
                }
                if(obj1 != null)
                {
                    return obj1.equals(obj2);
                }
            }
        }
        return false;
    }

    public abstract Object getContent();

    public String getType()
    {
        return addrType;
    }

    public int hashCode()
    {
        return addrType.hashCode() + getContent().hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("Type: " + addrType + "\n");
        stringbuffer.append("Content: " + getContent().toString() + "\n");
        return stringbuffer.toString();
    }
}
