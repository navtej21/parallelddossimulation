import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FilterTask implements Runnable {

    private BlockingQueue<Request> queue;
    private ConcurrentHashMap<String, AtomicInteger> ipCount;

    private AtomicInteger legitAccepted;
    private AtomicInteger legitDropped;
    private AtomicInteger maliciousDropped;
    private AtomicInteger maliciousPassed;

    public FilterTask(
            BlockingQueue<Request> queue,
            ConcurrentHashMap<String, AtomicInteger> ipCount,
            AtomicInteger legitAccepted,
            AtomicInteger legitDropped,
            AtomicInteger maliciousDropped,
            AtomicInteger maliciousPassed
    ) {
        this.queue = queue;
        this.ipCount = ipCount;
        this.legitAccepted = legitAccepted;
        this.legitDropped = legitDropped;
        this.maliciousDropped = maliciousDropped;
        this.maliciousPassed = maliciousPassed;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request r = queue.poll();
                if (r == null) break;

                ipCount.putIfAbsent(r.ip, new AtomicInteger(0));
                int count = ipCount.get(r.ip).incrementAndGet();

                // 🔥 Dynamic rate limiting
                int threshold = (queue.size() > 1000) ? 30 : 50;

                if (count > threshold) {
                    if (r.malicious) maliciousDropped.incrementAndGet();
                    else legitDropped.incrementAndGet();
                } else {
                    // Simulate server load
                    Thread.sleep(2);

                    if (r.malicious) maliciousPassed.incrementAndGet();
                    else legitAccepted.incrementAndGet();
                }
            }
        } catch (Exception ignored) {}
    }
}
