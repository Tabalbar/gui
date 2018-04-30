import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener

/**
* Panel for SchoolFrame GUI.
* Demonstrates connecting non-gui objects to GUI
*
* @author L.Miller, B.Polo
* @since 4/22/2018
*/

public class SchoolPanel extends JPanel {

  /********* label. ************/
   private JLabel lTitle = new JLabel("Kapiolani School Registration");
   /********* label. ************/
   private JLabel lMsg = new JLabel("                ");
  /******* button. ****************/
   private JButton bDone = new JButton(" Add ");
   /******* button. ****************/
   private JButton bClear = new JButton(" Clear ");
  
  /********* sub-panel. *********/
   private JPanel topSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel centerSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel bottomSubPanel = new JPanel();
  /** we can declare and initialize ActionListener obj. */
   private GUIListener listener = new GUIListener();
  
  /******** text field for user entry. *******/
   private JTextField tfName = new JTextField(25);
  /******** text field for user entry. *******/
   private JTextField tfID = new JTextField(10);
  /********** Choice drop down menu for GPA. **/
   private Choice chGPA = new Choice();
  
  /******** student. *********/
   private Student st;
   /******* capacity of Student array. ****/
   private final int capacity = 10;
   /******** Array of Students. ***************/
   private Student[ ] stArr = new Student[capacity];
   /******** counter for Students. ***************/
   private int count = 0;
   
  /******** String for holding Student for display. */ 
   private String sOut = new String("");
  /****** text are for displaying Student.toString()s. */
   private JTextArea textArea = new JTextArea("");
  /** Make TextArea scrollable. **********************/
   private JScrollPane scroll = new JScrollPane(textArea, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  /**
  * Constructor holds everything.
  */
   public SchoolPanel() {
    
      setLayout(new BorderLayout()); //Border panel layout
      setPreferredSize(new Dimension(400, 500));
      topSubPanel.setBackground(Color.cyan); //north area color
      centerSubPanel.setBackground(Color.yellow); //center area color
      bottomSubPanel.setBackground(Color.white); //bottomSubPanel area color
     
     //adding title to the topSubPanel
      topSubPanel.add(lTitle);
      add("North", topSubPanel); //adding top sub-panel to North
   
     
     //labels initialized
      JLabel lStudentName = new JLabel("Student Name: ");
      JLabel lGPA = new JLabel("Student GPA: ");
      JLabel lID = new JLabel("Student ID: ");
     
     //add choices to the choice dropdown list
      chGPA.add("0.0");
      chGPA.add("0.5");
      chGPA.add("1.0");
      chGPA.add("1.5");
      chGPA.add("2.0");
      chGPA.add("2.5");
      chGPA.add("3.0");
      chGPA.add("3.5");
      chGPA.add("4.0");
      chGPA.add("4.5"); 
     
     //add labels, textFields and choice
      centerSubPanel.add(lStudentName);
      centerSubPanel.add(tfName);
      centerSubPanel.add(lGPA);
      centerSubPanel.add(chGPA);
      centerSubPanel.add(lID);
      centerSubPanel.add(tfID);
     
     //fill array for displaying Students with string of dashes to start
     //and add all to the center
      for (int x = 0; x < capacity; x++) {
         sOut += (x + 1) 
            + "--------------------------------"
            + "-------------------------------------\n";
      
      }
      textArea.setText(sOut);
      textArea.setEditable(false);
      centerSubPanel.add(scroll);  //add scrollPane, textArea inside.        
     
      //add the center sub-panel to Center of main panel
      add("Center", centerSubPanel);
     
     //adding message and buttons to the bottomSubPanel sub-panel
      bottomSubPanel.add(lMsg);
      bottomSubPanel.add(bDone);
      bDone.addActionListener(listener); //add listener to button
      bottomSubPanel.add(bClear);
      bClear.addActionListener(listener); //add listener to button 
     //add bottomSubPanel sub-panel to South area of main panel      
      add("South", bottomSubPanel);     
   } //close StudentPanel constructor
 
 /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
      
      //if "clear" button clicked, run cleaner method  
         if (event.getSource() == bClear) {
            cleaner();
         }
      //if "done" button clicked
      //get the input from the text boxes
      //post error messages if input not valid
      //add student to array if valid
         if (event.getSource()  == bDone) { 
            String sName  = "";
            String sID  = "";
            String sGPA = "";
            int iID = 0;
            double dGPA = 0;
         
            //get stuff in textBoxes
            sName = tfName.getText();
            sID = tfID.getText();
            //get Choice selection
            sGPA = chGPA.getSelectedItem();
         
            try {
                //converting sID to integer
               iID = Integer.parseInt(sID);
              //converting sGPA to double
               dGPA = Double.parseDouble(sGPA);
               try  {
               //Student will throw StudentException if not valid
                  st = new Student(sName, iID, dGPA);
               
                  if (count < capacity) {
                     stArr[count] = st;
                     lMsg.setText("student added");
                     count++;
                  } else {
                     lMsg.setText("array full, cannot add student");
                  } 
               } catch (StudentException e) {
                  lMsg.setText(e.getMessage());
               }
              //redisplay the list of students
               sOut = "";
               for (int j = 0; j < capacity; j++) {
                  if (j < count) {
                     sOut += (j + 1) + " " + stArr[j].toString() + "\n\n";
                  } else {
                     sOut += (j + 1) 
                        + "-------------------------------"
                        + "--------------------------------------\n";
                  }
               }
               textArea.setText(sOut);
            } catch (NumberFormatException nfe) {
               lMsg.setText("Grade or GPA are not a number");
            }           
         } //end for "done" button  
      } //actionEvent method
   
   /**
   * helper method for ActionListener.
   * clears the TextBoxes resets choice
   */
      private void cleaner() {
         chGPA.select("0.0");
         tfName.setText("");
         tfID.setText("");
         lMsg.setText("          ");
      } //end cleaner method
   
   } // end GUIListener private class
 
 
} //end SchoolPanel class
