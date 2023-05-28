package Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalizeLibrary {

    public String normalizeParagraph(String paragraph) {
        paragraph = capitalizeFirstLetter(paragraph);
        paragraph = removeRedundantLineBreaks(paragraph);
        paragraph = addPeriodAfterLastSentence(paragraph);
        paragraph = fixCapitalizationAfterDot(paragraph);
        paragraph = fixSpacesAfterCommaAndDot(paragraph);
        paragraph = removeSpacesInQuotes(paragraph);

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

        return sb.toString();
    }

    public String capitalizeFirstLetter(String paragraph) {
        paragraph = paragraph.trim();
        if (paragraph.isEmpty()) {
            return paragraph;
        }
        return Character.toUpperCase(paragraph.charAt(0)) + paragraph.substring(1);
    }

    public String removeRedundantLineBreaks(String paragraph) {
        paragraph = paragraph.replaceAll("\\s+", " ");
        paragraph = paragraph.replaceAll("\\s*\n\\s*", "\n\n");
        return paragraph;
    }
    public String addPeriodAfterLastSentence(String paragraph) {
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

    public String fixSpacesAfterCommaAndDot(String paragraph) {
        paragraph = paragraph.replaceAll("\\s*,(\\p{L})", ", $1");
        paragraph = paragraph.replaceAll("\\s*\\.(\\p{L})", ". $1");
        paragraph = paragraph.replaceAll("\\s*:(\\p{L})", ": $1");
        paragraph = paragraph.replaceAll("\\s*;(\\p{L})", "; $1");
        paragraph = paragraph.replaceAll("\\s*!(\\p{L})", "! $1");
        paragraph = paragraph.replaceAll("\\s*\\?(\\p{L})", "? $1");
        return paragraph;
    }

    public String fixCapitalizationAfterDot(String paragraph) {
        Pattern pattern = Pattern.compile("\\.\\s+(\\p{Ll})");
        Matcher matcher = pattern.matcher(paragraph);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, ". " + matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    public String removeSpacesInQuotes(String paragraph) {
        Pattern pattern = Pattern.compile("“\\s+(.*?)\\s+”");
        Matcher matcher = pattern.matcher(paragraph);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String phrase = matcher.group(1);
            String replacedPhrase = phrase.trim();
            matcher.appendReplacement(sb, "“" + replacedPhrase + "”");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    public String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    
    public void saveDataToFile(String paragraph) {
        try {
            String path = Paths.get("").toAbsolutePath().toString();
			FileWriter wf = new FileWriter(path + "/src/Data/Output.txt");
				wf.write(paragraph);
			wf.close();
			System.out.println("\nSuccessfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("AN ERROR OCCORED!");
        }
    }
}