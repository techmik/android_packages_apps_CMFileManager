package javax.servlet.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package javax.servlet.annotation:
//            ServletSecurity

public interface HttpMethodConstraint
    extends Annotation
{

    public abstract String value();

    public abstract ServletSecurity.EmptyRoleSemantic emptyRoleSemantic();

    public abstract ServletSecurity.TransportGuarantee transportGuarantee();

    public abstract String[] rolesAllowed();
}