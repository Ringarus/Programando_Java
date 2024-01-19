import javax.swing.JOptionPane;

public class Interface {


    public static void main(String[] args) {
      String nome = JOptionPane.showInputDialog("Insira seu nome");  
      JOptionPane.showMessageDialog(null, "Olá "+nome);
      int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira sua idade"));
      JOptionPane.showMessageDialog(null, "Você tem "+idade+" anos.");
      double altura = Double.parseDouble(JOptionPane.showInputDialog("Insira sua altura"));
      JOptionPane.showMessageDialog(null, "Você tem "+altura+" cm de altura.");
    }
    
}