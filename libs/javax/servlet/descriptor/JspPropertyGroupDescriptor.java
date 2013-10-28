package javax.servlet.descriptor;

import java.util.Collection;

public interface JspPropertyGroupDescriptor
{

    public abstract Collection getUrlPatterns();

    public abstract String getElIgnored();

    public abstract String getPageEncoding();

    public abstract String getScriptingInvalid();

    public abstract String getIsXml();

    public abstract Collection getIncludePreludes();

    public abstract Collection getIncludeCodas();

    public abstract String getDeferredSyntaxAllowedAsLiteral();

    public abstract String getTrimDirectiveWhitespaces();

    public abstract String getDefaultContentType();

    public abstract String getBuffer();

    public abstract String getErrorOnUndeclaredNamespace();
}