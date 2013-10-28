package javax.servlet.annotation;

import java.lang.annotation.Annotation;
import javax.servlet.DispatcherType;

// Referenced classes of package javax.servlet.annotation:
//            WebInitParam

public interface WebFilter
    extends Annotation
{

    public abstract String description();

    public abstract String displayName();

    public abstract WebInitParam[] initParams();

    public abstract String filterName();

    public abstract String smallIcon();

    public abstract String largeIcon();

    public abstract String[] servletNames();

    public abstract String[] value();

    public abstract String[] urlPatterns();

    public abstract DispatcherType[] dispatcherTypes();

    public abstract boolean asyncSupported();
}