/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.edu.rmit.examples;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author v10532
 */
public interface StatefulBeanRemote extends EJBObject {

    int getVal() throws RemoteException;

    void incrementRemote() throws RemoteException;
    
}
