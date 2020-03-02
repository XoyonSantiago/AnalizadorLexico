import java.util.Scanner;
public class prueba {
public static void main(String[] args) {
Scanner reader = new Scanner(System.in);
int num1 , multi , i ; 
System.out.println("programa para las tablas de multiplicar del 1 al 10"); 
System.out.println("ingresa el numero que desea saber la tabla"); 
num1= reader.nextInt(); 
for ( i = 0 ; i <= 10 ; i ++) { 
multi = i * num1 ; 
System.out.println("el resultado es: "); 
System.out.println(multi); 
} 
} 
}
