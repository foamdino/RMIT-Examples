/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author v10532
 */
public interface ProductLocalHome extends EJBLocalHome {

    vn.edu.rmit.examples.ProductLocal findByPrimaryKey(java.lang.Long key)  throws FinderException;

    // better so the client code doesn't need to care about the id
    ProductLocal create(ProductDTO p) throws CreateException;

    //public Long ejbCreate(ProductDTO p) throws CreateException;

}
