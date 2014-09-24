//**************************************************
// Torran Kahleck, Sulgi Daniel Bak & Aaron Gonzales
//
// Class controls panel displaying images
//**************************************************

package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel 
{
  
  private static final long serialVersionUID=100L;
  private BufferedImage img;
  private Dimension size;
  
  public ImagePanel()
  {
    
  }
  
  /**
   * Sets current image in image panel, selected from combo box
   * @param path - path to image file
   */
  public void setImage(String path)
  {
    try 
    {
      img = ImageIO.read(new File(path));
      size = new Dimension(img.getWidth(null), img.getHeight(null));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
      setSize(size);
      setLayout(null);
    } 
    catch (FileNotFoundException e) 
    {
      System.out.println("FNF Error: " + e.getMessage());
    } 
    catch (IOException e) 
    {
      System.out.println("IO Error: " + e.getMessage());
    } 
  }
  
  /**
   * Getter for size of image panel, used to 
   * match the size of the triangles panel
   * @param size - dimensions of the image panel
   */
  public Dimension getSize()
  {
    return size;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, null);           
  }
}