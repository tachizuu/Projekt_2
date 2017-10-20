package Film;

import java.awt.Image;
import java.io.File;

public class Film
{
    private final String titel;
    private final String längd;
    private final String beskrivning;
    private final String regissör;
    private final String skådespelare;
    private final String genre;
    private final Image bild;
    
    public Film(String titel, String längd, String besk, String regissör, String skådespelare, String genre, Image bild)
    {
        this.titel = titel;
        this.längd = längd;
        this.beskrivning = besk;
        this.regissör = regissör;
        this.skådespelare = skådespelare;
        this.genre = genre;
        this.bild = bild;
    }
    
    public String getTitel()
    {
        return titel;
    }
    
    public String getBeskrivning()
    {
        return beskrivning;
    }

    public String getLängd() {
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
