package javax.naming.directory;

import javax.naming.NamingException;

public class InvalidAttributesException extends NamingException
{

    private static final long serialVersionUID = 0x24301a12642c8465L;

    public InvalidAttributesException()
    {
    }

    public InvalidAttributesException(String s)
    {
        super(s);
    }
}
