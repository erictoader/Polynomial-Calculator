import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private final String[] calcModes = {"First", "Second"};

    private final JTextField polinom1 = new JTextField(20);
    private final JTextField polinom2 = new JTextField(20);
    private final JTextField rezultat = new JTextField(20);

    private final JButton multiplyButton = new JButton("Multiply");
    private final JButton divideButton = new JButton("Divide");
    private final JButton addButton = new JButton("Add");
    private final JButton subtractButton = new JButton("Subtract");
    private final JButton differentiateButton = new JButton("Differentiate");
    private final JButton integrateButton = new JButton("Integrate");
    private final JComboBox modeCBox = new JComboBox(calcModes);

    private final JButton clearButton = new JButton("Clear");

    public View(){
        stylize();

        JPanel window = new JPanel();
        window.setBackground(new Color(44,45,47));
        window.setOpaque(true);
        window.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 7;

        JLabel space1 = new JLabel(" ");
        space1.setForeground(new Color(44,45,47));
        space1.setBackground(new Color(44,45,47));
        space1.setOpaque(true);
        window.add(space1, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;

        JLabel spaceCol1 = new JLabel("     ");
        spaceCol1.setForeground(new Color(44,45,47));
        spaceCol1.setBackground(new Color(44,45,47));
        spaceCol1.setOpaque(true);
        window.add(spaceCol1, c);

        // First polynomial:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.ipadx = 20;

        JLabel firstP = new JLabel("First polynomial: ");
        firstP.setForeground(new Color(231,231,231));
        firstP.setBackground(new Color(44,45,47));
        firstP.setOpaque(true);
        window.add(firstP, c);

        // Polynomial 1 text field

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 3;

        window.add(polinom1, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 6;
        c.gridy = 1;
        c.gridwidth = 1;

        JLabel spaceCol2 = new JLabel("  ");
        spaceCol2.setForeground(new Color(44,45,47));
        spaceCol2.setBackground(new Color(44,45,47));
        spaceCol2.setOpaque(true);
        window.add(spaceCol2, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;

        JLabel space2 = new JLabel(" ");
        space2.setForeground(new Color(44,45,47));
        space2.setBackground(new Color(44,45,47));
        space2.setOpaque(true);
        window.add(space2, c);

        //  Second polynomial:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.ipadx = 20;

        JLabel secondP = new JLabel("Second polynomial: ");
        secondP.setForeground(new Color(231,231,231));
        secondP.setBackground(new Color(44,45,47));
        secondP.setOpaque(true);
        window.add(secondP, c);

        // Polynomial 2 text field

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 3;

        window.add(polinom2, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;

        JLabel space3 = new JLabel(" ");
        space3.setForeground(new Color(44,45,47));
        space3.setBackground(new Color(44,45,47));
        space3.setOpaque(true);
        window.add(space3, c);

        // Result :

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 2;

        JLabel resP = new JLabel("Result: ");
        resP.setForeground(new Color(231,231,231));
        resP.setBackground(new Color(44,45,47));
        resP.setOpaque(true);
        window.add(resP, c);

        // Result text field

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 3;
        c.gridheight = 2;
        c.ipady = 40;

        window.add(rezultat, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 7;
        c.gridheight = 2;

        JLabel space4 = new JLabel(" ");
        space4.setForeground(new Color(44,45,47));
        space4.setBackground(new Color(44,45,47));
        space4.setOpaque(true);
        window.add(space4, c);

        // Add button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth = 2;
        c.ipady = 20;

        window.add(addButton, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 9;
        c.ipady = 20;
        c.gridwidth = 1;

        JLabel spaceCol3 = new JLabel(" ");
        spaceCol3.setForeground(new Color(44,45,47));
        spaceCol3.setBackground(new Color(44,45,47));
        spaceCol3.setOpaque(true);
        window.add(spaceCol3, c);

        // Subtract button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 9;
        c.ipady = 20;
        c.gridwidth = 2;

        window.add(subtractButton, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 7;
        c.gridheight = 2;
        c.ipady = 40;

        JLabel space5 = new JLabel(" ");
        space5.setForeground(new Color(44,45,47));
        space5.setBackground(new Color(44,45,47));
        space5.setOpaque(true);
        window.add(space5, c);

        // Multiply button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 12;
        c.gridwidth = 2;
        c.ipady = 20;

        window.add(multiplyButton, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 12;
        c.ipady = 20;
        c.gridwidth = 1;

        JLabel spaceCol4 = new JLabel(" ");
        spaceCol4.setForeground(new Color(44,45,47));
        spaceCol4.setBackground(new Color(44,45,47));
        spaceCol4.setOpaque(true);
        window.add(spaceCol4, c);

        // Divide button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 12;
        c.ipady = 20;
        c.gridwidth = 2;

        window.add(divideButton, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 13;
        c.gridwidth = 7;
        c.gridheight = 2;
        c.ipady = 40;

        JLabel space6 = new JLabel(" ");
        space6.setForeground(new Color(44,45,47));
        space6.setBackground(new Color(44,45,47));
        space6.setOpaque(true);
        window.add(space6, c);

        // Differentiate button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 15;
        c.gridwidth = 2;
        c.ipady = 20;

        window.add(differentiateButton, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 15;
        c.ipady = 20;
        c.gridwidth = 1;

        JLabel spaceCol5 = new JLabel(" ");
        spaceCol5.setForeground(new Color(44,45,47));
        spaceCol5.setBackground(new Color(44,45,47));
        spaceCol5.setOpaque(true);
        window.add(spaceCol5, c);

        // Integrate button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 15;
        c.ipady = 20;
        c.gridwidth = 2;

        window.add(integrateButton, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 16;
        c.gridwidth = 7;
        c.gridheight = 2;
        c.ipady = 40;

        JLabel space7 = new JLabel(" ");
        space7.setForeground(new Color(44,45,47));
        space7.setBackground(new Color(44,45,47));
        space7.setOpaque(true);
        window.add(space7, c);

        // Clear button

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 18;
        c.gridwidth = 2;
        c.ipady = 20;

        window.add(clearButton, c);

        // col space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 3;
        c.gridy = 18;
        c.ipady = 20;
        c.gridwidth = 1;

        JLabel spaceCol6 = new JLabel(" ");
        spaceCol6.setForeground(new Color(44,45,47));
        spaceCol6.setBackground(new Color(44,45,47));
        spaceCol6.setOpaque(true);
        window.add(spaceCol6, c);

        // Use for differentiate/ integrate:

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 18;
        c.ipady = 20;
        c.gridwidth = 1;
        c.ipadx = -10;

        JLabel use = new JLabel("Use for differentiate/ integrate: ");
        use.setFont(new Font("Helvetica", Font.PLAIN, 10));
        use.setForeground(new Color(231,231,231));
        use.setBackground(new Color(44,45,47));
        use.setOpaque(true);
        window.add(use, c);

        // CheckBox

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 5;
        c.gridy = 18;
        c.ipady = 20;
        c.ipadx = -15;
        c.gridwidth = 1;

        window.add(modeCBox, c);

        // Space

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 19;
        c.gridwidth = 7;
        c.gridheight = 2;
        c.ipady = 40;
        c.ipadx = 0;

        JLabel space8 = new JLabel(" ");
        space8.setForeground(new Color(44,45,47));
        space8.setBackground(new Color(44,45,47));
        space8.setOpaque(true);
        window.add(space8, c);

        ///

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 20;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.ipady = 20;
        c.ipadx = 0;

        JLabel ver = new JLabel("Polynomial Calculator v1.2 by Eric Toader");
        ver.setFont(new Font("Helvetica", Font.PLAIN, 8));
        ver.setForeground(new Color(231,231,231));
        ver.setBackground(new Color(44,45,47));
        ver.setOpaque(true);
        window.add(ver, c);

        ///

        this.setContentPane(window);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        if(System.getProperty("os.name", "generic").toLowerCase().contains("mac")) {
            rootPane.putClientProperty("apple.awt.fullWindowContent", true);
            rootPane.putClientProperty("apple.awt.transparentTitleBar", true);
            this.setTitle("");
        }
        else {
            this.setTitle("Polynomial Calculator");
        }

    }

    public void stylize(){
        polinom1.setEditable(true);
        polinom2.setEditable(true);

        rezultat.setEditable(false);

        addButton.setBackground(new Color(255, 158,11));
        addButton.setForeground(new Color(255,240,223));
        addButton.setOpaque(true);
        addButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        addButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        subtractButton.setBackground(new Color(255, 158,11));
        subtractButton.setForeground(new Color(255,240,223));
        subtractButton.setOpaque(true);
        subtractButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        subtractButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        multiplyButton.setBackground(new Color(255, 158,11));
        multiplyButton.setForeground(new Color(255,240,223));
        multiplyButton.setOpaque(true);
        multiplyButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        multiplyButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        divideButton.setBackground(new Color(255, 158,11));
        divideButton.setForeground(new Color(255,240,223));
        divideButton.setOpaque(true);
        divideButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        divideButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        differentiateButton.setBackground(new Color(255, 158,11));
        differentiateButton.setForeground(new Color(255,240,223));
        differentiateButton.setOpaque(true);
        differentiateButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        differentiateButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        integrateButton.setBackground(new Color(255, 158,11));
        integrateButton.setForeground(new Color(255,240,223));
        integrateButton.setOpaque(true);
        integrateButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        integrateButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        clearButton.setBackground(new Color(59,61,64));
        clearButton.setForeground(new Color(231,231,231));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Helvetica", Font.PLAIN, 18));
        clearButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(255,255,255),
                new Color(150,150,150), new Color(10,10,10), new Color(70,70,70)));

        polinom1.setBackground(new Color(59,61,64));
        polinom1.setForeground(new Color(231,231,231));
        polinom1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                new Color(20,20,20), new Color(20,20,20)));

        polinom2.setBackground(new Color(59,61,64));
        polinom2.setForeground(new Color(231,231,231));
        polinom2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                new Color(20,20,20), new Color(20,20,20)));

        rezultat.setBackground(new Color(59,61,64));
        rezultat.setForeground(new Color(231,231,231));
        rezultat.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
                new Color(20,20,20), new Color(20,20,20)));

        modeCBox.setFont(new Font("Helvetica", Font.PLAIN, 10));
    }

    public void reset(){
        rezultat.setText("");
        polinom1.setText("");
        polinom2.setText("");
    }

    public String getPolinom1(){
        return polinom1.getText();
    }

    public String getPolinom2(){
        return polinom2.getText();
    }

    public void setRezultat(String rezultat){
        this.rezultat.setText(rezultat);
    }

    public void addAdditionListener(ActionListener add){
        addButton.addActionListener(add);
    }

    public void addSubtractionListener(ActionListener sub){
        subtractButton.addActionListener(sub);
    }

    public void addMultiplicationListener(ActionListener mul){
        multiplyButton.addActionListener(mul);
    }

    public void addDivisionListener(ActionListener div){
        divideButton.addActionListener(div);
    }

    public void addDifferentiateListener(ActionListener dif){
        differentiateButton.addActionListener(dif);
    }

    public void addIntegrateListener(ActionListener integ){
        integrateButton.addActionListener(integ);
    }

    public void addClearListener(ActionListener clr){
        clearButton.addActionListener(clr);
    }

    public void addPolinomField1(ActionListener pf1){
        polinom1.addActionListener(pf1);
    }

    public void addPolinomField2(ActionListener pf2){
        polinom2.addActionListener(pf2);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(this,message);
    }

    public JTextField getPolinomField1() {
        return polinom1;
    }

    public JTextField getPolinomField2(){
        return polinom2;
    }

    public String getModeCBoxValue(){
        return (String)modeCBox.getSelectedItem();
    }
}
