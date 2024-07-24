package Graphics;

// מייבא את הספריות הנדרשות
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// מגדיר מחלקה בשם AddCompetitionDialog שמורשת מ-JDialog
public class AddCompetitionDialog extends JDialog {
    private JComboBox<String> competitionTypeComboBox; // רשימה נפתחת לבחירת סוג התחרות
    private String selectedCompetitionType; // משתנה לאחסון סוג התחרות שנבחרה

    // קונסטרוקטור למחלקה
    public AddCompetitionDialog() {
        setTitle("Add Competition"); // קובע את שם חלון הדיאלוג
        setSize(300, 150); // קובע את גודל חלון הדיאלוג
        setLocationRelativeTo(null); // ממקם את חלון הדיאלוג במרכז המסך
        setLayout(new BorderLayout(10, 10)); // קובע את פריסת חלון הדיאלוג

        // יוצר פאנל חדש עבור התוכן של הדיאלוג
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout()); // קובע את פריסת הפאנל כ- GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // קובע מרווחים בין הרכיבים בפאנל
        gbc.fill = GridBagConstraints.HORIZONTAL; // הכוונה שהרכיבים יתפשטו לרוחב
        gbc.gridx = 0; // קובע את העמודה בה יוצג הרכיב
        gbc.gridy = 0; // קובע את השורה בה יוצג הרכיב

        // מוסיף תווית לרשימת הבחירה
        contentPanel.add(new JLabel("Select Competition Type:"), gbc);

        // יוצר רשימה נפתחת עם סוגי התחרויות
        competitionTypeComboBox = new JComboBox<>(new String[] {"Air", "Water", "Terrestrial"});
        gbc.gridy = 1; // קובע את השורה בה יוצג הרכיב הבא
        gbc.weightx = 1.0; // מאפשר לרשימה להתפשט לרוחב הפאנל
        contentPanel.add(competitionTypeComboBox, gbc); // מוסיף את הרשימה הנפתחת לפאנל

        // מוסיף את פאנל התוכן למרכז חלון הדיאלוג
        add(contentPanel, BorderLayout.CENTER);

        // יוצר פאנל עבור כפתור האישור
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK"); // כפתור אישור
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // מקבל את סוג התחרות שנבחר ושומר אותו במשתנה
                selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
                setVisible(false); // סוגר את הדיאלוג
            }
        });
        buttonPanel.add(okButton); // מוסיף את כפתור האישור לפאנל

        // מוסיף את פאנל הכפתור לחלק התחתון של חלון הדיאלוג
        add(buttonPanel, BorderLayout.SOUTH);

        // קובע את ההתנהגות של סיום הדיאלוג
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // סוגר את הדיאלוג כאשר לוחצים על ה-X
        setModal(true); // מבטיח שהדיאלוג יחסום קלט לחלונות אחרים עד שייסגר
        setVisible(true); // מציג את הדיאלוג
    }

    // פונקציה להחזרת סוג התחרות שנבחר
    public String getCompetitionType() {
        return selectedCompetitionType; // מחזיר את סוג התחרות שנבחר
    }
}
