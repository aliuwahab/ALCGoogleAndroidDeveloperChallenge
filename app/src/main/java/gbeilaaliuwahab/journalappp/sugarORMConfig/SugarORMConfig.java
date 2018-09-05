package gbeilaaliuwahab.journalappp.sugarORMConfig;

import android.app.Application;

import com.orm.SugarConfig;


public class SugarORMConfig extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
//        SugarContext.terminate();
    }
}
