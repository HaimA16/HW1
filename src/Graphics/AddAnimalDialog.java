package Graphics;

import Animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    // רכיבי ה- GUI
    private JComboBox<String> animalTypeComboBox; // תפריט נפתח לסוג החיה
    private JTextField nameField; // שדה טקסט לשם החיה
    private JTextField weightField; // שדה טקסט למשקל החיה
    private JTextField speedField; // שדה טקסט למהירות החיה
    private JTextField positionField; // שדה טקסט למיקום החיה
    private JLabel positionLabel; // תווית למיקום החיה
    private JComboBox<String> genderComboBox; // תפריט נפתח למין החיה
    private JComboBox<String> orientationComboBox; // תפריט נפתח לכיוון החיה
    private JTextField sizeField; // שדה טקסט לגודל החיה
    private JTextField idField; // שדה טקסט ל-ID של החיה
    private JTextField maxEnergyField; // שדה טקסט לאנרגיה מקסימלית
    private JTextField energyPerMeterField; // שדה טקסט לאנרגיה לכל מטר
    private JComboBox<String> competitionTypeComboBox; // תפריט נפתח לסוג התחרות

    private String animalType; // סוג החיה שנבחר

    public AddAnimalDialog() {
        setTitle("Add Animal"); // קובע את הכותרת של חלון הדיאלוג
        setSize(500, 500); // קובע את גודל חלון הדיאלוג
        setLocationRelativeTo(null); // ממקם את חלון הדיאלוג במרכז המסך
        setLayout(new GridBagLayout()); // מגדיר את Layout Manager ל-GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // אובייקט לקביעת מיקומים
        gbc.insets = new Insets(5, 5, 5, 5); // מרווחים בין רכיבים

        // סוג חיה
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // מקבע את התווית לשמאל
        add(new JLabel("Select Animal Type:"), gbc); // מוסיף את התווית
        animalTypeComboBox = new JComboBox<>(new String[] {"Dog", "Cat", "Snake", "Eagle", "Pigeon", "Alligator", "Whale", "Dolphin"}); // יוצר את תפריט הבחירה לסוגי חיות
        gbc.gridx = 1;
        add(animalTypeComboBox, gbc); // מוסיף את תפריט הבחירה לחלון

        // שם
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Name:"), gbc); // מוסיף תווית לשם
        nameField = new JTextField(20); // יוצר שדה טקסט לשם עם רוחב 20 תווים
        gbc.gridx = 1;
        add(nameField, gbc); // מוסיף את שדה הטקסט לחלון

        // משקל
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Weight:"), gbc); // מוסיף תווית למשקל
        weightField = new JTextField(20); // יוצר שדה טקסט למשקל עם רוחב 20 תווים
        gbc.gridx = 1;
        add(weightField, gbc); // מוסיף את שדה הטקסט לחלון

        // מהירות
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Speed:"), gbc); // מוסיף תווית למהירות
        speedField = new JTextField(20); // יוצר שדה טקסט למהירות עם רוחב 20 תווים
        gbc.gridx = 1;
        add(speedField, gbc); // מוסיף את שדה הטקסט לחלון

        // מיקום
        positionLabel = new JLabel("Position (for Air/Water):"); // יוצר תווית למיקום
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(positionLabel, gbc); // מוסיף את התווית לחלון
        positionField = new JTextField(20); // יוצר שדה טקסט למיקום עם רוחב 20 תווים
        gbc.gridx = 1;
        add(positionField, gbc); // מוסיף את שדה הטקסט לחלון


        // מין
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Gender:"), gbc); // מוסיף תווית למין
        genderComboBox = new JComboBox<>(new String[] {"MALE", "FEMALE", "HERMAPHRODITE"}); // יוצר תפריט הבחירה למין
        gbc.gridx = 1;
        add(genderComboBox, gbc); // מוסיף את תפריט הבחירה לחלון

        // כיוון
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Orientation:"), gbc); // מוסיף תווית לכיוון
        orientationComboBox = new JComboBox<>(new String[] {"NORTH", "SOUTH", "EAST", "WEST"}); // יוצר תפריט הבחירה לכיוון
        gbc.gridx = 1;
        add(orientationComboBox, gbc); // מוסיף את תפריט הבחירה לחלון

        // גודל
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Size:"), gbc); // מוסיף תווית לגודל
        sizeField = new JTextField(20); // יוצר שדה טקסט לגודל עם רוחב 20 תווים
        gbc.gridx = 1;
        add(sizeField, gbc); // מוסיף את שדה הטקסט לחלון

        // ID
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(new JLabel("ID:"), gbc); // מוסיף תווית ל-ID
        idField = new JTextField(20); // יוצר שדה טקסט ל-ID עם רוחב 20 תווים
        gbc.gridx = 1;
        add(idField, gbc); // מוסיף את שדה הטקסט לחלון

        // אנרגיה מקסימלית
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(new JLabel("Max Energy:"), gbc); // מוסיף תווית לאנרגיה מקסימלית
        maxEnergyField = new JTextField(20); // יוצר שדה טקסט לאנרגיה מקסימלית עם רוחב 20 תווים
        gbc.gridx = 1;
        add(maxEnergyField, gbc); // מוסיף את שדה הטקסט לחלון

        // אנרגיה לכל מטר
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(new JLabel("Energy Per Meter:"), gbc); // מוסיף תווית לאנרגיה לכל מטר
        energyPerMeterField = new JTextField(20); // יוצר שדה טקסט לאנרגיה לכל מטר עם רוחב 20 תווים
        gbc.gridx = 1;
        add(energyPerMeterField, gbc); // מוסיף את שדה הטקסט לחלון

        // סוג תחרות
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(new JLabel("Competition Type:"), gbc); // מוסיף תווית לסוג התחרות
        competitionTypeComboBox = new JComboBox<>(new String[] {}); // יוצר תפריט הבחירה לסוג התחרות
        gbc.gridx = 1;
        add(competitionTypeComboBox, gbc); // מוסיף את תפריט הבחירה לחלון

        // כפתור אישור
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.CENTER; // מרכז את כפתור האישור
        JButton okButton = new JButton("OK"); // יוצר כפתור אישור
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animalType = (String) animalTypeComboBox.getSelectedItem(); // שומר את סוג החיה הנבחר
                setVisible(false); // סוגר את חלון הדיאלוג
            }
        });
        add(okButton, gbc); // מוסיף את כפתור האישור לחלון

        // מאזין לשינויים בתפריט סוג החיה
        animalTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUIForAnimalType(); // מעדכן את ה- UI לפי סוג החיה הנבחר
            }
        });

        updateUIForAnimalType(); // מעדכן את ה- UI לפי סוג החיה הנבחר כבר בעת פתיחת החלון
        setVisible(true); // מציג את חלון הדיאלוג
    }

    // פונקציה לעדכון התצוגה לפי סוג החיה הנבחר
    private void updateUIForAnimalType() {
        String selectedType = (String) animalTypeComboBox.getSelectedItem(); // מקבל את סוג החיה שנבחר

        boolean isAir = "Eagle".equals(selectedType) || "Pigeon".equals(selectedType); // בודק אם החיה היא עוף
        boolean isWater = "Whale".equals(selectedType) || "Dolphin".equals(selectedType); // בודק אם החיה היא ימית
        boolean isTerrestrial = "Dog".equals(selectedType) || "Cat".equals(selectedType) || "Snake".equals(selectedType); // בודק אם החיה היא יבשתית


        positionLabel.setVisible(isAir || isWater);
        positionField.setVisible(isAir || isWater);

        // עדכון סוג התחרות
        if (isAir) {
            competitionTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Air"}));
        } else if (isWater) {
            competitionTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Water"}));
        } else if (isTerrestrial) {
            competitionTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Terrestrial"}));
        }

        sizeField.setVisible(isAir || isWater || isTerrestrial); // מציג את שדה הגודל לכל סוגי החיות
    }

    // פונקציות לקבלת נתונים מהשדות
    public String getAnimalType() {
        return animalType; // מחזיר את סוג החיה שנבחר
    }

    public String getName() {
        return nameField.getText(); // מחזיר את השם שנכנס לשדה השם
    }

    public double getWeight() {
        try {
            return Double.parseDouble(weightField.getText()); // מנסה להמיר את המשקל למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }

    public double getSpeed() {
        try {
            return Double.parseDouble(speedField.getText()); // מנסה להמיר את המהירות למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }

    public int getPositionX() {
        try {
            return Integer.parseInt(positionField.getText()); // מנסה להמיר את המיקום למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }


    public Animal.Gender getGender() {
        return Animal.Gender.valueOf((String) genderComboBox.getSelectedItem()); // מחזיר את המין הנבחר
    }

    public Animal.Orientation getOrientation() {
        return Animal.Orientation.valueOf((String) orientationComboBox.getSelectedItem()); // מחזיר את הכיוון הנבחר
    }

    public int getId() {
        try {
            return Integer.parseInt(idField.getText()); // מנסה להמיר את ה-ID למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }

    public int getMaxEnergy() {
        try {
            return Integer.parseInt(maxEnergyField.getText()); // מנסה להמיר את האנרגיה המקסימלית למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }

    public int getEnergyPerMeter() {
        try {
            return Integer.parseInt(energyPerMeterField.getText()); // מנסה להמיר את האנרגיה לכל מטר למספר
        } catch (NumberFormatException e) {
            return 0; // מחזיר 0 במקרה של שגיאה
        }
    }

    public String getCompetitionType() {
        return (String) competitionTypeComboBox.getSelectedItem(); // מחזיר את סוג התחרות שנבחר
    }
}
