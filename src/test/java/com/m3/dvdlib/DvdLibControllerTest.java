package com.m3.dvdlib;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
        MockitoAnnotations.openMocks(this);
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
        when(view.mainMenu()).thenReturn(5).thenReturn(7).thenThrow(new RuntimeException("help"));

        DvdLibController dvdLibController = new DvdLibController(view, dao);
        dvdLibController.run();

        verify(view).goodbyeMessage();
        verify(view).dvdList(ArgumentMatchers.anyList());
        verify(dao).listAllDvds();
    }
}
