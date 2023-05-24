package asteroides;
//Librerias necesarias para la clase
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
//Clase para desarrollar el objeto Nave
public class Nave extends JPanel {
    //Atributos que determinan la posicion y desplazamiento de la nave
    private int posX;
    private int posY;
    //private int desX = 1;
    //private int desY = 1;

    private int desX ;
    private int desY ;

    //tamaño de la nave
    private final int ANCHO = 10;
    private final int ALTO= 10;
    private Juego juego;


    //Posicion inicial en el juego
    public Nave(Juego juego){
        this.juego=juego;
        this.posX= 195;
        this.posY= 195;
    }

    //comandos para poder mover la nave
    void mover(){
        if(posX + desX > juego.getWidth()- this.ANCHO){
            desX = 0;

        }
        if(posX+desX < 0){
            desX = 0;
        }
        if(posY+desY < 0){
            desY = 0;
        }
        if(posY+desY > juego.getHeight()- this.ALTO){
            desY = 0;
        }
        if(choque()){
            juego.gameOver();
        }
        posX= posX+desX;
        posY= posY+desY;
    }
//Metodo en donde el juego para si un asteroide choca con la nave
    private boolean choque() {
        for(Asteroide asteroide:juego.getAsteroides()){
            if(asteroide.getBounds().intersects(this.getBounds())){
                return true;
            }
        }
        return false;
    }
//Limites
    @Override
    public Rectangle getBounds() {
        return new Rectangle(posX, posY, ANCHO, ALTO);
    }
//Aspectos fisicos de la nave
    @Override
    public void paint(Graphics g){

        g.setColor(Color.red);
        g.fillRect(posX, posY, ANCHO, ALTO);
    }
//se desarrolla el metodo en donde se le asigna a cada tecla un movimiento en la pantalla de la nave
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            desX =-1;
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
            desX = 1;
        }
        if(e.getKeyCode()== KeyEvent.VK_UP) {
            desY = -1;
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN) {
            desY = 1;
        }
    }
}
