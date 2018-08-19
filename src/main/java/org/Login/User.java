package org.Login;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午11:08
 * @Version 1.0
 */
public class User {
    public User(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
}
