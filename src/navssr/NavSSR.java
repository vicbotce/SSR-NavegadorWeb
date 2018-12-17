/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navssr;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.NodeList;

/**
 *
 * @author sirkora
 */
public class NavSSR extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument_Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop() {
        File f = new File("../DatosPaginas");
        deleteDirectory(f);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    void deleteDirectory(File fileDel) {
            if(fileDel.isDirectory()){            
            
            if(fileDel.list().length == 0)
                fileDel.delete();
            else{
                
               for (String temp : fileDel.list()) {
                   File fileDelete = new File(fileDel, temp);
                   //recursive delete
                   deleteDirectory(fileDelete);
               }
               //check the directory again, if empty then delete it
               if(fileDel.list().length==0)
                   fileDel.delete();               
            }
        }else{            
            //if file, then delete it
            fileDel.delete();            
        }
    
}
    
  
}

  
 
