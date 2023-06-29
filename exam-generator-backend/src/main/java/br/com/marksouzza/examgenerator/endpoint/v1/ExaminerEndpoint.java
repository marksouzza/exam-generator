package br.com.marksouzza.examgenerator.endpoint.v1;

import br.com.marksouzza.examgenerator.persistence.model.Examiner;
import br.com.marksouzza.examgenerator.persistence.repository.ExaminerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/examiner")
public class ExaminerEndpoint {
    private final ExaminerRepository examinerRepository;

    @Autowired
    public ExaminerEndpoint(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Find examiner by his ID", description = "this is a note =)")
    public ResponseEntity<?> getExaminerById(@PathVariable long id) {
        System.out.println("here");
        Examiner examiner = examinerRepository.findById(id).get();
        return new ResponseEntity<>(examiner, HttpStatus.OK);
    }
}
