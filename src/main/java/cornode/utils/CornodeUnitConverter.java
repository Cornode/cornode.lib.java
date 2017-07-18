package jota.utils;

import java.text.DecimalFormat;

/**
 * This class provides methods to convert cornode to different units.
 *
 * @author sascha
 */
public class cornodeUnitConverter {

    /**
     * Convert the cornode amount.
     *
     * @param amount   The amount.
     * @param fromUnit The source unit e.g. the unit of amount.
     * @param toUnit   The target unit.
     * @return The specified amount in the target unit.
     **/
    public static long convertUnits(long amount, cornodeUnits fromUnit, cornodeUnits toUnit) {
        long amountInSource = (long) (amount * Math.pow(10, fromUnit.getValue()));
        return convertUnits(amountInSource, toUnit);
    }

    /**
     * Convert unit.
     *
     * @param amount The amount.
     * @param toUnit The target unit.
     * @return The specified amount in the target unit.
     **/
    private static long convertUnits(long amount, cornodeUnits toUnit) {
        return (long) (amount / Math.pow(10, toUnit.getValue()));
    }

    /**
     * Convert the cornode amount to text.
     *
     * @param amount   The amount.
     * @param extended Extended length.
     * @return The specified amount in the target unit.
     **/
    public static String convertRawcornodeAmountToDisplayText(long amount, boolean extended) {
        cornodeUnits unit = findOptimalcornodeUnitToDisplay(amount);
        double amountInDisplayUnit = convertAmountTo(amount, unit);
        return createAmountWithUnitDisplayText(amountInDisplayUnit, unit, extended);
    }

    /**
     * Convert amount to target unit.
     *
     * @param amount The amount.
     * @return The target unit.
     **/
    public static double convertAmountTo(long amount, cornodeUnits target) {
        return amount / Math.pow(10, target.getValue());
    }

    /**
     * Create amount with unit text.
     *
     * @param amountInUnit The amount in units.
     * @param unit         The unit.
     * @param extended     Extended length.
     * @return The target unit.
     **/
    private static String createAmountWithUnitDisplayText(double amountInUnit, cornodeUnits unit, boolean extended) {
        String result = createAmountDisplayText(amountInUnit, unit, extended);
        result += " " + unit.getUnit();
        return result;
    }

    /**
     * Create amount text.
     *
     * @param amountInUnit The amount in units.
     * @param unit         The unit.
     * @param extended     Extended length.
     * @return The target unit.
     **/
    public static String createAmountDisplayText(double amountInUnit, cornodeUnits unit, boolean extended) {
        DecimalFormat df;
        if (extended) df = new DecimalFormat("##0.##################");
        else
            df = new DecimalFormat("##0.##");

        String result = "";
        // display unit as integer if value is between 1-999 or in decimal format
        result += unit == cornodeUnits.cornode ? (long) amountInUnit : df.format(amountInUnit);
        return result;
    }

    /**
     * Finds the optimal unit to display the specified amount in.
     *
     * @param amount The amount.
     * @return The optimal cornodeUnit.
     **/
    public static cornodeUnits findOptimalcornodeUnitToDisplay(long amount) {
        int length = String.valueOf(amount).length();

        if (amount < 0) {// do not count "-" sign
            length -= 1;
        }

        cornodeUnits units = cornodeUnits.cornode;

        if (length >= 1 && length <= 3) {
            units = cornodeUnits.cornode;
        } else if (length > 3 && length <= 6) {
            units = cornodeUnits.KILO_cornode;
        } else if (length > 6 && length <= 9) {
            units = cornodeUnits.MEGA_cornode;
        } else if (length > 9 && length <= 12) {
            units = cornodeUnits.GIGA_cornode;
        } else if (length > 12 && length <= 15) {
            units = cornodeUnits.TERA_cornode;
        } else if (length > 15 && length <= 18) {
            units = cornodeUnits.PETA_cornode;
        }
        return units;
    }

}
