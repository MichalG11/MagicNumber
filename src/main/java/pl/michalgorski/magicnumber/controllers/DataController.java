package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.models.UnsupportedException;
import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.models.file.service.FileDataFactory;
import pl.michalgorski.magicnumber.models.file.service.FileReadService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DataController {

    private Scanner scanner;
    private FileReadService fileReadService;
    private FileDataFactory fileDataFactory;
    private CheckExtensionController checkExtensionController;

    DataController() {
        scanner = new Scanner(System.in);
        fileReadService = new FileReadService();
        fileDataFactory = new FileDataFactory();
        checkExtensionController = new CheckExtensionController();
    }

    void createFilesData() {

        String rootPath = scanner.nextLine();

        List<FileData> listWithFileData = new ArrayList<>();

        try {
            List<File> list = fileReadService.createListWithFiles(rootPath);
            listWithFileData = fileDataFactory.createFileDataList(list);

        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
        }

        createInformationAboutFiles(listWithFileData);
    }

    private void createInformationAboutFiles(List<FileData> listWithFileData) {

        boolean isAlwaysCorrect = true;

        for (FileData oneFileData : listWithFileData) {
            isAlwaysCorrect = checkExtensionController.checkExtensionsForFiles(oneFileData, isAlwaysCorrect);
        }

        try{
            if (!isAlwaysCorrect){
                throw new UnsupportedException("There are one or more unsupported files in the source folder!");
            }
        } catch (UnsupportedException ex) {
            ex.printStackTrace();
        }
    }
}
