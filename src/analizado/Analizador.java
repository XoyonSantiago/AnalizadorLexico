/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizado;

import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class Analizador {
   public ArrayList<String> secuencias = new ArrayList<String>();
   public ArrayList<String> tokens = new ArrayList<String>();
   public ArrayList<ArrayList<String>> variables = new ArrayList<ArrayList<String>> (3); //0 variable 1 tipo 2 valor
   boolean analex = false;    

    int tamaño, tama;
    public String operadores[]= {"=","+","-","*","/","<",">","++","--","<=",">=","!=",">>","<<"};
    public String otros[]= {"(",")",";","{","}","//",".",",","[","]"};
    public String reservadas[]={"asm","cin","include","cout","auto","bool","break","case",
                                "catch","char","class","const","const_cast","continue","default",
                                "delete","do","double","dynamic_cast","else","enum","explicit",
                                "extern","false","float","for","friend","goto","if","inline","int",
                                "long","mutable","namespace","new","operator","private","protected",
                                "public","register","reinterpret_cast","return","short","signed",
                                "sizeof","static","static_cast","struct","switch","template","this",
                                "throw","true","try","typedef","typeid","typename","union","unsigned",
                                "using","virtual","void","volatile","while"};
    String [] palabras;
    String [] palabrasP;
    public String [][] tblex;
    
    public void lexemas(String textoEditor){
        textoEditor=textoEditor.replaceAll("\n", " ");
        palabras =textoEditor.split(" ");
        tamaño=palabras.length;
    }
    
    // guarda las palabras en el array palabrasP
    public void letrasxletra(String textoEditor){
        String palabra = "", textoArea;
        String [] sal;
        int tamañocad, tamsal;
        char letra,c;
        int contador=0;
        textoArea=textoEditor;
        tamañocad=textoArea.length();
        
        palabrasP= new String[tama];
        
        for (int i=0;i<tamañocad;i++){
            c=textoArea.charAt(i);
            
            if (c==' ' && palabra!="" || c=='\n' && palabra!="" ){
               palabrasP[contador]=palabra;
              palabra="";
              contador++;
            }else if (c!=' '||c!='\n'){
             palabra= palabra + c;
            }
        }

    }
    
    // analiza espacion por espacio
    public void analizar(String codigo){
     String cod = codigo;
        int longitud = cod.length();
        char arreglo[] = new char[longitud];
        arreglo = cod.toCharArray();
        secuencias.clear();
        tokens.clear();
        lexer(cod);
    }    //cargar
              
    // analiza letra por letra para mostrarlo
    public void AnalizarAsig() {
        variables.add(new ArrayList<String>()); // 0 para variable
        variables.add(new ArrayList<String>()); // 1 para tipo
        variables.add(new ArrayList<String>()); // 2 para valor
        String tipo="";
        String bus="";
        int estado = 0, j = 0;
        for (int n = 0; n <= secuencias.size(); n++) {
            switch (estado) {
                case 0:
                    tipo="";
                    
                    if (secuencias.get(n).equals("palabra reservada")) {
                        tipo = tokens.get(n);
                        estado = 1;
                    } else if (secuencias.get(n) == "id") {
                        bus = tokens.get(n);
                        estado = 2;
                    } else {
                        estado = 6;
                    }
                    break;
                case 1:
                    if (secuencias.get(n) == "id") {
                        variables.get(0).add(tokens.get(n));
                        variables.get(1).add(tipo);
                        variables.get(2).add("NULL");
                        estado = 2;
                    } else {
                        estado = 6;
                    }
                    break;
                case 2:
                    if (secuencias.get(n) == "asi") {
                        estado = 3;
                    } else if (secuencias.get(n) == "fin") {
                        estado = 5;
                    } else if (secuencias.get(n) == "coa") {
                        estado = 1;
                    } else {
                        estado = 6;
                    }
                    break;
                case 3:
                    if (secuencias.get(n) == "num" || secuencias.get(n) == "cad" || secuencias.get(n) == "car") {
                        variables.get(2).set((buscar(bus)),tokens.get(n));
                        estado = 4;
                    } else {
                        estado = 6;
                    }
                    break;
                case 4:
                    if (secuencias.get(n) == "fin") {
                        estado = 5;
                    } else if (secuencias.get(n) == "coa") {
                        estado = 1;
                    } else {
                        estado = 6;
                    }
                    break;
                case 5:
                    estado = 0;
                    break;
                case 6:
                    estado = 0;
                    break;
            }
        }

    }
    
    public void lexer(String cod) {

        int i = 0;
        String cad = cod.trim();
        while (i < cad.length()) {
            char t = cad.charAt(i);
            if (Character.isDigit(t)) {
                String num = "";
                num += t;
                int j = i + 1;
                while (Character.isDigit(cad.charAt(j))) {
                    num += cad.charAt(j);
                    j++;
                    if (j == cad.length()) {
                        break;
                    }
                }
                i = j;
                secuencias.add("num");
                tokens.add("( "+num+" )");
               
                continue;
            } //Si es una letra
            else if (Character.isLetter(t)) {
                String palabra = "";
                palabra += t;
                int j = i + 1;
                while (Character.isLetterOrDigit(cad.charAt(j))) {
                    palabra += cad.charAt(j);
                    j++;
                    if (j == cad.length()) {
                        break;
                    }
                }
                i = j;
                if (palabraReservada(palabra)) {
                    
                    secuencias.add("res");
                    tokens.add("( "+palabra+" )");
                } else {
                    if (EsTipoDeDato(palabra)) {
                        
                        secuencias.add("palabra reservada");
                        tokens.add("( "+palabra+" )");
                    } else {
                        secuencias.add("id");
                        tokens.add("( "+palabra+" )");
       
                    }
                }
                continue;
            } //Si no es letra ni digito
            else if (!Character.isLetterOrDigit(t)) {
                if (t == '\"') {
                    String cadena = "";
                    cadena += t;
                    int j = i + 1;
                    while (cad.charAt(j) != '\"') {
                        cadena += cad.charAt(j);
                        j++;
                        if (j == cad.length()) {
                            break;
                        }
                    }
                    i = j;
                    cadena += cad.charAt(j);
                   
                    secuencias.add("cad");
                    tokens.add(cadena);
                }
                if (t == '<') {
                    String cadena = "";
                    cadena += t;
                    int j = i + 1;
                    while ((cad.charAt(j) != '>' && Character.isLetter(cad.charAt(j)) || cad.charAt(j) == '.')) {
                        cadena += cad.charAt(j);
                        j++;
                        if (j == cad.length()) {
                            break;
                        }
                    }

                    if (cad.charAt(j) == '>') {
                        i = j;
                        cadena += cad.charAt(j);
                        
                        secuencias.add("lib");
                        tokens.add(cadena);
                        i++;
                        t = cad.charAt(i);
                    }

                }
                if (t == '\'' && cad.charAt(i + 2) == '\'') {
                    String caracter = "";
                    int j = i + 1;
                    caracter = "\'" + cad.charAt(j) + "\'";
                    i += 2;
                    
                    secuencias.add("car");
                    tokens.add(caracter);
                }
                if (t != '\n' && t != ' ' && t != '\t' && t != '\b' && t != '\r' && t != '\'' && t != '\"') {
                    if (evaluarCaracter(t)) {
                        
                        if (t == ';') {
                            secuencias.add("fin");
                            tokens.add("( "+String.valueOf(t)+" )");
                        } else if (t == ',') {
                            secuencias.add("coa");
                            tokens.add(String.valueOf(t));
                        } else {
                            secuencias.add("");
                            tokens.add(String.valueOf(t));
                        }
                    } else if (evaluarOperadorAritmetico(t)) {
                        secuencias.add("ari");
                        tokens.add("( "+String.valueOf(t)+" )");
                    } else {
                        int r = i + 1;
                        String op;
                        op = t + "" + cad.charAt(r);
                        if (evaluarOp(op)) {
                            
                            secuencias.add("op");
                            tokens.add("( "+op+" )");
                            i++;
                        } else if (op.equals(">>") || op.equals("<<")) {
                            
                            secuencias.add("cou");
                            tokens.add(op);
                            i++;
                        } else if (op.equals("&&") || op.equals("&&")) {
                            
                            secuencias.add("log");
                            tokens.add(op);
                            i++;
                        } else if (evaluarAsig(t)) {
                            
                            secuencias.add("op");
                            tokens.add("( "+String.valueOf(t)+" )");
                        } else if (evaluarOperador(t) != ' ') {
                            
                            secuencias.add("coi");
                            tokens.add(String.valueOf(t));
                        } else {
     
                            break;

                        }
                    }
                } else if(t == '\n'){
                    secuencias.add("salto");
                    tokens.add("salto");
                }
                i++;
                continue;
            }
        }
               analex = true;
    }

    public static boolean evaluarCaracter(char c) {
        if (c == '(') {
            return true;
        } else if (c == ')') {
            return true;
        } else if (c == '#') {
            return true;
        } else if (c == '[') {
            return true;
        } else if (c == ']') {
            return true;
        } else if (c == '{') {
            return true;
        } else if (c == '}') {
            return true;
        } else if (c == ';') {
            return true;
        } else if (c == ',') {
            return true;
        } else if (c == '.') {
            return true;
        } else if (c == '<') {
            return false;
        } else if (c == '>') {
            return false;
        } else if (c == '!') {
            return false;
        } else if (c == '&') {
            return false;
        } else if (c == '|') {
            return false;
        } else {
            return false;
        }
    }

    public static boolean evaluarAsig(char c) {
        if (c == '=') {
            return true;
        } else {
            return false;
        }
    }

    public static char evaluarOperador(char c) {
        char car = ' ';
        if (c == '<') {
            car = '<';
        } else if (c == '>') {
            car = '>';
        } else if (c == '!') {
            car = '!';
        }
        return car;
    }

    public static boolean evaluarOperadorAritmetico(char c) {
        if (c == '+') {
            return true;
        } else if (c == '-') {
            return true;
        } else if (c == '*') {
            return true;
        } else if (c == '/') {
            return true;
        } else if (c == '%') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean evaluarOp(String c) {
        if (c.equals(">=")) {
            return true;
        } else if (c.equals("==")) {
            return true;
        } else if (c.equals("<=")) {
            return true;
        } else if (c.equals("!=")) {
            return true;
        } else if (c.equals("<>")) {
            return true;
        } else if (c.equals(">>")) {
            return false;
        } else if (c.equals("<<")) {
            return false;
        } else {
            return false;
        }
    }

    public static char evaluarSinstaxis(char c) {
        char car = ' ';
        if (c == '(') {
            car = '(';
        } else if (c == ')') {
            car = ')';
        } else if (c == '#') {
            car = '#';
        } else if (c == '[') {
            car = ']';
        } else if (c == '[') {
            car = ']';
        } else if (c == '{') {
            car = '{';
        } else if (c == '}') {
            car = '}';
        } else if (c == ';') {
            car = ';';
        } else if (c == ',') {
            car = ',';
        } else if (c == '.') {
            car = '.';
        }
        return car;
    }

    public static boolean palabraReservada(String cad) {
        if (cad.equalsIgnoreCase("if")) {
            return true;
        } else if (cad.equalsIgnoreCase("else")) {
            return true;
        } else if (cad.equalsIgnoreCase("for")) {
            return true;
        } else if (cad.equalsIgnoreCase("do")) {
            return true;
        } else if (cad.equalsIgnoreCase("switch")) {
            return true;
        } else if (cad.equalsIgnoreCase("case")) {
            return true;
        } else if (cad.equalsIgnoreCase("main")) {
            return true;
        } else if (cad.equalsIgnoreCase("void")) {
            return true;
        } else if (cad.equalsIgnoreCase("public")) {
            return true;
        } else if (cad.equalsIgnoreCase("while")) {
            return true;
        } else if (cad.equalsIgnoreCase("break")) {
            return true;
        } else if (cad.equalsIgnoreCase("continue")) {
            return true;
        } else if (cad.equalsIgnoreCase("include")) {
            return true;
        } else if (cad.equalsIgnoreCase("conio")) {
            return true;
        } else if (cad.equalsIgnoreCase("stdio")) {
            return true;
        } else if (cad.equalsIgnoreCase("iostream")) {
            return true;
        } else if (cad.equalsIgnoreCase("math")) {
            return true;
        } else if (cad.equalsIgnoreCase("cout")) {
            return true;
        } else if (cad.equalsIgnoreCase("cin")) {
            return true;
        } else if (cad.equalsIgnoreCase("true")) {
            return true;
        } else if (cad.equalsIgnoreCase("false")) {
            return true;
        } else if (cad.equalsIgnoreCase("return")) {
            return true;
        } else if (cad.equalsIgnoreCase("using")) {
            return true;
        } else if (cad.equalsIgnoreCase("namespace")) {
            return true;
        } else if (cad.equalsIgnoreCase("std")) {
            return true;
        } else if (cad.equalsIgnoreCase("stdlib")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean EsTipoDeDato(String cad) {

        if (cad.equalsIgnoreCase("int")) {
            return true;
        } else if (cad.equalsIgnoreCase("double")) {
            return true;
        } else if (cad.equalsIgnoreCase("float")) {
            return true;
        } else if (cad.equalsIgnoreCase("char")) {
            return true;
        } else if (cad.equalsIgnoreCase("long")) {
            return true;
        } else if (cad.equalsIgnoreCase("short")) {
            return true;
        } else if (cad.equalsIgnoreCase("boolean")) {
            return true;
        } else if (cad.equalsIgnoreCase("string")) {
            return true;
        } else {
            return false;
        }
    }    
    
    public int buscar(String var){
        int num=0;
        for(int i=0;i<variables.get(0).size();i++){
            if(var.equals(variables.get(0).get(i))){
                num=i;
            }
        }
        return num;
    }
    
}

