package javax.naming.directory;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.naming.*;

// Referenced classes of package javax.naming.directory:
//            Attribute, DirContext

public class BasicAttribute
    implements Attribute
{
    class ValuesEnumImpl
        implements NamingEnumeration
    {

        Enumeration list;

        public void close()
            throws NamingException
        {
            list = null;
        }

        public boolean hasMore()
            throws NamingException
        {
            return list.hasMoreElements();
        }

        public boolean hasMoreElements()
        {
            return list.hasMoreElements();
        }

        public Object next()
            throws NamingException
        {
            return list.nextElement();
        }

        public Object nextElement()
        {
            return list.nextElement();
        }

        ValuesEnumImpl()
        {
            list = values.elements();
        }
    }


    protected String attrID;
    protected transient Vector values;
    protected boolean ordered;
    private static final long serialVersionUID = 0x5d95d32a668565beL;

    public BasicAttribute(String s)
    {
        this(s, false);
    }

    public BasicAttribute(String s, Object obj)
    {
        this(s, obj, false);
    }

    public BasicAttribute(String s, Object obj, boolean flag)
    {
        this(s, flag);
        values.addElement(obj);
    }

    public BasicAttribute(String s, boolean flag)
    {
        ordered = false;
        attrID = s;
        values = new Vector();
        ordered = flag;
    }

    public void add(int i, Object obj)
    {
        if(!isOrdered() && contains(obj))
        {
            throw new IllegalStateException("Cannot add duplicate to unordered attribute");
        } else
        {
            values.insertElementAt(obj, i);
            return;
        }
    }

    public boolean add(Object obj)
    {
        if(isOrdered() || find(obj) < 0)
        {
            values.addElement(obj);
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean arrayEquals(Object obj, Object obj1)
    {
        int i;
        if((i = Array.getLength(obj)) != Array.getLength(obj1))
        {
            return false;
        }
        for(int j = 0; j < i; j++)
        {
            Object obj2 = Array.get(obj, j);
            Object obj3 = Array.get(obj1, j);
            if(obj2 == null || obj3 == null)
            {
                if(obj2 != obj3)
                {
                    return false;
                }
            } else
            if(!obj2.equals(obj3))
            {
                return false;
            }
        }

        return true;
    }

    public void clear()
    {
        values.setSize(0);
    }

    public Object clone()
    {
        BasicAttribute basicattribute;
        try
        {
            basicattribute = (BasicAttribute)super.clone();
        }
        catch(CloneNotSupportedException _ex)
        {
            basicattribute = new BasicAttribute(attrID, ordered);
        }
        basicattribute.values = (Vector)values.clone();
        return basicattribute;
    }

    public boolean contains(Object obj)
    {
        return find(obj) >= 0;
    }

    public boolean equals(Object obj)
    {
        if(obj != null && (obj instanceof Attribute))
        {
            Attribute attribute = (Attribute)obj;
            if(isOrdered() != attribute.isOrdered())
            {
                return false;
            }
            int i;
            if(attrID.equals(attribute.getID()) && (i = size()) == attribute.size())
            {
                try
                {
                    if(isOrdered())
                    {
                        for(int j = 0; j < i; j++)
                        {
                            if(!valueEquals(get(j), attribute.get(j)))
                            {
                                return false;
                            }
                        }

                    } else
                    {
                        for(NamingEnumeration namingenumeration = attribute.getAll(); namingenumeration.hasMoreElements();)
                        {
                            if(find(namingenumeration.nextElement()) < 0)
                            {
                                return false;
                            }
                        }

                    }
                }
                catch(NamingException _ex)
                {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private int find(Object obj)
    {
        Class class1;
        if(obj == null)
        {
            int i = values.size();
            for(int k = 0; k < i; k++)
            {
                if(values.elementAt(k) == null)
                {
                    return k;
                }
            }

        } else
        if((class1 = obj.getClass()).isArray())
        {
            int j = values.size();
            for(int l = 0; l < j; l++)
            {
                Object obj1 = values.elementAt(l);
                if(obj1 != null && class1 == obj1.getClass() && arrayEquals(obj, obj1))
                {
                    return l;
                }
            }

        } else
        {
            return values.indexOf(obj, 0);
        }
        return -1;
    }

    public Object get()
        throws NamingException
    {
        if(values.size() == 0)
        {
            throw new NoSuchElementException("Attribute " + getID() + " has no value");
        } else
        {
            return values.elementAt(0);
        }
    }

    public Object get(int i)
        throws NamingException
    {
        return values.elementAt(i);
    }

    public NamingEnumeration getAll()
        throws NamingException
    {
        return new ValuesEnumImpl();
    }

    public DirContext getAttributeDefinition()
        throws NamingException
    {
        throw new OperationNotSupportedException("attribute definition");
    }

    public DirContext getAttributeSyntaxDefinition()
        throws NamingException
    {
        throw new OperationNotSupportedException("attribute syntax");
    }

    public String getID()
    {
        return attrID;
    }

    public int hashCode()
    {
        int i = attrID.hashCode();
        int j = values.size();
        for(int k = 0; k < j; k++)
        {
            Object obj = values.elementAt(k);
            if(obj != null)
            {
                if(obj.getClass().isArray())
                {
                    int l = Array.getLength(obj);
                    for(int i1 = 0; i1 < l; i1++)
                    {
                        Object obj1 = Array.get(obj, i1);
                        if(obj1 != null)
                        {
                            i += obj1.hashCode();
                        }
                    }

                } else
                {
                    i += obj.hashCode();
                }
            }
        }

        return i;
    }

    public boolean isOrdered()
    {
        return ordered;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        int i = objectinputstream.readInt();
        values = new Vector(i);
        while(--i >= 0) 
        {
            values.addElement(objectinputstream.readObject());
        }
    }

    public Object remove(int i)
    {
        Object obj = values.elementAt(i);
        values.removeElementAt(i);
        return obj;
    }

    public boolean remove(Object obj)
    {
        int i = find(obj);
        if(i >= 0)
        {
            values.removeElementAt(i);
            return true;
        } else
        {
            return false;
        }
    }

    public Object set(int i, Object obj)
    {
        if(!isOrdered() && contains(obj))
        {
            throw new IllegalStateException("Cannot add duplicate to unordered attribute");
        } else
        {
            Object obj1 = values.elementAt(i);
            values.setElementAt(obj, i);
            return obj1;
        }
    }

    public int size()
    {
        return values.size();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(attrID + ": ");
        if(values.size() == 0)
        {
            stringbuffer.append("No values");
        } else
        {
            boolean flag = true;
            for(Enumeration enumeration = values.elements(); enumeration.hasMoreElements();)
            {
                if(!flag)
                {
                    stringbuffer.append(", ");
                }
                stringbuffer.append(enumeration.nextElement());
                flag = false;
            }

        }
        return stringbuffer.toString();
    }

    private static boolean valueEquals(Object obj, Object obj1)
    {
        if(obj == obj1)
        {
            return true;
        }
        if(obj == null)
        {
            return false;
        }
        if(obj.getClass().isArray() && obj1.getClass().isArray())
        {
            return arrayEquals(obj, obj1);
        } else
        {
            return obj.equals(obj1);
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(values.size());
        for(int i = 0; i < values.size(); i++)
        {
            objectoutputstream.writeObject(values.elementAt(i));
        }

    }
}
