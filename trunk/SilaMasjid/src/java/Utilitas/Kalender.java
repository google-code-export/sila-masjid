/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitas;

import java.util.Date;

/**
 *
 * @author Yooganz
 */
public class Kalender {
    String tanggal="";

    public String getTanggal() {
        String[] month = {"Januari","Februari","Maret","April","Mei","Juni",
                                   "Juli","Agustus","September","Oktober","November","Desember" };
        String[] day = {"Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};
        Date date = new Date(new java.util.Date().getTime());
        tanggal = day[date.getDay()]+", "+date.getDate()+" "+month[date.getMonth()] + " "+(date.getYear()+1900);
        return tanggal;
    }


}
