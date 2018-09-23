package org.Risk;

import java.util.HashMap;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 上午1:40
 * @Version 1.0
 */
public class Infomation {
    public static HashMap<ContractType,HashMap<Party,HashMap<Risk,HashMap<String,HashMap<String,String>>>>> contract = null;

    public static HashMap<Party,HashMap<Risk,HashMap<String,HashMap<String,String>>>> secondHandHousingSales = null;

    public static HashMap<Risk,HashMap<String,HashMap<String,String>>> secondHandHousingSalesA = null;
    public static HashMap<Risk,HashMap<String,HashMap<String,String>>> secondHandHousingSalesB = null;

    public static HashMap<String,HashMap<String,String>> riskReviewA = null;
    public static HashMap<String,String> firstReviewA = null;
    public static HashMap<String,String> secondReviewA = null;
    public static HashMap<String,String> thirdReviewA = null;
    public static HashMap<String,String> fourthReviewA = null;
    public static HashMap<String,String> fifthReviewA = null;

    public static HashMap<String,HashMap<String,String>> riskLocationA = null;
    public static HashMap<String,String> firstLocationA = null;
    public static HashMap<String,String> secondLocationA = null;
    public static HashMap<String,String> thirdLocationA = null;

    public static HashMap<String,HashMap<String,String>> riskReviewB = null;
    public static HashMap<String,String> firstReviewB = null;
    public static HashMap<String,String> secondReviewB = null;
    public static HashMap<String,String> thirdReviewB = null;
    public static HashMap<String,String> fourthReviewB = null;

    public static HashMap<String,HashMap<String,String>> riskLocationB = null;
    public static HashMap<String,String> firstLocationB = null;
    public static HashMap<String,String> secondLocationB = null;

