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
public interface ProductAdminRemote extends EJBObject {

    void addProduct(ProductDTO p) throws RemoteException;

    void removeProduct(Long id) throws RemoteException;
    
}
