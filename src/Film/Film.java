package Film;

public class Film
{
    private final String titel;
    private final String beskrivning;
    private final int betyg;
    
    public Film(String titel, String besk, int betyg)
    {
        this.titel = titel;
        this.beskrivning = besk;
        this.betyg = betyg;
    }
    
    public String getTitel()
    {
        return titel;
    }
    
    public String getBeskrivning()
    {
        return beskrivning;
    }
    
    public int getBetyg()
    {
        return betyg;
    }
}
