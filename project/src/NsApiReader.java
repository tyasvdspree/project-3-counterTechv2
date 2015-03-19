/**
 * Created by Tyas on 10/03/2015.
 */
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.json.JSONObject;
import org.json.XML;

public class NsApiReader
{
    public void getNsApiData()
    {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        //todo: add authorisation to the http header.
        WebResource service = client.resource(UriBuilder.fromUri("http://christianlangejan@hotmail.com:APREZyc2aQ0I1viyFEMmhsD6-ciFxzNGXgA5NTLCkj2bq_aITYjxdQ@webservices.ns.nl/ns-api-avt?station=RTD").build());

        String receivedXML = service.accept(MediaType.APPLICATION_XML).get(String.class);
        JSONObject soapDatainJsonObject = XML.toJSONObject(receivedXML);

        System.out.println(receivedXML);
        //System.out.println(soapDatainJsonObject.getJSONObject().getJSONObject().getString());
        //todo: make a NsDB (new class) see twitterDB class for expel.
    }
}
