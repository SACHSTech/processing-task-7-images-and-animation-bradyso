import processing.core.PApplet;
import processing.core.PImage; // Import Image Library

public class Sketch extends PApplet {
  /**
  * Description: Drawing Images and Animation
  * Author: Brady So
  */

  // Image variables
  PImage imgBackground;
  PImage imgSuperman;
  PImage imgBall;

  float fltInverseX;

  float fltSupermanX = 170;
  float fltSupermanY = 350;
  
  float fltBallX = 250;
  float fltBallY = 200;

  float fltBallSpeedX = 5;
  float fltBallSpeedY = 4;

  float fltSupermanSpeedX = 5;
  float fltSupermanSpeedY = 4;

	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    // loading images
    imgBackground = loadImage("Processingbackground.jpeg");
    imgBackground.resize(imgBackground.width / 2,imgBackground.height);

    imgSuperman = loadImage("Supermanflying.png");
    imgSuperman.resize(imgSuperman.width / 3, imgSuperman.height / 3);
    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // drawing background
    background(128);
    image(imgBackground, 0, 0);

    // drawing and animating superman
    image(imgSuperman, fltSupermanX, fltSupermanY);
    fltSupermanX += fltSupermanSpeedX;
    
    // basic edge detection between the walls
    if(fltSupermanX < 20 || fltSupermanX > height){
      fltSupermanSpeedX *= -1; 
    }
    if(fltSupermanX > 20 || fltSupermanX < height){
      fltSupermanSpeedX *= 1;
    }
    if(fltSupermanY < 20 || fltSupermanY > height){
      fltSupermanSpeedY *= -1; 
    }
    if(fltSupermanY > 20 || fltSupermanY < height){
      fltSupermanSpeedY *= 1;
    }

    // Drawing parabolic animation for Superman
    fltSupermanY = ((float) 0.01 * ((float) Math.pow(fltSupermanX - width / (float) 2, (float) 2))) + (float) 100;
    fltInverseX = width - (float) fltSupermanX;
      
    // drawing and animating shape (circle)
    fill(0, 255, 51);
    ellipse(fltBallX, fltBallY, 25, 25);
    
    fltBallX += fltBallSpeedX;
    fltBallY += fltBallSpeedY;

    // basic edge detection between the walls
    if(fltBallX < 20 || fltBallX > width){
      fltBallSpeedX *= -1;
    }
    if(fltBallY < 10 || fltBallY > height){
      fltBallSpeedY *= -1;
    }
  }
}