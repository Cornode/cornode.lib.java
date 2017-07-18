package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core api request 'findTransactions'
 **/
public class cornodeFindTransactionsRequest extends cornodeCommandRequest {

    private String[] bundles; // List of bundle hashes. The hashes need to be extended to 81chars by padding the hash with 9's.
    private String[] addresses;
    private String[] tags;
    private String[] approvees;

    /**
     * Initializes a new instance of the cornodeFindTransactionsRequest class.
     */
    private cornodeFindTransactionsRequest() {
        super(cornodeAPICommands.FIND_TRANSACTIONS);
    }

    /**
     * Create a new instance of the cornodeFindTransactionsRequest class.
     */
    public static cornodeFindTransactionsRequest createFindTransactionRequest() {
        return new cornodeFindTransactionsRequest();
    }

    /**
     * Initializes a new instance of the cornodeFindTransactionsRequest class.
     */
    public cornodeFindTransactionsRequest byBundles(String... bundles) {
        this.bundles = bundles;
        return this;
    }

    /**
     * Initializes a new instance of the cornodeFindTransactionsRequest class.
     */
    public cornodeFindTransactionsRequest byAddresses(String... addresses) {
        this.addresses = addresses;
        return this;
    }

    /**
     * Initializes a new instance of the cornodeFindTransactionsRequest class.
     */
    public cornodeFindTransactionsRequest byTags(String... tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Initializes a new instance of the cornodeFindTransactionsRequest class.
     */
    public cornodeFindTransactionsRequest byApprovees(String... approvees) {
        this.approvees = approvees;
        return this;
    }

    /**
     * Gets the bundles.
     *
     * @return The bundles.
     */
    public String[] getBundles() {
        return bundles;
    }

    /**
     * Sets the bundles.
     *
     * @param bundles The bundles.
     */
    public void setBundles(String[] bundles) {
        this.bundles = bundles;
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
     * Gets the tags.
     *
     * @return The tags.
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * Sets the tags.
     *
     * @param tags The tags.
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Gets the approvees.
     *
     * @return The approvees.
     */
    public String[] getApprovees() {
        return approvees;
    }

    /**
     * Sets the approvees.
     *
     * @param approvees The approvees.
     */
    public void setApprovees(String[] approvees) {
        this.approvees = approvees;
    }
}
