package javax.servlet.descriptor;

import java.util.Collection;

public interface JspConfigDescriptor
{

    public abstract Collection getTaglibs();

    public abstract Collection getJspPropertyGroups();
}