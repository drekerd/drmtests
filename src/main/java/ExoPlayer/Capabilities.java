package ExoPlayer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * for appium framework work correctly we need to import
 * java libraries
 * **appium java client jar
 * **selenium commons jar
 * **selenium libs jars
 * **selenium jar
 * */


public class Capabilities {

    public static AndroidDriver<AndroidElement> capabilities(String apkname) throws MalformedURLException {

        // base code for establish connections

        File file = new File("src\\main\\java\\",apkname);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.6:5555");
        cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        return driver;
    }

}
