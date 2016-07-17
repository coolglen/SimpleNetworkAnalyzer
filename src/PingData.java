import org.jfree.data.time.Second;

public class PingData {

    public Second second;
    public int ping;

    public PingData(int ping) {
        this.second = new Second();
        this.ping = ping;
    }
}
