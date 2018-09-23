package org.ShenHe;

import org.Util.State;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: yanshilong
 * @Date: 18-9-19 下午11:43
 * @Version 1.0
 */
public class CallableFuture {

    public State doCallabkefuture(UserDao user) throws ExecutionException, InterruptedException {
        ArrayList<State> arrayList1=new ArrayList(1);
        //ArrayList<State> arrayList2=new ArrayList(1);
         State rstate=new State();

        ExecutorService executor = Executors.newCachedThreadPool();

        Task1 task1=new Task1(user);//创建人物
       // FutureTask<UserDao> futureTask1=new FutureTask<UserDao>(task1);
        //节返回之
        FutureTask<State> futureTask1=new FutureTask<>(task1);

        executor.submit(futureTask1);
        executor.shutdown();


        System.out.println("已经提交完毕");
        try {
            //人物1=============================================================
            System.out.println("返回之是 "+futureTask1.get());
            State state1=futureTask1.get();
            if (state1.getState()==1)

                 {
            arrayList1.add(state1);


            }else {
                state1.setState(404);
                arrayList1.add(state1);
                return  state1;
            }



          //2==================================================








            rstate=(State) arrayList1.get(0);






        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }






        return rstate;
    }

}
