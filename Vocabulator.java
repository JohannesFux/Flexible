



import java.io.IOException; // Datei erzeugung
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
//import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane; //Für die Ein-und Ausgabe des Fensters

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File; // Datei erzeugung
import java.io.FileInputStream;
//import java.io.FileOutputStream; //zum beschrieben der Datei
import java.io.FileWriter;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.nio.charset.Charset;

public class Vocabulator {

    public static void main(String[] args)throws IOException, InterruptedException { 


        boolean abbruch = false;
        boolean abbruch_DE = false;
        boolean abbruch_EN = false;


   
        while (!abbruch) {
        
        
            //ArrayList<String> vokabelDatenbank = new ArrayList<>();
           // Charset charset = Charset.forName("UTF-8");
           // Path myText_path = Paths.get("Vokabeln.txt");
            int anzahlWörter = 1;
            String linie;

            //Erstellen eines drop-down Menüs
            //Auswahl im Fenster
            String[] options = {"Neue Vokabel", "DE Übungen starten", "EN Übungen starten", "Zufällige Übung starten", "Programm beenden"};
            //Fenster Eigenschaften
            String auswahl = (String)JOptionPane.showInputDialog(null,"Was möchten Sie gerne tun?", 
                "Vocabulator",JOptionPane.QUESTION_MESSAGE,null, options, 2);



            //#############################################################################
            //Auswahl - neue Vokabel hinzufügen

            if (auswahl.equals(options[0])) {

                String eingabeDeutsch = "";
                String eingabeEnglisch = "";
                boolean abbruch_AddVokabel =false;

                if(!abbruch_AddVokabel) {

                    AddVocable myFrameAdd = new AddVocable();
                    myFrameAdd.initialize();

                    while (!abbruch_AddVokabel) {

                        //Aus dem JFrame laden 

                        eingabeDeutsch = myFrameAdd.deutscheVokabel;
                        eingabeEnglisch = myFrameAdd.englischeVokabel;
                        abbruch_AddVokabel = myFrameAdd.ende;
                        
                    }

                   
    
                }
        

                BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Vokabeln.txt")));

                linie = br.readLine();
                while (linie!=null) {
                    if ("".equals(linie)) {
                        anzahlWörter ++;

                    }
                    linie = br.readLine();
                    
                }
                br.close();
                System.out.println(anzahlWörter);

                VokabelStructur[] vokabelDatenbank = new VokabelStructur[anzahlWörter] ;


                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Vokabeln.txt")));       

                for (int i=0; i<anzahlWörter; i++) {

                    linie = br2.readLine();
                   
                    String EinlesenDeutscheVokabel = linie;
                    linie = br2.readLine();
                   
                    String EinlesenEnglischeVokabel = linie;
                    linie = br2.readLine();
                   
                    int EinlesenAnzahlRichtig = Integer.parseInt(linie);
                    linie = br2.readLine();

                    


                    vokabelDatenbank[i] = new VokabelStructur(EinlesenDeutscheVokabel, EinlesenEnglischeVokabel, EinlesenAnzahlRichtig);
                        
        
                }
                br2.close();

                BufferedWriter bw = new BufferedWriter(new FileWriter("Vokabeln.txt",false));

                for (int i2=0; i2<anzahlWörter; i2++) {

                    
                            
                    bw.write(vokabelDatenbank[i2].getdeutscheVokabel());
                    System.out.println(vokabelDatenbank[i2].getdeutscheVokabel());
                    bw.newLine();

                    bw.write(vokabelDatenbank[i2].getenglischeVokabel());
                    System.out.println(vokabelDatenbank[i2].getenglischeVokabel());
                    bw.newLine();

                    bw.write(String.valueOf(vokabelDatenbank[i2].getanzahlRichtig()));
                    System.out.println(vokabelDatenbank[i2].getanzahlRichtig());
                    bw.newLine();
                    bw.write("");
                    bw.newLine();
                    
                    
                  
                }
                bw.close();

                BufferedWriter bw2 = new BufferedWriter(new FileWriter("Vokabeln.txt",true));

                bw2.write(eingabeDeutsch);
                bw2.newLine();
                bw2.write(eingabeEnglisch);
                bw2.newLine();
                bw2.write("0");
                bw2.newLine();
                bw2.write("");


                bw2.close();

                                            
            }





            //#############################################################################
            //Auswahl - Deutsche Vokabeln abfragen

            else if (auswahl.equals(options[1])) {

                int iZählerENDE = 0;

                BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Vokabeln.txt")));

                linie = br.readLine();
                while (linie!=null) {
                    if ("".equals(linie)) {
                        anzahlWörter ++;

                    }
                    linie = br.readLine();
                    
                }
                br.close();
                System.out.println(anzahlWörter);

                VokabelStructur[] vokabelDatenbank = new VokabelStructur[anzahlWörter] ;


                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Vokabeln.txt")));       

                for (int i3=0; i3<anzahlWörter; i3++) {

                    linie = br2.readLine();
                   
                    String EinlesenDeutscheVokabel = linie;
                    linie = br2.readLine();
                   
                    String EinlesenEnglischeVokabel = linie;
                    linie = br2.readLine();
                   
                    int EinlesenAnzahlRichtig = Integer.parseInt(linie);
                    linie = br2.readLine();

                    vokabelDatenbank[i3] = new VokabelStructur(EinlesenDeutscheVokabel, EinlesenEnglischeVokabel, EinlesenAnzahlRichtig);

                }
                br2.close();


                if (!abbruch_DE) {

                    for (VokabelStructur element : vokabelDatenbank){

                        int anzahlRichtig = element.getanzahlRichtig();

                        if (!abbruch_DE) {

                    
                        
                        String eingabe_EN_DE = JOptionPane.showInputDialog("Wie lautet die deutsche Vokabel von "+ element.getenglischeVokabel()+"?" );

                        if (eingabe_EN_DE.equals(element.getdeutscheVokabel())) {

                            JOptionPane.showMessageDialog(null, "Das war korrekt");
                            iZählerENDE++;
                            element.setanzahlRichtig(anzahlRichtig+1); 
                            
                        }

                        else {

                            JOptionPane.showMessageDialog(null, "Das war nicht Richtig");
                            iZählerENDE++;
                            element.setanzahlRichtig(anzahlRichtig-1); 

                        }

                        if (iZählerENDE==2) {
                        
                   

                            int eingabeAbbruch_DE = JOptionPane.showConfirmDialog(null,"Wollen Sie abbrechen?");

                            if (eingabeAbbruch_DE == 0) {

                                abbruch_DE = true;


                            
                    
                            }
                            iZählerENDE = 0;

                        }

                        }

                    }

                }

                BufferedWriter bw3 = new BufferedWriter(new FileWriter("Vokabeln.txt",false));

                

                for (int i4=0; i4<(anzahlWörter); i4++) {

                    
                            
                    bw3.write(vokabelDatenbank[i4].getdeutscheVokabel());
                    bw3.newLine();

                    bw3.write(vokabelDatenbank[i4].getenglischeVokabel());
                    bw3.newLine();

                    bw3.write(String.valueOf(vokabelDatenbank[i4].getanzahlRichtig()));
                    bw3.newLine();

                    bw3.write("");


                    if (anzahlWörter != i4) {
                        bw3.newLine();
                    }
                    
                    
                    
                    
                  
                }

                
                bw3.close();



            }


            //#############################################################################
            //Auswahl - Englische Vokabeln abfragen

            else if (auswahl.equals(options[2])) {

                
                int iZählerENDE = 0;

                BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Vokabeln.txt")));

                linie = br.readLine();
                while (linie!=null) {
                    if ("".equals(linie)) {
                        anzahlWörter ++;

                    }
                    linie = br.readLine();
                    
                }
                br.close();
                System.out.println(anzahlWörter);

                VokabelStructur[] vokabelDatenbank = new VokabelStructur[anzahlWörter] ;


                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Vokabeln.txt")));       

                for (int i5=0; i5<anzahlWörter; i5++) {

                    linie = br2.readLine();
                    String EinlesenDeutscheVokabel = linie;

                    linie = br2.readLine();
                    String EinlesenEnglischeVokabel = linie;

                    linie = br2.readLine();
                    int EinlesenAnzahlRichtig = Integer.parseInt(linie);

                    linie = br2.readLine();

                    vokabelDatenbank[i5] = new VokabelStructur(EinlesenDeutscheVokabel, EinlesenEnglischeVokabel, EinlesenAnzahlRichtig);

                }
                br2.close();


                if (!abbruch_EN) {

                    for (VokabelStructur element : vokabelDatenbank){

                        int anzahlRichtig = element.getanzahlRichtig();

                        if (!abbruch_EN) {

                    
                        
                        String eingabe_EN_DE = JOptionPane.showInputDialog("Wie lautet die englische Vokabel von "+ element.getdeutscheVokabel()+"?" );

                        if (eingabe_EN_DE.equals(element.getenglischeVokabel())) {

                            JOptionPane.showMessageDialog(null, "Das war korrekt");
                            iZählerENDE++;
                            element.setanzahlRichtig(anzahlRichtig+1); 
                            
                        }

                        else {

                            JOptionPane.showMessageDialog(null, "Das war nicht Richtig");
                            iZählerENDE++;
                            element.setanzahlRichtig(anzahlRichtig-1); 

                        }

                        if (iZählerENDE==2) {
                        
                   

                            int eingabeAbbruch_EN = JOptionPane.showConfirmDialog(null,"Wollen Sie abbrechen?");

                            if (eingabeAbbruch_EN == 0) {

                                abbruch_EN = true;


                            
                    
                            }
                            iZählerENDE = 0;

                        }

                        }

                    }

                }

                BufferedWriter bw3 = new BufferedWriter(new FileWriter("Vokabeln.txt",false));

                for (int i6=0; i6<anzahlWörter; i6++) {

                    
                            
                    bw3.write(vokabelDatenbank[i6].getdeutscheVokabel());
                    bw3.newLine();

                    bw3.write(vokabelDatenbank[i6].getenglischeVokabel());
                    bw3.newLine();

                    bw3.write(String.valueOf(vokabelDatenbank[i6].getanzahlRichtig()));
                    bw3.newLine();

                    bw3.write("");


                    if (anzahlWörter != i6) {
                        bw3.newLine();
                    }

       
                }
                bw3.close();


            }

            //#############################################################################

            else if (auswahl.equals(options[3])) {



                int iZählerENDE = 0;

                BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Vokabeln.txt")));

                linie = br.readLine();
                while (linie!=null) {
                    if ("".equals(linie)) {
                        anzahlWörter ++;

                    }
                    linie = br.readLine();
                    
                }
                br.close();
                System.out.println(anzahlWörter);

                VokabelStructur[] vokabelDatenbank = new VokabelStructur[anzahlWörter] ;


                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("Vokabeln.txt")));       

                for (int i7=0; i7<anzahlWörter; i7++) {

                    linie = br2.readLine();
                    String EinlesenDeutscheVokabel = linie;

                    linie = br2.readLine();
                    String EinlesenEnglischeVokabel = linie;

                    linie = br2.readLine();
                    int EinlesenAnzahlRichtig = Integer.parseInt(linie);

                    linie = br2.readLine();

                    vokabelDatenbank[i7] = new VokabelStructur(EinlesenDeutscheVokabel, EinlesenEnglischeVokabel, EinlesenAnzahlRichtig);

                }
                br2.close();


                if (!abbruch_EN) {

                    for (VokabelStructur element : vokabelDatenbank){

                        int anzahlRichtig = element.getanzahlRichtig();

                        if (!abbruch_EN) {

                            Random random = new Random();
                            Boolean zufallBoolean = random.nextBoolean();

                            if (zufallBoolean) {

                                
                        
                                String eingabe_EN_DE = JOptionPane.showInputDialog("Wie lautet die englische Vokabel von "+ element.getdeutscheVokabel()+"?" );

                                

                                if (eingabe_EN_DE.equals(element.getenglischeVokabel())) {

                                    JOptionPane.showMessageDialog(null, "Das war korrekt");
                                    iZählerENDE++;
                                    element.setanzahlRichtig(anzahlRichtig+1); 
                            
                                }

                                else {

                                    JOptionPane.showMessageDialog(null, "Das war nicht Richtig");
                                    iZählerENDE++;
                                    element.setanzahlRichtig(anzahlRichtig-1); 

                                }
                                
                            }

                            else{

                                
                        
                                String eingabe_EN_DE = JOptionPane.showInputDialog("Wie lautet die deutsch Vokabel von "+ element.getenglischeVokabel()+"?" );

                                if (eingabe_EN_DE.equals(element.getdeutscheVokabel())) {

                                    JOptionPane.showMessageDialog(null, "Das war korrekt");
                                    iZählerENDE++;
                                    element.setanzahlRichtig(anzahlRichtig+1); 
                            
                                }

                                else {

                                    JOptionPane.showMessageDialog(null, "Das war nicht Richtig");
                                    iZählerENDE++;
                                    element.setanzahlRichtig(anzahlRichtig-1); 

                                }

                            }

                    

                        if (iZählerENDE==10) {
                        
                   

                            int eingabeAbbruch_EN = JOptionPane.showConfirmDialog(null,"Wollen Sie abbrechen?");

                            if (eingabeAbbruch_EN == 0) {

                                abbruch_EN = true;


                            
                    
                            }

                            iZählerENDE = 0;

                        }

                        }

                    }

                }

                BufferedWriter bw3 = new BufferedWriter(new FileWriter("Vokabeln.txt",false));

                for (int i8=0; i8<anzahlWörter; i8++) {

                    
                            
                    bw3.write(vokabelDatenbank[i8].getdeutscheVokabel());
                    bw3.newLine();

                    bw3.write(vokabelDatenbank[i8].getenglischeVokabel());
                    bw3.newLine();

                    bw3.write(String.valueOf(vokabelDatenbank[i8].getanzahlRichtig()));
                    bw3.newLine();

                    bw3.write("");

                    if (anzahlWörter != i8) {
                        bw3.newLine();
                    }

                   
                  
                }
                bw3.close();



            }

            //#############################################################################
            //Auswahl - Abbrechen
            else if (auswahl.equals(options[4])) {

                abbruch = true;

            }





                    
        } 
    }
}

/*
 * 
                VokabelStructur[] vokabelDatenbank = new VokabelStructur[anzahlWörter];


                
                fis = new FileInputStream("Vokabeln.txt");
                isr = new InputStreamReader(fis);
                br = new BufferedReader(isr);

                vokabelDatenbank = new VokabelStructur[anzahlWörter];
                


 */
