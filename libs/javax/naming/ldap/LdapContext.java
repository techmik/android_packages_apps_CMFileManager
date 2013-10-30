package javax.naming.ldap;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;

// Referenced classes of package javax.naming.ldap:
//            ExtendedRequest, ExtendedResponse, Control

public interface LdapContext
    extends DirContext
{

    public static final String CONTROL_FACTORIES = "java.naming.factory.control";

    public abstract ExtendedResponse extendedOperation(ExtendedRequest extendedrequest)
        throws NamingException;

    public abstract Control[] getConnectControls()
        throws NamingException;

    public abstract Control[] getRequestControls()
        throws NamingException;

    public abstract Control[] getResponseControls()
        throws NamingException;

    public abstract LdapContext newInstance(Control acontrol[])
        throws NamingException;

    public abstract void reconnect(Control acontrol[])
        throws NamingException;

    public abstract void setRequestControls(Control acontrol[])
        throws NamingException;
}
