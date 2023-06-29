import com.br.marksouzza.examgenerator.persistence.dao.LoginDAO;
import com.br.marksouzza.examgenerator.persistence.model.Token;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexBean implements Serializable {
    private String message = "Working =)";
    private final LoginDAO loginDAO;

    @Inject
    public IndexBean(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public void login() {
        Token token = loginDAO.loginReturningToken("mark", "password");
        System.out.println(token);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
