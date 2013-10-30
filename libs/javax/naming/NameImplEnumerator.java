package javax.naming;

import java.util.*;

// Referenced classes of package javax.naming:
//            NameImpl

final class NameImplEnumerator
    implements Enumeration
{

    Vector vector;
    int count;
    int limit;

    NameImplEnumerator(Vector vector1, int i, int j)
    {
        vector = vector1;
        count = i;
        limit = j;
    }

    public boolean hasMoreElements()
    {
        return count < limit;
    }

    public Object nextElement()
    {
        if(count < limit)
        {
            return vector.elementAt(count++);
        } else
        {
            throw new NoSuchElementException("NameImplEnumerator");
        }
    }
}
