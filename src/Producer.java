import java.util.List;

public class Producer implements Runnable{
    List<Integer> sharedListObj;
    Producer(List<Integer> sharedListObj){
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run(){
        int i = 0;
        while(true){
            synchronized (sharedListObj){
                // while condition as mandated to avoid spurious wakeup
                while(sharedListObj.size() >=1){
                    try{
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Putting value in the list
                System.out.println("Adding to queue - " + Thread.currentThread().getName() + "");
                sharedListObj.add(i);
                sharedListObj.notify();

                if(i > 4) break;
            }
        }
    }

}

class Consumer implements Runnable{
    List<Integer> sharedListObj;
    Consumer(List<Integer> sharedListObj){
        this.sharedListObj = sharedListObj;
    }

    @Override
    public void run(){
        while (true) {
            synchronized (sharedListObj) {
                while (sharedListObj.size() < 1) {
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                // Getting value from the list
                System.out.println("Getting from queue " + Thread.currentThread().getName() + " " + sharedListObj.get(0));
                // To get out of while(true) loop
                if (sharedListObj.get(0) == 5) break;
                sharedListObj.remove(0);
                sharedListObj.notify();
            }
        }
    }
}


