package javax.naming;


// Referenced classes of package javax.naming:
//            NamingException, Reference

public interface Referenceable
{

    public abstract Reference getReference()
        throws NamingException;
}
