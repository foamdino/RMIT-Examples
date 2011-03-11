/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpentitybeanexample;

import javax.ejb.Handle;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import vn.edu.rmit.examples.ProductAdminRemote;
import vn.edu.rmit.examples.ProductAdminRemoteHome;
import vn.edu.rmit.examples.ProductDTO;

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

                InitialContext ic = new InitialContext();
                //Object lookup = ic.lookup("java:comp/env/ejb/ProductAdmin");
                Object lookup = ic.lookup("ejb/ProductAdmin");

                // as it's a remote interface you need to narrow the reference
                ProductAdminRemoteHome home = (ProductAdminRemoteHome) PortableRemoteObject.narrow(lookup, ProductAdminRemoteHome.class);
                ProductAdminRemote admin = home.create();

                ProductDTO p = new ProductDTO();
                p.setName("Test");
                p.setPrice(new Float("49.95"));

                System.out.println(p.getName());

                admin.addProduct(p);

                Handle handle = admin.getHandle();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }

}
