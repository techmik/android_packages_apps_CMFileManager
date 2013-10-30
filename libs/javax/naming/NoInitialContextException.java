package javax.naming;


// Referenced classes of package javax.naming:
//            NamingException

public class NoInitialContextException extends NamingException
{

    private static final long serialVersionUID = 0xd09ffbc0d4c9ce81L;

    public NoInitialContextException()
    {
    }

    public NoInitialContextException(String s)
    {
        super(s);
    }
}
