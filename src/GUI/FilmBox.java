/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Film.Film;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import projekt.pkg2.Projekt2;

/**
 *
 * @author sebastianmeyer
 */
public class FilmBox extends javax.swing.JPanel {

    private final Film film;
    private static final ArrayList<FilmFönster> filmFönster = new ArrayList<>();
    
    public FilmBox(Film movie) {
        initComponents();
        film = movie;
        
        titel.setText(Projekt2.shorten(film.getTitel(), 40));
        längd.setText(Projekt2.convertTime(film.getLängd()));
        //Skalar bilden
        try
        {
            ImageIcon ikon = new ImageIcon(film.getBild().getScaledInstance(54, 74, Image.SCALE_DEFAULT));
            bild.setIcon(ikon);
        }
        catch(Exception e)
        {
            System.out.println("Felmeddelande: " + e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titel = new javax.swing.JLabel();
        längd = new javax.swing.JLabel();
        bild = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        titel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titel.setText("titel");

        längd.setText("längd");

        bild.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bild, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(längd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 379, Short.MAX_VALUE))
                    .addComponent(titel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(längd)
                .addContainerGap())
            .addComponent(bild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        boolean nyFilm = true;
        
        for(FilmFönster ff:filmFönster)
        {
            if(ff.compareFilm(film))
            {
                ff.setVisible(true);
                ff.requestFocus();
                nyFilm = false;
            }
        }
        
        if(nyFilm)
        {
            filmFönster.add(new FilmFönster());
            filmFönster.get(filmFönster.size() - 1).visaFilm(film, (50 + filmFönster.size() * 50), 100);
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bild;
    private javax.swing.JLabel längd;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables

}