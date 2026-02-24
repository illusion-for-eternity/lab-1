package ua.kpi.library.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportData {
    private String filePath;

    public ImportData(String path) {
        this.filePath = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public ArrayList<String> importObjects() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String s;
            while ((s = br.readLine()) != null) {
                lines.add(s);
                //System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lines;
    }
}
