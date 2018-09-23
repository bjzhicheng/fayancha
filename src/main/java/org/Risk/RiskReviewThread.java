package org.Risk;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 上午1:42
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  static org.Risk.Infomation.contract;




public class RiskReviewThread extends Thread {
    private String text;
    private ContractType contractType;
    private Party party;
    private ArrayList<String> risks = null;
    private ArrayList<String> suggestions = null;



    public RiskReviewThread(String text, ContractType contractType, Party party) {
        this.text = text;
        this.contractType = contractType;
        this.party = party;
        risks = new ArrayList<>();
        suggestions = new ArrayList<>();
    }

    public ArrayList<String> getRisks() {
        return this.risks;
    }

    public ArrayList<String> getSuggestions() {
        return this.suggestions;
    }

    public String getText() {
        return text;
    }

    @Override
    public void run() {
        HashMap<Party, HashMap<Risk, HashMap<String, HashMap<String, String>>>> contractMap = contract.get(this.contractType);
        HashMap<Risk, HashMap<String, HashMap<String, String>>> PersonType = contractMap.get(this.party);
        HashMap<String, HashMap<String, String>> riskReview = PersonType.get(Risk.riskReview);
        HashMap<String, HashMap<String, String>> riskLocation = PersonType.get(Risk.riskLocation);
        Set reviewkeys = riskReview.keySet();
        Set locationKeys = riskLocation.keySet();

        for (Object key:reviewkeys){
            HashMap<String,String> info = riskReview.get((String) key);
            Set regexs = info.keySet();
            for(Object regex:regexs){
                Pattern pattern = Pattern.compile((String) regex);
                Matcher matcher = pattern.matcher(this.text);
                if (matcher.find()){
                    String riskAndSuggestion = info.get((String)regex);
                    String[] strings = riskAndSuggestion.split("&");
                    this.risks.add(strings[0]);
                    this.suggestions.add(strings[1]);
                    break;
                }
            }
        }

        for (Object key:locationKeys){
            HashMap<String,String> info = riskLocation.get((String) key);
            Set regexs = info.keySet();
            for(Object regex:regexs){
                Pattern pattern = Pattern.compile((String) regex);
                Matcher matcher = pattern.matcher(this.text);
                if (matcher.find()){
                    String[] regexx = ((String) regex).split("[.][*]");
                    pattern = Pattern.compile("[^.，。,]*"+regexx[regexx.length-1]+"[^.，。,]*");
                    matcher = pattern.matcher(this.text);
                    if (matcher.find()){
                        String newText = matcher.replaceAll(matcher.group()+".风险:"+info.get((String) regex));
                    }
                    break;
                }
            }
        }
    }
}
