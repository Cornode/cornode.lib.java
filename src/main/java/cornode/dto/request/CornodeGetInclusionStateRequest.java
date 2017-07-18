package jota.dto.request;

import jota.cornodeAPICommands;

import java.util.Collection;

/**
 * This class represents the core API request 'getInclusionStates'
 **/
public class cornodeGetInclusionStateRequest extends cornodeCommandRequest {

    private String[] transactions;
    private String[] tips;

    /**
     * Initializes a new instance of the cornodeGetInclusionStateRequest class.
     */
    private cornodeGetInclusionStateRequest(final String[] transactions, final String[] tips) {
        super(cornodeAPICommands.GET_INCLUSIONS_STATES);
        this.transactions = transactions;
        this.tips = tips;
    }

    /**
     * Create a new instance of the cornodeGetInclusionStateRequest class.
     */
    public static cornodeGetInclusionStateRequest createGetInclusionStateRequest(String[] transactions, String[] tips) {
        return new cornodeGetInclusionStateRequest(transactions, tips);
    }

    /**
     * Create a new instance of the cornodeGetInclusionStateRequest class.
     */
    public static cornodeGetInclusionStateRequest createGetInclusionStateRequest(Collection<String> transactions, Collection<String> tips) {
        return createGetInclusionStateRequest(
                transactions.toArray(new String[]{}),
                tips.toArray(new String[]{}));
    }

    /**
     * Gets the transactions.
     *
     * @return The transactions.
     */
    public String[] getTransactions() {
        return transactions;
    }

    /**
     * Sets the transactions.
     *
     * @param transactions The transactions.
     */
    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets the tips.
     *
     * @return The tips.
     */
    public String[] getTips() {
        return tips;
    }

    /**
     * Sets the tips.
     *
     * @param tips The tips.
     */
    public void setTips(String[] tips) {
        this.tips = tips;
    }
}
