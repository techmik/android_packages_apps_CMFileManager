package javax.naming.spi;

import javax.naming.directory.DirContext;

// Referenced classes of package javax.naming.spi:
//            ContinuationDirContext, DirContextNamePair

class DirContextStringPair
{

    DirContext ctx;
    String str;

    DirContextStringPair(DirContext dircontext, String s)
    {
        ctx = dircontext;
        str = s;
    }

    DirContext getDirContext()
    {
        return ctx;
    }

    String getString()
    {
        return str;
    }
}
