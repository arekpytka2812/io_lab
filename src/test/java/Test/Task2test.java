package Test;

import org.io.DAOs.Bus;
import org.io.DAOs.BusStatus;
import org.io.DAOs.BusStop;
import org.io.DAOs.Line;
import org.io.Utils.DbService;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Category({FactoryTest.class})
public class Task2test {

    List<Bus> busDataList = new ArrayList<>();
    List<Bus> availableBusList = new ArrayList<>();
    List<BusStop> busStopList = new ArrayList<>();
    List<List<BusStop>> routesList = new ArrayList<>();

    List<Line> linesData = new ArrayList<>();

    DbService dbService = new DbService();


    @BeforeAll
    public void setup() {
        insertBusTestData();
        insertStopTestData();
        insertLinesData();
    }

    public void insertBusTestData(){
        // filling list with bus data
        busDataList.add(new Bus(1, 0.0, 2.0, BusStatus.Available));
        busDataList.add(new Bus(2, 12.34, 5.1, BusStatus.OnRoute));
        busDataList.add(new Bus(3, 14.23, 45.0, BusStatus.Broken));
        busDataList.add(new Bus(4, 34.3, 21.0, BusStatus.Available));
        busDataList.add(new Bus(5, 1.0, 9.3, BusStatus.Available));

        // adding busses to database
        for(Bus bus : busDataList){
            dbService.insertBus(bus);
        }

        // filling available bus list
        for(Bus bus : busDataList){
            if(bus.getStatus().equals(BusStatus.Available)){
                availableBusList.add(bus);
            }
        }
    }

    public void insertStopTestData() {
        busStopList.add(new BusStop(1, "Galeria"));
        busStopList.add(new BusStop(2, "Muzeum"));
        busStopList.add(new BusStop(3, "Sklep Budowlany"));
        busStopList.add(new BusStop(4, "Uczelnia"));

        // adding stops to database
        for (BusStop stop : busStopList){
            dbService.insertStop(stop);
        }
    }

    public void insertLinesData(){
        routesList.add(new ArrayList<>());
        routesList.get(0).addAll(Arrays.asList(busStopList.get(2), busStopList.get(3), busStopList.get(1), busStopList.get(0)));

        routesList.add(new ArrayList<>());
        routesList.get(1).addAll(Arrays.asList(busStopList.get(1), busStopList.get(2), busStopList.get(3), busStopList.get(0)));

        routesList.add(new ArrayList<>());
        routesList.get(2).addAll(Arrays.asList(busStopList.get(3), busStopList.get(0), busStopList.get(2), busStopList.get(1)));

        routesList.add(new ArrayList<>());
        routesList.get(3).addAll(Arrays.asList(busStopList.get(0), busStopList.get(1), busStopList.get(2), busStopList.get(3)));

        routesList.add(new ArrayList<>());
        routesList.get(4).addAll(Arrays.asList(busStopList.get(0), busStopList.get(3), busStopList.get(1), busStopList.get(2)));

        linesData.add(new Line(routesList.get(0), 1));
        linesData.add(new Line(routesList.get(1), 2));
        linesData.add(new Line(routesList.get(2), 3));
        linesData.add(new Line(routesList.get(3), 4));
        linesData.add(new Line(routesList.get(4), 5));

        for(Line line : linesData){
            dbService.insertLine(line);
        }

    }


    @Test
    @Category({DatabaseTest.class})
    @DisplayName("Buses function test")
    public void getAvailableBusesTest(){
        // asserting that only available busses are get from database
        Assertions.assertEquals(dbService.getAvailableBuses(), availableBusList);
    }

    @Test
    @Category({DatabaseTest.class})
    @DisplayName("Stops function test")
    public void getStopTest(){
        // asserting that stops are inserted properly
        Assertions.assertEquals(dbService.getStops(), busStopList);
    }

    @Test
    @Category({DatabaseTest.class})
    @DisplayName("Lines function test")
    public void lineCreationTest(){
        // asserting that lines are inserted properly
        Assertions.assertEquals(dbService.getLines(), linesData);
    }
}
