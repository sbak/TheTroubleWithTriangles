//**************************************************
// Torran Kahleck, Sulgi Daniel Bak & Aaron Gonzales
//
// Class controls panel displaying
//  triangles
//**************************************************

package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class TrianglesPanel extends JPanel 
{
  private static final long serialVersionUID=100L;
  
  public TrianglesPanel()
  {
    
  }
  
  /**
   * Resized triangle panel to match the image panel size
   * @param size
   */
  public void resizeForImage (Dimension size)
  {
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);      
  }
}