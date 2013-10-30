package javax.naming;

import java.util.Hashtable;

// Referenced classes of package javax.naming:
//            NamingException, Name, Context

public class CannotProceedException extends NamingException
{

    protected Name remainingNewName;
    protected Hashtable environment;
    protected Name altName;
    protected Context altNameCtx;
    private static final long serialVersionUID = 0x10ed554208d3daedL;

    public CannotProceedException()
    {
        remainingNewName = null;
        environment = null;
        altName = null;
        altNameCtx = null;
    }

    public CannotProceedException(String s)
    {
        super(s);
        remainingNewName = null;
        environment = null;
        altName = null;
        altNameCtx = null;
    }

    public Name getAltName()
    {
        return altName;
    }

    public Context getAltNameCtx()
    {
        return altNameCtx;
    }

    public Hashtable getEnvironment()
    {
        return environment;
    }

    public Name getRemainingNewName()
    {
        return remainingNewName;
    }

    public void setAltName(Name name)
    {
        altName = name;
    }

    public void setAltNameCtx(Context context)
    {
        altNameCtx = context;
    }

    public void setEnvironment(Hashtable hashtable)
    {
        environment = hashtable;
    }

    public void setRemainingNewName(Name name)
    {
        if(name != null)
        {
            remainingNewName = (Name)name.clone();
        } else
        {
            remainingNewName = null;
        }
    }
}
