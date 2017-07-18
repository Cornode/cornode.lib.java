package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core API request 'addNeighbors' and 'removeNeighbors'
 **/
public class cornodeNeighborsRequest extends cornodeCommandRequest {

    private String[] uris;

    /**
     * Initializes a new instance of the cornodeNeighborsRequest class.
     */
    private cornodeNeighborsRequest(cornodeAPICommands type, final String... uris) {
        super(type);
        this.uris = uris;
    }

    /**
     * Create a new instance of the cornodeNeighborsRequest class.
     */
    public static cornodeNeighborsRequest createAddNeighborsRequest(String... uris) {
        return new cornodeNeighborsRequest(cornodeAPICommands.ADD_NEIGHBORS, uris);
    }

    /**
     * Create a new instance of the cornodeNeighborsRequest class.
     */
    public static cornodeNeighborsRequest createRemoveNeighborsRequest(String... uris) {
        return new cornodeNeighborsRequest(cornodeAPICommands.REMOVE_NEIGHBORS, uris);
    }

    /**
     * Gets the uris.
     *
     * @return The uris.
     */
    public String[] getUris() {
        return uris;
    }

    /**
     * Sets the uris.
     *
     * @param uris The uris.
     */
    public void setUris(String[] uris) {
        this.uris = uris;
    }
}

