/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navssr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author victorbotti
 */
public class recuperarDatos extends Thread{

    private String webResponse;
    private String webURL;

    public recuperarDatos(String webURL) {
        this.webResponse = recuperarPagina(webURL);
        this.webURL = webURL;
    }

    public void run(){
        try{
            recuperarImagenes();
            recuperarHTML();
            recuperarJavaScript();
            recuperarCSS();
        }catch(Exception e){}
    }
    private String recuperarPagina(String link) {
        URL url;
        String pagina = "";
        try {

            // Creando un objeto URL
            url = new URL(link);

            // Realizando la petición GET
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            // Leyendo el resultado
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            String linea;
            while ((linea = in.readLine()) != null) {
                pagina += linea + "\n";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pagina;
    }

    public void recuperarImagenes() throws MalformedURLException, IOException {
        Document doc = Jsoup.parse(this.webResponse);
        Elements links = doc.select("img");
        String[] pag = webURL.split("\\.");

        try {
            new File("../DatosPaginas/" + pag[1] + "/imagenes").mkdirs();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Element lin : links) {
            
            String href = lin.attr("src");
            
            try {
                
                if (href.substring(0, 2).equals("//")) {
                    href = "https:" + href;
                } else if (href.substring(0, 1).equals("/")) {
                    href = webURL + href;
                }
                String[] linkDiv = href.split("/");
                try {
                    URL urlImagen = new URL(href);
                    HttpsURLConnection con = (HttpsURLConnection) urlImagen.openConnection();
                    con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                    InputStream in = con.getInputStream();
                    Files.copy(in, Paths.get("../DatosPaginas/" + pag[1] + "/imagenes/" + linkDiv[linkDiv.length - 1]));
                } catch (FileAlreadyExistsException e) {
                }

            } catch (Exception e) {
                System.out.println("No se ha indicado ubicacion de la imagen");
            }

        }
    }

    public void recuperarHTML() {
        FileWriter fichero = null;
        String[] pag = this.webURL.split("\\.");
        System.out.println(pag[1]);
        try {

            fichero = new FileWriter("../DatosPaginas/" + pag[1] + "/index.html");

            // Escribimos linea a linea en el fichero
            fichero.write(this.webResponse);

            fichero.close();

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    public void recuperarJavaScript() {
        Document doc = Jsoup.parse(this.webResponse);
        Elements links = doc.select("script");

        for (Element lin : links) {

            String href = lin.attr("src");
            if (href == "") {
                continue;
            }

            if (href.substring(0, 2).equals("//")) {
                href = "https:" + href;
            } else if (href.substring(0, 1).equals("/")) {
                href = webURL + href;
            }

            try {
                // Creando un objeto URL
                URL url = new URL(href);

                // Realizando la petición GET
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                // Leyendo el resultado
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));

                String linea;
                String pagina = "";
                while ((linea = in.readLine()) != null) {
                    pagina += linea + "\n";
                }
                String[] pag = this.webURL.split("\\.");
                String[] linkDiv = href.split("/");
                File fichero = new File("../DatosPaginas/" + pag[1] + "/javascript/" + linkDiv[linkDiv.length - 1]);
                fichero.getParentFile().mkdirs();
                FileWriter write = new FileWriter(fichero);

                // Escribimos linea a linea en el fichero
                write.write(pagina);

                write.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void recuperarCSS() throws MalformedURLException, IOException {
        String href;
        String comprobar;
        Document doc = Jsoup.parse(this.webResponse);
        Elements links = doc.select("link");
        String[] pag = webURL.split("\\.");

        try {

            new File("../DatosPaginas/" + pag[1] + "/css").mkdirs();

        } catch (Exception e) {
            System.out.println("Falla en la carpeta");
        }

        for (Element lin : links) {
            href = lin.attr("href");
            comprobar = lin.attr("rel");
            if (!comprobar.equals("stylesheet")) {
                continue;
            }

            if (href.substring(0, 2).equals("//")) {
                href = "https:" + href;
            } else if (href.substring(0, 1).equals("/")) {
                href = webURL + href;
            }
            String[] linkDiv = href.split("/");
            try {

                URL urlCSS = new URL(href);
                HttpsURLConnection con = (HttpsURLConnection) urlCSS.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                InputStream in = con.getInputStream();
                Files.copy(in, Paths.get("../DatosPaginas/" + pag[1] + "/css/" + linkDiv[linkDiv.length - 1]));

            } catch (MalformedURLException e) {
                e.toString();
            } catch (IOException e) {
                e.toString();
            }

        }

    }
}
