package jota;

import jota.dto.request.*;
import jota.dto.response.*;
import jota.error.InvalidTrytesException;
import jota.utils.InputValidator;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * This class provides access to the cornode core API
 *
 * @author Adrian
 */
public class cornodeAPICore {

    private static final Logger log = LoggerFactory.getLogger(cornodeAPICore.class);

    private cornodeAPIService service;
    private String protocol, host, port;

    /**
     * Build the API core.
     *
     * @param builder The builder.
     */
    protected cornodeAPICore(final Builder builder) {
        protocol = builder.protocol;
        host = builder.host;
        port = builder.port;
        postConstruct();
    }

    /**
     * @param call
     * @param <T>
     * @return
     */
    protected static <T> Response<T> wrapCheckedException(final Call<T> call) {
        try {
            final Response<T> res = call.execute();
            if (res.code() == 400) {
                throw new IllegalAccessError("400 " + res.errorBody().string());
            } else if (res.code() == 401) {
                throw new IllegalAccessError("401 " + res.errorBody().string());
            } else if (res.code() == 500) {
                throw new IllegalAccessError("500 " + res.errorBody().string());
            }
            return res;
        } catch (IOException e) {
            log.error("Execution of the API call raised exception. cornode Node not reachable?", e);
            throw new IllegalStateException(e.getMessage());
        }
    }

    /**
     * @param env
     * @param def
     * @return
     */
    private static String env(String env, String def) {
        final String value = System.getenv(env);
        if (value == null) {
            log.warn("Environment variable '{}' is not defined, and actual value has not been specified. "
                    + "Rolling back to default value: '{}'", env, def);
            return def;
        }
        return value;
    }

    /**
     *
     */
    private void postConstruct() {

        final String nodeUrl = protocol + "://" + host + ":" + port;

        final OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.SECONDS)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(nodeUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(cornodeAPIService.class);

        log.debug("Jota-API Java proxy pointing to node url: '{}'", nodeUrl);
    }

    public GetNodeInfoResponse getNodeInfo() {
        final Call<GetNodeInfoResponse> res = service.getNodeInfo(cornodeCommandRequest.createNodeInfoRequest());
        return wrapCheckedException(res).body();
    }

    public GetNeighborsResponse getNeighbors() {
        final Call<GetNeighborsResponse> res = service.getNeighbors(cornodeCommandRequest.createGetNeighborsRequest());
        return wrapCheckedException(res).body();
    }

    public AddNeighborsResponse addNeighbors(String... uris) {
        final Call<AddNeighborsResponse> res = service.addNeighbors(cornodeNeighborsRequest.createAddNeighborsRequest(uris));
        return wrapCheckedException(res).body();
    }

    public RemoveNeighborsResponse removeNeighbors(String... uris) {
        final Call<RemoveNeighborsResponse> res = service.removeNeighbors(cornodeNeighborsRequest.createRemoveNeighborsRequest(uris));
        return wrapCheckedException(res).body();
    }

    public GetTipsResponse getTips() {
        final Call<GetTipsResponse> res = service.getTips(cornodeCommandRequest.createGetTipsRequest());
        return wrapCheckedException(res).body();
    }

    public FindTransactionResponse findTransactions(String[] addresses, String[] tags, String[] approvees, String[] bundles) {

        final cornodeFindTransactionsRequest findTransRequest = cornodeFindTransactionsRequest
                .createFindTransactionRequest()
                .byAddresses(addresses)
                .byTags(tags)
                .byApprovees(approvees)
                .byBundles(bundles);

        final Call<FindTransactionResponse> res = service.findTransactions(findTransRequest);
        return wrapCheckedException(res).body();
    }

    public FindTransactionResponse findTransactionsByAddresses(final String... addresses) {
        return findTransactions(addresses, null, null, null);
    }

    public FindTransactionResponse findTransactionsByBundles(final String... bundles) {
        return findTransactions(null, null, null, bundles);
    }

    public FindTransactionResponse findTransactionsByApprovees(final String... approvees) {
        return findTransactions(null, null, approvees, null);
    }

    public FindTransactionResponse findTransactionsByDigests(final String... digests) {
        return findTransactions(null, digests, null, null);
    }

    public GetInclusionStateResponse getInclusionStates(String[] transactions, String[] tips) {
        final Call<GetInclusionStateResponse> res = service.getInclusionStates(cornodeGetInclusionStateRequest
                .createGetInclusionStateRequest(transactions, tips));
        return wrapCheckedException(res).body();
    }

