//**************************************************
// Torran Kahleck, Sulgi Daniel Bak & Aaron Gonzales
//
// Class controls main frame of program
//**************************************************

package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GenomeFrame extends JFrame implements ChangeListener
{
  
  private static final long serialVersionUID=100L;
  public static final Color BACKGROUND = Color.blue; 
  public static final Color IMAGES_BACKGROUND = Color.white; 
  private JLabel triNumLbl;
  private JLabel tribeNumLbl;
  Font labelFont = new Font("Helvetica", Font.BOLD, 12);
  
  private ImagePanel imgPanel;
  private TrianglesPanel triPanel;
  
  /**
   * Class constructor creates subpanels and labels
   */
  public GenomeFrame()
  {
    super("Genetic Algorithm Image Matcher"); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Set up top-left panel with images and combo box
    imgPanel = new ImagePanel();
    imgPanel.setBackground(IMAGES_BACKGROUND);
    imgPanel.setMaximumSize(new Dimension(512, 512));
    imgPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
    
    String[] artStrings = {"\"Mona Lisa\", by da Vinci", "\"Poppies, near Argenteuil\", by Monet", 
                           "\"The Great Wave off Kanagawa\", by Hokusai"}; 
    
    JComboBox artList = new JComboBox(artStrings);
    artList.setSelectedIndex(0);
    artList.setMaximumSize(new Dimension(350, 30));
    artList.setAlignmentX(Component.CENTER_ALIGNMENT);
    artList.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent ev)
      {
        JComboBox cb = (JComboBox)ev.getSource();
        int artIndex = (int)cb.getSelectedIndex();
        updateImagePanel(artIndex);
        
      }
    });
    
    JPanel topLeft = new JPanel();
    topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.Y_AXIS));
    topLeft.setMaximumSize(new Dimension(542, 600));
    topLeft.setBorder(new EmptyBorder(10, 10, 0, 10));
    topLeft.add(artList);
    topLeft.add(imgPanel);

    // Set up top-middle panel with triangle slider and genetic panel
    triNumLbl = new JLabel("Triangle #:");
    triNumLbl.setPreferredSize(new Dimension(80, 15));
    triNumLbl.setForeground(Color.white);
    triNumLbl.setFont(labelFont);
    triNumLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    JSlider triNumSlide = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);
    triNumSlide.addChangeListener(this);
    triNumSlide.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    JPanel triNumSldCtrl = new JPanel();
    triNumSldCtrl.setLayout(new BoxLayout(triNumSldCtrl, BoxLayout.X_AXIS));
    triNumSldCtrl.setMaximumSize(new Dimension(542, 30));
    triNumSldCtrl.setMinimumSize(new Dimension(542, 30));
    triNumSldCtrl.add(triNumLbl);
    triNumSldCtrl.add(triNumSlide);

    triPanel = new TrianglesPanel();
    triPanel.setBackground(IMAGES_BACKGROUND);
    triPanel.setMaximumSize(new Dimension(512, 512));
    triPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
    
    JPanel topMiddle = new JPanel();
    topMiddle.setLayout(new BoxLayout(topMiddle, BoxLayout.Y_AXIS));
    topMiddle.setMaximumSize(new Dimension(542, 600));
    topMiddle.setMinimumSize(new Dimension(542, 600));
    topMiddle.setBorder(new EmptyBorder(10, 10, 0, 10));
    topMiddle.add(triNumSldCtrl);
    topMiddle.add(triPanel);
    
    // set up top-right panel with button controls
    JLabel tribeFitLbl = new JLabel("Tribe Fit Plchldr Lbl");
    tribeFitLbl.setForeground(Color.white);
    tribeFitLbl.setFont(labelFont);
    tribeFitLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    final JLabel btnTestLbl = new JLabel("");
    btnTestLbl.setForeground(Color.white);
    btnTestLbl.setFont(labelFont);
    btnTestLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnTestLbl.setBorder(new EmptyBorder(20, 0, 0, 0));
    
    final JButton startButton = new JButton("Start");
    startButton.setMaximumSize(new Dimension(300, 50));
    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    startButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        String buttonText = (String)ev.getActionCommand();
        if (buttonText.equals("Start")) 
        {
          startButton.setText("Pause");
        } 
        else 
        {
          startButton.setText("Start");
        }
        btnTestLbl.setText("Start/Pause Pressed");
      }
    });
    
    final JButton prevButton = new JButton("Previous");
    prevButton.setMaximumSize(new Dimension(300, 50));
    prevButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    prevButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Previous Pressed");
      }
    });
    
    final JButton nextButton = new JButton("Next");
    nextButton.setMaximumSize(new Dimension(300, 50));
    nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    nextButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Next Pressed");
      }
    });
    
    final JButton resetButton = new JButton("Reset");
    resetButton.setMaximumSize(new Dimension(300, 50));
    resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resetButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Reset Pressed");
      }
    });
    
    final JButton genTableButton = new JButton("Show Table");
    genTableButton.setMaximumSize(new Dimension(300, 50));
    genTableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    genTableButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Show Table Pressed");
      }
    });
    
    final JButton readFileButton = new JButton("Read File");
    readFileButton.setMaximumSize(new Dimension(150, 50));
    readFileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    readFileButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Read File Pressed");
      }
    });
    
    final JButton writeFileButton = new JButton("Write File");
    writeFileButton.setMaximumSize(new Dimension(150, 50));
    writeFileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    writeFileButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Write File Pressed");
      }
    });
    
    final JButton appendFileButton = new JButton("Append Stats File");
    appendFileButton.setMaximumSize(new Dimension(150, 50));
    appendFileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    appendFileButton.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent ev) 
      {
        btnTestLbl.setText("Append Stats Pressed");
      }
    });
    
    JPanel btnControl = new JPanel();
    btnControl.setLayout(new BoxLayout( btnControl, BoxLayout.Y_AXIS));
    btnControl.setMaximumSize(new Dimension(150, 512));
    btnControl.setBorder(new EmptyBorder(10, 0, 0, 0));
    btnControl.add(startButton);
    btnControl.add(prevButton);
    btnControl.add(nextButton);
    btnControl.add(resetButton);
    btnControl.add(genTableButton);
    btnControl.add(readFileButton);
    btnControl.add(writeFileButton);
    btnControl.add(appendFileButton);
    btnControl.add(btnTestLbl);
    
    JPanel topRight = new JPanel();
    topRight.setLayout(new BoxLayout(topRight, BoxLayout.Y_AXIS));
    topRight.setMaximumSize(new Dimension(150, 600));
    topRight.setMinimumSize(new Dimension(150, 600));
    topRight.setBorder(new EmptyBorder(10, 10, 0, 10));
    topRight.add(tribeFitLbl);
    topRight.add(btnControl);
    
    // All top panels added to 'top' panel
    JPanel top = new JPanel();
    top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
    top.setPreferredSize(new Dimension(1320, 600));
    top.add(topLeft);
    top.add(topMiddle);
    top.add(topRight);
    
    // Set up bottom panel with tribe slider
    tribeNumLbl = new JLabel("Tribe #:");
    tribeNumLbl.setPreferredSize(new Dimension(70, 15));
    tribeNumLbl.setForeground(Color.white);
    tribeNumLbl.setFont(labelFont);
    tribeNumLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    JSlider tribeNumSlide = new JSlider(JSlider.HORIZONTAL, 1, 1000, 1);
    tribeNumSlide.addChangeListener(this);
    tribeNumSlide.setAlignmentX(Component.RIGHT_ALIGNMENT);
    
    JPanel bottom = new JPanel();
    bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
    bottom.setPreferredSize(new Dimension(1320, 150));
    bottom.setBorder(new EmptyBorder(10, 10, 0, 10));
    bottom.add(tribeNumLbl);
    bottom.add(tribeNumSlide);
    
    JPanel mainPanel = new JPanel ();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setPreferredSize(new Dimension(1320, 750));
    mainPanel.add(top);
    mainPanel.add(bottom);
    
    updateImagePanel(0);
    
    setBackground(BACKGROUND);
    setResizable(false);
    setContentPane(mainPanel);
    pack();
  }
  
  /**
   * Update the image panel with the selected image from the combo box
   *   also resizes triPanel to match size of image panel
   * @param index - index of combo box chosen, corresponds to specific image
   */
  protected void updateImagePanel(int index)
  {
    
    String path = null;
    String fileName = null;
    
    switch (index)
    {
      case 0: fileName = "mona-lisa-cropted-512x413";
        break;
      case 1: fileName = "poppyfields-512x384";
        break;
      case 2: fileName = "the_great_wave_off_kanagawa-512x352";
        break;
      default: break;
    }
    
    path = "images/" + fileName + ".png";
    imgPanel.setImage(path);
    triPanel.resizeForImage(imgPanel.getSize());
  }
  
  /**
   * Follow changes to the triangle slider
   */
  public void stateChanged(ChangeEvent e) {
      JSlider source = (JSlider)e.getSource();
      int curValue = source.getValue();
      int sliderMax = source.getMaximum();
      
      if (sliderMax <= 200) triNumLbl.setText("Triangle " + curValue + ":");
      else if (sliderMax <= 1000) tribeNumLbl.setText("Tribe " + curValue + ":");
  }
  
}