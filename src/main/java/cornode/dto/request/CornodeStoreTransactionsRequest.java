package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core API request 'getTransactionsToApprove'
 * It stores transactions into the local storage. The trytes to be used for this call are returned by attachToTangle.
 **/
public class cornodeStoreTransactionsRequest extends cornodeCommandRequest {

    private String[] trytes;

    /**
     * Initializes a new instance of the cornodeStoreTransactionsRequest class.
     */
    private cornodeStoreTransactionsRequest(final String... trytes) {
        super(cornodeAPICommands.STORE_TRANSACTIONS);
        this.trytes = trytes;
    }

    /**
     * Create a new instance of the cornodeStoreTransactionsRequest class.
     */
    public static cornodeStoreTransactionsRequest createStoreTransactionsRequest(final String... trytes) {
        return new cornodeStoreTransactionsRequest(trytes);
    }

    /**
     * Gets the trytes.
     *
     * @return The trytes.
     */
    public String[] getTrytes() {
        return trytes;
    }

    /**
     * Sets the trytes.
     *
     * @param trytes The trytes.
     */
    public void setTrytes(String[] trytes) {
        this.trytes = trytes;
    }
}
