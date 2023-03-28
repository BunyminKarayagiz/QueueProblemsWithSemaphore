import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Thread[] leaders = new Thread[8];
        Thread[] followers = new Thread[8];
        Queue queue = new Queue();
        for (int i = 0; i < 8; i++) {
            if (rnd.nextBoolean()) {
                leaders[i] = new Thread(new Leaders(queue, i));
                leaders[i].start();
            } else {
                followers[i] = new Thread(new Followers(queue, i));
                followers[i].start();
            }
        }

    }
}