package x.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import x.test.annotion.TestConstrain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqParam {

    /**
     * 请求流水号
     */
    @TestConstrain(message = "自定义校验")
    private String reqId;

    /**
     * 请求来源
     */
    private String sourceName;

    /**
     * 来源IP
     */
    @Pattern(regexp = "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$")
    public String sourceIp;

}
