package javax.naming.spi;

import java.io.Serializable;
import javax.naming.*;

public class ResolveResult
    implements Serializable
{

    protected Object resolvedObj;
    protected Name remainingName;

    protected ResolveResult()
    {
        resolvedObj = null;
        remainingName = null;
    }

    public ResolveResult(Object obj, String s)
    {
        resolvedObj = obj;
        try
        {
            remainingName = new CompositeName(s);
        }
        catch(InvalidNameException _ex) { }
    }

    public ResolveResult(Object obj, Name name)
    {
        resolvedObj = obj;
        setRemainingName(name);
    }

    public void appendRemainingComponent(String s)
    {
        if(s != null)
        {
            CompositeName compositename = new CompositeName();
            try
            {
                compositename.add(s);
            }
            catch(InvalidNameException _ex) { }
            appendRemainingName(compositename);
        }
    }

    public void appendRemainingName(Name name)
    {
        if(name != null)
        {
            if(remainingName != null)
            {
                try
                {
                    remainingName.addAll(name);
                }
                catch(InvalidNameException _ex) { }
            } else
            {
                remainingName = (Name)name.clone();
            }
        }
    }

    public Name getRemainingName()
    {
        return remainingName;
    }

    public Object getResolvedObj()
    {
        return resolvedObj;
    }

    public void setRemainingName(Name name)
    {
        if(name != null)
        {
            remainingName = (Name)name.clone();
        } else
        {
            remainingName = null;
        }
    }

    public void setResolvedObj(Object obj)
    {
        resolvedObj = obj;
    }
}
