package Test.Mocked;

import mockit.Mocked;
import org.io.DAOs.*;
import org.io.Utils.BusUtil;
import org.io.Utils.DispatchUtil;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.experimental.categories.Category;

@Category({MockedTest.class})
public class SendReplacementBusMockedTest {

    @Mocked
    Bus bus = new Bus(1, 0.0, 2.0, BusStatus.Available);

    @Mocked
    BreakDown breakDown = new BreakDown(3, 12.0, 23.2, BreakDownType.Malfunction);

    @Test
    public void setReplacementBusTest(){

        BusUtil.reportFailure(breakDown);

        Assertions.assertFalse(DispatchUtil.getUnresolvedBreakDowns().isEmpty());

        DispatchUtil.sendReplacementBus(bus, breakDown);

        Assertions.assertTrue(DispatchUtil.getUnresolvedBreakDowns().isEmpty());
    }
}
