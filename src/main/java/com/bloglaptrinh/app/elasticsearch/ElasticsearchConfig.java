package com.bloglaptrinh.app.elasticsearch;


import com.bloglaptrinh.app.model.Document;
import com.bloglaptrinh.app.prop.ConfigProps;
import com.google.gson.Gson;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import static org.elasticsearch.index.query.QueryBuilders.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
public class ElasticsearchConfig {

    private final ConfigProps props;
    private final Gson gson;

    public ElasticsearchConfig(ConfigProps props, Gson gson) {
        this.props = props;
        this.gson = gson;
    }

    public Client getClient(){
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        return client;
    }

    public static void main(String[] args) throws IOException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));




        //index(client);
        get(client);
        search(client);

        client.close();
    }

    public static void index(Client client) throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();

        String json = Strings.toString(builder);
        IndexResponse response = client.prepareIndex("twitter", "_doc")
                .setSource(json, XContentType.JSON)
                .get();


        String _index = response.getIndex();
        String _type = response.getType();
        String _id = response.getId();
        long _version = response.getVersion();
        RestStatus status = response.status();





        IndexResponse response2 = client.prepareIndex("twitter", "_doc", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "quanghoa")
                        .field("postDate", new Date())
                        .field("message", "trying out Quanghoa")
                        .endObject()
                )
                .get();

        String _index1 = response2.getIndex();
        String _type1 = response2.getType();
        String _id1 = response2.getId();
        long _version1 = response2.getVersion();
        RestStatus status1 = response2.status();
    }

    public static void get(Client client){
        GetResponse response = client.prepareGet("twitter", "_doc", "1").get();
        System.out.println(response.getSourceAsString());
    }

    public static void search(Client client){
        QueryBuilder qb = termQuery("user", "kimchy");

        SearchResponse scrollResp = client.prepareSearch("twitter")
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(new TimeValue(60000))
                .setQuery(qb)
                .setSize(100).get(); //max of 100 hits will be returned for each scroll
//Scroll until no hits are returned
        do {
            for (SearchHit hit : scrollResp.getHits().getHits()) {
                //Handle the hit...
                hit.docId();

                String a = hit.getSourceAsString();
            }

            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        } while (scrollResp.getHits().getHits().length != 0);
    }

    public String createIndex(Client client, Document document){

        try {
            IndexRequest request = new IndexRequest(props.getIndex().getName(), props.getIndex().getType());
            request.source(gson.toJson(document), XContentType.JSON);
            IndexResponse response = (IndexResponse) client.index(request);
            return response.getId();
        } catch (Exception ex) {
        }

        return null;
    }
}
