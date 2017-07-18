package jota.dto.response;

/**
 * Response of {@link jota.dto.request.cornodeFindTransactionsRequest}
 **/
public class FindTransactionResponse extends AbstractResponse {

    String[] hashes;


    /**
     * Gets the hashes.
     *
     * @return The hashes.
     */
    public String[] getHashes() {
        return hashes;
    }
}
