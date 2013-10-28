package javax.servlet;

import java.util.*;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;

// Referenced classes of package javax.servlet:
//            HttpConstraintElement, HttpMethodConstraintElement

public class ServletSecurityElement extends HttpConstraintElement
{

    public ServletSecurityElement()
    {
        methodConstraints = new HashSet();
        methodNames = new HashSet();
    }

    public ServletSecurityElement(HttpConstraintElement constraint)
    {
        super(constraint.getEmptyRoleSemantic(), constraint.getTransportGuarantee(), constraint.getRolesAllowed());
        methodConstraints = new HashSet();
        methodNames = new HashSet();
    }

    public ServletSecurityElement(Collection methodConstraints)
    {
        this.methodConstraints = ((Collection) (methodConstraints != null ? methodConstraints : ((Collection) (new HashSet()))));
        methodNames = checkMethodNames(this.methodConstraints);
    }

    public ServletSecurityElement(HttpConstraintElement constraint, Collection methodConstraints)
    {
        super(constraint.getEmptyRoleSemantic(), constraint.getTransportGuarantee(), constraint.getRolesAllowed());
        this.methodConstraints = ((Collection) (methodConstraints != null ? methodConstraints : ((Collection) (new HashSet()))));
        methodNames = checkMethodNames(this.methodConstraints);
    }

    public ServletSecurityElement(ServletSecurity annotation)
    {
        super(annotation.value().value(), annotation.value().transportGuarantee(), annotation.value().rolesAllowed());
        methodConstraints = new HashSet();
        HttpMethodConstraint arr$[] = annotation.httpMethodConstraints();
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            HttpMethodConstraint constraint = arr$[i$];
            methodConstraints.add(new HttpMethodConstraintElement(constraint.value(), new HttpConstraintElement(constraint.emptyRoleSemantic(), constraint.transportGuarantee(), constraint.rolesAllowed())));
        }

        methodNames = checkMethodNames(methodConstraints);
    }

    public Collection getHttpMethodConstraints()
    {
        return methodConstraints;
    }

    public Collection getMethodNames()
    {
        return methodNames;
    }

    private Collection checkMethodNames(Collection methodConstraints)
    {
        Collection methodNames = new HashSet();
        String methodName;
        for(Iterator i$ = methodConstraints.iterator(); i$.hasNext(); methodNames.add(methodName))
        {
            HttpMethodConstraintElement methodConstraint = (HttpMethodConstraintElement)i$.next();
            methodName = methodConstraint.getMethodName();
            if(methodNames.contains(methodName))
                throw new IllegalArgumentException((new StringBuilder()).append("Duplicate HTTP method name: ").append(methodName).toString());
        }

        return methodNames;
    }

    private Collection methodNames;
    private Collection methodConstraints;
}