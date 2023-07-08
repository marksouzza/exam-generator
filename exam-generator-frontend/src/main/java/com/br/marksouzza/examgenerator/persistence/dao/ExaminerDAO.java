package com.br.marksouzza.examgenerator.persistence.dao;

import com.br.marksouzza.examgenerator.persistence.model.Examiner;
import com.br.marksouzza.examgenerator.util.JsonUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.io.Serializable;

public class ExaminerDAO implements Serializable {
    private final String BASE_URL = "http://localhost:8081/v1/examiner";
    private final JsonUtil jsonUtil;

    @Inject
    public ExaminerDAO(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

    public Examiner getExaminerById(Long id){
        ResponseEntity<Examiner> examinerEntity = new RestTemplate().exchange(BASE_URL + "/1", HttpMethod.GET, new HttpEntity<>(jsonUtil.createTokenizedHeader()), Examiner.class);
        Examiner examiner = examinerEntity.getBody();
        return examiner;
    }
}
