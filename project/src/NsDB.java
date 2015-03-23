import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tyas on 23/03/2015.
<<<<<<< HEAD
 */
=======
*/
>>>>>>> 7eb6b6b7ab49ee32bf269e0bb5ff400824d26880

public class NsDB
    {
    private Connection conn;
    public NsDB(String dbName) throws ClassNotFoundException, SQLException
        {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String dbConnectionString = "jtdb" + dbName + "create=true";
        String greatString = "GREAT TABLE departure_times(train_id VARCHAR, departure_time DATE, departure_delay INT, Delay_text)";
        Class.forName(driver);
        conn = DriverManager.getConnection(dbConnectionString);
        Statement statement = conn.createStatement();
        if (true)
            {
            statement.execute("Drop TABLE departure_times");
            statement.execute(greatString);
            }
        }
    }
