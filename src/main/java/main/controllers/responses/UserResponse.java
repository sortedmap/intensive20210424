package main.controllers.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String login;
    private boolean result;

    public UserResponse(boolean result) {
        this.result = result;
    }

    public UserResponse(String login, boolean result) {
        this.login = login;
        this.result = result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
