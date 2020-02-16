package x.test.model;

public class ReqParam {

    public String reqId;

    public String name;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReqParam{" +
                "reqId='" + reqId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
