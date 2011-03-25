/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import vn.edu.rmit.examples.dto.DepartmentDTO;
import vn.edu.rmit.examples.dto.StudentDTO;

/**
 *
 * @author v10532
 */
public class Manager implements SessionBean {
    
    private SessionContext context;
    private DepartmentLocalHome deptHome;
    private StudentLocalHome studentHome;


    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;

    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations

    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    // </editor-fold>;

    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
        deptHome = lookupDepartmentLocal();
        studentHome = lookupStudentLocal();
    }

    private DepartmentLocalHome lookupDepartmentLocal() {
        try {
            Context c = new InitialContext();
            DepartmentLocalHome rv = (DepartmentLocalHome) c.lookup("java:comp/env/Department");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private StudentLocalHome lookupStudentLocal() {
        try {
            Context c = new InitialContext();
            StudentLocalHome rv = (StudentLocalHome) c.lookup("java:comp/env/Student");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void addStudent(StudentDTO s) {
        try {
            lookupStudentLocal().create(s);
        } catch(CreateException e) {
            e.printStackTrace();
        }
    }

    public void addDepartment(DepartmentDTO d) {
        try {
            lookupDepartmentLocal().create(d);
        } catch(CreateException e) {
            e.printStackTrace();
        }
    }

    public void addStudentToDepartment(StudentDTO s) {
        try {
            StudentLocal student = lookupStudentLocal().findByName(s.getName());
            DepartmentLocal department = lookupDepartmentLocal().findByName(s.getDepartment().getName());
            student.setDepartment(department);

            Collection c = department.getStudents();
            c.add(student);
            department.setStudents(c);

        } catch(FinderException e) {
            e.printStackTrace();
        }
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")




}
