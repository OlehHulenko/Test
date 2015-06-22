package ua.hulenkoOleg;

import javax.swing.*;

public class hulenkoOleg {
    public static void main(String [] args){
        String dt = new java.text.SimpleDateFormat(("hh:mm aaa")).format(java.util.Calendar.getInstance().getTime());
        JOptionPane.showMessageDialog(null, "Now is: " + dt, "Time ", JOptionPane.INFORMATION_MESSAGE);

    }
}
