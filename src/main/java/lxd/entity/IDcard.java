package lxd.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDcard {

    String identity;
    Date beginDate;
    String handlerAddr;
    int expiry;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getHandlerAddr() {
        return handlerAddr;
    }

    public void setHandlerAddr(String handlerAddr) {
        this.handlerAddr = handlerAddr;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String toString() {
        return "IDcard{" +
                "identity='" + identity + '\'' +
                ", beginDate=" + dateFormat.format(beginDate) +
                ", handlerAddr='" + handlerAddr + '\'' +
                ", expiry=" + expiry +
                '}';
    }
}
