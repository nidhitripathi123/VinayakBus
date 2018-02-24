import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.nidhitripathi.vinayakbus.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nidhi Tripathi on 23-02-2018.
 */

public class MainActivity extends Activity {

    ArrayList<String> title_array = new ArrayList<String>();
    ArrayList<String> notice_array = new ArrayList<String>();
    ListView list;
    CustomBaseAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView1);
        new TheTask().execute();
    }

    class TheTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String str = null;
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(
                    "http://10.0.2.2/BSDI/show.php");
            HttpResponse response = httpclient.execute(httppost);
            str = EntityUtils.toString(response.getEntity());

            return str;

        }



        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            String response = result.toString();
            try {


                JSONArray new_array = new JSONArray(response);

                for (int i = 0, count = new_array.length(); i < count; i++) {
                    try {
                        JSONObject jsonObject = new_array.getJSONObject(i);
                        title_array.add(jsonObject.getString("title").toString());
                        notice_array.add(jsonObject.getString("notice").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter = new CustomBaseAdaptor(MainActivity.this, title_array, notice_array);
                list.setAdapter(adapter);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                // tv.setText("error2");
            }

        }
    }

}