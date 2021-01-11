/*
package Sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

*/
/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: MapElement
 *//*


public abstract class MapElement {

    private final int TILE_SPACE = 20;
     private final int TILE_HEIGHT = 10;
     private final int TILE_WIDTH = 10;

     protected Coordinate position;
     private Image image;
     private ImageView iv;

     public MapElement(int i, int j) {
          this.position = new Coordinate(i, j);
     }

     //public abstract void getState();

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
          this.iv.setImage(image);
     }

     public void innitIv() {
          iv = new ImageView();
     }

     public ImageView getIv() {
          return this.iv;
     }

     public Coordinate getPosition() {
          return this.position;
     }

     public void setPosition(int x, int y) {
          this.position.setX(x);
          this.position.setY(y);
     }

     public boolean hasCollidedLeft(MapElement object) {
          if (((this.position.getX() - TILE_SPACE) == object.getPosition().getX())
               && this.position.getY() == object.position.getY())
          {
               return true;
          } else {
               return false;
          }
     }

     public boolean hasCollidedRight(MapElement object) {
          if (((this.position.getX() + TILE_SPACE) == object.getPosition().getX())
                  && this.position.getY() == object.position.getY())
          {
               return true;
          } else {
               return false;
          }
     }

     public boolean hasCollidedTop(MapElement object) {
          if (((this.position.getY() - TILE_SPACE) == object.getPosition().getY())
                  && this.position.getX() == object.position.getX())
          {
               return true;
          } else {
               return false;
          }
     }

     public boolean hasCollidedBottom(MapElement object) {
          if (((this.position.getY() + TILE_SPACE) == object.getPosition().getY())
                  && this.position.getX() == object.position.getX())
          {
               return true;
          } else {
               return false;
          }
     }

    public abstract char getState();

    public abstract void setState(char state);



    //protected abstract void state();
}
*/
