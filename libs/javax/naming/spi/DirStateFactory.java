package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.Attributes;

// Referenced classes of package javax.naming.spi:
//            StateFactory

public interface DirStateFactory
    extends StateFactory
{
    public static class Result
    {

        private Object obj;
        private Attributes attrs;

        public Attributes getAttributes()
        {
            return attrs;
        }

        public Object getObject()
        {
            return obj;
        }

        public Result(Object obj1, Attributes attributes)
        {
            obj = obj1;
            attrs = attributes;
        }
    }


    public abstract Result getStateToBind(Object obj, Name name, Context context, Hashtable hashtable, Attributes attributes)
        throws NamingException;
}
