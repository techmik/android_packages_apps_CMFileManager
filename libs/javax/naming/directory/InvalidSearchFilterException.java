package javax.naming.directory;

import javax.naming.NamingException;

public class InvalidSearchFilterException extends NamingException
{

    private static final long serialVersionUID = 0x284877205a985231L;

    public InvalidSearchFilterException()
    {
    }

    public InvalidSearchFilterException(String s)
    {
        super(s);
    }
}
