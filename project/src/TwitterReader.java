import twitter4j.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tyas on 10/03/2015.
 */

public class TwitterReader {
    List<String> QueryAttitude;
    List<String> searchQuery;

    public void twitterSearch() throws TwitterException, IOException, InterruptedException
    {
        AsyncTwitterFactory factory = new AsyncTwitterFactory();
        AsyncTwitter twitter = factory.getInstance();
        twitter.addListener(new TwitterAdapter()
        {
            TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
            StatusListener listener = new StatusListener()
            {
            @Override
            public void onStatus(Status status)
                {
                System.out.println(status.getUser().getName() + " : " + status.getText());
                }

            @Override
            public void onStallWarning(StallWarning warning)
                {
                System.out.println("Got stall warning:" + warning);
                }

            @Override
            public void onException(Exception ex)
                {
                ex.printStackTrace();
                }
            };
            twitterStream.addListener(listener);
            twitterStream.sample();
        });
    }
}