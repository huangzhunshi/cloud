package com.zuul.bootc.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import com.netflix.discovery.provider.Serializer;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;

public class DemoApp {
    public static void main(String[] arg) throws IOException {
//        System.out.println("xxxx");
        //createUserIndex();
        //delUserIndex();
        //addUserDoc();
        //updateUserDoc();
        //delUserDoc();
        //getUserDoc();
        //searchUserDoc();
        pageUserDocList();
    }


    /**
     * 分页查询
     * @throws IOException
     */
    public static void pageUserDocList() throws IOException {
        int pageNumber=1;
        int pageSize=10;

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.queryStringQuery("白"));
        searchSourceBuilder.from((pageNumber - 1) * pageSize);//设置起始页
        searchSourceBuilder.size(pageSize);//设置页大小
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("user")// 索引名称
                .build();
        JestClient jestClient=getJestClient();

        JestResult result = jestClient.execute(search);
        List<User> userList=result.getSourceAsObjectList(User.class);

        System.out.println(result.getJsonString());
        for (User u:userList) {

            System.out.println(u.getUserName());
        }
    }

    /**
     * 搜索文档
     * @throws IOException
     */
    public static void searchUserDoc() throws IOException {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder
                .should(QueryBuilders.fuzzyQuery("userName", "白")
                );

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);


        Search search = new Search.Builder(searchSourceBuilder.toString()).
                addIndex("user").addType("abuser").build();

        JestClient jestClient=getJestClient();
        JestResult result=jestClient.execute(search);
        List<User> userList=result.getSourceAsObjectList(User.class);

        System.out.println(userList.size());
        for (User u:userList) {

            System.out.println(u.getUserName());
        }
    }

    /**
     * 根据id获取用户实体
     * @throws IOException
     */
    public static void getUserDoc() throws IOException {
        Get get = new Get.Builder("user","6").build();

        JestClient jestClient=getJestClient();
        JestResult result = jestClient.execute(get);
        User user= result.getSourceAsObject(User.class);
        System.out.println(user.getUserName());
    }


    /**
     * 根据id删除
     * @throws IOException
     */
    public static void delUserDoc() throws IOException {
        Delete.Builder builder = new Delete.Builder("14beH2MBh4p7QWFiMYj9").index("user").type("abuser");
        JestClient jestClient=getJestClient();
        JestResult result = jestClient.execute(builder.build());

    }


    /**
     * 修改user-doc
     */
    public static void updateUserDoc() throws IOException {
        Bulk.Builder builder = new Bulk.Builder();

        User user=new User();
        user.setUserId(5);
        user.setUserName("修改后11");
        JSONObject doc = new JSONObject();
        doc.put("doc", user);

        Update update = new Update.Builder(doc)
                    .index("user")
                    .type("abuser")
                    .id(user.getUserId().toString())
                    .build();
        builder.addAction(update);

        JestClient jestClient=getJestClient();
        JestResult result = jestClient.execute(builder.build());

    }

    /**
     * 新增user-doc (如果id存在，走的是修改逻辑)
     * @throws IOException
     */
    private static void addUserDoc() throws IOException {

        User user=new User();
        user.setUserId(6);
        user.setUserName("小白");

        Bulk.Builder builder = new Bulk.Builder();
        Index index = new Index.Builder(user)
                    .index("user")
                    .type("abuser")
                    .build();

        builder.addAction(index);
        JestClient jestClient=getJestClient();
        JestResult result = jestClient.execute(builder.build());



    }


    /**
     * 删除用户索引
     * @throws IOException
     */
    private static void delUserIndex() throws IOException {
        DeleteIndex deleteIndex=new DeleteIndex.Builder("user").build();

        JestClient jestClient=getJestClient();
        jestClient.execute(deleteIndex);
    }


    /**
     * 新增用户索引
     */
    private static void createUserIndex() throws IOException {
       CreateIndex createIndex=   new CreateIndex.Builder("user").build();

       JestClient jestClient=getJestClient();
       jestClient.execute(createIndex);
    }

    /**
     *返回 JestClient 客户端
     * @return
     */
    public static JestClient getJestClient() {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ss").create())
                .connTimeout(2500)
                .readTimeout(3000)
                .multiThreaded(true)
                .build());
        return factory.getObject();
    }



    public class Shop {
        private Integer shopId;
        private String shopName;
        private Integer type;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
