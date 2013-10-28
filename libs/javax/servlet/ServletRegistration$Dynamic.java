package javax.servlet;

import java.util.Set;

// Referenced classes of package javax.servlet:
//            ServletRegistration, Registration, ServletSecurityElement, MultipartConfigElement

public static interface 
    extends ServletRegistration, 
{

    public abstract void setLoadOnStartup(int i);

    public abstract Set setServletSecurity(ServletSecurityElement servletsecurityelement);

    public abstract void setMultipartConfig(MultipartConfigElement multipartconfigelement);

    public abstract void setRunAsRole(String s);
}