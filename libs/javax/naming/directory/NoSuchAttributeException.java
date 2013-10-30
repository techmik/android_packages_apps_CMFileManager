package javax.naming.directory;

import javax.naming.NamingException;

public class NoSuchAttributeException extends NamingException
{

    private static final long serialVersionUID = 0x431e6668495bfb09L;

    public NoSuchAttributeException()
    {
    }

    public NoSuchAttributeException(String s)
    {
        super(s);
    }
}
