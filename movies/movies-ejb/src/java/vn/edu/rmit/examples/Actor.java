/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import vn.edu.rmit.examples.dto.ActorDTO;

/**
 *
 * @author v10532
 */
public abstract class Actor implements EntityBean {

    private EntityContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click on the + sign on the left to edit the code.">

    // TODO Consider creating Transfer Object to encapsulate data
    // TODO Review finder methods

    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context = null;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }

    // </editor-fold>
    
    public abstract java.lang.Long getId();

    public abstract void setId(java.lang.Long key);

    public abstract String getName();

    public abstract void setName(String n);

    public abstract Collection getMovies();

    public abstract void setMovies(Collection m);

    public java.lang.Long ejbCreate(ActorDTO a)  throws CreateException {
        
        // TODO add additional validation code, throw CreateException if data is not valid
        try {
            setId(getNewId());
            setName(a.getName());
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
        return null;
    }

    public void ejbPostCreate(ActorDTO a) {
        // TODO populate relationships here if appropriate
    }

    private Long getNewId() throws Exception {
        Connection con = getMoviedb().getConnection();
        PreparedStatement pstmt = con.prepareStatement("select max(id) from actor");
        ResultSet rs = pstmt.executeQuery();
        Long id = new Long(1);
        if(rs.next()) {
            id = new Long(rs.getLong(1) + 1);
        }

        return id;
    }

    private DataSource getMoviedb() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/moviedb");
    }



}
