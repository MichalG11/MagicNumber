package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.views.MessagesMagazin;

public class ApplicationController {

    private MessagesMagazin messagesMagazin;
    private DataController dataController;

    public  ApplicationController(){
        messagesMagazin = new MessagesMagazin();
        dataController = new DataController();
    }

    public void startApplication() {
        messagesMagazin.showFolderRequestText();

        dataController.createFilesData();
    }
}
