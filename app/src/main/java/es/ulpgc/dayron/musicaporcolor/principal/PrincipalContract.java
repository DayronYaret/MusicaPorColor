package es.ulpgc.dayron.musicaporcolor.principal;

import java.lang.ref.WeakReference;

public interface PrincipalContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PrincipalViewModel viewModel);
    void reproduceCanarias();
    void reproduceAndalucia();
    void reproduceCastillaLaMancha();
    void reproduceCastillaYLeon();
    void reproduceCantabria();
    void reproduceAsturias();
    void reproduceMurcia();
    void reproduceBaleares();
    void reproduceValencia();
    void reproduceGalioia();
    void reproduceCatalunya();
    void reproduceAragon();
    void reproduceExtremadura();
    void reproduceLaRioja();
    void reproduceNavarra();
    void reproducePaisVasco();

    void reproduceVacio();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void reproduce(int touchedRGB);
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PrincipalState state);

    PrincipalState getDataFromPreviousScreen();
  }
}
