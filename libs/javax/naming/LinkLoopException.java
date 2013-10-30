package javax.naming;


// Referenced classes of package javax.naming:
//            LinkException

public class LinkLoopException extends LinkException
{

    private static final long serialVersionUID = 0xd4b669459586af47L;

    public LinkLoopException()
    {
    }

    public LinkLoopException(String s)
    {
        super(s);
    }
}
