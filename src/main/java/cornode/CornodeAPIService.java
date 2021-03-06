package jota;

import jota.dto.request.*;
import jota.dto.response.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * cornode API Proxy Service definition using Retrofit2
 *
 * @author davassi
 */
public interface cornodeAPIService {

    String CONTENT_TYPE_HEADER = "Content-Type: application/json";
    String USER_AGENT_HEADER = "User-Agent: JOTA-API wrapper";

    /**
     * Returns information about your node.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getNodeInfo"}'
     *
     * @return a {@code NodeInfoResponse} object, if succesfull.
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetNodeInfoResponse> getNodeInfo(@Body cornodeCommandRequest request);

    /**
     * Get the list of latest tips (unconfirmed transactions).
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getNeighbors"}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetNeighborsResponse> getNeighbors(@Body cornodeCommandRequest request);

    /**
     * Add a list of neighbors to your node.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "addNeighbors", "uris": ["udp://8.8.8.8:14265", "udp://8.8.8.5:14265"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<AddNeighborsResponse> addNeighbors(@Body cornodeNeighborsRequest request);

    /**
     * Removes a list of neighbors to your node.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "removeNeighbors", "uris": ["udp://8.8.8.8:14265", "udp://8.8.8.5:14265"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<RemoveNeighborsResponse> removeNeighbors(@Body cornodeNeighborsRequest request);

    /**
     * Get the list of latest tips (unconfirmed transactions).
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getTips"}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetTipsResponse> getTips(@Body cornodeCommandRequest request);

    /**
     * Find the transactions which match the specified input and return
     * <p>
     * curl http://localhost:14265 \ -X POST \ -H 'Content-Type: application/json' \
     * -d '{"command": "findTransactions", "addresses": ["RVORZ9SIIP9RCYMREUIXXVPQIPHVCNPQ9HZWYKFWYWZRE9JQKG9REPKIASHUUECPSQO9JT9XNMVKWYGVAZETAIRPTM"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<FindTransactionResponse> findTransactions(@Body cornodeFindTransactionsRequest request);


    /**
     * Get the inclusion states of a set of transactions. This is for determining if a transaction was accepted and confirmed by the network or not. You can search for multiple tips (and thus, milestones) to get past inclusion states of transactions.
     * <p>
     * curl http://localhost:14265   -X POST   -H 'Content-Type: application/json'
     * -d '{"command": "getInclusionStates", "transactions"Q9HZWYKFWYWZRE9JQKG9REPKIASHUUECPSQO9JT9XNMVKWYGVAZETAIRPTM"], "tips" : []}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetInclusionStateResponse> getInclusionStates(@Body cornodeGetInclusionStateRequest request);

    /**
     * Returns the raw trytes data of a transaction.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getTrytes", "hashes": ["OAATQS9VQLSXCLDJVJJVYUGONXAXOFMJOZNSYWRZSWECMXAQQURHQBJNLD9IOFEPGZEPEMPXCIVRX9999"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetTrytesResponse> getTrytes(@Body cornodeGetTrytesRequest request);

    /**
     * Tip selection which returns trunkTransaction and branchTransaction. The input value is the latest coordinator milestone, as provided through the getNodeInfo API call.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getTransactionsToApprove", "depth": 27}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetTransactionsToApproveResponse> getTransactionsToApprove(@Body cornodeGetTransactionsToApproveRequest request);

    /**
     * It returns the confirmed balance which a list of addresses have at the latest confirmed milestone.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "getBalances", "addresses": ["HBBYKAKTILIPVUKFOTSLHGENPTXYBNKXZFQFR9VQFWNBMTQNRVOUKPVPRNBSZVVILMAFBKOTBLGLWLOHQ"], "threshold": 100}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetBalancesResponse> getBalances(@Body cornodeGetBalancesRequest request);

    /**
     * Attaches the specified transactions (trytes) to the Tangle by doing Proof of Work.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "attachToTangle", "trunkTransaction": "JVMTDGDPDFYHMZPMWEKKANBQSLSDTIIHAYQUMZOKHXXXGJHJDQPOMDOMNRDKYCZRUFZROZDADTHZC9999", "branchTransaction": "P9KFSJVGSPLXAEBJSHWFZLGP9GGJTIO9YITDEHATDTGAFLPLBZ9FOFWWTKMAZXZHFGQHUOXLXUALY9999", "minWeightMagnitude": 18, "trytes": ["TRYTVALUEHERE"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<GetAttachToTangleResponse> attachToTangle(@Body cornodeAttachToTangleRequest request);

    /**
     * Interrupts and completely aborts the attachToTangle process.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "interruptAttachingToTangle" }
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<InterruptAttachingToTangleResponse> interruptAttachingToTangle(@Body cornodeCommandRequest request);

    /**
     * Broadcast a list of transactions to all neighbors. The input trytes for this call are provided by attachToTangle.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "broadcastTransactions", "trytes": ["BYSWEAUTWXHXZ9YBZISEK9LUHWGMHXCGEVNZHRLUWQFCUSDXZHOFHWHL9MQPVJXXZLIXPXPXF9KYEREFSKCPKYIIKPZVLHUTDFQKKVVBBN9ATTLPCNPJDWDEVIYYLGPZGCWXOBDXMLJC9VO9QXTTBLAXTTBFUAROYEGQIVB9MJWJKXJMCUPTWAUGFZBTZCSJVRBGMYXTVBDDS9MYUJCPZ9YDWWQNIPUAIJXXSNLKUBSCOIJPCLEFPOXFJREXQCUVUMKSDOVQGGHRNILCO9GNCLWFM9APMNMWYASHXQAYBEXF9QRIHIBHYEJOYHRQJAOKAQ9AJJFQ9WEIWIJOTZATIBOXQLBMIJU9PCGBLVDDVFP9CFFSXTDUXMEGOOFXWRTLFGV9XXMYWEMGQEEEDBTIJ9OJOXFAPFQXCDAXOUDMLVYRMRLUDBETOLRJQAEDDLNVIRQJUBZBO9CCFDHIX9MSQCWYAXJVWHCUPTRSXJDESISQPRKZAFKFRULCGVRSBLVFOPEYLEE99JD9SEBALQINPDAZHFAB9RNBH9AZWIJOTLBZVIEJIAYGMC9AZGNFWGRSWAXTYSXVROVNKCOQQIWGPNQZKHUNODGYADPYLZZZUQRTJRTODOUKAOITNOMWNGHJBBA99QUMBHRENGBHTH9KHUAOXBVIVDVYYZMSEYSJWIOGGXZVRGN999EEGQMCOYVJQRIRROMPCQBLDYIGQO9AMORPYFSSUGACOJXGAQSPDY9YWRRPESNXXBDQ9OZOXVIOMLGTSWAMKMTDRSPGJKGBXQIVNRJRFRYEZ9VJDLHIKPSKMYC9YEGHFDS9SGVDHRIXBEMLFIINOHVPXIFAZCJKBHVMQZEVWCOSNWQRDYWVAIBLSCBGESJUIBWZECPUCAYAWMTQKRMCHONIPKJYYTEGZCJYCT9ABRWTJLRQXKMWY9GWZMHYZNWPXULNZAPVQLPMYQZCYNEPOCGOHBJUZLZDPIXVHLDMQYJUUBEDXXPXFLNRGIPWBRNQQZJSGSJTTYHIGGFAWJVXWL9THTPWOOHTNQWCNYOYZXALHAZXVMIZE9WMQUDCHDJMIBWKTYH9AC9AFOT9DPCADCV9ZWUTE9QNOMSZPTZDJLJZCJGHXUNBJFUBJWQUEZDMHXGBPTNSPZBR9TGSKVOHMOQSWPGFLSWNESFKSAZY9HHERAXALZCABFYPOVLAHMIHVDBGKUMDXC9WHHTIRYHZVWNXSVQUWCR9M9RAGMFEZZKZ9XEOQGOSLFQCHHOKLDSA9QCMDGCGMRYJZLBVIFOLBIJPROKMHOYTBTJIWUZWJMCTKCJKKTR9LCVYPVJI9AHGI9JOWMIWZAGMLDFJA9WU9QAMEFGABIBEZNNAL9OXSBFLOEHKDGHWFQSHMPLYFCNXAAZYJLMQDEYRGL9QKCEUEJ9LLVUOINVSZZQHCIKPAGMT9CAYIIMTTBCPKWTYHOJIIY9GYNPAJNUJ9BKYYXSV9JSPEXYMCFAIKTGNRSQGUNIYZCRT9FOWENSZQPD9ALUPYYAVICHVYELYFPUYDTWUSWNIYFXPX9MICCCOOZIWRNJIDALWGWRATGLJXNAYTNIZWQ9YTVDBOFZRKO9CFWRPAQQRXTPACOWCPRLYRYSJARRKSQPR9TCFXDVIXLP9XVL99ERRDSOHBFJDJQQGGGCZNDQ9NYCTQJWVZIAELCRBJJFDMCNZU9FIZRPGNURTXOCDSQGXTQHKHUECGWFUUYS9J9NYQ9U9P9UUP9YMZHWWWCIASCFLCMSKTELZWUGCDE9YOKVOVKTAYPHDF9ZCCQAYPJIJNGSHUIHHCOSSOOBUDOKE9CJZGYSSGNCQJVBEFTZFJ9SQUHOASKRRGBSHWKBCBWBTJHOGQ9WOMQFHWJVEG9NYX9KWBTCAIXNXHEBDIOFO9ALYMFGRICLCKKLG9FOBOX9PDWNQRGHBKHGKKRLWTBEQMCWQRLHAVYYZDIIPKVQTHYTWQMTOACXZOQCDTJTBAAUWXSGJF9PNQIJ9AJRUMUVCPWYVYVARKR9RKGOUHHNKNVGGPDDLGKPQNOYHNKAVVKCXWXOQPZNSLATUJT9AUWRMPPSWHSTTYDFAQDXOCYTZHOYYGAIM9CELMZ9AZPWB9MJXGHOKDNNSZVUDAGXTJJSSZCPZVPZBYNNTUQABSXQWZCHDQSLGK9UOHCFKBIBNETK999999999999999999999999999999999999999999999999999999999999999999999999999999999NOXDXXKUDWLOFJLIPQIBRBMGDYCPGDNLQOLQS99EQYKBIU9VHCJVIPFUYCQDNY9APGEVYLCENJIOBLWNB999999999XKBRHUD99C99999999NKZKEKWLDKMJCI9N9XQOLWEPAYWSH9999999999999999999999999KDDTGZLIPBNZKMLTOLOXQVNGLASESDQVPTXALEKRMIOHQLUHD9ELQDBQETS9QFGTYOYWLNTSKKMVJAUXSIROUICDOXKSYZTDPEDKOQENTJOWJONDEWROCEJIEWFWLUAACVSJFTMCHHXJBJRKAAPUDXXVXFWP9X9999IROUICDOXKSYZTDPEDKOQENTJOWJONDEWROCEJIEWFWLUAACVSJFTMCHHXJBJRKAAPUDXXVXFWP9X9999"]}
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<BroadcastTransactionsResponse> broadcastTransactions(@Body cornodeBroadcastTransactionRequest request);

    /**
     * Store transactions into the local storage. The trytes to be used for this call are returned by attachToTangle.
     * <p>
     * curl http://localhost:14265 -X POST -H 'Content-Type: application/json'
     * -d '{"command": "storeTransactions", "trytes": ["BYSWEAUTWXHXZ9YBZISEK9LUHWGMHXCGEVNZHRLUWQFCUSDXZHOFHWHL9MQPVJXXZLIXPXPXF9KYEREFSKCPKYIIKPZVLHUTDFQKKVVBBN9ATTLPCNPJDWDEVIYYLGPZGCWXOBDXMLJC9VO9QXTTBLAXTTBFUAROYEGQIVB9MJWJKXJMCUPTWAUGFZBTZCSJVRBGMYXTVBDDS9MYUJCPZ9YDWWQNIPUAIJXXSNLKUBSCOIJPCLEFPOXFJREXQCUVUMKSDOVQGGHRNILCO9GNCLWFM9APMNMWYASHXQAYBEXF9QRIHIBHYEJOYHRQJAOKAQ9AJJFQ9WEIWIJOTZATIBOXQLBMIJU9PCGBLVDDVFP9CFFSXTDUXMEGOOFXWRTLFGV9XXMYWEMGQEEEDBTIJ9OJOXFAPFQXCDAXOUDMLVYRMRLUDBETOLRJQAEDDLNVIRQJUBZBO9CCFDHIX9MSQCWYAXJVWHCUPTRSXJDESISQPRKZAFKFRULCGVRSBLVFOPEYLEE99JD9SEBALQINPDAZHFAB9RNBH9AZWIJOTLBZVIEJIAYGMC9AZGNFWGRSWAXTYSXVROVNKCOQQIWGPNQZKHUNODGYADPYLZZZUQRTJRTODOUKAOITNOMWNGHJBBA99QUMBHRENGBHTH9KHUAOXBVIVDVYYZMSEYSJWIOGGXZVRGN999EEGQMCOYVJQRIRROMPCQBLDYIGQO9AMORPYFSSUGACOJXGAQSPDY9YWRRPESNXXBDQ9OZOXVIOMLGTSWAMKMTDRSPGJKGBXQIVNRJRFRYEZ9VJDLHIKPSKMYC9YEGHFDS9SGVDHRIXBEMLFIINOHVPXIFAZCJKBHVMQZEVWCOSNWQRDYWVAIBLSCBGESJUIBWZECPUCAYAWMTQKRMCHONIPKJYYTEGZCJYCT9ABRWTJLRQXKMWY9GWZMHYZNWPXULNZAPVQLPMYQZCYNEPOCGOHBJUZLZDPIXVHLDMQYJUUBEDXXPXFLNRGIPWBRNQQZJSGSJTTYHIGGFAWJVXWL9THTPWOOHTNQWCNYOYZXALHAZXVMIZE9WMQUDCHDJMIBWKTYH9AC9AFOT9DPCADCV9ZWUTE9QNOMSZPTZDJLJZCJGHXUNBJFUBJWQUEZDMHXGBPTNSPZBR9TGSKVOHMOQSWPGFLSWNESFKSAZY9HHERAXALZCABFYPOVLAHMIHVDBGKUMDXC9WHHTIRYHZVWNXSVQUWCR9M9RAGMFEZZKZ9XEOQGOSLFQCHHOKLDSA9QCMDGCGMRYJZLBVIFOLBIJPROKMHOYTBTJIWUZWJMCTKCJKKTR9LCVYPVJI9AHGI9JOWMIWZAGMLDFJA9WU9QAMEFGABIBEZNNAL9OXSBFLOEHKDGHWFQSHMPLYFCNXAAZYJLMQDEYRGL9QKCEUEJ9LLVUOINVSZZQHCIKPAGMT9CAYIIMTTBCPKWTYHOJIIY9GYNPAJNUJ9BKYYXSV9JSPEXYMCFAIKTGNRSQGUNIYZCRT9FOWENSZQPD9ALUPYYAVICHVYELYFPUYDTWUSWNIYFXPX9MICCCOOZIWRNJIDALWGWRATGLJXNAYTNIZWQ9YTVDBOFZRKO9CFWRPAQQRXTPACOWCPRLYRYSJARRKSQPR9TCFXDVIXLP9XVL99ERRDSOHBFJDJQQGGGCZNDQ9NYCTQJWVZIAELCRBJJFDMCNZU9FIZRPGNURTXOCDSQGXTQHKHUECGWFUUYS9J9NYQ9U9P9UUP9YMZHWWWCIASCFLCMSKTELZWUGCDE9YOKVOVKTAYPHDF9ZCCQAYPJIJNGSHUIHHCOSSOOBUDOKE9CJZGYSSGNCQJVBEFTZFJ9SQUHOASKRRGBSHWKBCBWBTJHOGQ9WOMQFHWJVEG9NYX9KWBTCAIXNXHEBDIOFO9ALYMFGRICLCKKLG9FOBOX9PDWNQRGHBKHGKKRLWTBEQMCWQRLHAVYYZDIIPKVQTHYTWQMTOACXZOQCDTJTBAAUWXSGJF9PNQIJ9AJRUMUVCPWYVYVARKR9RKGOUHHNKNVGGPDDLGKPQNOYHNKAVVKCXWXOQPZNSLATUJT9AUWRMPPSWHSTTYDFAQDXOCYTZHOYYGAIM9CELMZ9AZPWB9MJXGHOKDNNSZVUDAGXTJJSSZCPZVPZBYNNTUQABSXQWZCHDQSLGK9UOHCFKBIBNETK999999999999999999999999999999999999999999999999999999999999999999999999999999999NOXDXXKUDWLOFJLIPQIBRBMGDYCPGDNLQOLQS99EQYKBIU9VHCJVIPFUYCQDNY9APGEVYLCENJIOBLWNB999999999XKBRHUD99C99999999NKZKEKWLDKMJCI9N9XQOLWEPAYWSH9999999999999999999999999KDDTGZLIPBNZKMLTOLOXQVNGLASESDQVPTXALEKRMIOHQLUHD9ELQDBQETS9QFGTYOYWLNTSKKMVJAUXSIROUICDOXKSYZTDPEDKOQENTJOWJONDEWROCEJIEWFWLUAACVSJFTMCHHXJBJRKAAPUDXXVXFWP9X9999IROUICDOXKSYZTDPEDKOQENTJOWJONDEWROCEJIEWFWLUAACVSJFTMCHHXJBJRKAAPUDXXVXFWP9X9999"]}'
     */
    @Headers({CONTENT_TYPE_HEADER, USER_AGENT_HEADER})
    @POST("./")
    Call<StoreTransactionsResponse> storeTransactions(@Body cornodeStoreTransactionsRequest request);
}
