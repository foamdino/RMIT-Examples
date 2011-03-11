/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author v10532
 */
public class ProductAdmin implements SessionBean {
    
    private SessionContext context;

    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;

    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations

    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    // </editor-fold>;

    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.           
    }

    public void addProduct(ProductDTO p) {
        try {
            //lookupProductLocal().create(p.getName(), p.getPrice());
            lookupProductLocal().create(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Long id) {
        try {
            ProductLocal productLocal = lookupProductLocal().findByPrimaryKey(id);
            productLocal.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    private ProductLocalHome lookupProductLocal() {
        try {
            System.out.println("Looking up product local");
            Context c = new InitialContext();
            ProductLocalHome rv = (ProductLocalHome) c.lookup("java:comp/env/ejb/ProductLocalHome");

            System.out.println("product local home: "+ rv);
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")



}
