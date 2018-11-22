/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navssr;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String pagina = "";
        String paginaURLString = paginaURL.getText();
        
        System.out.println(paginaURLString);
        label.setText("Hello World!");
        URL url;
        try {
            final WebEngine webEngine = panelWEB.getEngine();
            //webEngine.load("http://www.pccomponentes.es");
            // Creando un objeto URL
            
            url = new URL("http://" + paginaURLString);
 
            // Realizando la petición GET
            URLConnection con = url.openConnection();
 
            // Leyendo el resultado
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
 
            String linea;
            while ((linea = in.readLine()) != null) {
                pagina += linea;
            }
            System.out.println(pagina);
            webEngine.loadContent(pagina);
            
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
 
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
