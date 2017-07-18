package jota.dto.response;

/**
 * Response of {@link jota.dto.request.cornodeStoreTransactionsRequest}
 **/
public class StoreTransactionsResponse extends AbstractResponse {

    /**
     * Initializes a new instance of the StoreTransactionsResponse class.
     */
    public StoreTransactionsResponse(long duration) {
        setDuration(duration);
    }
}

