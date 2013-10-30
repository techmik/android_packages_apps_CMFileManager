package javax.naming.ldap;

import java.util.EventObject;

// Referenced classes of package javax.naming.ldap:
//            UnsolicitedNotificationListener, UnsolicitedNotification

public class UnsolicitedNotificationEvent extends EventObject
{

    private UnsolicitedNotification notice;
    private static final long serialVersionUID = 0xdeef4ad946c73647L;

    public UnsolicitedNotificationEvent(Object obj, UnsolicitedNotification unsolicitednotification)
    {
        super(obj);
        notice = unsolicitednotification;
    }

    public void dispatch(UnsolicitedNotificationListener unsolicitednotificationlistener)
    {
        unsolicitednotificationlistener.notificationReceived(this);
    }

    public UnsolicitedNotification getNotification()
    {
        return notice;
    }
}
