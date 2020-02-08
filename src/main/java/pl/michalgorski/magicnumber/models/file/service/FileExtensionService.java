package pl.michalgorski.magicnumber.models.file.service;

import java.io.File;

public class FileExtensionService {

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
