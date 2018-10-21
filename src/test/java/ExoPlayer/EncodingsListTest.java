package ExoPlayer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.transaction.TransactionRequiredException;
import java.net.MalformedURLException;
import java.util.List;

import static ExoPlayer.EncodingsList.wv_HDCP_required;
import static org.testng.Assert.*;

public class EncodingsListTest extends Capabilities{

    public static int time = 16000;
    public static EncodingsList test;
    private static AndroidDriver androidDriver;
    private static int i = 0;



    @BeforeTest
    public static void setEncodingList() throws MalformedURLException {
        EncodingsList newTest = new EncodingsList();
        AndroidDriver<AndroidElement> driver = capabilities("exoPlayerDemo_v2.apk");
        androidDriver = driver;
        androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();
        test = newTest;
    }

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

    @AfterMethod
    public static void setBack() throws InterruptedException {
        androidDriver.navigate().back();
        Thread.sleep(2000);
    }

    //This is the FIRST that should run
    @Test
    public static void test_WV_HDCP_required_Result_True() throws MalformedURLException, InterruptedException {

        String testRun;
        i++;
        System.out.println("Test Number :"+i);
        //androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();

        testRun = androidDriver.findElementByXPath("//android.widget.TextView[@index='4']").getText();
        androidDriver.findElementByXPath("//android.widget.TextView[@index='4']").click();

        System.out.println("Started Test :"+testRun);

        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));

        String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='0']").getText();

        boolean result = getResult(name,androidDriver);
        assertTrue(result);
    }

    //This is the SECOND that should run
    @Test (dependsOnMethods = {"test_WV_HDCP_required_Result_True"}, alwaysRun = true)
    public static void testSecure_video_path_required_MP4_264_Result_True() throws MalformedURLException, InterruptedException {

        //androidDriver.findElementByXPath("//android.widget.TextView[@index='1']").click();
        //String testRun = androidDriver.findElementByXPath("(//android.widget.TextView)[5]").getText();
        i++;
        System.out.println("Test Number :"+i);
        List<MobileElement> paths = androidDriver.findElementsByClassName("android.widget.TextView");
        MobileElement path = paths.get(6);
        String testRun = path.getText();
        path.click();

        System.out.println("Started TestUnit "+testRun);

        long start = System.currentTimeMillis();
        Thread.sleep(time);
        System.out.println("Test time in ms = "+(System.currentTimeMillis()-start));

        String name = androidDriver.findElementByXPath("//android.widget.TextView[@index='0']").getText();

        //androidDriver.navigate().back();
        boolean result = getResult(name,androidDriver);

        Thread.sleep(2000);
        assertTrue(result);
    }

    //This is the Third that should run
    @Test (dependsOnMethods = {"testSecure_video_path_required_MP4_264_Result_True"}, alwaysRun = true)
    public void testWvSecure_Video_Path_Required_WebM_VP9_Result_True() throws MalformedURLException, InterruptedException{

        String testRun;
        System.out.println("Test Number :"+i);
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

        boolean result = getResult(name, androidDriver);
        assertTrue(result);
    }

    //This is the FOURTH that should run


    //This is the FIFTH that should run
    /*@Test (dependsOnMethods ={"test_WV_HDCP_required_Result_True"}, alwaysRun = true)
    public static void wv_30s_Licence_Fails_At_30s_Result_True() throws MalformedURLException, InterruptedException{
        boolean result = test.wv_30s_Licence_Fails_At_30s(32000);
        back();
        assertTrue(result);
    }*/



}