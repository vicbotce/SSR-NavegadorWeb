/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navssr;

import com.jfoenix.controls.*;
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
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author sirkora
 */
public class FXMLDocument_MainController implements Initializable {
    String paginaActual;
    String paginaAnterior;
    String paginaSiguiente;
    
    @FXML
    private Label label;
    @FXML
    private JFXButton button;
    @FXML
    private WebView panelWEB;
    @FXML
    private JFXTextField paginaURL;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String pagina = "";
        String paginaURLString = paginaURL.getText();
   
        URL url;
            final WebEngine webEngine = panelWEB.getEngine();
            
            
            String link = "https://" + paginaURLString;
            try{
                recuperarDatos rec = new recuperarDatos(link);
            // Realizando la petición GET
                rec.start();
                webEngine.load(link);
                
            }catch(Exception e){}}
            
            
            /*Document doc = Jsoup.parse(pagina);
            Elements links = doc.select("img");
            for(Element lin : links){
                String href = lin.attr("src");*/
                
                //System.out.println(href);
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    //NO SE USA, NO LO BORRAMOS POR SI HAY ALGUNA DEPENDENCIA EXTRAÑA
    private void volverAtras(ActionEvent event) {
        paginaSiguiente = paginaActual;
        paginaActual = paginaAnterior;
        
    }
    
    //NO SE USA, NO LO BORRAMOS POR SI HAY ALGUNA DEPENDENCIA EXTRAÑA
    private void volerAlante(ActionEvent event) {
        paginaActual = paginaSiguiente;
        paginaSiguiente = "";
  
    
    }

    @FXML
    private void onEnter(ActionEvent event) {
        handleButtonAction(event);
    }
}
