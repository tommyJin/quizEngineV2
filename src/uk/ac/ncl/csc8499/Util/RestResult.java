package uk.ac.ncl.csc8499.Util;

/**
 * Created by tommy on 2016/5/8.
 */
public class RestResult {
    /**
     * request successful code
     */
    public static final int OK = 200;

    /**
     * request error code
     */
    public static final int BAD_REQUEST = 400;

    /**
     * unlogin
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * server error code
     */
    public static final int INTERNAL_SERVER_ERROR = 500;


    /**
     * state code
     */
    private int status;

    /**
     * data
     */
    private Object data;

    /**
     * @param status state code
     * @param data
     */
    private RestResult(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * request successfully
     * @param data
     * @return
     */
    public static RestResult ok(Object data) {
        return new RestResult(OK, data);
    }

    public static RestResult error(Object data) {
        return new RestResult(BAD_REQUEST, data);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
