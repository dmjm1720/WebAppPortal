package mx.dao;

public class ImpuestoRetenido {

    private String ret106667;
    private String ret012500;

    public ImpuestoRetenido() {
    }

    public ImpuestoRetenido(String ret106667, String ret012500) {
        this.ret106667 = ret106667;
        this.ret012500 = ret012500;
    }

    public String getRet106667() {
        return ret106667;
    }

    public void setRet106667(String ret106667) {
        this.ret106667 = ret106667;
    }

    public String getRet012500() {
        return ret012500;
    }

    public void setRet012500(String ret012500) {
        this.ret012500 = ret012500;
    }

}
