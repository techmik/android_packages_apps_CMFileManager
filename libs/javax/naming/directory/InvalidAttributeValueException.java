package javax.naming.directory;

import javax.naming.NamingException;

public class InvalidAttributeValueException extends NamingException
{

    private static final long serialVersionUID = 0x7903d78afec63b03L;

    public InvalidAttributeValueException()
    {
    }

    public InvalidAttributeValueException(String s)
    {
        super(s);
    }
}
