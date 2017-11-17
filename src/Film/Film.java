package Film;

import java.awt.Image;

public class Film
{
    private final int id;
    private final String titel;
    private final int längd;
    private final String beskrivning;
    private final String regissör;
    private final String skådespelare;
    private final String genre;
    private final Image bild;
    
    public Film(int id, String titel, int längd, String besk, String regissör, String skådespelare, String genre, Image bild)
    {
        this.id = id;
        this.titel = titel;
        this.längd = längd;
        this.beskrivning = besk;
        this.regissör = regissör;
        this.skådespelare = skådespelare;
        this.genre = genre;
        this.bild = bild;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getTitel()
    {
        return titel;
    }
    
    public String getBeskrivning()
    {
        return beskrivning;
    }

    public int getLängd() {
        return längd;
    }

    public String getRegissör() {
        return regissör;
    }

    public String getSkådespelare() {
        return skådespelare;
    }

    public String getGenre() {
        return genre;
    }

    public Image getBild() {
        return bild;
    }
    
    
}
