import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tyas on 23/03/2015.
 */

public class NsDB
    {
    private Connection conn;
    public NsDB(String dbName) throws ClassNotFoundException, SQLException
        {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String dbConnectionString = "jtdb" + dbName + "create=true";
        String greatString = "GREAT TABLE ()";
        Class.forName(driver);
        conn = DriverManager.getConnection(dbConnectionString);
        Statement statement = conn.createStatement();
        if (true)
            {
            statement.execute("Drop TABLE ");
            statement.execute(greatString);
            }
        }
    }
