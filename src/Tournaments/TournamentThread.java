package Tournaments;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Map;

public class TournamentThread implements Runnable {
    private final Scores scores;
    private Boolean startSignal;
    private final int groups;
    private final JFrame resultsFrame;

    public TournamentThread(Scores scores, Boolean startSignal, int groups) {
        this.scores = scores;
        this.startSignal = startSignal;
        this.groups = groups;
        this.resultsFrame = createResultsFrame();
    }

    @Override
    public void run() {
        // Start the competition
        synchronized (startSignal) {
            startSignal = true;
            startSignal.notifyAll();
        }

        while (true) {
            Map<String, Date> allScores = scores.getAll();
            updateResultsDisplay(allScores);

            if (allScores.size() == groups) {
                break;
            }

            try {
                Thread.sleep(1000); // Update every second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Show final results
        showFinalResults(scores.getAll());
    }

    private JFrame createResultsFrame() {
        JFrame frame = new JFrame("Tournament Results");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Results will appear here", SwingConstants.CENTER), BorderLayout.CENTER);
        frame.setVisible(true);
        return frame;
    }

    private void updateResultsDisplay(Map<String, Date> currentScores) {
        StringBuilder results = new StringBuilder("<html><body>");
        for (int i = 1; i <= groups; i++) {
            String groupName = "Group " + i;
            Date finishTime = currentScores.get(groupName);
            if (finishTime != null) {
                results.append(groupName).append(": ").append(finishTime).append("<br>");
            } else {
                results.append(groupName).append(": Not finished<br>");
            }
        }
        results.append("</body></html>");

        SwingUtilities.invokeLater(() -> {
            resultsFrame.getContentPane().removeAll();
            resultsFrame.add(new JLabel(results.toString(), SwingConstants.CENTER));
            resultsFrame.revalidate();
            resultsFrame.repaint();
        });
    }

    private void showFinalResults(Map<String, Date> finalScores) {
        StringBuilder finalResults = new StringBuilder("<html><body><h2>Final Results:</h2>");
        finalScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> finalResults.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>"));
        finalResults.append("</body></html>");

        SwingUtilities.invokeLater(() -> {
            resultsFrame.getContentPane().removeAll();
            resultsFrame.add(new JLabel(finalResults.toString(), SwingConstants.CENTER));
            resultsFrame.revalidate();
            resultsFrame.repaint();
        });
    }
}
