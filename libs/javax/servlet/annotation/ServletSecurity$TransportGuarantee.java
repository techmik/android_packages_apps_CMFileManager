package javax.servlet.annotation;


// Referenced classes of package javax.servlet.annotation:
//            ServletSecurity

public static final class A extends Enum
{

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    public static e_3B_.clone valueOf(String name)
    {
        return (e_3B_.clone)Enum.valueOf(javax/servlet/annotation/ServletSecurity$TransportGuarantee, name);
    }

    public static final CONFIDENTIAL NONE;
    public static final CONFIDENTIAL CONFIDENTIAL;
    private static final CONFIDENTIAL $VALUES[];

    static 
    {
        NONE = new <init>A("NONE", 0);
        CONFIDENTIAL = new <init>A("CONFIDENTIAL", 1);
        $VALUES = (new A.VALUES[] {
            NONE, CONFIDENTIAL
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
