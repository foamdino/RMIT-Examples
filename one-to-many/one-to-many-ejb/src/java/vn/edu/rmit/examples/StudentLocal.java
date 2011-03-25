/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author v10532
 */
public interface StudentLocal extends EJBLocalObject {

    java.lang.Long getId();

    void setId(Long id);

    String getName();

    void setName(String s);

    DepartmentLocal getDepartment();

    void setDepartment(DepartmentLocal d);

}
