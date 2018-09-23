package org.Risk;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 上午1:42
 * @Version 1.0
 */
public class RiskReview{
    public static UserDao riskReview(String text, ContractType contractType, Party party){
        RiskReviewThread riskReviewThread = new RiskReviewThread(text,contractType,party);
        riskReviewThread.start();

        int aa= (int) ((Math.random()*9)*100);
        int bb= (int) ((Math.random()*9)*100);
        int cc= (int) ((Math.random()*9)*100);


        try {
            riskReviewThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserDao(aa,cc,bb,riskReviewThread.getRisks(),riskReviewThread.getSuggestions(),riskReviewThread.getText());
    }
}
