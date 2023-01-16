package Test.Mocked;

import mockit.Mocked;
import org.io.DAOs.BusStop;

import java.util.ArrayList;
import java.util.List;

import org.io.DAOs.Line;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.experimental.categories.Category;

@Category({MockedTest.class})
public class LineMockedTest {

    @Mocked
    List<BusStop> busStops = new ArrayList<>();


    @Test
    public void lineMockedTest(){
        busStops.add(new BusStop(1, "Muzeum"));
        busStops.add(new BusStop(2, "Galeria"));

        Line line = new Line(busStops, 1);

        Assertions.assertEquals(line.getRoute(), busStops);
    }

}
