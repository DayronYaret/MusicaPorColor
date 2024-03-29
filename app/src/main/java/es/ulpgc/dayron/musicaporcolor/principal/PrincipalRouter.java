package es.ulpgc.dayron.musicaporcolor.principal;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.musicaporcolor.app.AppMediator;

public class PrincipalRouter implements PrincipalContract.Router {

  public static String TAG = PrincipalRouter.class.getSimpleName();

  private AppMediator mediator;

  public PrincipalRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PrincipalActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(PrincipalState state) {
    mediator.setPrincipalState(state);
  }

  @Override
  public PrincipalState getDataFromPreviousScreen() {
    PrincipalState state = mediator.getPrincipalState();
    return state;
  }
}
