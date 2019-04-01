package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {


    private TrainController mockController;
    private TrainUser mockUser;
    private TrainSensor sensor;

    @Before
    public void before() {
        mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockController,mockUser);
    }

    @Test
    public void TestAbsoluteMargin_speedLimitUnderZero() {
        sensor.overrideSpeedLimit(-1);
        verify(mockUser).setAlarmState(true);
    }

    @Test
    public void TestAbsoluteMargin_speedLimitInsideIntervall() {
        sensor.overrideSpeedLimit(250);
        verify(mockUser).setAlarmState(false);
    }

    @Test
    public void TestAbsoluteMargin_speedLimitAboveLimit() {
        sensor.overrideSpeedLimit(501);
        verify(mockUser).setAlarmState(true);
    }

    @Test
    public void TestRelativeMargin_slowerThanHalf() {
        when(mockController.getReferenceSpeed()).thenReturn(50);
        sensor.overrideSpeedLimit(24);
        verify(mockUser).setAlarmState(true);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(0,0);
    }
}
