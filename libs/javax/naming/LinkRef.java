package javax.naming;


// Referenced classes of package javax.naming:
//            Reference, MalformedLinkException, NamingException, StringRefAddr, 
//            Name

public class LinkRef extends Reference
{

    static final String linkClassName;
    static final String linkAddrType = "LinkAddress";
    private static final long serialVersionUID = 0xb5400d398d60179eL;

    public LinkRef(String s)
    {
        super(linkClassName, new StringRefAddr("LinkAddress", s));
    }

    public LinkRef(Name name)
    {
        super(linkClassName, new StringRefAddr("LinkAddress", name.toString()));
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public String getLinkName()
        throws NamingException
    {
        if(super.className != null && super.className.equals(linkClassName))
        {
            RefAddr refaddr = get("LinkAddress");
            if(refaddr != null && (refaddr instanceof StringRefAddr))
            {
                return (String)((StringRefAddr)refaddr).getContent();
            }
        }
        throw new MalformedLinkException();
    }

    static 
    {
        linkClassName = (javax.naming.LinkRef.class).getName();
    }
}
