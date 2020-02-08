package pl.michalgorski.magicnumber.models.file.data;

import java.util.HashMap;
import java.util.Map;

public class FilePatternModel {

    private Map<String, int[]> mapWithFilePattern = new HashMap<>();

    public FilePatternModel(){
        int[] pngFilePattern = new int[]{0x89,0x50,0x4E};
        int[] jpgFilePattern = new int[]{0xFF,0xD8,0xFF};
        int[] pdfFilePattern = new int[]{0x25,0x50,0x44};
        int[] gifFilePattern = new int[]{0x47,0x49,0x46};
        int[] txtFilePattern = new int[]{};

        mapWithFilePattern.put("PNG", pngFilePattern);
        mapWithFilePattern.put("JPG", jpgFilePattern);
        mapWithFilePattern.put("PDF", pdfFilePattern);
        mapWithFilePattern.put("GIF", gifFilePattern);
        mapWithFilePattern.put("TXT", txtFilePattern);
    }

    public Map<String, int[]> getMapWithFilePattern() {
        return mapWithFilePattern;
    }
}
