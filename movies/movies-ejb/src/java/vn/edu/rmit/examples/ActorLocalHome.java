/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import vn.edu.rmit.examples.dto.ActorDTO;

/**
 *
 * @author v10532
 */
public interface ActorLocalHome extends EJBLocalHome {

    vn.edu.rmit.examples.ActorLocal findByPrimaryKey(java.lang.Long key)  throws FinderException;
    
    vn.edu.rmit.examples.ActorLocal create(ActorDTO a)  throws CreateException;

    ActorLocal findByName(String n) throws FinderException;

}
