package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core API request 'getTrytes'
 **/
public class cornodeGetTrytesRequest extends cornodeCommandRequest {

    private String[] hashes;

    /**
     * Initializes a new instance of the cornodeGetTrytesRequest class.
     */
    private cornodeGetTrytesRequest(final String... hashes) {
        super(cornodeAPICommands.GET_TRYTES);
        this.hashes = hashes;
    }

    /**
     * Create a new instance of the cornodeGetTrytesRequest class.
     */
    public static cornodeGetTrytesRequest createGetTrytesRequest(String... hashes) {
        return new cornodeGetTrytesRequest(hashes);
    }

    /**
     * Gets the hashes.
     *
     * @return The hashes.
     */
    public String[] getHashes() {
        return hashes;
    }

    /**
     * Sets the hashes.
     *
     * @param hashes The hashes.
     */
    public void setHashes(String[] hashes) {
        this.hashes = hashes;
    }
}
