package com.tribling.gwt.test.oauth.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListenerCollection;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.tribling.gwt.test.oauth.client.rpc.RpcService;
import com.tribling.gwt.test.oauth.client.rpc.RpcServiceAsync;
import com.tribling.gwt.test.oauth.client.tests.TestRpcCall;
import com.tribling.gwt.test.oauth.client.ui.LoginUiHorizontal;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OAuth implements EntryPoint, ClickListener {

	// this manages the users priviledges to protected resources
	private SessionManager sessionManager;

	private PushButton bTestLogin = new PushButton("Test Login");
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Manage the application's session
		sessionManager = new SessionManager();
		sessionManager.setLoginUiDiv("LoginUI");
		// TODO - separate method to start the process 

		// test and debug stuff
		testStuff();
		
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(bTestLogin);
		
		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("100%");
		vp.add(hp);
		vp.add(new HTML("&nbsp;"));
		RootPanel.get("Login_TestButton").add(vp);
		
		vp.setCellHorizontalAlignment(hp, HorizontalPanel.ALIGN_CENTER);
		
		
		
		bTestLogin.addClickListener(this);
	}
	

	private void autoLogin() {

		String email = "test@gonevertical.com";
		String password = "test*7";
		sessionManager.autoLogin(email, password);
	}
	
	/**
	 * test the stuff needed for this setup
	 */
	public void testStuff() {
		testRpcSetup();
		testSha1JsSetup();
	}

	/**
	 * call the native javascript
	 */
	private void testSha1JsSetup() {
		boolean works = sha1Test();
		RootPanel.get().add(new HTML("sha1.js file works?: " + works));
	}
	
	/**
	 * test out the included javascript
	 * run the native js method
	 */
	private native boolean sha1Test() /*-{
		return $wnd.sha1_vm_test();
	}-*/;
	
	/**
	 * test out rpc
	 */
	private void testRpcSetup() {
		TestRpcCall testRpc = new TestRpcCall();
		RootPanel.get().add(testRpc);
	}



	// observe
	public void onClick(Widget sender) {
		if (sender == bTestLogin) {
			autoLogin();
		}
		
	}
	
}
