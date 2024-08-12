package com.example.demo.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class SolrService {

    @Autowired
    private SolrClient solrClient;

    @Value("${spring.data.solr.core}")
    private String solrCore;

    public SolrService(@Value("${spring.data.solr.host}") String solrHost) {
        this.solrClient = new HttpSolrClient.Builder(solrHost).build();
    }

    // Apahce Solr 단독 실행 = Delete
    public void deleteDocument(String id) throws Exception {
        System.out.println("현재 넘어온 ID 값은 ? : "+id);
        solrClient.deleteById("test", id);
        solrClient.commit("test");
    }
}