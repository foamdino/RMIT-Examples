/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package statelesssessionbeansexample;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import vn.edu.rmit.examples.BeanTwoRemote;
import vn.edu.rmit.examples.BeanTwoRemoteHome;

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
            //String jndi = "java:comp/env/ejb/BeanTwo";
            String jndi = "ejb/BeanTwo";
            InitialContext ic = new InitialContext();
            Object lookup = ic.lookup(jndi);

            //System.out.println("lookup: "+lookup);

            BeanTwoRemoteHome home = (BeanTwoRemoteHome) PortableRemoteObject.narrow(lookup, BeanTwoRemoteHome.class);

            //System.out.println("home: "+ home.toString());

            BeanTwoRemote two = home.create();
            if(null == two) {
                System.out.println("Don't have handle to BeanTwo instance!");
            }
            String result = two.caller();
            System.out.println(result);

        } catch(Exception e) {
            System.out.println("Something went very wrong!");
            e.printStackTrace();
        }
    }

}