    public GetTrytesResponse getTrytes(String... hashes) {
        final Call<GetTrytesResponse> res = service.getTrytes(cornodeGetTrytesRequest.createGetTrytesRequest(hashes));
        return wrapCheckedException(res).body();
    }

    public GetTransactionsToApproveResponse getTransactionsToApprove(Integer depth) {
        final Call<GetTransactionsToApproveResponse> res = service.getTransactionsToApprove(cornodeGetTransactionsToApproveRequest.createcornodeGetTransactionsToApproveRequest(depth));
        return wrapCheckedException(res).body();
    }

    public GetBalancesResponse getBalances(Integer threshold, String[] addresses) {
        final Call<GetBalancesResponse> res = service.getBalances(cornodeGetBalancesRequest.createcornodeGetBalancesRequest(threshold, addresses));
        return wrapCheckedException(res).body();
    }

    public GetBalancesResponse getBalances(Integer threshold, List<String> addresses) {
        return getBalances(threshold, addresses.toArray(new String[]{}));
    }

    public InterruptAttachingToTangleResponse interruptAttachingToTangle() {
        final Call<InterruptAttachingToTangleResponse> res = service.interruptAttachingToTangle(cornodeCommandRequest.createInterruptAttachToTangleRequest());
        return wrapCheckedException(res).body();
    }

    public GetAttachToTangleResponse attachToTangle(String trunkTransaction, String branchTransaction, Integer minWeightMagnitude, String... trytes) throws InvalidTrytesException {
        if (!InputValidator.isArrayOfTrytes(trytes)) {
            throw new InvalidTrytesException();
        }

        final Call<GetAttachToTangleResponse> res = service.attachToTangle(cornodeAttachToTangleRequest.createAttachToTangleRequest(trunkTransaction, branchTransaction, minWeightMagnitude, trytes));
        return wrapCheckedException(res).body();
    }

    public StoreTransactionsResponse storeTransactions(String... trytes) {
        final Call<StoreTransactionsResponse> res = service.storeTransactions(cornodeStoreTransactionsRequest.createStoreTransactionsRequest(trytes));
        return wrapCheckedException(res).body();
    }

    public BroadcastTransactionsResponse broadcastTransactions(String... trytes) {
        final Call<BroadcastTransactionsResponse> res = service.broadcastTransactions(cornodeBroadcastTransactionRequest.createBroadcastTransactionsRequest(trytes));
        return wrapCheckedException(res).body();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends Builder<T>> {

        String protocol, host, port;

        public cornodeAPICore build() {

            if (protocol == null || host == null || port == null) {

                // check properties files.
                if (!checkPropertiesFiles()) {

                    // last resort: best effort on enviroment variable,
                    // before assigning default values.
                    checkEnviromentVariables();
                }
            }

            return new cornodeAPICore(this);
        }

        /**
         * @return
         */
        private boolean checkPropertiesFiles() {

            try {

                FileReader fileReader = new FileReader("node_config.properties");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                final Properties nodeConfig = new Properties();
                nodeConfig.load(bufferedReader);

                if (nodeConfig.getProperty("cornode.node.protocol") != null) {
                    protocol = nodeConfig.getProperty("cornode.node.protocol");
                }

                if (nodeConfig.getProperty("cornode.node.host") != null) {
                    host = nodeConfig.getProperty("cornode.node.host");
                }

                if (nodeConfig.getProperty("cornode.node.port") != null) {
                    port = nodeConfig.getProperty("cornode.node.port");
                }

            } catch (IOException e1) {
                log.debug("node_config.properties not found. Rolling back for another solution...");
            }
            return (port != null && protocol != null && host != null);
        }

        /**
         *
         */
        private void checkEnviromentVariables() {
            protocol = env("cornode_NODE_PROTOCOL", "http");
            host = env("cornode_NODE_HOST", "localhost");
            port = env("cornode_NODE_PORT", "14265");
        }

        /**
         * @param host
         * @return
         */
        public T host(String host) {
            this.host = host;
            return (T) this;
        }

        /**
         * @param port
         * @return
         */
        public T port(String port) {
            this.port = port;
            return (T) this;
        }

        /**
         * @param protocol
         * @return
         */
        public T protocol(String protocol) {
            this.protocol = protocol;
            return (T) this;
        }

    }
}
