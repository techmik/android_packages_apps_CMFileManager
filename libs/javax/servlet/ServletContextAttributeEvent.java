package javax.servlet;


// Referenced classes of package javax.servlet:
//            ServletContextEvent, ServletContext

public class ServletContextAttributeEvent extends ServletContextEvent
{

    public ServletContextAttributeEvent(ServletContext source, String name, Object value)
    {
        super(source);
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

    private String name;
    private Object value;
}