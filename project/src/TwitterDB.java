import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tyas on 16/03/2015.
 */
public class TwitterDB
    {
        public TwitterDB(String dbName) throws ClassNotFoundException, SQLException
            {
                String driver = "org.apache.derby.jdbc.EmbeddedDriver";
                String dbConnectionString = "jtdb" + dbName + "create=true";
                String greatString = "GREAT TABLE Tweet(TweetUser VARCHAR(), TweetRetweet INT(), TweetDate DATE, )";
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(dbConnectionString);
                Statement statement = conn.createStatement();
                if (true)
                    {
                        statement.execute("Drop TABLE Tweet");
                        statement.execute(greatString);

                    }
            }
    }
