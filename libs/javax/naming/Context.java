package javax.naming;

import java.util.Hashtable;

// Referenced classes of package javax.naming:
//            NamingException, Name, NameParser, NamingEnumeration

public interface Context
{

    public static final String INITIAL_CONTEXT_FACTORY = "java.naming.factory.initial";
    public static final String OBJECT_FACTORIES = "java.naming.factory.object";
    public static final String STATE_FACTORIES = "java.naming.factory.state";
    public static final String URL_PKG_PREFIXES = "java.naming.factory.url.pkgs";
    public static final String PROVIDER_URL = "java.naming.provider.url";
    public static final String DNS_URL = "java.naming.dns.url";
    public static final String AUTHORITATIVE = "java.naming.authoritative";
    public static final String BATCHSIZE = "java.naming.batchsize";
    public static final String REFERRAL = "java.naming.referral";
    public static final String SECURITY_PROTOCOL = "java.naming.security.protocol";
    public static final String SECURITY_AUTHENTICATION = "java.naming.security.authentication";
    public static final String SECURITY_PRINCIPAL = "java.naming.security.principal";
    public static final String SECURITY_CREDENTIALS = "java.naming.security.credentials";
    public static final String LANGUAGE = "java.naming.language";
    public static final String APPLET = "java.naming.applet";

    public abstract Object addToEnvironment(String s, Object obj)
        throws NamingException;

    public abstract void bind(String s, Object obj)
        throws NamingException;

    public abstract void bind(Name name, Object obj)
        throws NamingException;

    public abstract void close()
        throws NamingException;

    public abstract String composeName(String s, String s1)
        throws NamingException;

    public abstract Name composeName(Name name, Name name1)
        throws NamingException;

    public abstract Context createSubcontext(String s)
        throws NamingException;

    public abstract Context createSubcontext(Name name)
        throws NamingException;

    public abstract void destroySubcontext(String s)
        throws NamingException;

    public abstract void destroySubcontext(Name name)
        throws NamingException;

    public abstract Hashtable getEnvironment()
        throws NamingException;

    public abstract String getNameInNamespace()
        throws NamingException;

    public abstract NameParser getNameParser(String s)
        throws NamingException;

    public abstract NameParser getNameParser(Name name)
        throws NamingException;

    public abstract NamingEnumeration list(String s)
        throws NamingException;

    public abstract NamingEnumeration list(Name name)
        throws NamingException;

    public abstract NamingEnumeration listBindings(String s)
        throws NamingException;

    public abstract NamingEnumeration listBindings(Name name)
        throws NamingException;

    public abstract Object lookup(String s)
        throws NamingException;

    public abstract Object lookup(Name name)
        throws NamingException;

    public abstract Object lookupLink(String s)
        throws NamingException;

    public abstract Object lookupLink(Name name)
        throws NamingException;

    public abstract void rebind(String s, Object obj)
        throws NamingException;

    public abstract void rebind(Name name, Object obj)
        throws NamingException;

    public abstract Object removeFromEnvironment(String s)
        throws NamingException;

    public abstract void rename(String s, String s1)
        throws NamingException;

    public abstract void rename(Name name, Name name1)
        throws NamingException;

    public abstract void unbind(String s)
        throws NamingException;

    public abstract void unbind(Name name)
        throws NamingException;
}
