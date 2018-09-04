package org.GetVideos;

/**
 * @Author: yanshilong
 * @Date: 18-9-2 下午10:03
 * @Version 1.0
 */
public class VideosDao {
    private  int id;
    private int loves;
    private String title;
    private  String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
