package javax.servlet;

import javax.servlet.annotation.ServletSecurity;

// Referenced classes of package javax.servlet:
//            HttpConstraintElement

public class HttpMethodConstraintElement extends HttpConstraintElement
{

    public HttpMethodConstraintElement(String methodName)
    {
        if(methodName == null || methodName.length() == 0)
        {
            throw new IllegalArgumentException("invalid HTTP method name");
        } else
        {
            this.methodName = methodName;
            return;
        }
    }

    public HttpMethodConstraintElement(String methodName, HttpConstraintElement constraint)
    {
        super(constraint.getEmptyRoleSemantic(), constraint.getTransportGuarantee(), constraint.getRolesAllowed());
        if(methodName == null || methodName.length() == 0)
        {
            throw new IllegalArgumentException("invalid HTTP method name");
        } else
        {
            this.methodName = methodName;
            return;
        }
    }

    public String getMethodName()
    {
        return methodName;
    }

    private String methodName;
}