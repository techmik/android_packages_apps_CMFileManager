package javax.naming;


// Referenced classes of package javax.naming:
//            NamingException

public abstract class NamingSecurityException extends NamingException
{

    private static final long serialVersionUID = 0x51422917b2bb824fL;

    public NamingSecurityException()
    {
    }

    public NamingSecurityException(String s)
    {
        super(s);
    }
}
