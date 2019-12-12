package caio.systems.argonlight;

public class BillingClass {
    private int msgIcon;
    private String billCode;
    private String status;

    public BillingClass(int msgIcon, String billCode, String status) {
        this.msgIcon = msgIcon;
        this.billCode = billCode;
        this.status = status;
    }

    public int getMsgIcon() {
        return msgIcon;
    }

    public void setMsgIcon(int msgIcon) {
        this.msgIcon = msgIcon;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "COD: " + this.billCode;
    }
}
