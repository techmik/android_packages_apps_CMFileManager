package javax.naming.directory;

import javax.naming.NamingException;

public class AttributeInUseException extends NamingException
{

    private static final long serialVersionUID = 0x3d95ea02c92a5c44L;

    public AttributeInUseException()
    {
    }

    public AttributeInUseException(String s)
    {
        super(s);
    }
}
