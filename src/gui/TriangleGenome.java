//*****************************************************
// Torran Kahleck, Sulgi Daniel Bak & Aaron Gonzales
//
// Class contains main method, starts GUI
//*****************************************************

package gui;

import javax.swing.SwingUtilities;

public class TriangleGenome 
{
  public static void main(String[] args) 
  {
    SwingUtilities.invokeLater(new Runnable() 
    {
      public void run () 
      {
        GenomeFrame frame = new GenomeFrame();
        frame.setVisible(true);
      }
    });
  }
  
}