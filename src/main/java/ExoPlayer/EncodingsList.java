package ExoPlayer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class EncodingsList extends Capabilities {


    private static AndroidDriver androidDriver;

    //Other Methods for capabilities and utilites
    public static AndroidDriver<AndroidElement> getCapabilities() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("exoPlayerDemo_v2.apk");

        androidDriver = driver;
        return driver;
    }

    //press back after test case is done
    public static void back(){
        androidDriver.navigate().back();
    }

    public static boolean getResult(String name, AndroidDriver androidDriver) throws MalformedURLException {


        if(name.equals("00:11") || name.equals("playWhenReady=true, playbackState=idle") || name.equals("00:00")){
            //System.out.println(testRun+" :FAILED");
            return false;
        }else if(name.equals("playWhenReady=true, playbackState=ready")){
            System.out.println(androidDriver.findElementById("com.google.android.exoplayer.demo:id/player_state_view").getText());
            return true;
        }else{
            return false;
        }
    }

    // Test Cases Design
    public static boolean secure_video_path_required_MP4_264(int time) throws InterruptedException, MalformedURLException {

        /*AndroidDriver androidDriver;
        androidDriver = getCapabilities();*/

        androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();
        //androidDriver.findElementByAndroidUIAutomator("text(\"WIDEVINE DASH POLICY TESTS (GTS)\")").click();

        String testRun = androidDriver.findElementByXPath("//android.widget.TextView[@index='5']").getText();
        androidDriver.findElementByXPath("//android.widget.TextView[@index='5']").click();
        System.out.println("Started TestUnit "+testRun);

        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Test time in ms = "+(System.currentTimeMillis()-start));

        String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='0']").getText();

        //androidDriver.navigate().back();
        return getResult(name,androidDriver);

    }

    public static boolean wvSecure_Video_Path_Required_WebM_VP9(int time) throws InterruptedException, MalformedURLException {

        /*AndroidDriver androidDriver;
        androidDriver = getCapabilities();*/
        String testRun;

        //androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();

        testRun = androidDriver.findElementByXPath("//android.widget.TextView[@index='6']").getText();
        androidDriver.findElementByXPath("//android.widget.TextView[@index='6']").click();

        System.out.println("Started Test :"+ testRun);

        Thread.sleep(time);
        String name;

        if(androidDriver.findElementByAndroidUIAutomator("//android.widget.TextView[@index='6']").getText().equals(null)){

             name = androidDriver.findElementByAndroidUIAutomator("//android.widget.TextView[@index='0']").getText();
        } else{
             name = androidDriver.findElementByAndroidUIAutomator("//android.widget.TextView[@index='6']").getText();
        }


        //  if(name.equals("playWhenReady=true, playbackState=idle")){
        //androidDriver.navigate().back();
        return getResult(name,androidDriver);

    }

    public static boolean wv_HDCP_required(int time) throws InterruptedException, MalformedURLException {

        /*AndroidDriver androidDriver;
        androidDriver = getCapabilities();*/
        String testRun;

        //androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();

        testRun = androidDriver.findElementByXPath("//android.widget.TextView[@index='4']").getText();
        androidDriver.findElementByXPath("//android.widget.TextView[@index='4']").click();

        System.out.println("Started Test :"+testRun);

        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));

        String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='0']").getText();

        //androidDriver.navigate().back();
        return getResult(name,androidDriver);
    }

    public static boolean wv_30s_Licence_Fails_At_30s(int time) throws InterruptedException, MalformedURLException {

        /*AndroidDriver androidDriver;
        androidDriver = getCapabilities();*/
        String testRun;

        //androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();
        testRun = androidDriver.findElementByXPath("//android.widget.TextView[@index='9']").getText();
        androidDriver.findElementByXPath("//android.widget.TextView[@index='9']").click();

        System.out.println("Started Test :"+ testRun);

        //Thread.sleep(time);
        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));



            //String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='9']").getText();
            String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='0']").getText();



        System.out.println("NAME "+name);
        //  if(name.equals("playWhenReady=true, playbackState=idle")){
        if(name.equals("00:29") || name.equals("playWhenReady=true, playbackState=idle") || name.equals("00:28")){
            Thread.sleep(2000);
            androidDriver.navigate().back();
            return true;
        }else{
            Thread.sleep(2000);
            androidDriver.navigate().back();
            return false;
        }

    }











}
