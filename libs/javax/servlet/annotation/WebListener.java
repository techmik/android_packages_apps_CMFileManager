package javax.servlet.annotation;

import java.lang.annotation.Annotation;

public interface WebListener
    extends Annotation
{

    public abstract String value();
}