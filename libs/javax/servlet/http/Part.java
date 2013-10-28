package javax.servlet.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public interface Part
{

    public abstract InputStream getInputStream()
        throws IOException;

    public abstract String getContentType();

    public abstract String getName();

    public abstract long getSize();

    public abstract void write(String s)
        throws IOException;

    public abstract void delete()
        throws IOException;

    public abstract String getHeader(String s);

    public abstract Collection getHeaders(String s);

    public abstract Collection getHeaderNames();
}