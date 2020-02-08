package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.views.ConsoleTextCreator;

class CheckExtensionController {

    private ConsoleTextCreator consoleTextCreator;

    CheckExtensionController() {
        consoleTextCreator = new ConsoleTextCreator();
    }

    boolean checkExtensionsForFiles(FileData oneFileData, boolean isAlwaysCorrect){

        boolean isFileExtensionSupported = oneFileData.isFileExtensionSupported();
        boolean isRealExtensionSupported = oneFileData.isRealExtensionSupported();

        if (isFileExtensionSupported){
            if (isRealExtensionSupported){
                checkBothExtensions(oneFileData);
            } else {
                consoleTextCreator.fileExtSupportedRealExtUnsupported(oneFileData);
                isAlwaysCorrect = false;
            }
        } else {
            if (isRealExtensionSupported){
                consoleTextCreator.fileExtUnsupportedRealExtSupported(oneFileData);
            } else {
                consoleTextCreator.bothExtUnsupported(oneFileData);
            }
            isAlwaysCorrect = false;
        }
        return isAlwaysCorrect;
    }

    private void checkBothExtensions(FileData oneFileData) {

        if (oneFileData.getFileExtension().equals(oneFileData.getRealExtension())){
            consoleTextCreator.bothExtSupportedAndTheSame(oneFileData);
        } else {
            consoleTextCreator.bothExtSupportedBothDifferent(oneFileData);

        }
    }
}