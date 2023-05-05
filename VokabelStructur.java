

/** Sie enthält das deutsche und englische Vokabel. **/

public class VokabelStructur {

    private String englischeVokabel;
    private String deutscheVokabel;
    private int anzahlRichtig;
    
    

    /** Konstruktor benötigt folgende Werte: englischeVokabel, deutscheVokabel, anzahlRichtig*/

    public VokabelStructur (String wert1, String wert2, int i){

        this.deutscheVokabel = wert1;
        this.englischeVokabel = wert2;            
        this.anzahlRichtig = i;       

    }
    /** Gibt die englische Vokabel zurück */
    public String getenglischeVokabel(){
        return englischeVokabel;
    }
    /** Gibt die deutsche Vokabel zurück */
    public String getdeutscheVokabel(){
        return deutscheVokabel;
    }
    /** Gibt den Wert der anzahl der Richtigen Versuchen zurück */
    public int getanzahlRichtig(){
        return anzahlRichtig;
    }


    /** Ändeert den Preis */
    public void setenglischeVokabel(String wert){
        this.englischeVokabel = wert;
    }

    /** Ändeert den Preis */
    public void setdeutscheVokabel(String wert){
        this.deutscheVokabel = wert;
    }

    /** Ändeert den Preis */
    public void setanzahlRichtig(int wert){
        this.anzahlRichtig = wert;
    }

}
