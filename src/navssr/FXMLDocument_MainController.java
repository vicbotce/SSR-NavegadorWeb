/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navssr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author sirkora
 */
public class FXMLDocument_MainController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private WebView panelWEB;
    @FXML
    private TextField paginaURL;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText("Le has dado a buscar");
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36";
        String url = "https://" + paginaURL.getText();
        try {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("user-agent", userAgent);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            String response = new String();
            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
            in.close();
            System.out.print(response);
            WebEngine webEngine = panelWEB.getEngine();
            
            webEngine.loadContent( response, "text/html");
              

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
