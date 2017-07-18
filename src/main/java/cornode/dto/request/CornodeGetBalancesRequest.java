package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core api request 'getBalances'
 **/
public class cornodeGetBalancesRequest extends cornodeCommandRequest {

    private String[] addresses;
    private Integer threshold;

    /**
     * Initializes a new instance of the cornodeGetBalancesRequest class.
     */
    private cornodeGetBalancesRequest(final Integer threshold, final String... addresses) {
        super(cornodeAPICommands.GET_BALANCES);
        this.addresses = addresses;
        this.threshold = threshold;
    }

    /**
     * Create a new instance of the cornodeGetBalancesRequest class.
     */
    public static cornodeGetBalancesRequest createcornodeGetBalancesRequest(final Integer threshold, final String... addresses) {
        return new cornodeGetBalancesRequest(threshold, addresses);
    }

    /**
     * Gets the addresses.
     *
     * @return The addresses.
     */
    public String[] getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses The addresses.
     */
    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the threshold.
     *
     * @return The threshold.
     */
    public Integer getThreshold() {
        return threshold;
    }

    /**
     * Sets the threshold.
     *
     * @param threshold The threshold.
     */
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}

