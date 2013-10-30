package javax.naming.ldap;

import javax.naming.event.NamingListener;

// Referenced classes of package javax.naming.ldap:
//            UnsolicitedNotificationEvent

public interface UnsolicitedNotificationListener
    extends NamingListener
{

    public abstract void notificationReceived(UnsolicitedNotificationEvent unsolicitednotificationevent);
}
