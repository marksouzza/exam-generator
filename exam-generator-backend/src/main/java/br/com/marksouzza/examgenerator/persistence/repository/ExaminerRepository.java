package br.com.marksouzza.examgenerator.persistence.repository;

import br.com.marksouzza.examgenerator.persistence.model.Examiner;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExaminerRepository extends PagingAndSortingRepository<Examiner, Long> {
    Examiner findByEmail(String email);
}
