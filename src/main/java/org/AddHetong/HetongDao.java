package org.AddHetong;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午1:31
 * @Version 1.0
 */
public class HetongDao {
    private String id;
    private String url;
    private int loves;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLoves() {
        return loves;
    }

    public void setLoves(int loves) {
        this.loves = loves;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

}
