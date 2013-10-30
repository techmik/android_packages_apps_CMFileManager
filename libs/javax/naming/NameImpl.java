package javax.naming;

import java.io.Serializable;
import java.util.*;

// Referenced classes of package javax.naming:
//            InvalidNameException, NameImplEnumerator

class NameImpl
    implements Serializable
{

    private Vector components;
    private String syntaxDirection;
    private String syntaxSeparator;
    private String syntaxSeparator2;
    private boolean syntaxCaseInsensitive;
    private boolean syntaxTrimBlanks;
    private String syntaxEscape;
    private String syntaxBeginQuote1;
    private String syntaxEndQuote1;
    private String syntaxBeginQuote2;
    private String syntaxEndQuote2;
    private String syntaxAvaSeparator;
    private String syntaxTypevalSeparator;
    private final int STYLE_NONE = 0;
    private final int STYLE_QUOTE1 = 1;
    private final int STYLE_QUOTE2 = 2;
    private final int STYLE_ESCAPE = 3;
    private int escapingStyle;

    NameImpl(Properties properties)
    {
        escapingStyle = 0;
        recordNamingConvention(properties);
        components = new Vector();
    }

    NameImpl(Properties properties, String s)
        throws InvalidNameException
    {
        this(properties);
        boolean flag = syntaxDirection.equals("right_to_left");
        boolean flag1 = true;
        int i = s.length();
        for(int j = 0; j < i;)
        {
            j = extractComp(s, j, i, components);
            String s1 = flag ? (String)components.firstElement() : (String)components.lastElement();
            if(s1.length() >= 1)
            {
                flag1 = false;
            }
            if(j < i)
            {
                j = skipSeparator(s, j);
                if(j == i && !flag1)
                {
                    if(flag)
                    {
                        components.insertElementAt("", 0);
                    } else
                    {
                        components.addElement("");
                    }
                }
            }
        }

    }

    NameImpl(Properties properties, Enumeration enumeration)
    {
        this(properties);
        for(; enumeration.hasMoreElements(); components.addElement(enumeration.nextElement())) { }
    }

    public void add(int i, String s)
        throws InvalidNameException
    {
        if(size() > 0 && syntaxDirection.equals("flat"))
        {
            throw new InvalidNameException("A flat name can only zero or one component");
        } else
        {
            components.insertElementAt(s, i);
            return;
        }
    }

    public void add(String s)
        throws InvalidNameException
    {
        if(size() > 0 && syntaxDirection.equals("flat"))
        {
            throw new InvalidNameException("A flat name can only have a single component");
        } else
        {
            components.addElement(s);
            return;
        }
    }

    public boolean addAll(int i, Enumeration enumeration)
        throws InvalidNameException
    {
        boolean flag = false;
        for(int j = i; enumeration.hasMoreElements(); j++)
        {
            try
            {
                Object obj = enumeration.nextElement();
                if(size() > 0 && syntaxDirection.equals("flat"))
                {
                    throw new InvalidNameException("A flat name can only have a single component");
                }
                components.insertElementAt(obj, j);
                flag = true;
                continue;
            }
            catch(NoSuchElementException _ex) { }
            break;
        }

        return flag;
    }

    public boolean addAll(Enumeration enumeration)
        throws InvalidNameException
    {
        boolean flag = false;
        while(enumeration.hasMoreElements()) 
        {
            try
            {
                Object obj = enumeration.nextElement();
                if(size() > 0 && syntaxDirection.equals("flat"))
                {
                    throw new InvalidNameException("A flat name can only have a single component");
                }
                components.addElement(obj);
                flag = true;
                continue;
            }
            catch(NoSuchElementException _ex) { }
            break;
        }
        return flag;
    }

    public int compareTo(NameImpl nameimpl)
    {
        if(this == nameimpl)
        {
            return 0;
        }
        int i = size();
        int j = nameimpl.size();
        int k = Math.min(i, j);
        int l = 0;
        int i1 = 0;
        while(k-- != 0) 
        {
            String s = get(l++);
            String s1 = nameimpl.get(i1++);
            if(syntaxTrimBlanks)
            {
                s = s.trim();
                s1 = s1.trim();
            }
            if(syntaxCaseInsensitive)
            {
                s = s.toLowerCase();
                s1 = s1.toLowerCase();
            }
            int j1 = s.compareTo(s1);
            if(j1 != 0)
            {
                return j1;
            }
        }
        return i - j;
    }

    public boolean endsWith(int i, Enumeration enumeration)
    {
        int j = size() - i;
        if(j < 0 || j > size())
        {
            return false;
        }
        try
        {
            for(Enumeration enumeration1 = getSuffix(j); enumeration1.hasMoreElements();)
            {
                String s = (String)enumeration1.nextElement();
                String s1 = (String)enumeration.nextElement();
                if(syntaxTrimBlanks)
                {
                    s = s.trim();
                    s1 = s1.trim();
                }
                if(syntaxCaseInsensitive)
                {
                    if(!s.equalsIgnoreCase(s1))
                    {
                        return false;
                    }
                } else
                if(!s.equals(s1))
                {
                    return false;
                }
            }

        }
        catch(NoSuchElementException _ex)
        {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof NameImpl))
        {
            NameImpl nameimpl = (NameImpl)obj;
            if(nameimpl.size() == size())
            {
                Enumeration enumeration = getAll();
                Enumeration enumeration1 = nameimpl.getAll();
                while(enumeration.hasMoreElements()) 
                {
                    String s = (String)enumeration.nextElement();
                    String s1 = (String)enumeration1.nextElement();
                    if(syntaxTrimBlanks)
                    {
                        s = s.trim();
                        s1 = s1.trim();
                    }
                    if(syntaxCaseInsensitive)
                    {
                        if(!s.equalsIgnoreCase(s1))
                        {
                            return false;
                        }
                    } else
                    if(!s.equals(s1))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final int extractComp(String s, int i, int j, Vector vector)
        throws InvalidNameException
    {
        boolean flag = true;
        boolean flag1 = false;
        StringBuffer stringbuffer = new StringBuffer(j);
        while(i < j) 
        {
            boolean flag2;
            if(flag && ((flag2 = isA(s, i, syntaxBeginQuote1)) || isA(s, i, syntaxBeginQuote2)))
            {
                String s1 = flag2 ? syntaxBeginQuote1 : syntaxBeginQuote2;
                String s3 = flag2 ? syntaxEndQuote1 : syntaxEndQuote2;
                if(escapingStyle == 0)
                {
                    escapingStyle = flag2 ? 1 : 2;
                }
                for(i += s1.length(); i < j && !s.startsWith(s3, i); i++)
                {
                    if(isA(s, i, syntaxEscape) && isA(s, i + syntaxEscape.length(), s3))
                    {
                        i += syntaxEscape.length();
                    }
                    stringbuffer.append(s.charAt(i));
                }

                if(i >= j)
                {
                    throw new InvalidNameException(s + ": no close quote");
                }
                i += s3.length();
                if(i != j && !isSeparator(s, i))
                {
                    throw new InvalidNameException(s + ": close quote appears before end of component");
                }
                break;
            }
            if(isSeparator(s, i))
            {
                break;
            }
            if(isA(s, i, syntaxEscape))
            {
                if(isMeta(s, i + syntaxEscape.length()))
                {
                    i += syntaxEscape.length();
                    if(escapingStyle == 0)
                    {
                        escapingStyle = 3;
                    }
                } else
                if(i + syntaxEscape.length() >= j)
                {
                    throw new InvalidNameException(s + ": unescaped " + syntaxEscape + " at end of component");
                }
            } else
            if(isA(s, i, syntaxTypevalSeparator) && ((flag2 = isA(s, i + syntaxTypevalSeparator.length(), syntaxBeginQuote1)) || isA(s, i + syntaxTypevalSeparator.length(), syntaxBeginQuote2)))
            {
                String s2 = flag2 ? syntaxBeginQuote1 : syntaxBeginQuote2;
                String s4 = flag2 ? syntaxEndQuote1 : syntaxEndQuote2;
                i += syntaxTypevalSeparator.length();
                stringbuffer.append(syntaxTypevalSeparator + s2);
                for(i += s2.length(); i < j && !s.startsWith(s4, i); i++)
                {
                    if(isA(s, i, syntaxEscape) && isA(s, i + syntaxEscape.length(), s4))
                    {
                        i += syntaxEscape.length();
                    }
                    stringbuffer.append(s.charAt(i));
                }

                if(i >= j)
                {
                    throw new InvalidNameException(s + ": typeval no close quote");
                }
                i += s4.length();
                stringbuffer.append(s4);
                if(i != j && !isSeparator(s, i))
                {
                    throw new InvalidNameException(s.substring(i) + ": typeval close quote appears before end of component");
                }
                break;
            }
            stringbuffer.append(s.charAt(i++));
            flag = false;
        }
        if(syntaxDirection.equals("right_to_left"))
        {
            vector.insertElementAt(stringbuffer.toString(), 0);
        } else
        {
            vector.addElement(stringbuffer.toString());
        }
        return i;
    }

    public String get(int i)
    {
        return (String)components.elementAt(i);
    }

    public Enumeration getAll()
    {
        return components.elements();
    }

    private static boolean getBoolean(Properties properties, String s)
    {
        return toBoolean(properties.getProperty(s));
    }

    public Enumeration getPrefix(int i)
    {
        if(i < 0 || i > size())
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            return new NameImplEnumerator(components, 0, i);
        }
    }

    public Enumeration getSuffix(int i)
    {
        int j = size();
        if(i < 0 || i > j)
        {
            throw new ArrayIndexOutOfBoundsException(i);
        } else
        {
            return new NameImplEnumerator(components, i, j);
        }
    }

    public int hashCode()
    {
        int i = 0;
        for(Enumeration enumeration = getAll(); enumeration.hasMoreElements();)
        {
            String s = (String)enumeration.nextElement();
            if(syntaxTrimBlanks)
            {
                s = s.trim();
            }
            if(syntaxCaseInsensitive)
            {
                s = s.toLowerCase();
            }
            i += s.hashCode();
        }

        return i;
    }

    private final boolean isA(String s, int i, String s1)
    {
        return s1 != null && s.startsWith(s1, i);
    }

    public boolean isEmpty()
    {
        return components.isEmpty();
    }

    private final boolean isMeta(String s, int i)
    {
        return isA(s, i, syntaxEscape) || isA(s, i, syntaxBeginQuote1) || isA(s, i, syntaxBeginQuote2) || isSeparator(s, i);
    }

    private final boolean isSeparator(String s, int i)
    {
        return isA(s, i, syntaxSeparator) || isA(s, i, syntaxSeparator2);
    }

    private final void recordNamingConvention(Properties properties)
    {
        syntaxDirection = properties.getProperty("jndi.syntax.direction", "flat");
        if(!syntaxDirection.equals("left_to_right") && !syntaxDirection.equals("right_to_left") && !syntaxDirection.equals("flat"))
        {
            throw new IllegalArgumentException(syntaxDirection + "is not a valid value for the jndi.syntax.direction property");
        }
        if(!syntaxDirection.equals("flat"))
        {
            syntaxSeparator = properties.getProperty("jndi.syntax.separator");
            syntaxSeparator2 = properties.getProperty("jndi.syntax.separator2");
            if(syntaxSeparator == null)
            {
                throw new IllegalArgumentException("jndi.syntax.separator property required for non-flat syntax");
            }
        }
        syntaxEscape = properties.getProperty("jndi.syntax.escape");
        syntaxCaseInsensitive = getBoolean(properties, "jndi.syntax.ignorecase");
        syntaxTrimBlanks = getBoolean(properties, "jndi.syntax.trimblanks");
        syntaxBeginQuote1 = properties.getProperty("jndi.syntax.beginquote");
        syntaxEndQuote1 = properties.getProperty("jndi.syntax.endquote");
        if(syntaxEndQuote1 == null && syntaxBeginQuote1 != null)
        {
            syntaxEndQuote1 = syntaxBeginQuote1;
        } else
        if(syntaxBeginQuote1 == null && syntaxEndQuote1 != null)
        {
            syntaxBeginQuote1 = syntaxEndQuote1;
        }
        syntaxBeginQuote2 = properties.getProperty("jndi.syntax.beginquote2");
        syntaxEndQuote2 = properties.getProperty("jndi.syntax.endquote2");
        if(syntaxEndQuote2 == null && syntaxBeginQuote2 != null)
        {
            syntaxEndQuote2 = syntaxBeginQuote2;
        } else
        if(syntaxBeginQuote2 == null && syntaxEndQuote2 != null)
        {
            syntaxBeginQuote2 = syntaxEndQuote2;
        }
        syntaxAvaSeparator = properties.getProperty("jndi.syntax.separator.ava");
        syntaxTypevalSeparator = properties.getProperty("jndi.syntax.separator.typeval");
    }

    public Object remove(int i)
    {
        Object obj = components.elementAt(i);
        components.removeElementAt(i);
        return obj;
    }

    public int size()
    {
        return components.size();
    }

    private final int skipSeparator(String s, int i)
    {
        if(isA(s, i, syntaxSeparator))
        {
            i += syntaxSeparator.length();
        } else
        if(isA(s, i, syntaxSeparator2))
        {
            i += syntaxSeparator2.length();
        }
        return i;
    }

    public boolean startsWith(int i, Enumeration enumeration)
    {
        if(i < 0 || i > size())
        {
            return false;
        }
        try
        {
            for(Enumeration enumeration1 = getPrefix(i); enumeration1.hasMoreElements();)
            {
                String s = (String)enumeration1.nextElement();
                String s1 = (String)enumeration.nextElement();
                if(syntaxTrimBlanks)
                {
                    s = s.trim();
                    s1 = s1.trim();
                }
                if(syntaxCaseInsensitive)
                {
                    if(!s.equalsIgnoreCase(s1))
                    {
                        return false;
                    }
                } else
                if(!s.equals(s1))
                {
                    return false;
                }
            }

        }
        catch(NoSuchElementException _ex)
        {
            return false;
        }
        return true;
    }

    private final String stringifyComp(String s)
    {
        int i = s.length();
        boolean flag = false;
        boolean flag1 = false;
        String s1 = null;
        String s2 = null;
        StringBuffer stringbuffer = new StringBuffer(i);
        if(syntaxSeparator != null && s.indexOf(syntaxSeparator) >= 0)
        {
            if(syntaxBeginQuote1 != null)
            {
                s1 = syntaxBeginQuote1;
                s2 = syntaxEndQuote1;
            } else
            if(syntaxBeginQuote2 != null)
            {
                s1 = syntaxBeginQuote2;
                s2 = syntaxEndQuote2;
            } else
            if(syntaxEscape != null)
            {
                flag = true;
            }
        }
        if(syntaxSeparator2 != null && s.indexOf(syntaxSeparator2) >= 0)
        {
            if(syntaxBeginQuote1 != null)
            {
                if(s1 == null)
                {
                    s1 = syntaxBeginQuote1;
                    s2 = syntaxEndQuote1;
                }
            } else
            if(syntaxBeginQuote2 != null)
            {
                if(s1 == null)
                {
                    s1 = syntaxBeginQuote2;
                    s2 = syntaxEndQuote2;
                }
            } else
            if(syntaxEscape != null)
            {
                flag1 = true;
            }
        }
        if(s1 != null)
        {
            stringbuffer = stringbuffer.append(s1);
            for(int j = 0; j < i;)
            {
                if(s.startsWith(s2, j))
                {
                    stringbuffer.append(syntaxEscape).append(s2);
                    j += s2.length();
                } else
                {
                    stringbuffer.append(s.charAt(j++));
                }
            }

            stringbuffer.append(s2);
        } else
        {
            boolean flag2 = true;
            for(int k = 0; k < i;)
            {
                if(flag2 && isA(s, k, syntaxBeginQuote1))
                {
                    stringbuffer.append(syntaxEscape).append(syntaxBeginQuote1);
                    k += syntaxBeginQuote1.length();
                } else
                if(flag2 && isA(s, k, syntaxBeginQuote2))
                {
                    stringbuffer.append(syntaxEscape).append(syntaxBeginQuote2);
                    k += syntaxBeginQuote2.length();
                } else
                if(isA(s, k, syntaxEscape))
                {
                    if(k + syntaxEscape.length() >= i)
                    {
                        stringbuffer.append(syntaxEscape);
                    } else
                    if(isMeta(s, k + syntaxEscape.length()))
                    {
                        stringbuffer.append(syntaxEscape);
                    }
                    stringbuffer.append(syntaxEscape);
                    k += syntaxEscape.length();
                } else
                if(flag && s.startsWith(syntaxSeparator, k))
                {
                    stringbuffer.append(syntaxEscape).append(syntaxSeparator);
                    k += syntaxSeparator.length();
                } else
                if(flag1 && s.startsWith(syntaxSeparator2, k))
                {
                    stringbuffer.append(syntaxEscape).append(syntaxSeparator2);
                    k += syntaxSeparator2.length();
                } else
                {
                    stringbuffer.append(s.charAt(k++));
                }
                flag2 = false;
            }

        }
        return stringbuffer.toString();
    }

    private static boolean toBoolean(String s)
    {
        return s != null && s.toLowerCase().equals("true");
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag = true;
        int i = components.size();
        for(int j = 0; j < i; j++)
        {
            String s;
            if(syntaxDirection.equals("right_to_left"))
            {
                s = stringifyComp((String)components.elementAt(i - 1 - j));
            } else
            {
                s = stringifyComp((String)components.elementAt(j));
            }
            if(j != 0 && syntaxSeparator != null)
            {
                stringbuffer.append(syntaxSeparator);
            }
            if(s.length() >= 1)
            {
                flag = false;
            }
            stringbuffer = stringbuffer.append(s);
        }

        if(flag && i >= 1 && syntaxSeparator != null)
        {
            stringbuffer = stringbuffer.append(syntaxSeparator);
        }
        return stringbuffer.toString();
    }
}
