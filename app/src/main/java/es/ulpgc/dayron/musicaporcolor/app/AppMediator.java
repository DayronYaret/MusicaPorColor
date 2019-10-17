package es.ulpgc.dayron.musicaporcolor.app;

import android.app.Application;

import es.ulpgc.dayron.musicaporcolor.principal.PrincipalState;

public class AppMediator extends Application {

  private PrincipalState principalState;
  public AppMediator(){
    this.principalState= new PrincipalState();
  }

  public PrincipalState getPrincipalState() {
    return principalState;
  }
  public void setPrincipalState(PrincipalState state){
    this.principalState=state;
  }
}
