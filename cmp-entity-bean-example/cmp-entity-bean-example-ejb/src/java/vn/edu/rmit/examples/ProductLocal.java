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
public interface ProductLocal extends EJBLocalObject {

    java.lang.Long getId();

    void setId(Long id);

    java.lang.String getProductName();

    void setProductName(String name);

    java.lang.Float getPrice();

    void setPrice(Float price);
}
