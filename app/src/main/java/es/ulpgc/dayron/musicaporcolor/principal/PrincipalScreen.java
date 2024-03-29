package es.ulpgc.dayron.musicaporcolor.principal;

import java.lang.ref.WeakReference;


import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.musicaporcolor.app.AppMediator;

public class PrincipalScreen {

  public static void configure(PrincipalContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PrincipalState state = mediator.getPrincipalState();

    PrincipalContract.Router router = new PrincipalRouter(mediator);
    PrincipalContract.Presenter presenter = new PrincipalPresenter(state);
    PrincipalContract.Model model = new PrincipalModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
