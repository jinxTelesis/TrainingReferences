import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Util {

    /**
     * Method used for serialization
     */

    public static void serialzeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                new File(fileName)))) {
            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Method used for deserializing
     */

    // externalizable interface
    // custom serialization and deserialization


    public static Object deSerialzeObject(String fileName) throws ClassNotFoundException{
        Object obj = null;
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File(fileName))
        )){
            obj = ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
