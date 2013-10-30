package javax.naming;


// Referenced classes of package javax.naming:
//            RefAddr

public class StringRefAddr extends RefAddr
{

    private String contents;
    private static final long serialVersionUID = 0x844bf43ce111dcc9L;

    public StringRefAddr(String s, String s1)
    {
        super(s);
        contents = s1;
    }

    public Object getContent()
    {
        return contents;
    }
}
