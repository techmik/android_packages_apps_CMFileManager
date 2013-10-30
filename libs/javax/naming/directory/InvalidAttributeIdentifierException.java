package javax.naming.directory;

import javax.naming.NamingException;

public class InvalidAttributeIdentifierException extends NamingException
{

    private static final long serialVersionUID = 0x829668e5be4a058dL;

    public InvalidAttributeIdentifierException()
    {
    }

    public InvalidAttributeIdentifierException(String s)
    {
        super(s);
    }
}
