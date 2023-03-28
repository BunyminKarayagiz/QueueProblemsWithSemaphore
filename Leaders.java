public class Leaders implements Runnable {

    private Queue queue;
    private int id;

    public Leaders(Queue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        queue.danceLeader(id);
    }

}
