package b.bon.mycube.util;

import android.os.AsyncTask;
import android.util.Log;
import b.bon.mycube.model.ResultListener;

public class SolverTask extends AsyncTask<Void, Void, String> {

    private final String TAG = "zqy:SolverTask";

    private String rubikCubeStr;

    //返回结果所用的接口
    private ResultListener resultListener;

    public SolverTask(String rubikCubeStr) {
        this.rubikCubeStr = rubikCubeStr;
    }

    public void setResultListener(ResultListener resultListener) {
        this.resultListener = resultListener;
    }


    @Override
    protected String doInBackground(Void... params) {
        long time = System.currentTimeMillis();
        String result = new CubeClient().send(rubikCubeStr);
        Log.d(TAG, String.format("执行时长是%d", System.currentTimeMillis() - time));
        return result;
    }

    @Override
    protected void onPostExecute(String resultString) {
        if (resultString != null) {
            resultListener.onDataSuccessfully(resultString);
        } else {
            resultListener.onDataFailed();
        }
    }
}
