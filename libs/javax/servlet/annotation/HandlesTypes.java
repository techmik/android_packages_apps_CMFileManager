package javax.servlet.annotation;

import java.lang.annotation.Annotation;

public interface HandlesTypes
    extends Annotation
{

    public abstract Class[] value();
}