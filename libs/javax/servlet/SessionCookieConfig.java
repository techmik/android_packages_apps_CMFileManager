package javax.servlet;


public interface SessionCookieConfig
{

    public abstract void setName(String s);

    public abstract String getName();

    public abstract void setDomain(String s);

    public abstract String getDomain();

    public abstract void setPath(String s);

    public abstract String getPath();

    public abstract void setComment(String s);

    public abstract String getComment();

    public abstract void setHttpOnly(boolean flag);

    public abstract boolean isHttpOnly();

    public abstract void setSecure(boolean flag);

    public abstract boolean isSecure();

    public abstract void setMaxAge(int i);

    public abstract int getMaxAge();
}