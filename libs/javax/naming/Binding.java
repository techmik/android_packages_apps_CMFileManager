package javax.naming;


// Referenced classes of package javax.naming:
//            NameClassPair

public class Binding extends NameClassPair
{

    private Object boundObj;
    private static final long serialVersionUID = 0x7aab35cbb5f12f02L;

    public Binding(String s, Object obj)
    {
        super(s, null);
        boundObj = obj;
    }

    public Binding(String s, Object obj, boolean flag)
    {
        super(s, null, flag);
        boundObj = obj;
    }

    public Binding(String s, String s1, Object obj)
    {
        super(s, s1);
        boundObj = obj;
    }

    public Binding(String s, String s1, Object obj, boolean flag)
    {
        super(s, s1, flag);
        boundObj = obj;
    }

    public String getClassName()
    {
        String s = super.getClassName();
        if(s != null)
        {
            return s;
        }
        if(boundObj != null)
        {
            return boundObj.getClass().getName();
        } else
        {
            return null;
        }
    }

    public Object getObject()
    {
        return boundObj;
    }

    public void setObject(Object obj)
    {
        boundObj = obj;
    }

    public String toString()
    {
        return super.toString() + ":" + getObject();
    }
}
