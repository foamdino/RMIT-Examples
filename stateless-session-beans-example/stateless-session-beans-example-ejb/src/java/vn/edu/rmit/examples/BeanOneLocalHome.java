/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author v10532
 */
public interface BeanOneLocalHome extends EJBLocalHome {
    
    vn.edu.rmit.examples.BeanOneLocal create()  throws CreateException;

}
