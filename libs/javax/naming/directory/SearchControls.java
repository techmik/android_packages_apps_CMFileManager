package javax.naming.directory;

import java.io.Serializable;

public class SearchControls
    implements Serializable
{

    public static final int OBJECT_SCOPE = 0;
    public static final int ONELEVEL_SCOPE = 1;
    public static final int SUBTREE_SCOPE = 2;
    private int searchScope;
    private int timeLimit;
    private boolean derefLink;
    private boolean returnObj;
    private long countLimit;
    private String attributesToReturn[];
    private static final long serialVersionUID = 0xdd935921dd0f3e33L;

    public SearchControls()
    {
        searchScope = 1;
        timeLimit = 0;
        countLimit = 0L;
        derefLink = false;
        returnObj = false;
        attributesToReturn = null;
    }

    public SearchControls(int i, long l, int j, String as[], boolean flag, boolean flag1)
    {
        searchScope = i;
        timeLimit = j;
        derefLink = flag1;
        returnObj = flag;
        countLimit = l;
        attributesToReturn = as;
    }

    public long getCountLimit()
    {
        return countLimit;
    }

    public boolean getDerefLinkFlag()
    {
        return derefLink;
    }

    public String[] getReturningAttributes()
    {
        return attributesToReturn;
    }

    public boolean getReturningObjFlag()
    {
        return returnObj;
    }

    public int getSearchScope()
    {
        return searchScope;
    }

    public int getTimeLimit()
    {
        return timeLimit;
    }

    public void setCountLimit(long l)
    {
        countLimit = l;
    }

    public void setDerefLinkFlag(boolean flag)
    {
        derefLink = flag;
    }

    public void setReturningAttributes(String as[])
    {
        attributesToReturn = as;
    }

    public void setReturningObjFlag(boolean flag)
    {
        returnObj = flag;
    }

    public void setSearchScope(int i)
    {
        searchScope = i;
    }

    public void setTimeLimit(int i)
    {
        timeLimit = i;
    }
}
