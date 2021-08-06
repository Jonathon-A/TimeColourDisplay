package ColourTime;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ColourTime {

    public static long i = 0;
    public static long j = 0;
    public static long k = 0;

    public static void main(String[] args) throws InterruptedException {
        JFrame x = new JFrame();
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 5, false);
        x.setSize(1600, 1200);
        x.setTitle("Display");
        JButton reset = new JButton("Current Time");
        reset.setBounds(205, 800, 1190, 90);
        reset.setBackground(Color.white);
        reset.setBorder(roundedBorder);
        reset.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 0;
                j = 0;
                k = 0;
            }
        });
        JButton b = new JButton("Add 1 Second");
        b.setBounds(1005, 740, 190, 50);
        b.setBackground(Color.white);
        b.setBorder(roundedBorder);
        b.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
            }
        });
        JButton b2 = new JButton("Minus 1 Second");
        b2.setBounds(1205, 740, 190, 50);
        b2.setBackground(Color.white);
        b2.setBorder(roundedBorder);
        b2.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i--;
            }
        });
        JButton b3 = new JButton("Add 1 Minute");
        b3.setBounds(605, 740, 190, 50);
        b3.setBackground(Color.white);
        b3.setBorder(roundedBorder);
        b3.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j++;
            }
        });
        JButton b4 = new JButton("Minus 1 Minute");
        b4.setBounds(805, 740, 190, 50);
        b4.setBackground(Color.white);
        b4.setBorder(roundedBorder);
        b4.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j--;
            }
        });
        JButton b5 = new JButton("Minus 1 Hour");
        b5.setBounds(405, 740, 190, 50);
        b5.setBackground(Color.white);
        b5.setBorder(roundedBorder);
        b5.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k--;
            }
        });
        JButton b6 = new JButton("Add 1 Hour");
        b6.setBounds(205, 740, 190, 50);
        b6.setBackground(Color.white);
        b6.setBorder(roundedBorder);
        b6.setFont(new Font("Verdana", Font.PLAIN, 20));
        x.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k++;
            }
        });
        JLabel mylabel = new JLabel();
        mylabel.setHorizontalAlignment(JLabel.CENTER);
        mylabel.setFont(new Font("Verdana", Font.PLAIN, 250));
        mylabel.setForeground(white);
        x.add(mylabel, SwingConstants.CENTER);
        x.setVisible(true);
      
        while (true) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String str = "0001/01/01 00:00:00";
            LocalDateTime now = LocalDateTime.now().plusSeconds(i).plusMinutes(j).plusHours(k);
            LocalDateTime mid = LocalDateTime.parse(str, dtf2);
            LocalDateTime time = LocalDateTime.from(mid);
            long years = time.until(now, ChronoUnit.YEARS);
            time = time.plusYears(years);
            long months = time.until(now, ChronoUnit.MONTHS);
            time = time.plusMonths(months);
            long days = time.until(now, ChronoUnit.DAYS);
            time = time.plusDays(days);
            long hours = time.until(now, ChronoUnit.HOURS);
            time = time.plusHours(hours);
            long minutes = time.until(now, ChronoUnit.MINUTES);
            time = time.plusMinutes(minutes);
            long seconds = time.until(now, ChronoUnit.SECONDS);
            int h = Math.toIntExact(hours)*(256/24);
            int m = Math.toIntExact(minutes)*(256/60);
            int s = Math.toIntExact(seconds)*(256/60);
            x.getContentPane().setBackground(new Color(h, m, s));
            mylabel.setText(dtf.format(now));
        }
    }
}
