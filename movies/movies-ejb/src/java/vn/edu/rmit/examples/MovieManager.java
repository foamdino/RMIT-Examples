/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import vn.edu.rmit.examples.dto.ActorDTO;
import vn.edu.rmit.examples.dto.MovieDTO;

/**
 *
 * @author v10532
 */
public class MovieManager implements SessionBean {
    
    private SessionContext context;
    
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

    private ActorLocalHome actorHome;
    private MovieLocalHome movieHome;

    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.

        actorHome = lookupActorLocal();
        movieHome = lookupMovieLocal();
    }

    private ActorLocalHome lookupActorLocal() {
        try {
            Context c = new InitialContext();
            ActorLocalHome rv = (ActorLocalHome) c.lookup("java:comp/env/Actor");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MovieLocalHome lookupMovieLocal() {
        try {
            Context c = new InitialContext();
            MovieLocalHome rv = (MovieLocalHome) c.lookup("java:comp/env/Movie");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void createActor(ActorDTO a) {
        try {
            actorHome.create(a);
        } catch(CreateException e) {
            System.out.println("Unable to create actor");
            e.printStackTrace();
        }
    }

    public void createMovie(MovieDTO m) {
        try {
            movieHome.create(m);
        } catch(CreateException e) {
            System.out.println("Unable to create movie");
            e.printStackTrace();
        }
    }

    public void hireActorForMovie(String actorName, String movieName) {
        try {
            ActorLocal a = actorHome.findByName(actorName);
            MovieLocal m = movieHome.findByName(movieName);
            Collection c = new ArrayList();
            c.add(a);
            m.setActors(c);
        } catch(FinderException e) {
            System.out.println("Unable to find actor/movie");
            e.printStackTrace();
        }
    }


    public void removeActor(String actorName) {
        try {
            ActorLocal a = actorHome.findByName(actorName);
            a.remove();
        } catch(FinderException e) {
            System.out.println("Unable to find actor");
            e.printStackTrace();
        } catch(RemoveException e) {
            System.out.println("Unable to remove actor");
            e.printStackTrace();
        }
    }

    public void removeMovie(String movieName) {
        try {
            MovieLocal m = movieHome.findByName(movieName);
            m.remove();
        } catch(FinderException e) {
            System.out.println("Unable to find movie");
            e.printStackTrace();
        } catch(RemoveException e) {
            System.out.println("Unable to remove movie");
            e.printStackTrace();
        }
    }

    public void fireActorFromMovie(String actorName, String movieName) {
        try {
            ActorLocal a = actorHome.findByName(actorName);
            MovieLocal m = movieHome.findByName(movieName);
            Collection c = new ArrayList();
            Collection current = m.getActors();
            for(Iterator it = current.iterator(); it.hasNext();) {
                ActorLocal currentActor = (ActorLocal)it.next();
                if(!currentActor.getName().equals(a.getName())) {
                    c.add(currentActor);
                }
            }
            m.setActors(c);
        } catch(FinderException e) {
            System.out.println("Unable to find actor/movie");
            e.printStackTrace();
        }
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    
}
