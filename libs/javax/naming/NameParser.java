package javax.naming;


// Referenced classes of package javax.naming:
//            NamingException, Name

public interface NameParser
{

    public abstract Name parse(String s)
        throws NamingException;
}
