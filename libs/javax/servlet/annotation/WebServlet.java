package javax.servlet.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package javax.servlet.annotation:
//            WebInitParam

public interface WebServlet
    extends Annotation
{

    public abstract String name();

    public abstract String[] value();

    public abstract String[] urlPatterns();

    public abstract int loadOnStartup();

    public abstract WebInitParam[] initParams();

    public abstract boolean asyncSupported();

    public abstract String smallIcon();

    public abstract String largeIcon();

    public abstract String description();

    public abstract String displayName();
}