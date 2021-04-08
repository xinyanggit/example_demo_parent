package com.yx;

/**
 * @author yangxin@webull.com
 * @date 2021年03月19日
 * @time 10:48 上午
 * @since JDK1.8
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(corporateActionTypeToProductType(CorporateActionType.COMPANY_NAME_CHANGE));
        System.out.println(corporateActionTypeToProductType(CorporateActionType.STOCK_SPLIT));
        System.out.println(corporateActionTypeToProductType(CorporateActionType.YX));
        System.out.println(corporateActionTypeToProductType(CorporateActionType.SPIN_OFF));
    }
    public static String corporateActionTypeToProductType(CorporateActionType actionType) {
        switch (actionType) {
            case ISIN_CHANGE:
                return "ISIN CHANGE";
            case COMPANY_NAME_CHANGE:
                return "NAME CHANGE";
            case SYMBOL_CHANGE:
                return "SYMBOL CHANGE";
            case CUSIP_CHANGE:
                return "CUSIP CHANGE";
            case EXCHANGE_CHANGE:
                return "Market Change";
            case STOCK_SPLIT:
                return "Stock Split";
            case REVERSE_STOCK_SPLIT:
                return "Reverse Split";
            case DIVIDEND:
                return "Stock Dividend";
            case MERGER:
                return "Stock Merger";
            case SPIN_OFF:
                return "Spinoff";
            default:
                System.out.println("not match, actionType:" + actionType.name());
                return "Not Match";
        }

    }

}


enum CorporateActionType {
    SYMBOL_CHANGE,//symbol变更
    CUSIP_CHANGE,//cusip变更
    ISIN_CHANGE,//isin变更
    COMPANY_NAME_CHANGE,//公司名称变更
    EXCHANGE_CHANGE,//交易所变更
    LIST_STATUS_CHANGE,//上市状态变更

    STOCK_SPLIT,//拆股
    REVERSE_STOCK_SPLIT,//合股
    DIVIDEND,//分红
    MERGER,//合并
    SPIN_OFF,//分拆
    YX;
}