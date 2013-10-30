package javax.naming.spi;

import javax.naming.Name;
import javax.naming.directory.DirContext;

// Referenced classes of package javax.naming.spi:
//            ContinuationDirContext, DirContextStringPair

class DirContextNamePair
{

    DirContext ctx;
    Name name;

    DirContextNamePair(DirContext dircontext, Name name1)
    {
        ctx = dircontext;
        name = name1;
    }

    DirContext getDirContext()
    {
        return ctx;
    }

    Name getName()
    {
        return name;
    }
}
