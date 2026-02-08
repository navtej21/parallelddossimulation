import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class RequestGenerator {

    public static void generate(BlockingQueue<Request> queue) throws Exception {
        Random rand = new Random();

        // Legitimate users
        for (int i = 0; i < 600; i++) {
            queue.put(new Request("192.168.1." + rand.nextInt(50), false));
        }

        // DDoS attacker
        for (int i = 0; i < 1400; i++) {
            queue.put(new Request("10.0.0.ATTACKER", true));
        }
    }
}
