package com.skyon.common.enums;
/**
 * 预警对象类别枚举类
 * @author xinglj
 *
 */
public enum WarningObjectCategory {
	PRIVATE("01","个人客户"),
	PUBLIC     	("03","对公客户"),
	SMALLPUBLIC     	("02","小微客户"),
	NOPEERS    	("04","非同业主体"),
	PEERS     	("05","同业主体"),
	PARTNER  	("06","合作方(渠道)"),
	NSO_PRIVATE  	("07","非自营零售客户"),//Non self operated
	PRODUCTION       	("08","产品"),
	ASSETS       	("09","资产"),
	CASTGROUP       	("10","投组");
	
	private final String code;
    private final String info;

    WarningObjectCategory(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
