/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import vn.edu.rmit.examples.dto.DepartmentDTO;

/**
 *
 * @author v10532
 */
public interface DepartmentLocalHome extends EJBLocalHome {

    vn.edu.rmit.examples.DepartmentLocal findByPrimaryKey(java.lang.Long key)  throws FinderException;
    
    vn.edu.rmit.examples.DepartmentLocal create(DepartmentDTO d)  throws CreateException;

    DepartmentLocal findByName(String n) throws FinderException;

}
