package javax.naming;

import java.io.Serializable;

public class NameClassPair
    implements Serializable
{

    private String name;
    private String className;
    private boolean isRel;
    private static final long serialVersionUID = 0x4e01028bfa76686bL;

    public NameClassPair(String s, String s1)
    {
        isRel = true;
        name = s;
        className = s1;
    }

    public NameClassPair(String s, String s1, boolean flag)
    {
        isRel = true;
        name = s;
        className = s1;
        isRel = flag;
    }

    public String getClassName()
    {
        return className;
    }

    public String getName()
    {
        return name;
    }

    public boolean isRelative()
    {
        return isRel;
    }

    public void setClassName(String s)
    {
        className = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setRelative(boolean flag)
    {
        isRel = flag;
    }

    public String toString()
    {
        return (isRelative() ? "" : "(not relative)") + getName() + ": " + getClassName();
    }
}
