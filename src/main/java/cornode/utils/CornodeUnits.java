package jota.utils;

/**
 * Table of cornode units based off of the standard system of Units.
 *
 * @author pinpong
 **/
public enum cornodeUnits {

    cornode("i", 0),
    KILO_cornode("Ki", 3), // 10^3
    MEGA_cornode("Mi", 6), // 10^6
    GIGA_cornode("Gi", 9), // 10^9
    TERA_cornode("Ti", 12), // 10^12
    PETA_cornode("Pi", 15); // 10^15

    private String unit;
    private long value;

    /**
     * Initializes a new instance of the cornodeUnit class.
     */
    cornodeUnits(String unit, long value) {
        this.unit = unit;
        this.value = value;
    }

    /**
     * Gets the unit.
     *
     * @return The cornode Unit.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Gets the value.
     *
     * @return The value.
     */
    public long getValue() {
        return value;
    }
}
