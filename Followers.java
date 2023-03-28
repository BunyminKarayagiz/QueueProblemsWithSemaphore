public class Followers implements Runnable {

    private Queue queue;
    private int id;

    public Followers(Queue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        queue.danceFollower(id);
    }

}
