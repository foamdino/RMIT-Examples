/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import vn.edu.rmit.examples.dto.StudentDTO;

/**
 *
 * @author v10532
 */
public interface StudentLocalHome extends EJBLocalHome {

    vn.edu.rmit.examples.StudentLocal findByPrimaryKey(java.lang.Long key)  throws FinderException;
    
    vn.edu.rmit.examples.StudentLocal create(StudentDTO s)  throws CreateException;

    StudentLocal findByName(String n) throws FinderException;

}
