import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws Exception {

        long sequentialTime = runTest(1, "SEQUENTIAL");
        long parallelTime = runTest(4, "PARALLEL");

        System.out.println("\n========== PERFORMANCE COMPARISON ==========");
        System.out.println("Sequential Execution Time : " + sequentialTime + " ms");
        System.out.println("Parallel Execution Time   : " + parallelTime + " ms");

        double speedup = (double) sequentialTime / parallelTime;
        System.out.printf("Speedup Achieved          : %.2fx\n", speedup);

        System.out.println("============================================");
    }

    static long runTest(int threads, String mode) throws Exception {

        BlockingQueue<Request> queue = new LinkedBlockingQueue<>(2000);
        ConcurrentHashMap<String, AtomicInteger> ipCount = new ConcurrentHashMap<>();

        AtomicInteger legitAccepted = new AtomicInteger(0);
        AtomicInteger legitDropped = new AtomicInteger(0);
        AtomicInteger maliciousDropped = new AtomicInteger(0);
        AtomicInteger maliciousPassed = new AtomicInteger(0);

        RequestGenerator.generate(queue);

        long startTime = System.nanoTime();

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executor.execute(new FilterTask(
                    queue,
                    ipCount,
                    legitAccepted,
                    legitDropped,
                    maliciousDropped,
                    maliciousPassed
            ));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.nanoTime();
        long timeTakenMs = (endTime - startTime) / 1_000_000;

        System.out.println("\n--- " + mode + " MODE (" + threads + " THREADS) ---");
        System.out.println("Execution Time        : " + timeTakenMs + " ms");
        System.out.println("Legitimate Accepted   : " + legitAccepted.get());
        System.out.println("Legitimate Dropped    : " + legitDropped.get());
        System.out.println("Malicious Dropped     : " + maliciousDropped.get());
        System.out.println("Malicious Passed      : " + maliciousPassed.get());

        return timeTakenMs;
    }
}
