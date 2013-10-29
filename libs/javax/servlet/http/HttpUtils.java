package javax.servlet.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.servlet.ServletInputStream;

// Referenced classes of package javax.servlet.http:
//            HttpServletRequest

/**
 * @deprecated Class HttpUtils is deprecated
 */

public class HttpUtils
{

    public HttpUtils()
    {
    }

    public static Hashtable parseQueryString(String s)
    {
        String valArray[] = null;
        if(s == null)
            throw new IllegalArgumentException();
        Hashtable ht = new Hashtable();
        StringBuffer sb = new StringBuffer();
        String key;
        for(StringTokenizer st = new StringTokenizer(s, "&"); st.hasMoreTokens(); ht.put(key, valArray))
        {
            String pair = st.nextToken();
            int pos = pair.indexOf('=');
            if(pos == -1)
                throw new IllegalArgumentException();
            key = parseName(pair.substring(0, pos), sb);
            String val = parseName(pair.substring(pos + 1, pair.length()), sb);
            if(ht.containsKey(key))
            {
                String oldVals[] = (String[])(String[])ht.get(key);
                valArray = new String[oldVals.length + 1];
                for(int i = 0; i < oldVals.length; i++)
                    valArray[i] = oldVals[i];

                valArray[oldVals.length] = val;
            } else
            {
                valArray = new String[1];
                valArray[0] = val;
            }
        }

        return ht;
    }

    public static Hashtable parsePostData(int len, ServletInputStream in)
    {
        byte postedBytes[];
        UnsupportedEncodingException e;
        if(len <= 0)
            return new Hashtable();
        if(in == null)
            throw new IllegalArgumentException();
        postedBytes = new byte[len];
        try
        {
            int offset = 0;
            do
            {
                int inputLen = in.read(postedBytes, offset, len - offset);
                if(inputLen <= 0)
                {
                    String msg = lStrings.getString("err.io.short_read");
                    throw new IllegalArgumentException(msg);
                }
                offset += inputLen;
            } while(len - offset > 0);
        }
        // Misplaced declaration of an exception variable
        catch(UnsupportedEncodingException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
        String postedBody = new String(postedBytes, 0, len, "8859_1");
        return parseQueryString(postedBody);
    }

    private static String parseName(String s, StringBuffer sb)
    {
        sb.setLength(0);
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch(c)
            {
            case 43: // '+'
                sb.append(' ');
                break;

            case 37: // '%'
                try
                {
                    sb.append((char)Integer.parseInt(s.substring(i + 1, i + 3), 16));
                    i += 2;
                    break;
                }
                catch(NumberFormatException e)
                {
                    throw new IllegalArgumentException();
                }
                catch(StringIndexOutOfBoundsException e)
                {
                    String rest = s.substring(i);
                    sb.append(rest);
                    if(rest.length() == 2)
                        i++;
                }
                break;

            default:
                sb.append(c);
                break;
            }
        }

        return sb.toString();
    }

    public static StringBuffer getRequestURL(HttpServletRequest req)
    {
        StringBuffer url = new StringBuffer();
        String scheme = req.getScheme();
        int port = req.getServerPort();
        String urlPath = req.getRequestURI();
        url.append(scheme);
        url.append("://");
        url.append(req.getServerName());
        if(scheme.equals("http") && port != 80 || scheme.equals("https") && port != 443)
        {
            url.append(':');
            url.append(req.getServerPort());
        }
        url.append(urlPath);
        return url;
    }

    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");

}
