package pandox.anguloso.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class AngularRequest {

    private Long id;

    private String path;
    private Date requestDate;
    private Date responseDate;
    private int httpStatus;
    private String json;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AngularRequest{");
        sb.append("id=").append(id);
        sb.append(", path='").append(path).append('\'');
        sb.append(", requestDate=").append(requestDate);
        sb.append(", responseDate=").append(responseDate);
        sb.append(", httpStatus=").append(httpStatus);
        sb.append(", json='").append(json).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
