package es.ulpgc.dayron.musicaporcolor.principal;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.ulpgc.dayron.musicaporcolor.R;

public class PrincipalActivity
    extends AppCompatActivity implements PrincipalContract.View {

  public static String TAG = PrincipalActivity.class.getSimpleName();

  private PrincipalContract.Presenter presenter;
  private ImageView mapa;
  private MediaPlayer mp;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_principal);

    // do the setup
    PrincipalScreen.configure(this);

    mapa = findViewById(R.id.imageView);
    mapa.setOnTouchListener(new View.OnTouchListener(){
      @Override
      public boolean onTouch(View view, MotionEvent event) {
        Drawable imgDrawable = ((ImageView) view).getDrawable();
        //imgDrawable will not be null if you had set src to ImageView, in case of background drawable it will be null
        Bitmap bitmap = ((BitmapDrawable) imgDrawable).getBitmap();

        Matrix inverse = new Matrix();
        ((ImageView) view).getImageMatrix().invert(inverse);
        float[] touchPoint = new float[]{event.getX(), event.getY()};
        inverse.mapPoints(touchPoint);
        int xCoord = (int) touchPoint[0];
        int yCoord = (int) touchPoint[1];

        if ((yCoord >= 0) && (yCoord < bitmap.getHeight())) {
          int touchedRGB = bitmap.getPixel(xCoord, yCoord);

          //then do what you want with the pixel data, e.g
          //int redValue = Color.red(touchedRGB);
          //int greenValue = Color.green(touchedRGB);
          //int blueValue = Color.blue(touchedRGB);
          //int alphaValue = Color.alpha(touchedRGB);

          //int colorValue = Color.argb(alphaValue, redValue, greenValue, blueValue);

          Log.i("TouchedColor", "TouchedRGB: " + touchedRGB);
          //Log.i("TouchedColor", "RedValue: " + redValue);
          //Log.i("TouchedColor", "GreenValue: " + greenValue);
          //Log.i("TouchedColor", "BlueValue: " + blueValue);
          //Log.i("TouchedColor", "AlphaValue: " + alphaValue);
          //Log.i("TouchedColor", "ColorValue ARGB: " + colorValue);
          presenter.reproduce(touchedRGB);
        }else{
          reproduceVacio();
        }
        return false;
      }
    });

  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchData();
  }

  @Override
  public void displayData(PrincipalViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

  }

  @Override
  public void reproduceCanarias() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.canarias);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.canarias);
      mp.start();
    }
  }

  @Override
  public void reproduceAndalucia() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.andalucia);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.andalucia);
      mp.start();
    }
  }

  @Override
  public void reproduceCastillaLaMancha() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.castillalamancha);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.castillalamancha);
      mp.start();
    }
  }

  @Override
  public void reproduceCastillaYLeon() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.castillayleon);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.castillayleon);
      mp.start();
    }
  }

  @Override
  public void reproduceCantabria() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.cantabria);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.cantabria);
      mp.start();
    }
  }

  @Override
  public void reproduceAsturias() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.asturias);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.asturias);
      mp.start();
    }
  }

  @Override
  public void reproduceMurcia() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.murcia);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.murcia);
      mp.start();
    }
  }

  @Override
  public void reproduceBaleares() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.baleares);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.baleares);
      mp.start();
    }
  }

  @Override
  public void reproduceValencia() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.valencia);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.valencia);
      mp.start();
    }
  }

  @Override
  public void reproduceGalioia() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.galicia);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.galicia);
      mp.start();
    }
  }

  @Override
  public void reproduceCatalunya() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.cataluna);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.cataluna);
      mp.start();
    }
  }

  @Override
  public void reproduceAragon() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.aragon);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.aragon);
      mp.start();
    }
  }

  @Override
  public void reproduceExtremadura() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.extremadura);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.extremadura);
      mp.start();
    }
  }

  @Override
  public void reproduceLaRioja() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.larioja);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.larioja);
      mp.start();
    }
  }

  @Override
  public void reproduceNavarra() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.navarra);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.navarra);
      mp.start();
    }
  }

  @Override
  public void reproducePaisVasco() {
    if(mp==null){
      mp= MediaPlayer.create(getApplicationContext(),R.raw.paisvasco);
      mp.start();
    }else{
      mp.release();
      mp=null;
      mp=MediaPlayer.create(getApplicationContext(),R.raw.paisvasco);
      mp.start();
    }
  }

  @Override
  public void reproduceVacio() {
    if(mp==null){
      mp.release();
    }else{
      mp.release();
      mp=null;
    }
  }

  @Override
  public void injectPresenter(PrincipalContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
