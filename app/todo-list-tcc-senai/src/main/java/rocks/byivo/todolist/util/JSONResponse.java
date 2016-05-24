package rocks.byivo.todolist.util;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

public class JSONResponse<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    public JSONResponse(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public JSONResponse() {
        this.status = HttpStatus.OK.value();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
