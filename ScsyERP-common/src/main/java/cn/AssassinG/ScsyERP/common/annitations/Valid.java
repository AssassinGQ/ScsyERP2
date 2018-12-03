package cn.AssassinG.ScsyERP.common.annitations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Valid {
	public enum VarType{Number, String, Other};
//	public enum ExtraType{Phone, Email};
	
	boolean needValid() default true;
	boolean nullAble() default false;
	VarType varType() default VarType.String;
	//String
	int minLength() default 0;
	int maxLength() default Integer.MAX_VALUE;
	String regex() default "";
	//Number
	long minValue() default Long.MIN_VALUE;
	long maxValue() default Long.MAX_VALUE;
}
