package javax.servlet.annotation;

import java.lang.annotation.Annotation;

public interface MultipartConfig
    extends Annotation
{

    public abstract String location();

    public abstract long maxFileSize();

    public abstract long maxRequestSize();

    public abstract int fileSizeThreshold();
}