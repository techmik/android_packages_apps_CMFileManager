package javax.naming.ldap;

import java.io.Serializable;

public interface Control
    extends Serializable
{

    public static final boolean CRITICAL = true;
    public static final boolean NONCRITICAL = false;

    public abstract byte[] getEncodedValue();

    public abstract String getID();

    public abstract boolean isCritical();
}
