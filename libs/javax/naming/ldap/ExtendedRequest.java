package javax.naming.ldap;

import java.io.Serializable;
import javax.naming.NamingException;

// Referenced classes of package javax.naming.ldap:
//            ExtendedResponse

public interface ExtendedRequest
    extends Serializable
{

    public abstract ExtendedResponse createExtendedResponse(String s, byte abyte0[], int i, int j)
        throws NamingException;

    public abstract byte[] getEncodedValue();

    public abstract String getID();
}
