/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import vn.edu.rmit.examples.dto.ActorDTO;
import vn.edu.rmit.examples.dto.MovieDTO;

/**
 *
 * @author v10532
 */
public interface MovieManagerRemote extends EJBObject {

    void createActor(ActorDTO a) throws RemoteException;

    void createMovie(MovieDTO m) throws RemoteException;

    void hireActorForMovie(String actorName, String movieName) throws RemoteException;

    void removeActor(String actorName) throws RemoteException;

    void removeMovie(String movieName) throws RemoteException;

    void fireActorFromMovie(String actorName, String movieName) throws RemoteException;
    
}
