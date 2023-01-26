package org.io.TestFitnessFixture;

import fit.ColumnFixture;
import org.io.DAOs.BusStop;

import java.util.IllegalFormatCodePointException;

public class TestAddStop extends ColumnFixture {

    int ID;
    String name;

    public boolean addLineTest() throws IllegalFormatCodePointException{

        int oldSize = SetUp.app.getStops().size();

        SetUp.app.addStop(new BusStop(ID, name));

        int newSize = SetUp.app.getStops().size();

        return oldSize != newSize;
    }

}
