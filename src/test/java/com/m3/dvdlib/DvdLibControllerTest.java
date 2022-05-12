package com.m3.dvdlib;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class DvdLibControllerTest {

    @Mock
    private IDvdLibView view;

    @Mock
    private DvdLibDao dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void runExit() {
        System.out.println("view = " + view);
        when(view.mainMenu()).thenReturn(7);

        DvdLibController dvdLibController = new DvdLibController(view, dao);
        dvdLibController.run();

        verify(view, times(1)).goodbyeMessage();
//        Mockito.verify(view).enterMovieTitle();
    }

    @Test
    void runListDvds() {
        System.out.println("view = " + view);
        when(view.mainMenu()).thenReturn(5).thenReturn(7).thenThrow(new Exception("help"));

        DvdLibController dvdLibController = new DvdLibController(view, dao);
        dvdLibController.run();

        verify(view).goodbyeMessage();
        verify(view).dvdList(anyListOf(Dvd.class));
        verify(dao).listAllDvds();
    }
}
