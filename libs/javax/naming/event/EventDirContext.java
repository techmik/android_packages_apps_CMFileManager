package javax.naming.event;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

// Referenced classes of package javax.naming.event:
//            EventContext, NamingListener

public interface EventDirContext
    extends EventContext, DirContext
{

    public abstract void addNamingListener(String s, String s1, SearchControls searchcontrols, NamingListener naminglistener)
        throws NamingException;

    public abstract void addNamingListener(String s, String s1, Object aobj[], SearchControls searchcontrols, NamingListener naminglistener)
        throws NamingException;

    public abstract void addNamingListener(Name name, String s, SearchControls searchcontrols, NamingListener naminglistener)
        throws NamingException;

    public abstract void addNamingListener(Name name, String s, Object aobj[], SearchControls searchcontrols, NamingListener naminglistener)
        throws NamingException;
}
