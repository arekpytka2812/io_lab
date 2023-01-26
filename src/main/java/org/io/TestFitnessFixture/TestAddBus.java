package org.io.TestFitnessFixture;

import fit.ColumnFixture;
import org.io.DAOs.Bus;

import java.util.IllegalFormatCodePointException;

public class TestAddBus extends ColumnFixture {
    int ID;

    public boolean addBusTest() throws IllegalFormatCodePointException{

        int size = SetUp.app.getBusList().size();

        SetUp.app.addBus(new Bus(ID));

        int newSize = SetUp.app.getBusList().size();

        return size != newSize;
    }

}
