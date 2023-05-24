package asteroides;
//Librerias necesarias para la clase
import javax.swing.*;
import java.awt.*;

//Clase asteroide
public class Asteroide extends JPanel {
    private int posX;
    private int posY;
    private int desX = 1;
    private int desY = 1;
    private final int ANCHO = 20;
    private final int ALTO= 20;
    private Juego juego;
//Genera que los asteroides aparezcan aleatoreamente en la pantalla
    public Asteroide(Juego juego){
        this.juego=juego;
        this.posX= (int) (Math.random()*390);
        this.posY= (int) (Math.random()*390);
    }
    //metodo que determina los movimientos de los asteroides
    void mover(){
        if(posX + desX > juego.getWidth()- this.ANCHO){
            desX = -1;

        }
        if(posX+desX < 0){
            desX = 1;
        }
        if(posY+desY < 0){
            desY = 1;
        }
        if(posY+desY > juego.getHeight()- this.ALTO){
            desY = -1;
        }

        posX = posX + desX;
        posY = posY + desY;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(posX, posY, ANCHO, ALTO);
    }

    //Determina los aspectos fisicos de los asteroides
    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(posX, posY, ANCHO, ALTO);

     //   g.drawString("PUNTAJE: " + puntaje);
}

}

