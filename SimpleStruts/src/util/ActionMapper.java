package util;
/**
 *ActionMapper�������󲢾�����Ҫ����ĳ��Action
 * @author ��ǿ
 *
 */
public class ActionMapper {
	/**
	 * 
	 */
    private ConfigurationManager configurationManager;
    
	public ActionMapping isHasAction(String requestpath){

        return new ActionMapping("userloginAction", "Action.LoginAction", "/");
		
	}
}
