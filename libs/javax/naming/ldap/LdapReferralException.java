package javax.naming.ldap;

import java.util.Hashtable;
import javax.naming.*;

// Referenced classes of package javax.naming.ldap:
//            Control

public abstract class LdapReferralException extends ReferralException
{

    private static final long serialVersionUID = 0xe8d68be60a29a0ecL;

    protected LdapReferralException()
    {
    }

    protected LdapReferralException(String s)
    {
        super(s);
    }

    public abstract Context getReferralContext()
        throws NamingException;

    public abstract Context getReferralContext(Hashtable hashtable)
        throws NamingException;

    public abstract Context getReferralContext(Hashtable hashtable, Control acontrol[])
        throws NamingException;
}
