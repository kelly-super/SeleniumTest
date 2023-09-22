package PageObjects;

public class GlobalObject {
    private String browser;
    private String url;
    private String userEmail;
    private String password;

    public void setBrowser(String browser){
        this.browser = browser;
    }
    public String getBrowser(){
        return this.browser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
