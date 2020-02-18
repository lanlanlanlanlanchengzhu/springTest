package x.test.constants;

public enum LogTypeEnum {
    LOG_TYPE_BIZA("bizALogger"), LOG_TYPE_BIZB("bizBLogger");

    private String logType;

    LogTypeEnum(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }
}
