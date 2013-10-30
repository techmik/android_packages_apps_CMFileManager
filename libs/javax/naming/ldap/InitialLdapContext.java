package javax.naming.ldap;

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.InitialDirContext;

// Referenced classes of package javax.naming.ldap:
//            Control, LdapContext, ExtendedRequest, ExtendedResponse

public class InitialLdapContext extends InitialDirContext
    implements LdapContext
{

    private static final String BIND_CONTROLS_PROPERTY = "java.naming.ldap.control.connect";

    public InitialLdapContext()
        throws NamingException
    {
        super(null);
    }

    public InitialLdapContext(Hashtable hashtable, Control acontrol[])
        throws NamingException
    {
        super(true);
        Hashtable hashtable1 = hashtable != null ? (Hashtable)hashtable.clone() : new Hashtable(11);
        if(acontrol != null)
        {
            Control acontrol1[] = new Control[acontrol.length];
            System.arraycopy(acontrol, 0, acontrol1, 0, acontrol.length);
            hashtable1.put("java.naming.ldap.control.connect", acontrol1);
        }
        init(hashtable1);
    }

    public ExtendedResponse extendedOperation(ExtendedRequest extendedrequest)
        throws NamingException
    {
        return getDefaultLdapInitCtx().extendedOperation(extendedrequest);
    }

    public Control[] getConnectControls()
        throws NamingException
    {
        return getDefaultLdapInitCtx().getConnectControls();
    }

    private LdapContext getDefaultLdapInitCtx()
        throws NamingException
    {
        javax.naming.Context context = getDefaultInitCtx();
        if(!(context instanceof LdapContext))
        {
            if(context == null)
            {
                throw new NoInitialContextException();
            } else
            {
                throw new NotContextException("Not an instance of LdapContext");
            }
        } else
        {
            return (LdapContext)context;
        }
    }

    public Control[] getRequestControls()
        throws NamingException
    {
        return getDefaultLdapInitCtx().getRequestControls();
    }

    public Control[] getResponseControls()
        throws NamingException
    {
        return getDefaultLdapInitCtx().getResponseControls();
    }

    public LdapContext newInstance(Control acontrol[])
        throws NamingException
    {
        return getDefaultLdapInitCtx().newInstance(acontrol);
    }

    public void reconnect(Control acontrol[])
        throws NamingException
    {
        getDefaultLdapInitCtx().reconnect(acontrol);
    }

    public void setRequestControls(Control acontrol[])
        throws NamingException
    {
        getDefaultLdapInitCtx().setRequestControls(acontrol);
    }
}
