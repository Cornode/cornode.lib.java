package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core API request 'getTransactionsToApprove'
 **/
public class cornodeGetTransactionsToApproveRequest extends cornodeCommandRequest {

    private Integer depth;

    /**
     * Initializes a new instance of the cornodeGetTransactionsToApproveRequest class.
     */
    private cornodeGetTransactionsToApproveRequest(final Integer depth) {
        super(cornodeAPICommands.GET_TRANSACTIONS_TO_APPROVE);
        this.depth = depth;
    }

    /**
     * Create a new instance of the cornodeGetTransactionsToApproveRequest class.
     */
    public static cornodeGetTransactionsToApproveRequest createcornodeGetTransactionsToApproveRequest(Integer depth) {
        return new cornodeGetTransactionsToApproveRequest(depth);
    }

    /**
     * Gets the depth.
     *
     * @return The depth.
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * Sets the depth.
     *
     * @param depth The depth.
     */
    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
