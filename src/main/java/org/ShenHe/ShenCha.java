package org.ShenHe;

import org.Util.State;

import java.util.concurrent.ExecutionException;

/**
 * @Author: yanshilong
 * @Date: 18-9-20 上午10:30
 * @Version 1.0
 */
public class ShenCha {
    public State DoShenCha(UserDao use){
        State state=new State();
        String mess=use.getMessage();

           CallableFuture callableFuture=new CallableFuture();
        try {

           state= callableFuture.doCallabkefuture(use);







        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return state;

    }


}
