package asteroides;
//Librerias necesarias para la clase
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;
//Clase juego
public class Juego extends JPanel {
//Atributos
    private int Puntaje;
    private Nave nave;
    //ArrayList de Asteroides
    private ArrayList<Asteroide> asteroides;
//Constructor de la clase
    public Juego(){
// Inicializar los objetos del juego
        nave = new Nave(this);
        setAsteroides(new ArrayList());
        //añado un asteroide
        anadeAsteroide();
//Añado un keyListener para usar las teclas nesecarias en el programa
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                nave.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
    }


//main principal
    public static void main(String[] args) throws InterruptedException{
    
    Juego juego = new Juego();

//Titelo de la interfaz grafica
    JFrame frame = new JFrame("Juego Nave espacial");
//Estos codigos desarrollan la interfaz grafica
    frame.add(juego);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //determina el tamañano de la pantalla
    frame.setSize(500,500);
    int iteraciones = 0;

    while(true){

        juego.mover();
        juego.repaint();
        // determina la velocidad de los objetos
        Thread.sleep(7);
        iteraciones++;
        if(iteraciones % 500 ==0){
            juego.anadeAsteroide();
        }

    }

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);//necesaria para borrar la pantalla antes de volver a pintar
        nave.paint(g);
        for(Asteroide asteroide: getAsteroides()){
            asteroide.paint(g);
        }
        nave.paint(g);
    }
    // se encarga de mover los elementos del juego
    private void mover(){
        nave.mover();
        for(Asteroide asteroide: getAsteroides()){
            asteroide.mover();
        }



    }
    //metodo que crea un nuevo asteroide
    private void anadeAsteroide() {


        Asteroide asteroide = new Asteroide(this);
        getAsteroides().add(asteroide);

    }

    public ArrayList<Asteroide> getAsteroides() {
        return asteroides;
    }

    public void setAsteroides(ArrayList<Asteroide> asteroides) {
        this.asteroides = asteroides;
    }

    //Arroja el mensaje cuando el juego se acaba
    void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over:(","Game Over :(", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}