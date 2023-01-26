package org.io.TestFitnessFixture;

import fit.ColumnFixture;
import org.io.DAOs.Bus;
import org.io.DAOs.BusStop;
import org.io.DAOs.Line;

import java.util.*;

public class TestAddLine extends ColumnFixture {

    int lineNumber;

    public boolean addlineTest() throws IllegalFormatCodePointException{

        int oldSize = SetUp.app.getLines().size();

        SetUp.app.addline(new Line(SetUp.routesList.get(lineNumber), lineNumber));

        int newSize = SetUp.app.getLines().size();

        return oldSize != newSize;
    }
}
