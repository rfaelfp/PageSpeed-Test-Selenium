package automation;

public class Modelo {

    private String resultMobile;
    private String resultDesktop;
    private String site;

    public Modelo() {

    }

    public Modelo(String resultMobile, String resultDesktop, String site) {
        this.resultMobile = resultMobile;
        this.resultDesktop = resultDesktop;
        this.site = site;
    }

    public void setResultMobile(String resultMobile) {
        this.resultMobile = resultMobile;
    }

    public String getResultMobile() {
        return this.resultMobile;
    }

    public void setResultDesktop(String resultDesktop) {
        this.resultDesktop = resultDesktop;
    }

    public String getResultDesktop() {
        return this.resultDesktop;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return this.site;
    }

}
