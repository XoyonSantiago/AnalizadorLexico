/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author Ecordova
 */
public class Archivo {
    private File archivo;
    
    public Archivo() {
        archivo = null;
    }
    
    public void NuevoArchivo(){
        archivo = null;
    }
    
    public String AbrirArchivo(String ruta){
        String texto = "";
        try{
            FileReader file = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(file);
            String linea;          
            while((linea = lectura.readLine()) != null){
                texto += linea + "\n";               
            }          
            lectura.close();
            file.close();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "El archivo no se abrió!", "Error!", 2);
        }
        return texto;
    }
    
    public boolean Nuevo(){
        return archivo == null;
    }
    
    public void GuardarArchivo(String texto, String ruta){
        if(Nuevo()){
            archivo = new File(ruta);
        }
        try{
            FileWriter escritura = new FileWriter(archivo); 
            escritura.write(texto);
            escritura.close();
        }catch(Exception e){
        }
    }
       
}