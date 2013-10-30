package javax.servlet;


// Referenced classes of package javax.servlet:
//            ServletRequestEvent, ServletContext, ServletRequest

public class ServletRequestAttributeEvent extends ServletRequestEvent
{

    private String name;
    private Object value;

    public ServletRequestAttributeEvent(ServletContext sc, ServletRequest request, String name, Object value)
    {
        super(sc, request);
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public Object getValue()
    {
        return value;
    }
}
