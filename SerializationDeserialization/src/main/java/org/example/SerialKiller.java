package org.example;


import java.io.*;

class JavaIsOp implements Serializable{
    static{
        System.out.println("Instance is temprary but class is permanent");
    }
    JavaIsOp(){
        System.out.println("I am being objectified.........");
    }
    transient int i=69;
    int j=69;
}

class ReactIsOp implements  Serializable{
    static {
        System.out.println("Instance is temporary but Class is Permnanet");
    }

    ReactIsOp(){
        System.out.println("Being objectified................");
    }

    int i=669;
    int j=669;
}
public class SerialKiller {
    private static final String FILE_NAME="choke_me_daddy.ser";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       JavaIsOp jp=new JavaIsOp();
       ReactIsOp ro=new ReactIsOp();
        System.out.println("Seilization started..................");
        FileOutputStream fos=new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(jp);
        oos.writeObject(ro);
        System.out.println("Serialization completed................");

        System.in.read();

        System.out.println("Deserialization started...................");
        FileInputStream fis=new FileInputStream(FILE_NAME);
        ObjectInputStream ois=new ObjectInputStream(fis);
        JavaIsOp obj= (JavaIsOp) ois.readObject();
        ReactIsOp obj1=(ReactIsOp) ois.readObject();
        System.out.println("Java obj"+obj.i+"--->>"+obj.j);
        System.out.println("React obj"+obj1.i+"------>>"+obj1.j);
        System.out.println("Deserilaization completed..................");

        //For derarlization phase const is not invoked that means no new obj is
        //getting created we are using that same saved object in file


        //even if we delete .class file after saving the obj in file under serilization process,
        //we still can successfully desrialziae it,cos its coming from the saved file and not from
        // .class object code


        //order in which we desrialize must be same as order in which we have seriliazed else
        //expect classcast exception
    }
}
