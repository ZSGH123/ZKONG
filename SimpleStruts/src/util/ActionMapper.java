package util;
/**
 *ActionMapper解析请求并决定需要调用某个Action
 * @author 钟强
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
