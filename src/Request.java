public class Request {
    String ip;
    boolean malicious;
    long timestamp;

    public Request(String ip, boolean malicious) {
        this.ip = ip;
        this.malicious = malicious;
        this.timestamp = System.currentTimeMillis();
    }
}
