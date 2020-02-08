package pl.michalgorski.magicnumber.models.file.service;

import java.io.File;

public class FileExtensionService {

    /**
     * The method reads a file and returns a file extension.
     *
     * @param file
     * @return
     */
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
