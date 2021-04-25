package main.controllers.responses;

public class UserRequest {

    private String login;

    public UserRequest() {
    }

    public UserRequest(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
