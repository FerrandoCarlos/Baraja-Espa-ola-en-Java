/**
 *  La baraja estará compuesta por un conjunto de cartas, 40 exactamente.
 * Las operaciones que podrá realizar la baraja son:
 */
package g8ej3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Carlos Ferrando
 */
public class Baraja {

    private List<Carta> cartasMazo;
    private List<Carta> cartasMonton;
    private static final int NUM_CARTAS = 40;

    public Baraja() {
        this.cartasMazo = new ArrayList<>();
        this.cartasMonton = new ArrayList<>();
        crearMazo();

    }

    public Baraja(ArrayList<Carta> cartasMazo, ArrayList<Carta> cartasMonton) {
        this.cartasMazo = cartasMazo;
        this.cartasMonton = cartasMonton;
    }

    //• barajar(): cambia de posición todas las cartas aleatoriamente.
    public void barajar() {
        Collections.shuffle(cartasMazo);
    }

    // • siguienteCarta(): devuelve la siguiente carta que está en la baraja, 
    //cuando no haya más o se haya llegado al final, se indica al usuario que no hay más cartas. 
    public void siguienteCarta() {
        Carta c = null;
        Iterator<Carta> it = cartasMazo.iterator();

        if (cartasMazo.isEmpty()) {
            System.out.println("No hay más cartas en el mazo!!!");
        } else {
            c = cartasMazo.get(0);
            cartasMonton.add(c);
            if (it.next().equals(cartasMazo.get(0))) {
                it.remove();
            }
        }
      
    }

    //• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
    public int cartasDisponibles() {
        return cartasMazo.size();
    }

    //• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número
    //* de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos
    //* nada, pero debemos indicárselo al usuario.
    public void darCartas(int nroCartas) {

        if (nroCartas > NUM_CARTAS) {
            System.out.println("No se pueden dar más cartas de las que tiene el mazo!!!");
        } else {
            if (nroCartas > cartasDisponibles()) {
                System.out.println("No hay suficientes cartas en el mazo!!!");
            } else {
                for (int i = 0; i < nroCartas; i++) {
                    siguienteCarta();
                }
            }
        }

    }

    //• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
    //* indicárselo al usuario
    public void cartasMonton() {
        if (cartasMonton.isEmpty()) {
            System.out.println("Aun no se ha repartido ninguna carta!!!");
        } else {
            System.out.println("-----------CARTAS EN EL MONTON------------");
            System.out.println("------------------------------------------");
            for (Carta aux : cartasMonton) {
                System.out.println(aux);
            }
        }
    }

    // • mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta
    //* y luego se llama al método, este no mostrara esa primera carta.
    public void mostrarCartas() {
        System.out.println("-----------CARTAS EN EL MAZO------------");
        System.out.println("----------------------------------------");
        for (Carta aux : cartasMazo) {
            System.out.println(aux);
        }
    }

    //Se crea un mazo de 40 cartas del 1 al 12 por palo sin los 8 y los 9. Los palos son enum. 
    public void crearMazo() {

        Palo[] palos = Palo.values();//Array de Enums

        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < 12; j++) {
                if (!(j == 7 || j == 8)) {
                    if (j >= 9) {
                        cartasMazo.add(new Carta(palos[i], j + 1));
                    } else {
                        cartasMazo.add(new Carta(palos[i], j + 1));
                    }
                }
            }
        }

    }
}
