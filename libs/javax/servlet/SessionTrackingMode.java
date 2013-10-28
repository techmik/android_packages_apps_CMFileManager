package javax.servlet;


public final class SessionTrackingMode extends Enum
{

    public static SessionTrackingMode[] values()
    {
        return (SessionTrackingMode[])$VALUES.clone();
    }

    public static SessionTrackingMode valueOf(String name)
    {
        return (SessionTrackingMode)Enum.valueOf(javax/servlet/SessionTrackingMode, name);
    }

    private SessionTrackingMode(String s, int i)
    {
        super(s, i);
    }

    public static final SessionTrackingMode COOKIE;
    public static final SessionTrackingMode URL;
    public static final SessionTrackingMode SSL;
    private static final SessionTrackingMode $VALUES[];

    static 
    {
        COOKIE = new SessionTrackingMode("COOKIE", 0);
        URL = new SessionTrackingMode("URL", 1);
        SSL = new SessionTrackingMode("SSL", 2);
        $VALUES = (new SessionTrackingMode[] {
            COOKIE, URL, SSL
        });
    }
}