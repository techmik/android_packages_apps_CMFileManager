package javax.naming.ldap;

import javax.naming.NamingException;

// Referenced classes of package javax.naming.ldap:
//            Control

public interface HasControls
{

    public abstract Control[] getControls()
        throws NamingException;
}
