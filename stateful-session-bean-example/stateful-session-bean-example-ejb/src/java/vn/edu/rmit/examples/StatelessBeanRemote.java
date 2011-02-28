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
public interface StatelessBeanRemote extends EJBObject {

    int getVal() throws RemoteException;

    void increment() throws RemoteException;
    
}
