package model;

public enum WebServiceEndpoints {
    STATUS("http://localhost:8080/api/status"),
    TRADE("https://restful-booker.herokuapp.com/auth");

    private final String url;

    WebServiceEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
