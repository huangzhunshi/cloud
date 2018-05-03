package com.zuul.bootc.elasticsearch;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.PutMapping;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j(topic = "monitor")
public class ESHelper {
    @Autowired
    private JestClient jestClient;

    /**
     * 创建索引
     *
     * @return JestResult
     */
    protected JestResult buildIndex(CreateIndex createIndex, String indexName) {
        try {
            JestResult result = jestClient.execute(createIndex);
            return result;
        } catch (IOException e) {
            log.error("[ElasticSearch]创建索引失败，索引名称：{},异常如下\n：{}", indexName, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建映射
     *
     * @return JestResult
     */
    protected JestResult putMapping(PutMapping putMapping, String indexName, String indexType) {
        try {
            JestResult result = jestClient.execute(putMapping);
            return result;
        } catch (IOException e) {
            log.error("[ElasticSearch]创建映射失败，索引名称：{}，索引类型：{},异常如下\n：{}", indexName, indexType, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传文档
     *
     * @return JestResult
     */
    protected JestResult buildDocument(Bulk.Builder builder, String indexName, String indexType) {
        try {
            JestResult result = jestClient.execute(builder.build());
            return result;
        } catch (IOException e) {
            log.error("[ElasticSearch]批量上传文档失败，索引名称：{}，索引类型：{},异常如下\n：{}", indexName, indexType, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新文档
     *
     * @return JestResult
     */
    protected JestResult updateDocuments(Bulk.Builder builder, String indexName, String indexType) {
        try {
            JestResult result = jestClient.execute(builder.build());
            return result;
        } catch (IOException e) {
            log.error("[ElasticSearch]批量更新文档失败，索引名称：{}，索引类型：{},异常如下\n：{}", indexName, indexType, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询文档
     *
     * @return JestResult
     */
    protected SearchResult searchDocuments(SearchSourceBuilder searchSourceBuilder, String indexName, String indexType) {
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(indexType)
                .build();
        try {
            SearchResult result = jestClient.execute(search);
            return result;
        } catch (IOException e) {
            log.error("[ElasticSearch]搜索异常，索引名称：{}，索引类型：{},异常如下\n：{}", indexName, indexType, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从json文件中读取json数据
     *
     * @return String
     */
   /* public String getMappingSource(Resource resource) {
        StringBuilder message = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }
        } catch (IOException e) {
            throw BizException.create(e.getMessage());
        }
        return message.toString();
    }*/

    public int getQueryTotal(JestResult result){
        JsonObject jsonObject = result.getJsonObject();
        jsonObject = jsonObject.getAsJsonObject("hits");
        JsonElement jsonElement = jsonObject.get("total");
        return jsonElement.getAsInt();
    }
}
