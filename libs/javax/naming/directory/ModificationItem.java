package javax.naming.directory;

import java.io.Serializable;

// Referenced classes of package javax.naming.directory:
//            Attribute, DirContext

public class ModificationItem
    implements Serializable
{

    private int mod_op;
    private Attribute attr;
    private static final long serialVersionUID = 0x69199e89ac11aae2L;

    public ModificationItem(int i, Attribute attribute)
    {
        switch(i)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            if(attribute == null)
            {
                throw new IllegalArgumentException("Must specify non-null attribute for modification");
            }
            mod_op = i;
            attr = attribute;
            break;

        default:
            throw new IllegalArgumentException("Invalid modification code " + i);
        }
    }

    public Attribute getAttribute()
    {
        return attr;
    }

    public int getModificationOp()
    {
        return mod_op;
    }

    public String toString()
    {
        switch(mod_op)
        {
        case 1: // '\001'
            return "Add attribute: " + attr.toString();

        case 2: // '\002'
            return "Replace attribute: " + attr.toString();

        case 3: // '\003'
            return "Remove attribute: " + attr.getID().toString();
        }
        return "";
    }
}
