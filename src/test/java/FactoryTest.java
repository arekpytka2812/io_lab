import org.io.DAOs.Bus;
import org.io.DAOs.BusStatus;
import org.io.DAOs.BusStop;
import org.io.DAOs.Line;
import org.io.Utils.AdminUtil;
import org.io.Utils.DispatchUtil;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FactoryTest {

    List<Bus> busDataList = new ArrayList<>();
    List<Bus> availableBusList = new ArrayList<>();
    List<BusStop> busStopList = new ArrayList<>();
    List<List<BusStop>> routesList = new ArrayList<>();

    List<Line> linesData = new ArrayList<>();


    @Before
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
        for(var bus : busDataList){
            AdminUtil.addBus(bus);
        }

        // filling available bus list
        for(var bus : busDataList){
            AdminUtil.addBus(bus);
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
        for (var stop : busStopList){
            AdminUtil.addStop(stop);
        }
    }

    public void insertLinesData(){
        routesList.add(new ArrayList<>());
        routesList.get(0).addAll(Arrays.asList(busStopList.get(2), busStopList.get(3), busStopList.get(1), busStopList.get(4)));

        routesList.add(new ArrayList<>());
        routesList.get(1).addAll(Arrays.asList(busStopList.get(1), busStopList.get(2), busStopList.get(3), busStopList.get(4)));

        routesList.add(new ArrayList<>());
        routesList.get(2).addAll(Arrays.asList(busStopList.get(3), busStopList.get(4), busStopList.get(2), busStopList.get(1)));

        routesList.add(new ArrayList<>());
        routesList.get(3).addAll(Arrays.asList(busStopList.get(4), busStopList.get(1), busStopList.get(2), busStopList.get(3)));

        routesList.add(new ArrayList<>());
        routesList.get(4).addAll(Arrays.asList(busStopList.get(1), busStopList.get(3), busStopList.get(1), busStopList.get(2)));

        linesData.add(new Line(routesList.get(0), 1));
        linesData.add(new Line(routesList.get(1), 2));
        linesData.add(new Line(routesList.get(2), 3));
        linesData.add(new Line(routesList.get(3), 4));
        linesData.add(new Line(routesList.get(4), 5));

        for(var line : linesData){
            AdminUtil.addLine(line);
        }

    }


    @Test
    @DisplayName("Buses function test")
    void getAvailableBusesTest(){
        // asserting that only available busses are get from database
        Assertions.assertEquals(DispatchUtil.getAvailableBuses(), availableBusList);
    }

    @Test
    @DisplayName("Stops function test")
    void getStopTest(){
        // asserting that stops are inserted correctly
        Assertions.assertEquals(DispatchUtil.getStops(), busStopList);
    }

    @Test
    @DisplayName("Line function test")
    void lineCreationTest(){

        Assertions.assertEquals(DispatchUtil.getLines(), linesData);
    }
}
