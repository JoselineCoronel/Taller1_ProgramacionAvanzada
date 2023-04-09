import edu.princeton.cs.stdlib.StdDraw;
import java.awt.*;

/**
 * Despliega en pantalla una version simplificada de "Mystify"
 */
public class SalvaPantalla {

    //Declaracion e inicializacion de las variables

    //Rango de dibujo
    static double min = -1.0;
    static double max = 1.0;

    //Par ordenado
    static double x = min + (max - min) * Math.random();
    static double y = min + (max - min) * Math.random();
    static double x1 = min + (max - min) * Math.random();
    static double y1 = min + (max - min) * Math.random();

    //Velocidad de movimiento al azar
    static double velocidad = Math.random() * 0.07;

    //Velocidad inicial por cada componente del par ordenado
    static double vx = velocidad;
    static double vy = velocidad;
    static double vx1 = velocidad;
    static double vy1 = velocidad;

    //Estableciendo colores
    static Color c1 = new Color(255,55,100);
    static Color c2 = new Color(231,130,128);
    static Color c3 = new Color(170,19,56);
    static Color c4 = new Color(231,58,150);
    static Color c5 = new Color(255,0,127);
    static Color c6 = new Color(99,19,56);
    static Color backGround = new Color(255,238,236);

    //Lista de colores
    static Color[] colores = {c1, c2, c3, c4, c5, c6};


    /**
     *
     * @param args
     * Invoca metodos
     */
    public static void main(String[] args) {

        //Llama a otros subprogramas
        lienzo();
        movimiento();
    }


    /**
     * Se crea el lienzo de dibujo
     */
    public static void lienzo() {

            //Definicion de la escala del lienzo de dibujo
            StdDraw.setXscale(min, max);
            StdDraw.setYscale(min, max);

            //Evitar el parpadeo de la pantalla
            StdDraw.enableDoubleBuffering();
        }


    /**
     * Se crean las lineas y el comportamiento de ellas
     */
    public static void movimiento(){

        //Loop infinito
        while (true) {

            //Colision
            if (Math.abs(x + vx) > 1.0) {
                vx = -vx;
            }
            if (Math.abs(y + vy) > 1.0) {
                vy = -vy;
            }
            if (Math.abs(x1 + vx) > 1.0) {
                vx1 = -vx1;
            }
            if (Math.abs(y1 + vy) > 1.0) {
                vy1 = -vy1;
            }
            //Limpiar el fondo
            StdDraw.clear();

            //Color del fondo
            StdDraw.setPenColor(backGround);
            StdDraw.filledSquare(-1,1,2);
            StdDraw.show();

            //Loop para crear 6 lineas
            for (int i = 0; i < 6; i++) {

                //Seleccion del color del lapiz de entre los colores de la lista
                StdDraw.setPenColor(colores[i]);

                //Dibujar la linea
                StdDraw.line(x, y, x1, y1);

                //Mostrar pantalla
                StdDraw.show();

                //Actualizacion de posicion
                x += vx;
                y += vy;
                x1 += vx1;
                y1 += vy1;
            }

            //Esperar
            StdDraw.pause(50);
        }
    }
}


