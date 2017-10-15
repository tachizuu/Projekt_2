package projekt.pkg2;

import GUI.FilmFönster;
import GUI.HuvudFönster;
import Film.Film;
import GUI.LäggTillFönster;

public class Projekt2
{
    public static void main(String[] args)
    {
        LäggTillFönster ltf = new LäggTillFönster();
        ltf.visa();
        FilmFönster f = new FilmFönster();
        f.visaFilm(new Film("Titel", "adspiasiasdjasdisdi", 5), 200, 200);
        HuvudFönster hv = new HuvudFönster();
        hv.visa();
    }
}