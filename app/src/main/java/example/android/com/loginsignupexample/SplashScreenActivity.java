package example.android.com.loginsignupexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;

import example.android.com.utils.SharedPreferenceHandler;

public class SplashScreenActivity extends Activity {

    // Set Duration of the Splash Screen
    private Context context=this;
    long Delay = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove the Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Get the view from splash_screen.xml
        setContentView(R.layout.splash_screen);

        // Create a Timer
        Timer RunSplash = new Timer();

        // Task to do when the timer ends
        //TimerTask ShowSplash = new TimerTask() {
        final Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                                            /*
                                             * We are creating this new thread because we don’t
                                             * want our main thread to stop working for that
                                             * time as our android stop working and some time
                                             * application will crashes
                                             */
                    e.printStackTrace();
                }
                finally {
                    Intent i;
                    if ((SharedPreferenceHandler.readValue(context,"LoginObject").isEmpty())
                            &&(SharedPreferenceHandler.readValue(context,"RegisterObject").isEmpty()))
                    {
                         i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    }else
                    {
                        i = new Intent(SplashScreenActivity.this, UserHomeActivity.class);
                    }
                    startActivity(i);
                    finish();
                }

            }
        });

        // Start the timer
        //RunSplash.schedule(ShowSplash, Delay);
        th.start(); // start the thread
    }
}