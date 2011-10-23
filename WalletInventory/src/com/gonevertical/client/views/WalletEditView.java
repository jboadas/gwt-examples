package com.gonevertical.client.views;

import com.gonevertical.client.app.ClientFactory;
import com.gonevertical.client.app.requestfactory.dto.WalletDataProxy;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface WalletEditView extends IsWidget {

  interface Presenter {
    void goTo(Place place);
    
    void setRunning(boolean running);
  }

  void setPresenter(Presenter presenter);
  
  void setClientFactory(ClientFactory clientFactory);
  
  void setData(WalletDataProxy walletData);
  
  void draw();
}