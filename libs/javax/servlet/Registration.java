package javax.servlet;

import java.util.Map;
import java.util.Set;

public interface Registration
{
    /* member class not found */
    class Dynamic {}


    public abstract String getName();

    public abstract String getClassName();

    public abstract boolean setInitParameter(String s, String s1);

    public abstract String getInitParameter(String s);

    public abstract Set setInitParameters(Map map);

    public abstract Map getInitParameters();
}