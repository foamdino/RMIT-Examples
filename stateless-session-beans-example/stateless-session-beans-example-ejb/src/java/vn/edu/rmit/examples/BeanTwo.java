/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author v10532
 */
public class BeanTwo implements SessionBean {
    
    private SessionContext context;
    private BeanOneLocal oneLocal;

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

        try {
            InitialContext ctx = new InitialContext();
            BeanOneLocalHome oneHome = (BeanOneLocalHome)ctx.lookup("java:comp/env/ejb/BeanOneLocalHome");
            oneLocal = oneHome.create();

        } catch(NamingException e) {
            
        } catch(CreateException e) {
            
        }
    }

    public String caller() {
        if(null == oneLocal) {
            return "No BeanOne available!";
        } else {
            return "BeanTwo calling : "+ oneLocal.methodOne();
        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    
}
