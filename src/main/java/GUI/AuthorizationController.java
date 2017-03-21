package GUI;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ilyas on 20.03.2017.
 */
public class AuthorizationController {
    private String client_id = "5734337";
    private String scope = "friends,wall";
    private String redirect_uri = "http://oauth.vk.com/blank.html";
    private String display = "page";
    private String response_type = "code";
    public void authoritationVK(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI("https://oauth.vk.com/authorize?client_id=" + client_id +
                    "&display=" + display +
                    "&redirect_uri=" + redirect_uri +
                    "&scope=" + scope +
                    "&response_type=" + response_type +
                    "&v=5.62"));



            TransportClient transportClient = HttpTransportClient.getInstance();
            VkApiClient vk = new VkApiClient(transportClient);

            //необходимо получить code для дальнейшего получения токена
            UserAuthResponse authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                    .execute();

            UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
