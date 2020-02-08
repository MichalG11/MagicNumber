package pl.michalgorski.magicnumber.views;

import pl.michalgorski.magicnumber.models.file.data.FileData;

public class MessagesMagazin {

    public void showFolderRequestText(){
        System.out.println("Podaj ścieżkę do folderu z plikami np.: \"D://folder/folder\": \n");
    }

    public void bothExtSupportedAndTheSame(FileData fileData) {
        System.out.println(fileData.getFileName() + "___THE SAME___File extension: " + fileData.getFileExtension() +
                ", Real extension: " + fileData.getRealExtension() + " \n");
    }

    public void bothExtSupportedBothDifferent(FileData fileData) {
        System.out.println(fileData.getFileName() + "___DIFFERENT___File extension: " + fileData.getFileExtension() +
                ", Real extension: " + fileData.getRealExtension() + " \n");
    }

    public void fileExtSupportedRealExtUnsupported(FileData fileData) {
        System.out.println(fileData.getFileName() + "___DIFFERENT___File extension: " + fileData.getFileExtension() +
                ", Real extension: UNSUPPORTED" + " \n");
    }

    public void fileExtUnsupportedRealExtSupported(FileData fileData) {
        System.out.println(fileData.getFileName() + "___DIFFERENT___File extension: UNSUPPORTED "
                + ", Real extension: " + fileData.getRealExtension() + " \n");
    }

    public void bothExtUnsupported(FileData fileData) {
        System.out.println(fileData.getFileName() + "___BOTH EXTENSION UNSUPPORTED" + " \n");
    }
}
