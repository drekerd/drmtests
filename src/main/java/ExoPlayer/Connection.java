package ExoPlayer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Connection extends Capabilities {


    //START MAIN WITH TEST APK
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        /*Call the method responsible for establish a connection, need to send the apk name to run.
        * you need to copy the applicataion you want to use to src folder and the name must match correctly and the name of the device
        * */

        /*AndroidDriver<AndroidElement> androidDriver = capabilities("Raaga.apk");
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        int time = 32000;

        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));




    }






}


