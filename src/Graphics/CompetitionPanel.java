package Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

 class CompetitionPanel extends JPanel {
    private BufferedImage backgroundImage;
    private JButton[] routeButtons;
     private JButton[] arr;
     private JComboBox<String> Enter;


     public CompetitionPanel() {
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\yeuda\\IdeaProjects\\HW1\\src\\Graphics\\competitionBackground2.png"));
        } catch (IOException e) {
            System.out.println("Error loading background image");
        }

        setLayout(new BorderLayout());

        // Create route selection buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create buttons for different routes
        String[] routeNames = {"Add Competition", "Add Animal", "Clear","Eat","Info","Exit"};
        routeButtons = new JButton[routeNames.length];
        for (int i = 0; i < routeNames.length; i++) {
            routeButtons[i] = new JButton(routeNames[i]);
            buttonPanel.add(routeButtons[i]);

        }

        add(buttonPanel, BorderLayout.SOUTH);

         JPanel arrPanel = new JPanel();
         arrPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

         String[] Option = {"File", "Help"};
         arr = new JButton[Option.length];
         for (int i = 0; i < Option.length; i++) {
             arr[i] = new JButton(Option[i]);
             arrPanel.add(arr[i]);
         }
         add(arrPanel, BorderLayout.NORTH);

         JMenu menu = new JMenu("File");
         JMenuItem menuItem= new JMenuItem("Exit");
         menu.add(menuItem);

         menuItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 System.exit(0); // Exit the program
             }
         });



         JMenu menu1 = new JMenu("Help");
         JMenuItem menuItem1= new JMenuItem("Help");
         menu1.add(menuItem1);

         menuItem1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 // Show message dialog
                 JOptionPane.showMessageDialog(
                         CompetitionPanel.this,
                         "Home Work 2 GUI",
                         "Message",
                         JOptionPane.INFORMATION_MESSAGE
                 );
             }
         });

         JMenuBar menuBar = new JMenuBar();
         menuBar.add(menu);
         menuBar.add(menu1);

         JPanel panel1 = new JPanel(new BorderLayout());
         panel1.add(menuBar, BorderLayout.NORTH);

         add(panel1, BorderLayout.NORTH);

     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }



 }