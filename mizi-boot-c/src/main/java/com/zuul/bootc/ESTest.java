package com.zuul.bootc;


import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.BulkResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;



import java.io.IOException;

import java.util.Collections;



public class ESTest {
    public static void main(String arg[]) throws Exception {
//        for (String a:arg
//             ) {
//            System.out.println(a);
//        }
        System.out.println(arg[0]);
       // System.out.println("xxxx001");

    }

    public static void search() throws IOException {
        Search.Builder builder=new Search.Builder("子");
        JestClient jestClient=getJestClient();
        jestClient.execute(builder.build());

    }

    /**
     * jest 添加数据demo
     * @throws IOException
     */
    private static void jestAddDataTest() throws IOException {

        JestClient jestClient=getJestClient();
        Bulk.Builder bulkBuilder = new Bulk.Builder();

        Message message=new Message();
        message.setMessage("皇子");
        message.setStatus(1);
        Index index = new Index.Builder(message).index("haha")
                .type("haha").build();

        bulkBuilder.addAction(index);

        jestClient.execute(bulkBuilder.build());

        jestClient.close();

    }

    /**
     *
     * @return
     */
    public static JestClient getJestClient() {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss").create())
                .connTimeout(1500)
                .readTimeout(3000)
                .multiThreaded(true)
                .build());
        return factory.getObject();
    }


    /**
     * 查询所有数据
     * @throws Exception
     */
    public static void queryAll() throws Exception {
        String method = "POST";
        String endpoint = "/test-index/test/_search";
        HttpEntity entity = new NStringEntity("{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}", ContentType.APPLICATION_JSON);
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestClient restClient  =builder.build();
        Response response = restClient.performRequest(method,endpoint,Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /**
     * 获取文档
     * @throws Exception
     */
    public static void getDocument()throws Exception{
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestClient restClient  =builder.build();
        String method = "GET";
        String endpoint = "/test-index/test/1";
        Response response = restClient.performRequest(method,endpoint);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /**
     * 创建文档
     * @throws Exception
     */
    public static void createDocument()throws Exception{
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        RestClient restClient  =builder.build();

        String method = "PUT";
        String endpoint = "/test-index/test/1";
        HttpEntity entity = new NStringEntity(
                "{\n" +
                        "    \"user\" : \"kimchy\",\n" +
                        "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                        "    \"message\" : \"trying out Elasticsearch\"\n" +
                        "}", ContentType.APPLICATION_JSON);

        Response response = restClient.performRequest(method,endpoint, Collections.<String, String>emptyMap(),entity);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


    /**
     * 创建索引
     * @throws IOException
     */
    public static void createIndex() throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        String method = "PUT";
        String endpoint = "/test-index";
        RestClient restClient  =builder.build();
        Response response = restClient.performRequest(method,endpoint);
    }
}
