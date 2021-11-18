/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordaleatorio;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author albertogarzon
 */
/*
 - 4 numeros (0 a 9) distintos
 - La suma de los digitos 1 y 4 es impar
 - La multiplicacion de los digitos 2 y 3 es par
 - Letra aleatoria entre (F - X) en mayuscula
 */
public class Contraseña {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        //Variables para generar numeros aleatorios y la letra aleatoria
        int numero1, numero2, numero3, numero4;
        char letra;

        //Variable para generar un numero aleatorio y pasarlo posteriormente a char
        int caracterUnicode;
        boolean seguir;
        int sumaImpar;
        int muliplicacionPar;

        JOptionPane.showMessageDialog(null, "Bienvenido a generacion de contraseñas aleatorias");

        do {

            //Variable booleana asignandole valor true para que no finalize el bucle de forma abrupta tras otra ejecución
            seguir = true;

            do {
                JOptionPane.showMessageDialog(null, "Se generaran cuatro numeros aleatorios (0 a 9)");

                //Se generan los numeros aleatorios entre 0 a 9
                numero1 = aleatorio.nextInt(9) + 1;

                numero2 = aleatorio.nextInt(9) + 1;

                numero3 = aleatorio.nextInt(9) + 1;

                numero4 = aleatorio.nextInt(9) + 1;

                //Si uno de los numeros coincide con otro de los tres restantes se volvera a generar dichos numeros
                if (numero1 == numero2 || numero1 == numero3 || numero1 == numero4 || numero2 == numero3
                        || numero2 == numero4 || numero3 == numero4) {

                    JOptionPane.showMessageDialog(null, "Numeros repetidos, se volveran a generar los numeros");
                }

            } while (numero1 == numero2 || numero1 == numero3 || numero1 == numero4 || numero2 == numero3
                    || numero2 == numero4 || numero3 == numero4);

            JOptionPane.showMessageDialog(null, "los numeros generados son: " + "numero1: (" + numero1
                    + ") - numero2: (" + numero2 + ") - numero3: (" + numero3 + ") - numero4: (" + numero4 + ")");

            //Se genera un numero aleatorio del 70 al 80 que en caracter unicode seria de la F a la X 
            caracterUnicode = aleatorio.nextInt(88 - 70 + 1) + 70;

            //Se realiza un casting implicito para pasar el caracter unicode a char
            letra = (char) caracterUnicode;

            //Se pasa la letra obtenida a mayuscula
            JOptionPane.showMessageDialog(null, "La letra aleatoria es: " + Character.toUpperCase(letra));

            //Se realizan las sumas de los numeros
            sumaImpar = numero1 + numero4;
            muliplicacionPar = numero2 * numero3;

            //Se determina si la suma es par o impar y si la contraseña es valida segun las indicaciones del programa
            if (!(sumaImpar % 2 == 0)) {

                JOptionPane.showMessageDialog(null, "La suma de numero1 y numero4 es impar");

            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no es valida, la suma de numero1 y numero4 es par");
                JOptionPane.showMessageDialog(null, "Se volvera a generar una contraseña aleatoria");
                seguir = false;
                //Uso la sentencia continue. Ya que la suma de los numeros 1 y 4 es par, la contraseña no es valida y
                //no es necesario realizar mas comprobaciones. Por lo que llegaria al while y repetiria el bucle
                continue;
            }

            if (muliplicacionPar % 2 == 0) {

                JOptionPane.showMessageDialog(null, "La multiplicación de numero2 y numero3 es par");
                JOptionPane.showMessageDialog(null, "La contraseña es valida");

            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no es valida, la multiplicación de numero2 y numero3 es impar");
                JOptionPane.showMessageDialog(null, "Se volvera a generar una contraseña aleatoria");
                seguir = false;
            }

        } while (!seguir);

        //Se muestra la contraseña concatenando todos los numeros y la letra generada
        JOptionPane.showMessageDialog(null, "Su contraseña es: " + numero1
                + numero2 + numero3 + numero4 + letra);

    }

}
