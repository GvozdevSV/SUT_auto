package api;

import java.util.Date;

public class ErrorLogin {
    public int status;
    public String message;
    public Object context;
    public Date timestamp;

    public ErrorLogin(int status, String message, Object context, Date timestamp) {
        this.status = status;
        this.message = message;
        this.context = context;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getContext() {
        return context;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ErrorLogin(){

    }
}
