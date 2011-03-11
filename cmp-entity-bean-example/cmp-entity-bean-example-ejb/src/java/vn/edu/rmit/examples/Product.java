/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author v10532
 */
public abstract class Product implements EntityBean {

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

    //vn.edu.rmit.examples.ProductLocal create(ProductDTO p)  throws CreateException;
    public java.lang.Long ejbCreate(vn.edu.rmit.examples.ProductDTO p) throws javax.ejb.CreateException {
        System.out.println("In ejbCreate!");
        Long id = null;
        try {
            DataSource ds = getProductdb();
            Connection c = ds.getConnection();

            PreparedStatement pstmt = c.prepareStatement("Select max(id) from product");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                long current = rs.getLong(1);
                id = new Long(++current);
            } else {
                //no rows, so 1 is the correct value
                id = new Long(1);
            }

            setId(id);
            setProductName(p.getName());
            setPrice(p.getPrice());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /*public Long ejbCreate(java.lang.Long key)  throws CreateException {
        if (key == null) {
            throw new CreateException("The field \"key\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setPk(key);

        return null;
    }*/

    public void ejbPostCreate(ProductDTO p) {
        // TODO populate relationships here if appropriate
    }

    private DataSource getProductdb() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/productdb");
    }

    public abstract java.lang.Long getId();

    public abstract void setId(java.lang.Long key);

    public abstract java.lang.String getProductName();

    public abstract void setProductName(java.lang.String name);

    public abstract java.lang.Float getPrice();

    public abstract void setPrice(java.lang.Float p);
}