    static {
        contract = new HashMap<>();

        secondHandHousingSales = new HashMap<>();
        secondHandHousingSalesA = new HashMap<>();
        secondHandHousingSalesB = new HashMap<>();
        riskReviewA = new HashMap<>();
        riskLocationA = new HashMap<>();
        riskReviewB = new HashMap<>();
        riskLocationB = new HashMap<>();

        firstReviewA = new HashMap<>();
        secondReviewA = new HashMap<>();
        thirdReviewA = new HashMap<>();
        fourthReviewA = new HashMap<>();
        fifthReviewA = new HashMap<>();
        firstLocationA = new HashMap<>();
        secondLocationA = new HashMap<>();
        thirdLocationA = new HashMap<>();
        firstReviewB = new HashMap<>();
        secondReviewB = new HashMap<>();
        thirdReviewB = new HashMap<>();
        fourthReviewB = new HashMap<>();
        firstLocationB = new HashMap<>();
        secondLocationB = new HashMap<>();

        firstLocationA.put(".*过户.*房产.*交付.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*房产.*交付.*前.*费用.*承担.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*房产.*交付.*后.*费用.*承担.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*收到.*房款.*天内.*房产.*交付.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*合同.*签订.*天内.*房屋.*交付.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*收到.*房款.*天内.*房屋.*交付.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*合同.*签订.*天内.*房产.*交付.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*于.*交付.*房屋.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*于.*交付.*房产.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*房屋.*使用.*权利.*转让.*","房屋使用权益和腾房的风险.");
        firstLocationA.put(".*房屋.*出租.*权利.*转让.*","房屋使用权益和腾房的风险.");

        secondLocationA.put(".*迁出.*户口.*","落户口的风险.");
        secondLocationA.put(".*户口.*迁出.*","落户口的风险.");

        thirdLocationA.put(".*未.*批准.*贷款.*申请.*","贷款下不来的风险.");
        thirdLocationA.put(".*审批.*数额.*不足.*","贷款下不来的风险.");
        thirdLocationA.put(".*未.*获得.*银行.*批准.*","贷款下不来的风险.");
        thirdLocationA.put(".*未.*获得.*公积金.*批准.*","贷款下不来的风险.");

        firstLocationB.put(".*未.*批准.*贷款.*申请.*","贷款下不来的风险.");
        firstLocationB.put(".*审批.*数额.*不足.*","贷款下不来的风险.");
        firstLocationB.put(".*未.*获得.*银行.*批准.*","贷款下不来的风险.");
        firstLocationB.put(".*未.*获得.*公积金.*批准.*","贷款下不来的风险.");

        secondLocationB.put(".*逾期.*交付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*逾期.*支付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*于.*日前.*交付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*于.*日前.*支付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*日内.*支付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*天内.*支付.*首付.*","逾期存首付的风险.");
        secondLocationB.put(".*没.*按.*期限.*支付.*","逾期存首付的风险.");
        secondLocationB.put(".*没.*按.*期限.*付款.*","逾期存首付的风险.");
        secondLocationB.put(".*没.*按.*期限.*交付.*","逾期存首付的风险.");

        firstReviewA.put(".*中介.*房屋.*价.*元.*买卖协议.*不一致.*","中介协议与房管局买卖协议价格约定不一致的风险.&很多情况下,中介协议和买卖协议房屋价格不一致,会导致合同存在时效的风险,应当通过补充协议,明确说明原因,并三方签字确认,以最大化降低该风险.");

        secondReviewA.put(".*中介.*买方.*买卖协议.*不一致.*","买方签约和落户不一致的情况下,容易产生合同无效的风险.&如果买方签约人和落户人不是同一人的话,应当通过补充协议方式予以明确约定.");

        thirdReviewA.put(".*办.*完.*过户.*房.*交付.*费.*结清.*逾期.*违约.*","房屋使用权益无法保障的风险.&除了明确约定交房及交接问题外,还应考虑房屋是否存在其他使用的情况,如有承租方的情况下,应约定交房不能的情况下违约赔偿.");
        thirdReviewA.put(".*办.*完.*过户.*房.*腾.*费.*结清.*逾期.*违约.*","房屋使用权益无法保障的风险.&除了明确约定交房及交接问题外,还应考虑房屋是否存在其他使用的情况,如有承租方的情况下,应约定交房不能的情况下违约赔偿.");
        thirdReviewA.put(".*办.*完.*过户.*房.*交付.*费.*结清.*逾期.*赔偿.*","房屋使用权益无法保障的风险.&除了明确约定交房及交接问题外,还应考虑房屋是否存在其他使用的情况,如有承租方的情况下,应约定交房不能的情况下违约赔偿.");
        thirdReviewA.put(".*办.*完.*过户.*房.*腾.*费.*结清.*逾期.*赔偿.*","房屋使用权益无法保障的风险.&除了明确约定交房及交接问题外,还应考虑房屋是否存在其他使用的情况,如有承租方的情况下,应约定交房不能的情况下违约赔偿.");

        fourthReviewA.put(".*未.*户口.*迁出.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*不.*户口.*迁出.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*未.*户口.*迁走.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*不.*户口.*迁走.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*未.*户籍.*迁出.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*不.*户籍.*迁出.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*未.*户籍.*迁走.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");
        fourthReviewA.put(".*不.*户籍.*迁走.*违约.*","特殊情况下,无法满足落户使用的风险.&有些购房目的是落户口,如果户口无法迁入,购房目的受影响,这种情况下,应约定严格的违约金.");

        fifthReviewA.put(".*未.*贷款.*批准.*定金.*房.*款.*返还.*不承担.*违约.*","贷款通不过法律后果不明的风险.&因客观原因贷款未通过,应明确约定相应后果,及处理办法,如定金和预付款如何退还以及互不追究违约等.不明确的情况下,往往责任非常重大.");
        fifthReviewA.put(".*没.*贷款.*批准.*定金.*房.*款.*返还.*不承担.*违约.*","贷款通不过法律后果不明的风险.&因客观原因贷款未通过,应明确约定相应后果,及处理办法,如定金和预付款如何退还以及互不追究违约等.不明确的情况下,往往责任非常重大.");
        fifthReviewA.put(".*未.*贷款.*批准.*定金.*房.*款.*退还.*不承担.*违约.*","贷款通不过法律后果不明的风险.&因客观原因贷款未通过,应明确约定相应后果,及处理办法,如定金和预付款如何退还以及互不追究违约等.不明确的情况下,往往责任非常重大.");
        fifthReviewA.put(".*没.*贷款.*批准.*定金.*房.*款.*退还.*不承担.*违约.*","贷款通不过法律后果不明的风险.&因客观原因贷款未通过,应明确约定相应后果,及处理办法,如定金和预付款如何退还以及互不追究违约等.不明确的情况下,往往责任非常重大.");

        firstReviewB.put(".*中介.*房屋.*价.*元.*买卖协议.*不一致.*","中介协议与房管局买卖协议价格约定不一致的风险.&很多情况下,中介协议和买卖协议房屋价格不一致,会导致合同存在时效的风险,应当通过补充协议,明确说明原因,并三方签字确认,以最大化降低该风险.");

        secondReviewB.put(".*中介.*买方.*买卖协议.*不一致.*","买方签约和落户不一致的情况下,容易产生合同无效的风险.&如果买方签约人和落户人不是同一人的话,应当通过补充协议方式予以明确约定.");

        thirdReviewB.put(".*未.*贷款.*批准.*定金.*房.*款.*返还.*承担.*违约.*解除.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*没.*贷款.*批准.*定金.*房.*款.*返还.*承担.*违约.*解除.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*未.*贷款.*批准.*定金.*房.*款.*退还.*承担.*违约.*解除.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*没.*贷款.*批准.*定金.*房.*款.*退还.*承担.*违约.*解除.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*未.*贷款.*批准.*定金.*房.*款.*返还.*承担.*违约.*终止.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*没.*贷款.*批准.*定金.*房.*款.*返还.*承担.*违约.*终止.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*未.*贷款.*批准.*定金.*房.*款.*退还.*承担.*违约.*终止.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");
        thirdReviewB.put(".*没.*贷款.*批准.*定金.*房.*款.*退还.*承担.*违约.*终止.*","贷款通不过法律后果不明的风险.&因客观原因贷款迟迟未通过,买方又无法全款支付的,会直接影响到卖方资金使用的安排,此种情况下应明确约定违约和解约等处理条款.");

        fourthReviewB.put(".*未.*划入.*首付.*逾期.*日.*解除.*违约.*","首付款支付不能的风险.&如果首付款存在支付不能的情况,买卖合同根本目的会受影响,对此应明确约定违约及解约的处理办法.");
        fourthReviewB.put(".*未.*支付.*首付.*逾期.*日.*解除.*违约.*","首付款支付不能的风险.&如果首付款存在支付不能的情况,买卖合同根本目的会受影响,对此应明确约定违约及解约的处理办法.");
        fourthReviewB.put(".*未.*划入.*预付款.*逾期.*日.*解除.*违约.*","首付款支付不能的风险.&如果首付款存在支付不能的情况,买卖合同根本目的会受影响,对此应明确约定违约及解约的处理办法.");
        fourthReviewB.put(".*未.*支付.*预付款.*逾期.*日.*解除.*违约.*","首付款支付不能的风险.&如果首付款存在支付不能的情况,买卖合同根本目的会受影响,对此应明确约定违约及解约的处理办法.");


        riskReviewA.put("1",firstReviewA);
        riskReviewA.put("2",secondReviewA);
        riskReviewA.put("3",thirdReviewA);
        riskReviewA.put("4",fourthReviewA);
        riskReviewA.put("5",fifthReviewA);

        riskLocationB.put("1",firstLocationB);
        riskLocationB.put("2",secondLocationB);

        riskLocationA.put("1",firstLocationA);
        riskLocationA.put("2",secondLocationA);
        riskLocationA.put("3",thirdLocationA);

        riskReviewB.put("1",firstReviewB);
        riskReviewB.put("2",secondReviewB);
        riskReviewB.put("3",thirdReviewB);
        riskReviewB.put("4",fourthReviewB);

        secondHandHousingSalesA.put(Risk.riskReview,riskReviewA);
        secondHandHousingSalesA.put(Risk.riskLocation,riskLocationA);
        secondHandHousingSalesB.put(Risk.riskReview,riskReviewB);
        secondHandHousingSalesB.put(Risk.riskLocation,riskLocationB);
        secondHandHousingSales.put(Party.A,secondHandHousingSalesA);
        secondHandHousingSales.put(Party.B,secondHandHousingSalesB);
        contract.put(ContractType.SecondHandHousingSales,secondHandHousingSales);
    }
}
