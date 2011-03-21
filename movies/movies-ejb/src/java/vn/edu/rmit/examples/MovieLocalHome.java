/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import vn.edu.rmit.examples.dto.MovieDTO;

/**
 *
 * @author v10532
 */
public interface MovieLocalHome extends EJBLocalHome {

    vn.edu.rmit.examples.MovieLocal findByPrimaryKey(java.lang.Long key)  throws FinderException;
    
    vn.edu.rmit.examples.MovieLocal create(MovieDTO m)  throws CreateException;

    MovieLocal findByName(String n) throws FinderException;

}
