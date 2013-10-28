package javax.servlet.annotation;


// Referenced classes of package javax.servlet.annotation:
//            ServletSecurity

public static final class  extends Enum
{

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public static c_3B_.clone valueOf(String name)
    {
        return (c_3B_.clone)Enum.valueOf(javax/servlet/annotation/ServletSecurity$EmptyRoleSemantic, name);
    }

    public static final DENY PERMIT;
    public static final DENY DENY;
    private static final DENY $VALUES[];

    static 
    {
        PERMIT = new <init>("PERMIT", 0);
        DENY = new <init>("DENY", 1);
        $VALUES = (new .VALUES[] {
            PERMIT, DENY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}