import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SendPushNotificationSample
{
    public static final String PUSHWOOSH_SERVICE_BASE_URL = "https://cp.pushwoosh.com/json/1.3/";
    private static final String AUTH_TOKEN = "IwJDmoNnCqdQly2XebprJwYg40zi9ar4ywVJFWfuGZ3t161dmAQbByVJyObl9CWpIyuX2G7YyqahdwDVBc9W";
    private static final String APPLICATION_CODE = "32190-AF7B0";
 
    public static void main(String[] args) throws JSONException, MalformedURLException
    {
        String method = "createMessage";
        URL url = new URL(PUSHWOOSH_SERVICE_BASE_URL + method);
 
        JSONArray notificationsArray = new JSONArray()
                .put(new JSONObject().put("send_date", "now")
                                     .put("content", "test")
                                     .put("link", "http://pushwoosh.com/"));
 
        JSONObject requestObject = new JSONObject()
                .put("application", APPLICATION_CODE)
                .put("auth", AUTH_TOKEN)
                .put("notifications", notificationsArray);
 
        JSONObject mainRequest = new JSONObject().put("request", requestObject);
        System.out.println(""+mainRequest.toString());
        JSONObject response = SendServerRequest.sendJSONRequest(url, mainRequest.toString());
 
        System.out.println("Response is: " + response);
    }
}
