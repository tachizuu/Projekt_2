package projekt.pkg2;

import GUI.HuvudFönster;
import Film.Film;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Projekt2 {
    
    public static ArrayList<Film> filmer;
    public static HuvudFönster hf;
    
    public static void main(String[] args) {
        
        filmer = new ArrayList<>();
        hf = new HuvudFönster();
        update();
    }
    
    public static void update()     //uppdaterar filmlista, sedan huvudföstret
    {
        filmer = getFromDB();
        hf.visa(filmer);
    }
    
    public static String convertTime(int min)
    {
        String s = "";
        s += (int)Math.floor(min / 60);
        s += ":" + String.format("%02d", min % 60);;
        return s;
    }
    
    public static String clean(String way, String s)
    {
        if("forDB".equals(way))
        {
            String out = s.replace("'", "''");
            return out;
        }
        else if("fromDB".equals(way))
        {
            String out = s.replace("''", "'");
            return out;
        }
        return s;
    }
    
    public static String shorten(String text, int längd)
    {
        String s = "";
        
        try
        {
            s = text.substring(0, längd) + "...";
        }catch(Exception e)
        {
            s = text;
        }
        
        return s;
    }
    
    public static ArrayList<Film> getFromDB()
    {
        
        ArrayList<Film> lista = new ArrayList<>();
        try
        {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM filmer";
            ResultSet data = stmt.executeQuery(sql);
            
            while(data.next())
            {
                Blob blob = data.getBlob("bild");
                Image bild = ImageIO.read(blob.getBinaryStream());
                if(bild != null)
                {
                    lista.add(new Film(data.getInt("Id"), clean("fromDB", data.getString("titel")), data.getInt("längd"), clean("fromDB", data.getString("beskrivning")), clean("fromDB", data.getString("regissör")), clean("fromDB", data.getString("skådespelare")), clean("fromDB", data.getString("genre")), bild));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Något verkar ha gått fel med databasanslutningen!");
        }
        return lista;
    }
    
    public static boolean postToDB(String titel, int längd, String besk, String regissör, String skådespelare, String genre, File bild)
    {
        PreparedStatement ps = null;
        InputStream is = null;
        Connection connection = null;
        String path = bild.getPath();
        try
        {
            connection = getConnection();
            ps = connection.prepareCall(String.format("INSERT INTO filmer VALUES(null, '%s', %d, '%s', '%s', '%s', '%s', ?);", titel, längd, besk, regissör, skådespelare, genre));
            is = new FileInputStream(new File(path));
            ps.setBinaryStream(1, is);
            int count = ps.executeUpdate();
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            try
            {
                if(is != null) is.close();
                if(ps != null) ps.close();
                if(connection != null) connection.close();
            }
            catch(Exception e)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void deleteInDB(int id)
    {   
        PreparedStatement ps = null;
        InputStream is = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            ps = connection.prepareCall("DELETE FROM `filmer` WHERE `filmer`.`id` = " + id);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        finally
        {
            try
            {
                if(is != null) is.close();
                if(ps != null) ps.close();
                if(connection != null) connection.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    private static Connection getConnection() throws SQLException
    {
        String url = "jdbc:mysql://localhost/projekt_2";
        String user = "root";
        String password = "";
        Connection connection = (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, password);
        return connection;
    }
}
