
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,income,category,education,occupation;
    String formno;
    signupTwo(String formno){  
        
        this.formno = formno;
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE TWO"); 
        
        JLabel addtionalDetails = new JLabel("Page 2: Additional Details");
        addtionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addtionalDetails.setBounds(290,80,300,30);
        add(addtionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
      
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,120,30);
        add(gender);
       
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationalValues[] = {"Non-Graduation","Graduate","Post Graduation","Doctrate","Others"};
        education = new JComboBox(educationalValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        
        JLabel mariral = new JLabel("Occupation:");
        mariral.setFont(new Font("Raleway", Font.BOLD, 20));
        mariral.setBounds(100,390,200,30);
        add(mariral);
        
        String occupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retire","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        
        JLabel pancard = new JLabel("PAN Number:");
        pancard.setFont(new Font("Raleway", Font.BOLD, 20));
        pancard.setBounds(100,440,200,30);
        add(pancard);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadharcard = new JLabel("Aadhar Number:");
        aadharcard.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharcard.setBounds(100,490,200,30);
        add(aadharcard);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
 
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
 
        ButtonGroup existingaccgroup = new ButtonGroup();
        existingaccgroup.add(eyes);
        existingaccgroup.add(eno);
   
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = this.formno;
        String sreligion = (String) religion.getSelectedItem();
        String scategoty  = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        } else if (sno.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        } else if(eno.isSelected()){
            existingAccount = "NO";
        } 
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
                Conn c = new Conn();
                // '"+formno+"' it take as string values
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"', '"+scategoty+"', '"+sincome+"','"+seducation+"','"+soccupation+"', '"+span+"', '"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                // signupthree obj
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new signupTwo("");
    }
    
}
