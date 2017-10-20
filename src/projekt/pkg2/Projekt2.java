package projekt.pkg2;

import GUI.FilmFönster;
import GUI.HuvudFönster;
import Film.Film;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Projekt2
{
    public static void main(String[] args)
    {
        try
    {
        ArrayList<Film> filmer = new ArrayList<>();
        
        Image bild = ImageIO.read(new File("C://images/hajen.jpg"));//temporär bildlösning
        
        filmer.add(new Film("Filmens titel", "2:34", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        filmer.add(new Film("Detta är en likadan film", "2:34", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        filmer.add(new Film("Detta är en dkjlkcj film", "2:23", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        filmer.add(new Film("asdlökasd är en likadan film", "5:34", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        filmer.add(new Film("Detta är en likadan film", "101010", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        filmer.add(new Film("Detta är en likadan asdljk", "mjau", "Världens bästa film", "Stefan", "Johan, Anders", "skräck", bild));
        
        HuvudFönster hv = new HuvudFönster();
        hv.visa(filmer);
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    }
}