package javax.naming;


// Referenced classes of package javax.naming:
//            NamingSecurityException

public class NoPermissionException extends NamingSecurityException
{

    private static final long serialVersionUID = 0x7482369e4144455fL;

    public NoPermissionException()
    {
    }

    public NoPermissionException(String s)
    {
        super(s);
    }
}
