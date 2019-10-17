package es.ulpgc.dayron.musicaporcolor.principal;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PrincipalPresenter implements PrincipalContract.Presenter {

  public static String TAG = PrincipalPresenter.class.getSimpleName();

  private WeakReference<PrincipalContract.View> view;
  private PrincipalViewModel viewModel;
  private PrincipalContract.Model model;
  private PrincipalContract.Router router;

  public PrincipalPresenter(PrincipalState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    PrincipalState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void reproduce(int touchedRGB) {
    switch (touchedRGB){
      case -65408:
        view.get().reproduceCanarias();
        break;
      case -3620889:
        view.get().reproduceAndalucia();
        break;
      case -9399618:
        view.get().reproduceExtremadura();
        break;
      case -1055568:
        view.get().reproduceCastillaLaMancha();
        break;
      case -12582848:
        view.get().reproduceMurcia();
        break;
      case -4856291:
        view.get().reproduceValencia();
        break;
      case -6694422:
        view.get().reproduceBaleares();
        break;
      case -3947581:
        view.get().reproduceCatalunya();
        break;
      case -6075996:
        view.get().reproduceAragon();
        break;
      case -4621737:
        view.get().reproduceCastillaYLeon();
        break;
      case -1237980:
        view.get().reproduceGalioia();
        break;
      case -32985:
        view.get().reproduceAsturias();
        break;
      case -3584:
        view.get().reproduceCantabria();
        break;
      case -14503604:
        view.get().reproducePaisVasco();
        break;
      case -20791:
        view.get().reproduceLaRioja();
        break;
      case -16735512:
        view.get().reproduceNavarra();
        break;
        default:
          view.get().reproduceVacio();
          break;
    }
  }

  @Override
  public void injectView(WeakReference<PrincipalContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PrincipalContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PrincipalContract.Router router) {
    this.router = router;
  }
}
