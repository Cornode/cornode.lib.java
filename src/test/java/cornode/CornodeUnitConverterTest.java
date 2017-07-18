package jota;

import jota.utils.cornodeUnitConverter;
import jota.utils.cornodeUnits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author pinpong
 */
public class cornodeUnitConverterTest {

    @Test
    public void shouldConvertUnitItoKi() {
        assertEquals(cornodeUnitConverter.convertUnits(1000, cornodeUnits.cornode, cornodeUnits.KILO_cornode), 1);
    }

    @Test
    public void shouldConvertUnitKiToMi() {
        assertEquals(cornodeUnitConverter.convertUnits(1000, cornodeUnits.KILO_cornode, cornodeUnits.MEGA_cornode), 1);
    }

    @Test
    public void shouldConvertUnitMiToGi() {
        assertEquals(cornodeUnitConverter.convertUnits(1000, cornodeUnits.MEGA_cornode, cornodeUnits.GIGA_cornode), 1);
    }

    @Test
    public void shouldConvertUnitGiToTi() {
        assertEquals(cornodeUnitConverter.convertUnits(1000, cornodeUnits.GIGA_cornode, cornodeUnits.TERA_cornode), 1);
    }

    @Test
    public void shouldConvertUnitTiToPi() {
        assertEquals(cornodeUnitConverter.convertUnits(1000, cornodeUnits.TERA_cornode, cornodeUnits.PETA_cornode), 1);
    }

    @Test
    public void shouldFindOptimizeUnitToDisplay() {
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1), cornodeUnits.cornode);
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1000), cornodeUnits.KILO_cornode);
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1000000), cornodeUnits.MEGA_cornode);
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1000000000), cornodeUnits.GIGA_cornode);
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1000000000000L), cornodeUnits.TERA_cornode);
        assertEquals(cornodeUnitConverter.findOptimalcornodeUnitToDisplay(1000000000000000L), cornodeUnits.PETA_cornode);
    }

    @Test
    public void shouldConvertRawcornodeAmountToDisplayText() {
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1, false), "1 i");
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1000, false), "1 Ki");
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1000000, false), "1 Mi");
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1000000000, false), "1 Gi");
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1000000000000L, false), "1 Ti");
        assertEquals(cornodeUnitConverter.convertRawcornodeAmountToDisplayText(1000000000000000L, false), "1 Pi");
    }
}
