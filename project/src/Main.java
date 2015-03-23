
/**
 * Created by Tyas on 10/03/2015.
 */

import java.sql.Time;
import java.time.LocalDateTime;

public class Main
{
private static LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) throws Exception
    {
        Boolean run = true;
        TwitterReader twitterReader = new TwitterReader();
        NsApiReader nsApiReader = new NsApiReader();
        while (run == true)
            {
                if (now.getMinute() % 15 == 0)
                    {
                    twitterReader.twitterSearch();
                    nsApiReader.getNsApiData();
                    }
            }
    }
}
