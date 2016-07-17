
import util.DynamicTimeSeriesChart;
import util.RegexHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingAnalyzer extends DynamicTimeSeriesChart implements Runnable {

    private boolean pinging = false;
    public PingAnalyzer(String title) {
        super(title);
        startPing();
    }

    public void startPing(){
        Thread thread = new Thread(this);
        pinging = true;
        thread.start();
    }

    public void stopPinging(){
        pinging = false;
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (pinging){

            if(System.currentTimeMillis() - lastTime > 1000) {
                String ip = "8.8.8.8";
                String pingResult = "";

                String pingCmd = "ping " + ip;
                try {
                    Runtime r = Runtime.getRuntime();
                    Process p = r.exec(pingCmd);

                    BufferedReader in = new BufferedReader(new
                            InputStreamReader(p.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if(RegexHandler.findAll(inputLine, "time=\\d+ms").size() >0) {
                            this.update(Integer.parseInt(RegexHandler.findAll(RegexHandler.findAll(inputLine, "time=\\d+ms").get(0), "\\d+").get(0)));
                        }
                        pingResult += inputLine;

                    }
                    in.close();

                } catch (IOException e) {
                    System.out.println(e);
                }
                lastTime = System.currentTimeMillis();
            }

        }
    }
}
