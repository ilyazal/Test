import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.Photo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.LogManager;

import static javafx.application.Application.launch;

/**
 * Created by ilyas on 19.03.2017.
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Enter.fxml"));
        Parent root = loader.load();
        Scene scene_login = new Scene(root);
        stage.setScene(scene_login);
        stage.show();

    }

    public static void main(String[] args) throws IOException {

        launch(args);
    }

}
