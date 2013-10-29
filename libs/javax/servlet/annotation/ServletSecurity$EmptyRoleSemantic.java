package javax.servlet.annotation;


// Referenced classes of package javax.servlet.annotation:
//            ServletSecurity

public static final class ServletSecurity$EmptyRoleSemantic extends Enum
{

    public static ServletSecurity$EmptyRoleSemantic[] values()
    {
        return (ServletSecurity$EmptyRoleSemantic[])$VALUES.clone();
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
        PERMIT = new <init>ServletSecurity$EmptyRoleSemantic("PERMIT", 0);
        DENY = new <init>ServletSecurity$EmptyRoleSemantic("DENY", 1);
        $VALUES = (new ServletSecurity$EmptyRoleSemantic.VALUES[] {
            PERMIT, DENY
        });
    }

    private Enum values(String s, int i)
    {
        super(s, i);
    }
}
