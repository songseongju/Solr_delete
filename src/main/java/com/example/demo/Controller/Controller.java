package com.example.demo.Controller;

import com.example.demo.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solr")
public class Controller {
    @Autowired
    private SolrService solrService;

    // Apahce Solr 단독 실행 = Delete
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable String id) {
        try {
            solrService.deleteDocument(id.trim());
            return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
