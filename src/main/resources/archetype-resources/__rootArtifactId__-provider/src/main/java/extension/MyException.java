package ${package}.extension;

/**
 * Created by donh on 2018/11/6.
 */
public class MyException extends RuntimeException {

    private String code;
    private String msg;
    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}