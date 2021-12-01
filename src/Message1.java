public class Message1 {

    public static synchronized void displayMsg(){

        // safe for multiple threads to read resource

        // multiple threads executing a method not an issue only the resource

        //DEADLOCK HAPPENS WHEN ONE SYNCHRONIZED METHOD CALLS ANOTHER
        //SYNCHRONIZED METHOD

        //THERE ARE NESTED SYNCHRONIZED BLOCKS

        //Race condition
        //thread starvation
        //DEADLOCK
        //Livelock




    }

}
