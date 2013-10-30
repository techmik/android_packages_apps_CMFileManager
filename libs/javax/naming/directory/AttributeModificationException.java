package javax.naming.directory;

import javax.naming.NamingException;

// Referenced classes of package javax.naming.directory:
//            ModificationItem

public class AttributeModificationException extends NamingException
{

    private ModificationItem unexecs[];
    private static final long serialVersionUID = 0x6fdd462d96b0fdaaL;

    public AttributeModificationException()
    {
        unexecs = null;
    }

    public AttributeModificationException(String s)
    {
        super(s);
        unexecs = null;
    }

    public ModificationItem[] getUnexecutedModifications()
    {
        return unexecs;
    }

    public void setUnexecutedModifications(ModificationItem amodificationitem[])
    {
        unexecs = amodificationitem;
    }

    public String toString()
    {
        String s = super.toString();
        if(unexecs != null)
        {
            s = s + "First unexecuted modification: " + unexecs[0].toString();
        }
        return s;
    }
}
