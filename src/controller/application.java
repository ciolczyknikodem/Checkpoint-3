package controller;

import services.InputGetter;
import view.menuView;

public class application {

    menuView view = new menuView();

    public static void main(String[] args) {

    }

    public runMainMenu() {
        boolean isExit = false;

        while(!isExit) {
            view.handleMainMenu();

            switch(view.askForMenuOption()) {
                case "1" :
                    break;

                case "2" :
                    break;

                case "3" :
                    break;

                case "4" :
                    break;

                case "5" :
                    break;

                case "0" :
                    isExit = true;
                    break;
            }
        }
    }
}
