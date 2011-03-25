/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import vn.edu.rmit.examples.dto.DepartmentDTO;
import vn.edu.rmit.examples.dto.StudentDTO;

/**
 *
 * @author v10532
 */
public interface ManagerRemote extends EJBObject {

    void addStudent(StudentDTO s) throws RemoteException;

    void addDepartment(DepartmentDTO d) throws RemoteException;

    void addStudentToDepartment(StudentDTO s) throws RemoteException;
    
}
