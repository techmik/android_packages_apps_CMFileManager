package javax.servlet.annotation;

import java.lang.annotation.Annotation;

// Referenced classes of package javax.servlet.annotation:
//            HttpConstraint, HttpMethodConstraint

public interface ServletSecurity
    extends Annotation
{
    /* member class not found */
    class TransportGuarantee {}

    /* member class not found */
    class EmptyRoleSemantic {}


    public abstract HttpConstraint value();

    public abstract HttpMethodConstraint[] httpMethodConstraints();
}