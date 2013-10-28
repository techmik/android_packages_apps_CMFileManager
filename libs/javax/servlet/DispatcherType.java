package javax.servlet;


public final class DispatcherType extends Enum
{

    public static DispatcherType[] values()
    {
        return (DispatcherType[])$VALUES.clone();
    }

    public static DispatcherType valueOf(String name)
    {
        return (DispatcherType)Enum.valueOf(javax/servlet/DispatcherType, name);
    }

    private DispatcherType(String s, int i)
    {
        super(s, i);
    }

    public static final DispatcherType FORWARD;
    public static final DispatcherType INCLUDE;
    public static final DispatcherType REQUEST;
    public static final DispatcherType ASYNC;
    public static final DispatcherType ERROR;
    private static final DispatcherType $VALUES[];

    static 
    {
        FORWARD = new DispatcherType("FORWARD", 0);
        INCLUDE = new DispatcherType("INCLUDE", 1);
        REQUEST = new DispatcherType("REQUEST", 2);
        ASYNC = new DispatcherType("ASYNC", 3);
        ERROR = new DispatcherType("ERROR", 4);
        $VALUES = (new DispatcherType[] {
            FORWARD, INCLUDE, REQUEST, ASYNC, ERROR
        });
    }
}