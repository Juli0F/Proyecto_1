package com.tienda.loaddata;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTextArea;

/**
 *
 * @author julio
 */
// esta clase carga el archivo desde una que el usuario elige
public class ReadFile {

    private FileReader entrada;
    private String path;

    //el constructor recibe como parametro la ruta del archivo a leer
    //la ruta se la envia el FileChooser
    public ReadFile(String path) {

        this.path = path;
    }

    public void leerArchivo(JTextArea correcto,JTextArea error) {

        try {
            entrada = new FileReader((path));
            BufferedReader bufferEntrada = new BufferedReader(entrada);

            String linea = "";

            int cont = 0;
            
                while (linea != null) {
                    ///----lee una linea y la envia al interprete
                    //-----hasta leer todo el documento de texto
                    linea = bufferEntrada.readLine();
                    cont++;

                    

                    if (linea != null) {
                        Interprete enviarLinea = new Interprete(linea);
                        enviarLinea.splitLinea(linea, cont,correcto,error);
                    }
                }

            
            entrada.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
