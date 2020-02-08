package pl.michalgorski.magicnumber.models.file.service;

import pl.michalgorski.magicnumber.models.file.data.FilePatternModel;

import java.io.File;
import java.util.Map;

public class FileExtensionService {

    private FilePatternModel filePatternModel;
    private final Map<String, int[]> mapWithFilePattern;

    public FileExtensionService() {
        filePatternModel = new FilePatternModel();
        mapWithFilePattern = filePatternModel.getMapWithFilePattern();
    }

    String getExtensionOfFile(File file){

        String fileName = file.getName();

        return cutExtensionFromFileName(fileName);
    }

    private String cutExtensionFromFileName(String fileName) {

        String fileExtension = "";
        String[] partsTableOfFileName = fileName.split("\\.");

        if (partsTableOfFileName.length > 1) {
            int indexWithExtension = partsTableOfFileName.length - 1;
            fileExtension = partsTableOfFileName[indexWithExtension];
        }
        return fileExtension.toUpperCase();
    }


}
