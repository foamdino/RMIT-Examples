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
public interface StatefulBeanLocal extends EJBLocalObject {

    public void incrementLocal();
    public int getVal();
    
}
