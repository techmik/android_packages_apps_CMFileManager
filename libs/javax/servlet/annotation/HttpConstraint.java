package javax.servlet.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package javax.servlet.annotation:
//            ServletSecurity

public interface HttpConstraint
    extends Annotation
{

    public abstract ServletSecurity.EmptyRoleSemantic value();

    public abstract ServletSecurity.TransportGuarantee transportGuarantee();

    public abstract String[] rolesAllowed();
}