package javax.servlet.annotation;

import java.lang.annotation.Annotation;

public interface WebInitParam
    extends Annotation
{

    public abstract String name();

    public abstract String value();

    public abstract String description();
}