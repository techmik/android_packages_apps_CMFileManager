package javax.naming;

import java.util.Hashtable;

// Referenced classes of package javax.naming:
//            NamingException, Context

public abstract class ReferralException extends NamingException
{

    private static final long serialVersionUID = 0xd80356d970425244L;

    protected ReferralException()
    {
    }

    protected ReferralException(String s)
    {
        super(s);
    }

    public abstract Context getReferralContext()
        throws NamingException;

    public abstract Context getReferralContext(Hashtable hashtable)
        throws NamingException;

    public abstract Object getReferralInfo();

    public abstract void retryReferral();

    public abstract boolean skipReferral();
}
