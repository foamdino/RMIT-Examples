/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package statefulsessionbeanexample;

import javax.ejb.Handle;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import vn.edu.rmit.examples.StatefulBeanRemote;
import vn.edu.rmit.examples.StatefulBeanRemoteHome;
import vn.edu.rmit.examples.StatelessBeanRemote;
import vn.edu.rmit.examples.StatelessBeanRemoteHome;

/**
 *
 * @author v10532
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            Client c = new Client(i);
            c.run();
        }

        System.out.println("*******************************************************************************");
        System.out.println("Can we access the bean through it's Local interface from a command line client?");
        System.out.println("*******************************************************************************");

    }

    private static class Client implements Runnable {

        private int id;

        private String  statefulJndi = "ejb/StatefulBean";

        private String  statelessJndi = "ejb/StatelessBean";

        public Client(int id) {
            this.id = id;
        }

        public void run() {
            try {

                InitialContext ic = new InitialContext();
                Object lookup = ic.lookup(statefulJndi);

                // as it's a remote interface you need to narrow the reference
                StatefulBeanRemoteHome sfHome = (StatefulBeanRemoteHome) PortableRemoteObject.narrow(lookup, StatefulBeanRemoteHome.class);
                // first time round 'create' an EJB (not really create, but request one from object pool)
                StatefulBeanRemote sfr = sfHome.create();

                Handle sfh = sfr.getHandle();

                if(null == sfr) {
                    System.out.println("Don't have handle to StatefulBeanRemote interface!");
                }

                int val = sfr.getVal();

                System.out.println("["+this.id+"] Dealing with a remote interface");
                System.out.println("["+this.id+"] Value starts at: "+ val);

                sfr.incrementRemote();

                System.out.println("["+this.id+"] Initial id of stateful bean: "+ sfr.hashCode());

                // now get a new 'handle' to bean
                sfr = (StatefulBeanRemote)sfh.getEJBObject();
                System.out.println("["+this.id+"] Get new reference to stateful bean from handle");
                System.out.println("["+this.id+"] New id of stateful bean: "+ sfr.hashCode());

                val = sfr.getVal();

                System.out.println("["+this.id+"] Value is now: "+ val);

                statelessJndi = "ejb/StatelessBean";
                lookup = ic.lookup(statelessJndi);

                // as it's a remote interface you need to narrow the reference
                StatelessBeanRemoteHome slHome = (StatelessBeanRemoteHome) PortableRemoteObject.narrow(lookup, StatelessBeanRemoteHome.class);
                StatelessBeanRemote slr = slHome.create();
                Handle slh = slr.getHandle();

                val = slr.getVal();

                System.out.println("\t["+this.id+"] Dealing with a remote interface");
                System.out.println("\t["+this.id+"] Value starts at: "+ val);

                slr.increment();

                System.out.println("\t["+this.id+"] Initial id of stateless bean: "+ slr.hashCode());

                // now get a new 'handle' to bean
                slr = (StatelessBeanRemote)slh.getEJBObject();
                System.out.println("\t["+this.id+"] Get new reference to stateless bean from handle");
                System.out.println("\t["+this.id+"] New id of stateless bean: "+ slr.hashCode());

                val = slr.getVal();

                System.out.println("\t["+this.id+"] Value is now: "+ val);

            } catch (Exception e) {
                System.out.println("Something went wrong!");
                e.printStackTrace();
            }
        }
    }

}
