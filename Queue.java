import java.util.concurrent.Semaphore;

public class Queue extends Main {
    Semaphore mutex = new Semaphore(1);
    Semaphore leaderQueue = new Semaphore(0);
    Semaphore followerQueue = new Semaphore(0);
    Semaphore rendezvous = new Semaphore(0);

    public int followers = 0;
    public int leaders = 0;

    public void danceLeader(int id) {
        try {
            mutex.acquire();
            System.out.println(id + " leader enter");
            if (followers > 0) {
                followers--;
                followerQueue.release();
            } else {

                leaders++;
                mutex.release();
                leaderQueue.acquire();
            }
            System.out.println(id + ". Dancer Dans Etti---------");
            rendezvous.acquire();
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void danceFollower(int id) {
        try {
            mutex.acquire();
            System.out.println(id + " Follower enter");
            if (leaders > 0) {
                leaders--;
                leaderQueue.release();
            } else {

                followers++;
                mutex.release();
                followerQueue.acquire();
            }
            System.out.println(id + ". Follower Dans Etti---------");
            rendezvous.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}