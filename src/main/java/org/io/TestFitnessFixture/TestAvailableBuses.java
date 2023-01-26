package org.io.TestFitnessFixture;

import fit.ColumnFixture;
import org.io.DAOs.Bus;
import org.io.DAOs.BusStatus;

import java.util.IllegalFormatCodePointException;

public class TestAvailableBuses extends ColumnFixture {

    int ID;
    String status;

    public int availableBusesTest() throws IllegalFormatCodePointException {

        SetUp.app.addBus(new Bus(ID, BusStatus.valueOf(status)));

        return SetUp.app.getAvailableBuses().size();

    }
}
