package com.special.effect.javafxprojects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessBirthday extends JFrame {
    private JButton btnYes;
    private JButton btnNo;
    private JLabel lbOutput;
    private JPanel GuessBirthday;
    private JButton btnStart;
    private String[][][] dates = {
            {
                    {"1", "3", "5", "7"},
                    {"9", "11", "13", "15"},
                    {"17", "19", "21", "23"},
                    {"25", "27", "29", "31"}
            },
            {
                    {"2", "3", "6", "7"},
                    {"10", "11", "14", "15"},
                    {"18", "19", "22", "23"},
                    {"26", "27", "30", "31"}
            },
            {
                    {"4", "5", "6", "7"},
                    {"12", "13", "14", "15"},
                    {"20", "21", "22", "23"},
                    {"28", "29", "30", "31"}
            },
            {
                    {"8", "9", "10", "11"},
                    {"12", "13", "14", "15"},
                    {"24", "25", "26", "27"},
                    {"28", "29", "30", "31"}
            },
            {
                    {"16", "17", "18", "19"},
                    {"20", "21", "22", "23"},
                    {"24", "25", "26", "27"},
                    {"28", "29", "30", "31"}
            }
    };
    private int day = 0;
    private int question = 0;

    public GuessBirthday() {
        setContentPane(GuessBirthday);
        setTitle("Guess Birthday");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 200);
        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                question = 0;
                day = 0;
                lbOutput.setText("Is your birthday in the list?\n\n " + "\n" + getDateStr());
            }
        });

        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                question++;
                if (question > 4) {
                    lbOutput.setText("Your birthday is " + day + "!");
                } else {
                    lbOutput.setText("Is your birthday in the list?\n\n " + "\n" + getDateStr());
                }
            }
        });

        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                day += Integer.parseInt(dates[question][0][0]);
                question++;
                if (question > 4) {
                    lbOutput.setText("Your birthday is " + day + "!");
                } else {
                    lbOutput.setText("Is your birthday in the list?\n\n " + "\n" + getDateStr());
                }
            }
        });
    }

    private String getDateStr() {
        String dateStr = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dateStr += dates[question][i][j] + " ";
            }
            dateStr += "\n";
        }
        return dateStr;
    }

    public static void main(String[] args) {
        new GuessBirthday();
    }
}
