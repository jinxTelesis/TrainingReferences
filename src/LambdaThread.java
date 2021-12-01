public class LambdaThread {

    public LambdaThread(String name){
        Runnable r = () ->{

            System.out.println("Entered run method " + Thread.currentThread().getName());

            for(int i = 0; i < 5; i++){
                System.out.println("Lambda thread "+ i);
            }
            System.out.println("Finished with Lambda Thread");
        };

        new Thread(r,name).start();
    }

    public static void main(String[] args){
        LambdaThread thread = new LambdaThread("LambdaThread");

        // New State

        // Runnable state

        // Blocked state

        // Waiting state

        // Timed Waiting

        // Terminated
    }

}
