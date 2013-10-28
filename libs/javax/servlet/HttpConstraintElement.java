package javax.servlet;

import javax.servlet.annotation.ServletSecurity;

public class HttpConstraintElement
{

    public HttpConstraintElement()
    {
        this(javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic.PERMIT);
    }

    public HttpConstraintElement(javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic semantic)
    {
        this(semantic, javax.servlet.annotation.ServletSecurity.TransportGuarantee.NONE, new String[0]);
    }

    public transient HttpConstraintElement(javax.servlet.annotation.ServletSecurity.TransportGuarantee guarantee, String roleNames[])
    {
        this(javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic.PERMIT, guarantee, roleNames);
    }

    public transient HttpConstraintElement(javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic semantic, javax.servlet.annotation.ServletSecurity.TransportGuarantee guarantee, String roleNames[])
    {
        if(semantic == javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic.DENY && roleNames.length > 0)
        {
            throw new IllegalArgumentException("Deny semantic with rolesAllowed");
        } else
        {
            emptyRoleSemantic = semantic;
            transportGuarantee = guarantee;
            rolesAllowed = roleNames;
            return;
        }
    }

    public javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic()
    {
        return emptyRoleSemantic;
    }

    public javax.servlet.annotation.ServletSecurity.TransportGuarantee getTransportGuarantee()
    {
        return transportGuarantee;
    }

    public String[] getRolesAllowed()
    {
        return rolesAllowed;
    }

    private javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic emptyRoleSemantic;
    private javax.servlet.annotation.ServletSecurity.TransportGuarantee transportGuarantee;
    private String rolesAllowed[];
}