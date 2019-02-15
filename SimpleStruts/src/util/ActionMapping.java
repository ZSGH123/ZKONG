package util;

public class ActionMapping {
     private String actionName;
     private String actionClassName;
     private String nameSpace;
     
	public ActionMapping(String actionName, String actionClassName, String nameSpace) {
		super();
		this.actionName = actionName;
		this.actionClassName = actionClassName;
		this.nameSpace = nameSpace;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionClassName() {
		return actionClassName;
	}
	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}
	public String getNameSpace() {
		return nameSpace;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
     
}
