package pl.michalgorski.magicnumber.views;

import pl.michalgorski.magicnumber.models.file.data.FileData;

public class ConsoleTextCreator {

    public void showFolderRequestText(){
        System.out.println("Podaj ścieżkę do folderu z plikami np.: \"D://folder/folder\": \n");
    }

    public void bothExtSupportedAndTheSame(FileData oneFileData) {

    }

    public void bothExtSupportedBothDifferent(FileData oneFileData) {

    }

    public void fileExtSupportedRealExtUnsupported(FileData oneFileData) {

    }

    public void fileExtUnsupportedRealExtSupported(FileData oneFileData) {

    }

    public void bothExtUnsupported(FileData oneFileData) {

    }
}
