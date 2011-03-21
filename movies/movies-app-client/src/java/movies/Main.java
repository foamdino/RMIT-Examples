/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package movies;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import vn.edu.rmit.examples.MovieManagerRemote;
import vn.edu.rmit.examples.MovieManagerRemoteHome;
import vn.edu.rmit.examples.dto.ActorDTO;
import vn.edu.rmit.examples.dto.MovieDTO;

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
        MovieManagerRemote manager = lookupMovieManagerRemote();

        ActorDTO a = new ActorDTO();
        a.setName("Jeff Bridges");

        MovieDTO m = new MovieDTO();
        m.setName("The Big Lebowski");

        manager.createActor(a);
        manager.createMovie(m);
        manager.hireActorForMovie(a.getName(), m.getName());
        manager.fireActorFromMovie(a.getName(), m.getName());
        manager.removeActor(a.getName());
        manager.removeMovie(m.getName());
    }

    private MovieManagerRemote lookupMovieManagerRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("java:comp/env/MovieManager");
            MovieManagerRemoteHome rv = (MovieManagerRemoteHome) PortableRemoteObject.narrow(remote, MovieManagerRemoteHome.class);
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
