import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Grade_Calculator extends JFrame {
 private JTextField[] subject;
 private JTextField totalMark;
 private JTextField avgPercentage;
 private JTextField gradesField;

 public Student_Grade_Calculator() {
  setTitle("Student Grade Calculator");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLayout(new FlowLayout());

  String[] subjectNames = {"Mathematics", "Science", "English", "Social-Science", "Sanskrit"};

  subject = new JTextField[subjectNames.length];
  for (int i = 0; i < subjectNames.length; i++) {
   JLabel label = new JLabel(subjectNames[i] + " (out of 100): ");
   subject[i] = new JTextField(20);
   add(label);
   add(subject[i]);
  }

  JButton calculateButton = new JButton("Calculate Grade");
  calculateButton.addActionListener(new CalculateButtonListener());

  add(calculateButton);

  totalMark = new JTextField(20);
  totalMark.setEditable(false);
  add(new JLabel("Total Marks: "));
  add(totalMark);

  avgPercentage = new JTextField(20);
  avgPercentage.setEditable(false);
  add(new JLabel("Average Percentage: "));
  add(avgPercentage);

  gradesField = new JTextField(20);
  gradesField.setEditable(false);
  add(new JLabel("Grade: "));
  add(gradesField);

  pack();
  setVisible(true);
 }

 private class CalculateButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   double totalMarks = 0;
   for (JTextField field : subject) {
    totalMarks += Double.parseDouble(field.getText());
   }

   double averagePercentage = totalMarks / subject.length;
   String grades = getGrade(averagePercentage);

   totalMark.setText(String.valueOf(totalMarks));
   avgPercentage.setText(String.format("%.2f", averagePercentage) + "%");
   gradesField.setText(grades);
  }
 }

 private String getGrade(double averagePercentage) {
  if (averagePercentage >= 90) {
   return "A";
  } else if (averagePercentage >= 80) {
   return "B";
  } else if (averagePercentage >= 70) {
   return "C";
  } else if (averagePercentage >= 60) {
   return "D";
  } else {
   return "F";
  }
 }

 public static void main(String[] args) {
  new Student_Grade_Calculator();
 }
}

