import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.function.IntFunction;
//import javax.lang.model.util.ElementScanner14;
import javax.swing.*;

public class AddVocable extends JFrame{

    private boolean abgeschlossen;
    private boolean schließen;
    private String englischeVokabel;
    private String deutscheVokabel;

    final private Font mainFont = new Font ("Segoe print", Font.BOLD, 18);
    JTextField tfDetuscheVokabel, tfEnglischeVokabel;
    ImageIcon lbUebernommen;
    boolean HM_OK;
    
    

    public void initialize() throws InterruptedException {
        /************ Form Panel **************/
        JLabel lbDeutscheVokabel = new JLabel ("Deutsche Vokabel");
        lbDeutscheVokabel.setFont(mainFont);

        tfDetuscheVokabel = new JTextField();
        tfDetuscheVokabel.setFont(mainFont);

        JLabel lbEnglischVokabel = new JLabel ("Englische Vokabel");
        lbEnglischVokabel.setFont(mainFont);

        tfEnglischeVokabel = new JTextField();
        tfEnglischeVokabel.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbDeutscheVokabel);
        formPanel.add(tfDetuscheVokabel);
        formPanel.add(lbEnglischVokabel);
        formPanel.add(tfEnglischeVokabel);

        
        

        /************* Buttons Panel ****************/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {      

            @Override
            public void actionPerformed(ActionEvent e) {

                HM_OK = true;      
            }
            
        });

        englischeVokabel= "";
        deutscheVokabel= "";
        
        englischeVokabel = tfDetuscheVokabel.getText();
        deutscheVokabel = tfEnglischeVokabel.getText(); 

        /*************  Bild für uebernahme  **************/
        JLabel picLabel = new JLabel(lbUebernommen);

        abgeschlossen = false;

        if (HM_OK & ((englischeVokabel != null & deutscheVokabel != null) | (englischeVokabel != ("") & deutscheVokabel != (""))) ) {

            lbUebernommen = (new ImageIcon("correct-mark.png"));               
            abgeschlossen = true;
            
        }
        else{

            lbUebernommen = (new ImageIcon("wrong-sign.png")); 
            HM_OK = false;
            

        }

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tfDetuscheVokabel.setText("");
                tfEnglischeVokabel.setText("");
                
                
            }
            
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnOK);
        buttonPanel.add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        //Durch den nächsten Befehl werden die Fenster flexibel groß
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);       
        mainPanel.add(picLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        

        add(mainPanel);
        
        setTitle("Vocabulator");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(rootPaneCheckingEnabled);
        setVisible(true);

        
        schließen = Vocabulator.getSchließen() ;

        if (schließen) {

            dispose();
                           
        }

    }



    public String getDeutscheVokabel() {
        return deutscheVokabel;
        
    }

    public String getEnglischeVokabel() {
        return englischeVokabel;
        
    }

    public boolean getAbgeschlossen() {
        return abgeschlossen;
        
    }

    
        
    



}
