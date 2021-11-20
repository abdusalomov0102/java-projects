package uz.pdp.model;

public class Result {

    private boolean succes;
    private String message;

    public Result() {
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(boolean succes, String message) {
        this.succes = succes;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "succes=" + succes +
                ", message='" + message + '\'' +
                '}';
    }

}
