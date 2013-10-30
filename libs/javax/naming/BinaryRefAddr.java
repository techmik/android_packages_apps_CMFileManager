package javax.naming;


// Referenced classes of package javax.naming:
//            RefAddr

public class BinaryRefAddr extends RefAddr
{

    private byte buf[];
    private static final long serialVersionUID = 0xd09a93b2deb38847L;

    public BinaryRefAddr(String s, byte abyte0[])
    {
        this(s, abyte0, 0, abyte0.length);
    }

    public BinaryRefAddr(String s, byte abyte0[], int i, int j)
    {
        super(s);
        buf = null;
        buf = new byte[j];
        System.arraycopy(abyte0, i, buf, 0, j);
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof BinaryRefAddr))
        {
            BinaryRefAddr binaryrefaddr = (BinaryRefAddr)obj;
            if(super.addrType.compareTo(((RefAddr) (binaryrefaddr)).addrType) == 0)
            {
                if(buf == null && binaryrefaddr.buf == null)
                {
                    return true;
                }
                if(buf == null || binaryrefaddr.buf == null || buf.length != binaryrefaddr.buf.length)
                {
                    return false;
                }
                for(int i = 0; i < buf.length; i++)
                {
                    if(buf[i] != binaryrefaddr.buf[i])
                    {
                        return false;
                    }
                }

                return true;
            }
        }
        return false;
    }

    public Object getContent()
    {
        return buf;
    }

    public int hashCode()
    {
        int i = super.addrType.hashCode();
        for(int j = 0; j < buf.length; j++)
        {
            i += buf[j];
        }

        return i;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("Address Type: " + super.addrType + "\n");
        stringbuffer.append("AddressContents: ");
        for(int i = 0; i < buf.length && i < 32; i++)
        {
            stringbuffer.append(Integer.toHexString(buf[i]) + " ");
        }

        if(buf.length >= 32)
        {
            stringbuffer.append(" ...\n");
        }
        return stringbuffer.toString();
    }
}
