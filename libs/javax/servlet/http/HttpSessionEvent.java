package javax.servlet.http;

import java.util.EventObject;

// Referenced classes of package javax.servlet.http:
//            HttpSession

public class HttpSessionEvent extends EventObject
{

    public HttpSessionEvent(HttpSession source)
    {
        super(source);
    }

    public HttpSession getSession()
    {
        return (HttpSession)super.getSource();
    }
}
