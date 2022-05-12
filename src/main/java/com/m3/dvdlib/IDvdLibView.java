package com.m3.dvdlib;

import java.util.List;

public interface IDvdLibView {

    int mainMenu();

    void goodbyeMessage();

    Dvd enterNewDvdInfo();

    String enterMovieTitle();

    void dvdInfo(Dvd currentDvd, Boolean isInDb);

    public int editMenu();

    public String getNewEntry();

    public void dvdList(List<Dvd> dvdList);

    public void addDvdBanner();

    public void removeDvdBanner();

    public void dvdInfoBanner();

    public void listDvdsBanner();

    public void addDvdMessage(Boolean isInDb);

    public void removeDvdMessage(Boolean isInDb);

    public void editSuccessMessage();

    public void leaveEditMessage();

    public void libraryLoadedMessage();

    public void librarySavedMessage(String filePath);

    public void notInDbMessage();
}