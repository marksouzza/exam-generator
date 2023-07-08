import com.br.marksouzza.examgenerator.persistence.dao.ExaminerDAO;
import com.br.marksouzza.examgenerator.persistence.dao.LoginDAO;
import com.br.marksouzza.examgenerator.persistence.model.support.Token;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexBean implements Serializable {
    private String message = "Working =)";
    private final LoginDAO loginDAO;
    private final ExaminerDAO examinerDAO;

    @Inject
    public IndexBean(LoginDAO loginDAO, ExaminerDAO examinerDAO) {
        this.loginDAO = loginDAO;
        this.examinerDAO = examinerDAO;
    }

    public void login() {
        Token token = loginDAO.loginReturningToken("mark", "password");
        System.out.println(token);
    }

    public void checkExaminer() {
        examinerDAO.getExaminerById(1L);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
