package javax.naming.ldap;

import java.io.Serializable;

public interface ExtendedResponse
    extends Serializable
{

    public abstract byte[] getEncodedValue();

    public abstract String getID();
}
