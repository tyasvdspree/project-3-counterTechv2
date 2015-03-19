import twitter4j.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tyas on 10/03/2015.
 */

public class TwitterReader
    {
    String[] attitude = {":)", ":("};
    String[] searchString = {"RdamCentraal", "RCentraal", "RotterdamCentraal", "Rotterdam+Centraal"};
    List<String> queryAttitude = Arrays.asList(attitude);
    List<String> searchQuery = Arrays.asList(searchString);

    public void twitterSearch() throws TwitterException, IOException, InterruptedException, ClassNotFoundException, SQLException
        {
        for (int i = 0; i < queryAttitude.size(); i++) ;
        {
        for (int j = 0; j < searchQuery.size(); j++) ;
        {
        String queryString = searchQuery.get(j) + "+" + queryAttitude.get(i);
        Twitter twitter = new TwitterFactory().getInstance();
        {
        try
            {
            Query query = new Query(queryString);
            QueryResult result;
            do
                {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets)
                    {
                    TwitterDB twitterDB = new TwitterDB("twitterdb");
                    twitterDB.updatedb(tweet.getId(), tweet.getUser().getScreenName(), tweet.getText(), tweet.getRetweetCount(), tweet.getFavoriteCount(), tweet.getCreatedAt());
                    }
                }
            while ((query = result.nextQuery()) != null);
            System.exit(0);
            } catch (TwitterException te)
            {
            te.printStackTrace();
            System.out.print("failed to search tweets: " + te.getMessage());
            System.exit(-1);
            }
        }
        }
        }
        /*AsyncTwitterFactory factory = new AsyncTwitterFactory();
        AsyncTwitter twitter = factory.getInstance();
        twitter.addListener(new TwitterAdapter()
        {
            TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
            StatusListener listener = new StatusListener()
            {
            @Override
            public void onStatus(Status status)
                {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
                }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice)
                {

                }

            @Override
            public void onTrackLimitationNotice(int i)
                {

                }

            @Override
            public void onScrubGeo(long l, long l1)
                {

                }

            @Override
            public void onStallWarning(StallWarning stallWarning)
                {

                }

            @Override
            public void onException(Exception e)
                {

                }
            };
            twitterStream.addListener(listener);
            twitterStream.sample();
        });
    }*/
        }
    }