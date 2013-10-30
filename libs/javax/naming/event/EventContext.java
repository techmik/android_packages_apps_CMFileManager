package javax.naming.event;

import javax.naming.*;

// Referenced classes of package javax.naming.event:
//            NamingListener

public interface EventContext
    extends Context
{

    public static final int OBJECT_SCOPE = 0;
    public static final int ONELEVEL_SCOPE = 1;
    public static final int SUBTREE_SCOPE = 2;

    public abstract void addNamingListener(String s, int i, NamingListener naminglistener)
        throws NamingException;

    public abstract void addNamingListener(Name name, int i, NamingListener naminglistener)
        throws NamingException;

    public abstract void removeNamingListener(NamingListener naminglistener)
        throws NamingException;

    public abstract boolean targetMustExist()
        throws NamingException;
}
