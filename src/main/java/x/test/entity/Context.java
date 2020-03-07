package x.test.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class Context {

    public String reqId;

    public int count;

    public Map<String, Object> known;

}
