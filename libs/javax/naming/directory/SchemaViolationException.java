package javax.naming.directory;

import javax.naming.NamingException;

public class SchemaViolationException extends NamingException
{

    private static final long serialVersionUID = 0xd5c97d2fb107bec1L;

    public SchemaViolationException()
    {
    }

    public SchemaViolationException(String s)
    {
        super(s);
    }
}
