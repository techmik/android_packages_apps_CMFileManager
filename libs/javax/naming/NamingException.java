package javax.naming;

import java.io.PrintStream;
import java.io.PrintWriter;

// Referenced classes of package javax.naming:
//            CompositeName, Name

public class NamingException extends Exception
{

    protected Name resolvedName;
    protected Object resolvedObj;
    protected Name remainingName;
    protected Throwable rootException;
    private static final long serialVersionUID = 0xedf860e38a3ee737L;

    public NamingException()
    {
        rootException = null;
        resolvedName = remainingName = null;
        resolvedObj = null;
    }

    public NamingException(String s)
    {
        super(s);
        rootException = null;
        resolvedName = remainingName = null;
        resolvedObj = null;
    }

    public void appendRemainingComponent(String s)
    {
        if(s != null)
        {
            try
            {
                if(remainingName == null)
                {
                    remainingName = new CompositeName();
                }
                remainingName.add(s);
            }
            catch(NamingException namingexception)
            {
                throw new IllegalArgumentException(namingexception.toString());
            }
        }
    }

    public void appendRemainingName(Name name)
    {
        if(name == null)
        {
            return;
        }
        if(remainingName != null)
        {
            try
            {
                remainingName.addAll(name);
            }
            catch(NamingException namingexception)
            {
                throw new IllegalArgumentException(namingexception.toString());
            }
        } else
        {
            remainingName = (Name)name.clone();
        }
    }

    public String getExplanation()
    {
        return getMessage();
    }

    public Name getRemainingName()
    {
        return remainingName;
    }

    public Name getResolvedName()
    {
        return resolvedName;
    }

    public Object getResolvedObj()
    {
        return resolvedObj;
    }

    public Throwable getRootCause()
    {
        return rootException;
    }

    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printstream)
    {
        if(rootException != null)
        {
            String s = super.toString();
            synchronized(printstream)
            {
                printstream.print(s + (s.endsWith(".") ? "" : ".") + "  Root exception is ");
                rootException.printStackTrace(printstream);
            }
        } else
        {
            super.printStackTrace(printstream);
        }
    }

    public void printStackTrace(PrintWriter printwriter)
    {
        if(rootException != null)
        {
            String s = super.toString();
            synchronized(printwriter)
            {
                printwriter.print(s + (s.endsWith(".") ? "" : ".") + "  Root exception is ");
                rootException.printStackTrace(printwriter);
            }
        } else
        {
            super.printStackTrace(printwriter);
        }
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

    public void setResolvedName(Name name)
    {
        if(name != null)
        {
            resolvedName = (Name)name.clone();
        } else
        {
            resolvedName = null;
        }
    }

    public void setResolvedObj(Object obj)
    {
        resolvedObj = obj;
    }

    public void setRootCause(Throwable throwable)
    {
        if(throwable != this)
        {
            rootException = throwable;
        }
    }

    public String toString()
    {
        String s = super.toString();
        if(rootException != null)
        {
            s = s + " [Root exception is " + rootException + "]";
        }
        if(remainingName != null)
        {
            s = s + "; remaining name '" + remainingName + "'";
        }
        return s;
    }

    public String toString(boolean flag)
    {
        if(!flag || resolvedObj == null)
        {
            return toString();
        } else
        {
            return toString() + "; resolved object " + resolvedObj;
        }
    }
}
