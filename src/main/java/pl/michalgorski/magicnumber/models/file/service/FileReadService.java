package pl.michalgorski.magicnumber.models.file.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadService {

    /**
     * The method reads a source folder path and creates a File list.
     *
     * @param rootPath
     * @return
     * @throws NullPointerException
     */
    public List<File> createListWithFiles(String rootPath) throws NullPointerException{

        File directory = new File(rootPath);
        File[] fileArray = directory.listFiles();

        List<File> listWithFiles = new ArrayList<>(Arrays.asList(fileArray));

        return listWithFiles;
    }
}
