package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * Broadcast a list of transactions to all neighbors. The input trytes for this call are provided by attachToTangle
 **/
public class cornodeBroadcastTransactionRequest extends cornodeCommandRequest {

    private String[] trytes;

    /**
     * Initializes a new instance of the cornodeBroadcastTransactionRequest class.
     */
    private cornodeBroadcastTransactionRequest(final String... trytes) {
        super(cornodeAPICommands.BROADCAST_TRANSACTIONS);
        this.trytes = trytes;
    }

    /**
     * Initializes a new instance of the cornodeBroadcastTransactionRequest class.
     */
    public static cornodeBroadcastTransactionRequest createBroadcastTransactionsRequest(final String... trytes) {
        return new cornodeBroadcastTransactionRequest(trytes);
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