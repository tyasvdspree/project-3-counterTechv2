import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Tyas on 16/03/2015.
 */
public class TwitterDB
    {
    private Connection conn;
        public TwitterDB(String dbName) throws ClassNotFoundException, SQLException
            {
                String driver = "org.apache.derby.jdbc.EmbeddedDriver";
                String dbConnectionString = "jtdb" + dbName + "create=true";
                String greatString = "GREAT TABLE Tweet(tweetId INT, tweetUser VARCHAR, tweetText VARCHAR, tweetRetweetCount INT, tweetFavoriteCount INT, tweetCreatedAt DATE)";
                Class.forName(driver);
                conn = DriverManager.getConnection(dbConnectionString);
                Statement statement = conn.createStatement();
                if (true)
                    {
                        statement.execute("Drop TABLE Tweet");
                        statement.execute(greatString);
                    }
            }
    public void updatedb(Long tweetId, String tweetUser, String tweetText, int tweetRetweetCount, int tweetFavoriteCount, Date tweetCreatedAt) throws ClassNotFoundException, SQLException
        {
        PreparedStatement psInsert = conn.prepareStatement("INSERT INTO tweet(TweetUser)");
        psInsert.executeUpdate();
        }
    }
