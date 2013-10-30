package javax.naming;


// Referenced classes of package javax.naming:
//            NamingException, Name

public class LinkException extends NamingException
{

    protected Name linkResolvedName;
    protected Object linkResolvedObj;
    protected Name linkRemainingName;
    protected String linkExplanation;
    private static final long serialVersionUID = 0x916d2d1379d6ff10L;

    public LinkException()
    {
        linkResolvedName = null;
        linkResolvedObj = null;
        linkRemainingName = null;
        linkExplanation = null;
    }

    public LinkException(String s)
    {
        super(s);
        linkResolvedName = null;
        linkResolvedObj = null;
        linkRemainingName = null;
        linkExplanation = null;
    }

    public String getLinkExplanation()
    {
        return linkExplanation;
    }

    public Name getLinkRemainingName()
    {
        return linkRemainingName;
    }

    public Name getLinkResolvedName()
    {
        return linkResolvedName;
    }

    public Object getLinkResolvedObj()
    {
        return linkResolvedObj;
    }

    public void setLinkExplanation(String s)
    {
        linkExplanation = s;
    }

    public void setLinkRemainingName(Name name)
    {
        if(name != null)
        {
            linkRemainingName = (Name)name.clone();
        } else
        {
            linkRemainingName = null;
        }
    }

    public void setLinkResolvedName(Name name)
    {
        if(name != null)
        {
            linkResolvedName = (Name)name.clone();
        } else
        {
            linkResolvedName = null;
        }
    }

    public void setLinkResolvedObj(Object obj)
    {
        linkResolvedObj = obj;
    }

    public String toString()
    {
        return super.toString() + "; Link Remaining Name: '" + linkRemainingName + "'";
    }

    public String toString(boolean flag)
    {
        if(!flag || linkResolvedObj == null)
        {
            return toString();
        } else
        {
            return toString() + "; Link Resolved Object: " + linkResolvedObj;
        }
    }
}
