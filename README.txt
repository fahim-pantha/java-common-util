Sample setup
===============
* Create a MBean interface with getter and setter for attributes
* Implement the interface
* Register the MBean to the MBean server
* Open jconsole
* Checkout the Mbean attributes using jconsole 
* With a view to connect to checkout remotely, Please use the following JVM options while launching the project 
-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9010 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=192.168.59.99
* In the Jconsole use the following to connect:
service:jmx:rmi:///jndi/rmi://192.168.59.99:9010/jmxrmi
