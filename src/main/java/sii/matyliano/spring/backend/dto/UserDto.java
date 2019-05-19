package sii.matyliano.spring.backend.dto;



import org.hibernate.validator.constraints.NotEmpty;
import sii.matyliano.spring.backend.validator.ValidEmail;

import javax.validation.constraints.AssertTrue;


public class UserDto {


    @NotEmpty
    private String username;


    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @ValidEmail
    @NotEmpty
    private String email;

    @ValidEmail
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
