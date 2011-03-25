/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomany;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import vn.edu.rmit.examples.ManagerRemote;
import vn.edu.rmit.examples.ManagerRemoteHome;
import vn.edu.rmit.examples.dto.DepartmentDTO;
import vn.edu.rmit.examples.dto.StudentDTO;

/**
 *
 * @author v10532
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            new Main().test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test() throws Exception {
        DepartmentDTO d = new DepartmentDTO();
        d.setName("IT");

        StudentDTO s = new StudentDTO();
        s.setName("Kev");
        s.setDepartment(d);

        lookupManagerRemote().addDepartment(d);
        lookupManagerRemote().addStudent(s);
        lookupManagerRemote().addStudentToDepartment(s);

    }

    private ManagerRemote lookupManagerRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:comp/env/Manager");
            ManagerRemoteHome rv = (ManagerRemoteHome) PortableRemoteObject.narrow(remote, ManagerRemoteHome.class);
            return rv.create();
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } catch (CreateException ce) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
            throw new RuntimeException(ce);
        } catch (RemoteException re) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", re);
            throw new RuntimeException(re);
        }
    }


}
