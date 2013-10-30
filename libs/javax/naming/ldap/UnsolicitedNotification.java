package javax.naming.ldap;

import javax.naming.NamingException;

// Referenced classes of package javax.naming.ldap:
//            ExtendedResponse, HasControls

public interface UnsolicitedNotification
    extends ExtendedResponse, HasControls
{

    public abstract NamingException getException();

    public abstract String[] getReferrals();
}
