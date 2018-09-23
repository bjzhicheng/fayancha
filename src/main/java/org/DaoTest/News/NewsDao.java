package org.DaoTest.News;

/**
 * @Author: yanshilong
 * @Date: 18-9-2 上午10:22
 * @Version 1.0
 */
public class NewsDao {
//    | Field | Type         | Null | Key | Default | Extra |
//            +-------+--------------+------+-----+---------+-------+
//            | id    | int(10)      | NO   | PRI | NULL    |       |
//            | url   | varchar(100)  | YES  |     | NULL    |       |
//            | loves | int(10)      | YES  |     | NULL    |       |
//            | title | varchar(200) | YES  |     | NULL    |       |
//            | fromm | varchar(100) | YES  |     | NULL    |       |
//            +-------+--------------+------+-----+---------+-------+
//            5 rows in set (0.00 sec)
    private  int id;
    private String message;
    private String  conditions;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFromm() {
        return fromm;
    }

    public void setFromm(String fromm) {
        this.fromm = fromm;
    }

    private  String url;
    private int loves;
    private String title;
    private String fromm;
}
