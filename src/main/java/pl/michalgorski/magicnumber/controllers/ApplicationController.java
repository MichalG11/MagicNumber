package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.views.ConsoleTextCreator;

public class ApplicationController {

    private ConsoleTextCreator consoleTextCreator;
    private DataController dataController;

    public  ApplicationController(){
        consoleTextCreator = new ConsoleTextCreator();
        dataController = new DataController();
    }

    public void startApplication() {
        consoleTextCreator.showFolderRequestText();

        dataController.createFilesData();
    }
}
