package pl.michalgorski.magicnumber.controllers;

import pl.michalgorski.magicnumber.views.ConsoleTextCreator;

public class ApplicationController {

    private ConsoleTextCreator consoleTextCreator;

    public  ApplicationController(){
        consoleTextCreator = new ConsoleTextCreator();
    }

    public void startApplication() {
        consoleTextCreator.showFolderRequestText();


    }
}
