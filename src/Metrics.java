import java.util.concurrent.atomic.AtomicInteger;

public class Metrics {
    AtomicInteger total = new AtomicInteger(0);
    AtomicInteger accepted = new AtomicInteger(0);
    AtomicInteger dropped = new AtomicInteger(0);
}
