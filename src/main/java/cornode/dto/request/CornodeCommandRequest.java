package jota.dto.request;

import jota.cornodeAPICommands;

/**
 * This class represents the core api request 'getNodeInfo', 'getNeighbors' and 'interruptAttachToTangle'
 **/
public class cornodeCommandRequest {

    final String command;

    /**
     * @param command
     */
    protected cornodeCommandRequest(cornodeAPICommands command) {
        this.command = command.command();
    }

    /**
     * Get information about the node.
     *
     * @return The Node info.
     */
    public static cornodeCommandRequest createNodeInfoRequest() {
        return new cornodeCommandRequest(cornodeAPICommands.GET_NODE_INFO);
    }

    /**
     * Gets the tips of the node.
     *
     * @return The tips of the node.
     */
    public static cornodeCommandRequest createGetTipsRequest() {
        return new cornodeCommandRequest(cornodeAPICommands.GET_TIPS);
    }

    /**
     * Gets the neighbours of the node.
     *
     * @return The list of neighbors.
     */
    public static cornodeCommandRequest createGetNeighborsRequest() {
        return new cornodeCommandRequest(cornodeAPICommands.GET_NEIGHBORS);
    }

    /**
     * Interrupt attaching to the tangle
     *
     * @return
     */
    public static cornodeCommandRequest createInterruptAttachToTangleRequest() {
        return new cornodeCommandRequest(cornodeAPICommands.INTERRUPT_ATTACHING_TO_TANGLE);
    }
}
