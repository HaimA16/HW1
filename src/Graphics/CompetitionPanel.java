package Graphics;

// מייבא את הספריות הנדרשות
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// מגדיר מחלקה בשם CompetitionPanel שמורשת מ-JPanel
public class CompetitionPanel extends JPanel {
    private BufferedImage backgroundImage; // משתנה לאחסון התמונה של הרקע
    private JButton[] routeButtons; // מערך של כפתורים
    private java.util.List<String> competitionsList = new java.util.ArrayList<>(); // רשימה לאחסון התחרויות

    // קונסטרוקטור למחלקה
    public CompetitionPanel() {
        try {
            // מנסה לקרוא את תמונת הרקע מהקובץ
            backgroundImage = ImageIO.read(new File("C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\competitionBackground.png"));
        } catch (IOException e) {
            // מדפיס הודעת שגיאה אם התמונה לא נטענה
            System.out.println("Error loading background image");
        }

        // קובע את פריסת הפאנל כ- BorderLayout
        setLayout(new BorderLayout());

        // יוצר פאנל חדש לציור תמונת הרקע
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // אם התמונה לא ריקה, צייר אותה על הפאנל
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        // קובע את פריסת הפאנל כ- BorderLayout
        backgroundPanel.setLayout(new BorderLayout());
        // מוודא שהפאנל שקוף, כך שהתמונה תיראה דרכו
        backgroundPanel.setOpaque(false);

        // יוצר פאנל חדש עבור הכפתורים
        JPanel buttonPanel = new JPanel();
        // קובע את פריסת הכפתורים כ- GridBagLayout
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // קובע מרווחים בין הכפתורים
        gbc.fill = GridBagConstraints.BOTH; // הכפתורים יתפשטו למלא את הפאנל
        gbc.weightx = 1.0; // הכפתורים יתפשטו לרוחב
        gbc.weighty = 1.0; // הכפתורים יתפשטו לגובה

        // שמות הכפתורים
        String[] routeNames = {"Add Competition", "Add Animal", "Clear", "Eat", "Info", "Exit"};
        routeButtons = new JButton[routeNames.length];
        for (int i = 0; i < routeNames.length; i++) {
            // יוצר כפתור חדש לכל שם
            routeButtons[i] = new JButton(routeNames[i]);
            gbc.gridx = i; // קובע את מיקום הכפתור בעמודה
            gbc.gridy = 0; // קובע את מיקום הכפתור בשורה
            gbc.gridwidth = 1; // כל כפתור יתפוס עמודה אחת
            buttonPanel.add(routeButtons[i], gbc); // מוסיף את הכפתור לפאנל

            // מוסיף מאזין לאירועים עבור כל כפתור
            switch (routeNames[i]) {
                case "Add Competition":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // פותח חלון נוסף להוספת תחרות
                            AddCompetitionDialog dialog = new AddCompetitionDialog();
                            String competitionType = dialog.getCompetitionType(); // מקבל את סוג התחרות מהחלון
                            if (competitionType != null && !competitionType.isEmpty()) {
                                // אם סוג התחרות לא ריק ותקין, הוסף לרשימת התחרויות
                                competitionsList.add(competitionType);
                                // ניתן לעדכן את ממשק המשתמש כאן אם יש צורך
                            }
                        }
                    });
                    break;
                case "Add Animal":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // פותח חלון נוסף להוספת בעל חיים
                            AddAnimalDialog dialog = new AddAnimalDialog();
                            String competitionType = dialog.getCompetitionType(); // מקבל את סוג התחרות מהחלון
                            if (!isValidCompetitionType(competitionType)) {
                                // אם סוג התחרות לא תקין, מציג הודעת שגיאה
                                JOptionPane.showMessageDialog(
                                        CompetitionPanel.this,
                                        "The selected animal cannot participate in the chosen competition type.",
                                        "Invalid Competition Type",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            } else {
                                // כאן תוכל להוסיף קוד להנחת בעל חיים בתחילת המסלול שלו
                            }
                        }
                    });
                    break;
                case "Clear":
                    // הוסף כאן את הפעולה עבור כפתור ה- Clear
                    break;
                case "Eat":
                    // הוסף כאן את הפעולה עבור כפתור ה- Eat
                    break;
                case "Info":
                    // הוסף כאן את הפעולה עבור כפתור ה- Info
                    break;
                case "Exit":
                    routeButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // סיום התוכנית
                            System.exit(0);
                        }
                    });
                    break;
            }
        }

        // יוצר פאנל נוסף להנחת הכפתורים על הרקע
        JPanel overlayPanel = new JPanel(new BorderLayout());
        overlayPanel.add(buttonPanel, BorderLayout.SOUTH); // מוסיף את פאנל הכפתורים בתחתית הפאנל הנוסף

        // יוצר תפריט קבצים
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // סיום התוכנית כאשר נלחץ על Exit בתפריט
                System.exit(0);
            }
        });

        // יוצר תפריט עזרה
        JMenu menu1 = new JMenu("Help");
        JMenuItem menuItem1 = new JMenuItem("Help");
        menu1.add(menuItem1);
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // מציג הודעת עזרה כאשר נלחץ על Help בתפריט
                JOptionPane.showMessageDialog(
                        CompetitionPanel.this,
                        "Home Work 2\n GUI",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // יוצר סרגל תפריטים ומוסיף אליו את התפריטים שיצרנו
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(menu1);

        // יוצר פאנל עבור סרגל התפריטים ומוסיף אותו לחלק העליון
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.NORTH);

        // מוסיף את הפאנלים הראשיים לפאנל הראשי
        add(menuPanel, BorderLayout.NORTH); // מוסיף את פאנל התפריטים לחלק העליון
        add(backgroundPanel, BorderLayout.CENTER); // מוסיף את פאנל הרקע למרכז
        add(overlayPanel, BorderLayout.SOUTH); // מוסיף את פאנל הכפתורים לחלק התחתון
    }

    // פונקציה לבדיקת תקינות סוג התחרות
    private boolean isValidCompetitionType(String competitionType) {
        // כאן ניתן להוסיף לוגיקה לבדוק אם סוג התחרות תקין
        return true; // החזר true או false לפי הלוגיקה שתרצה להוסיף
    }
}