package es.ulpgc.dayron.musicaporcolor.principal;

import android.util.Log;

import java.lang.ref.WeakReference;
public class PrincipalModel implements PrincipalContract.Model {

  public static String TAG = PrincipalModel.class.getSimpleName();

  public PrincipalModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
