package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalizingTextSystem extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton normalizeButton;

    public NormalizingTextSystem() {
        setTitle("Paragraph Normalizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea();
        outputTextArea = new JTextArea();
        normalizeButton = new JButton("Normalize");

        normalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paragraph = inputTextArea.getText();
                String normalizedParagraph = normalizeParagraph(paragraph);
                outputTextArea.setText(normalizedParagraph);
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(createScrollPane(inputTextArea), BorderLayout.CENTER);
        topPanel.add(normalizeButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(createScrollPane(outputTextArea), BorderLayout.CENTER);
    }

    private JScrollPane createScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setPreferredSize(new Dimension(200, 150));
        scrollPane.getViewport().addChangeListener(e -> {
            if (scrollPane.getViewport().getView() != null) {
                SwingUtilities.invokeLater(() -> {
                    textArea.setSize(scrollPane.getViewport().getViewSize().width, Integer.MAX_VALUE);
                    textArea.setLineWrap(true);
                });
            }
        });
        return scrollPane;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NormalizingTextSystem().setVisible(true));
    }

    public static String normalizeParagraph(String paragraph) {
        paragraph = capitalizeFirstLetter(paragraph);
        paragraph = removeRedundantLineBreaks(paragraph);
        paragraph = addPeriodAfterLastSentence(paragraph);

        Pattern pattern = Pattern.compile("(?<=\\.)\\s+(\\p{Ll})");
        Matcher matcher = pattern.matcher(paragraph);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group().toUpperCase());
        }
        matcher.appendTail(sb);

        pattern = Pattern.compile("(\")\\p{Ll}");
        matcher = pattern.matcher(sb.toString());
        sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group().toUpperCase());
        }
        matcher.appendTail(sb);
        SaveDataToFile(paragraph);
        return sb.toString();
    }

    public static String capitalizeFirstLetter(String paragraph) {
        paragraph = paragraph.trim();
        if (paragraph.isEmpty()) {
            return paragraph;
        }
        return Character.toUpperCase(paragraph.charAt(0)) + paragraph.substring(1);
    }

    public static String removeRedundantLineBreaks(String paragraph) {
        paragraph = paragraph.replaceAll("\\s+", " ");
        paragraph = paragraph.replaceAll("\\s*\n\\s*", "\n\n");
        return paragraph;
    }
    public static String addPeriodAfterLastSentence(String paragraph) {
        paragraph = paragraph.trim();
        if (paragraph.isEmpty()) {
            return paragraph;
        }
        if (!paragraph.endsWith(".") && !paragraph.endsWith("!") && !paragraph.endsWith("?")) {
            paragraph += ".";
        }
        paragraph += " ";
        return paragraph;
    }
    public static void SaveDataToFile(String paragraph) {
        try {
            String path = Paths.get("").toAbsolutePath().toString();
			FileWriter wf = new FileWriter(path + "/src/Data/Output.txt");
				wf.write(paragraph);
			wf.close();
			System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("AN ERROR OCCORED!");
            e.printStackTrace();
        }
    }
}