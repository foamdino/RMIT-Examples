/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.util.Collection;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author v10532
 */
public interface DepartmentLocal extends EJBLocalObject {

    java.lang.Long getId();

    void setId(Long i);

    String getName();

    void setName(String n);

    Collection getStudents();

    void setStudents(Collection c);

}
