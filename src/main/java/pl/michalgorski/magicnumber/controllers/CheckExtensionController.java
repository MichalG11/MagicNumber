package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.views.ConsoleTextCreator;

public class CheckExtensionController {

    private ConsoleTextCreator consoleTextCreator;

    CheckExtensionController() {
        consoleTextCreator = new ConsoleTextCreator();
    }

    boolean checkExtensionsForFiles(FileData oneFileData, boolean isAlwaysCorrect){

        boolean isFileExtensionSupported = oneFileData.isFileExtensionSupported();
        boolean isRealExtensionSupported = oneFileData.isRealExtensionSupported();

        if (isFileExtensionSupported){
            if (isRealExtensionSupported){
                System.out.println("aaa");
            } else {
                System.out.println("bbb");
            }



        } else {
            if (isRealExtensionSupported){
                System.out.println("ccc");
            } else {
                System.out.println("ddd");
            }



        }
        return isAlwaysCorrect;
    }



}
