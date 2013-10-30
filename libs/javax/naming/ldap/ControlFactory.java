package javax.naming.ldap;

import com.sun.naming.internal.FactoryEnumeration;
import com.sun.naming.internal.ResourceManager;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.ldap:
//            LdapContext, Control

public abstract class ControlFactory
{

    protected ControlFactory()
    {
    }

    public abstract Control getControlInstance(Control control)
        throws NamingException;

    public static Control getControlInstance(Control control, Context context, Hashtable hashtable)
        throws NamingException
    {
        FactoryEnumeration factoryenumeration = ResourceManager.getFactories("java.naming.factory.control", hashtable, context);
        if(factoryenumeration == null)
        {
            return control;
        }
        Control control1;
        ControlFactory controlfactory;
        for(control1 = null; control1 == null && factoryenumeration.hasMore(); control1 = controlfactory.getControlInstance(control))
        {
            controlfactory = (ControlFactory)factoryenumeration.next();
        }

        return control1 == null ? control : control1;
    }
}
