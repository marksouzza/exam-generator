package com.br.marksouzza.examgenerator.persistence.model;

public class Examiner extends AbstractEntity {

    //    @NotEmpty(message = "Field name cannot be empty")
    private String name;

    //    @Email(message = "This email is not valid")
    //    @NotEmpty(message = "Field email cannot be empty")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
