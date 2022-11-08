/**
 * 3. Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número
 * entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta
 * clase debe contener un método toString() que retorne el número de carta y el palo. La
 * baraja estará compuesta por un conjunto de cartas, 40 exactamente.
 * Las operaciones que podrá realizar la baraja son:
 * • barajar(): cambia de posición todas las cartas aleatoriamente.
 * • siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya
 * más o se haya llegado al final, se indica al usuario que no hay más cartas.
 * • cartasDisponibles(): indica el número de cartas que aún se puede repartir.
 * • darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número
 * de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos
 * nada, pero debemos indicárselo al usuario.
 * • cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
 * indicárselo al usuario
 * • mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta
 * y luego se llama al método, este no mostrara esa primera carta.
 */
package g8ej3;

import java.util.Scanner;

/**
 * @author Carlos Ferrando
 */
public class Principal {

    public static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        Baraja mazo = new Baraja();
        mazo.barajar();
        menu(mazo);

    }

    private static void menu(Baraja mazo) {
        int option;
        boolean OUT = false;

        while (!OUT) {
            System.out.println("---------------------------------------------------");
            System.out.println("-                      MENU                       -");
            System.out.println("---------------------------------------------------");
            System.out.println("-        1)REPARTIR CARTAS                        -");
            System.out.println("-        2)MOSTRAR CARTAS                         -");
            System.out.println("-        3)MOSTRAR CARTAS MONTON                  -");
            System.out.println("-        4)CARTAS DISPONIBLES                     -");
            System.out.println("-        5)SALIR                                  -");
            System.out.println("---------------------------------------------------");
            System.out.println("");
            System.out.print("Ingresar una opción: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    int cantidad;
                    System.out.print("Ingresar la cantidad de cartas a repartir: ");
                    cantidad = input.nextInt();
                    while (cantidad <= 0) {
                        System.out.println((cantidad == 0) ? "No se pueden repartir " + cantidad + " cartas." : "No se puede repartir una cantidad negativa");
                        System.out.println("Ingresar nuevamente una cantidad");
                        cantidad = input.nextInt();
                    }
                    mazo.darCartas(cantidad);
                    break;
                case 2:
                    mazo.mostrarCartas();
                    break;
                case 3:
                    mazo.cartasMonton();
                    break;
                case 4:
                    System.out.printf("La cantidad de cartas disponibles es: %d\n", mazo.cartasDisponibles());
                    break;
                case 5:
                    System.out.println("Saliendo del juego.......");
                    OUT = true;
                    break;
                default:
                    System.out.println("La opción ingresada no esta en el menu");
            }
        }

    }

}
