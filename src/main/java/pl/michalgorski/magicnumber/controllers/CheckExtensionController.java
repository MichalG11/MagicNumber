package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.models.file.data.FileData;
import pl.michalgorski.magicnumber.views.MessagesMagazin;

class CheckExtensionController {

    private MessagesMagazin messagesMagazin;

    CheckExtensionController() {
        messagesMagazin = new MessagesMagazin();
    }

    boolean checkExtensionsForFiles(FileData oneFileData, boolean isAlwaysCorrect){

        boolean isFileExtensionSupported = oneFileData.isFileExtensionSupported();
        boolean isRealExtensionSupported = oneFileData.isRealExtensionSupported();

        if (isFileExtensionSupported){
            if (isRealExtensionSupported){
                checkBothExtensions(oneFileData);
            } else {
                messagesMagazin.fileExtSupportedRealExtUnsupported(oneFileData);
                isAlwaysCorrect = false;
            }
        } else {
            if (isRealExtensionSupported){
                messagesMagazin.fileExtUnsupportedRealExtSupported(oneFileData);
            } else {
                messagesMagazin.bothExtUnsupported(oneFileData);
            }
            isAlwaysCorrect = false;
        }
        return isAlwaysCorrect;
    }

    private void checkBothExtensions(FileData oneFileData) {

        if (oneFileData.getFileExtension().equals(oneFileData.getRealExtension())){
            messagesMagazin.bothExtSupportedAndTheSame(oneFileData);
        } else {
            messagesMagazin.bothExtSupportedBothDifferent(oneFileData);

        }
    }
}