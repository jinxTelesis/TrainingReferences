public class ThreadDemo {

    public static void main(String[] args){


        //LifeCycle of a thread in java
        //New state
        //Runnable state
        //Blocked state
        //Waiting state

        // Creating Java thread as an anonymous class
        InnerThread thread = new InnerThread("MyThread");

    }
}

class InnerThread{
    Thread t;

    //Constructor
    public InnerThread(String name){
        // Anonymous class with run method implemented
        Thread t = new Thread(name){
            @Override
            public void run(){
                System.out.println("Entered run method " +Thread.currentThread().getName());
                for(int i = 0; i < 5; i++){
                    System.out.println(name + i);
                }
                System.out.println("Finished with Inner Thread");
            }
        };

        t.start();
    }
}


