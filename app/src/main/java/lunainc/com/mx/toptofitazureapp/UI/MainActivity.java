package lunainc.com.mx.toptofitazureapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.toptofitazureapp.Connect.APIService;
import lunainc.com.mx.toptofitazureapp.Connect.ApiUtils;
import lunainc.com.mx.toptofitazureapp.Model.ResponseAzure;
import lunainc.com.mx.toptofitazureapp.R;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.urlImage)
    EditText urlImageField;

    @BindView(R.id.actionPredict)
    Button actionPredict;

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVars();
    }

    private void initVars() {
        mAPIService = ApiUtils.getAPIService();
    }


    @Override
    protected void onStart() {
        super.onStart();
        events();
    }

    private void events() {

        actionPredict.setOnClickListener(v -> {

            String finalUrl = urlImageField.getText().toString();
            
            if (finalUrl.trim().length() > 0 && !finalUrl.trim().isEmpty()) {


                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("URL", finalUrl)
                        .build();


                String key = getString(R.string.key_azure);
                Glide.with(this).load(finalUrl).into(imageView);

                mAPIService.predictImage( finalUrl).enqueue(new Callback<ResponseAzure>() {
                    @Override
                    public void onResponse(Call<ResponseAzure> call, Response<ResponseAzure> response) {
                        if (response.isSuccessful()){

                            Toast.makeText(MainActivity.this, "La imagen contiene lo siguiente: "+response.body().getPredictions().get(0).getTagName(), Toast.LENGTH_SHORT).show();


                        }else{
                            Toast.makeText(MainActivity.this, "Sucedio un error 1: "+response.message(), Toast.LENGTH_SHORT).show();
                            Log.e("Error", response.message());
                            Log.e("Error", String.valueOf(response.code()));
                            Log.e("Error", response.toString());
                            Log.e("Error", response.headers().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseAzure> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Sucedio un error 2: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(this, "Debes ingresar una URL valida", Toast.LENGTH_LONG).show();
            }



        });

    }


  /*
    public void postRequest(String data) throws IOException {

        MediaType MEDIA_TYPE = MediaType.parse("application/json");
        String url = "https://southcentralus.api.cognitive.microsoft.com/customvision/v3.0/Prediction/7d757196-5f59-43bb-867b-ea364e7d54ad/classify/iterations/ToptoFit%201/url";

        OkHttpClient client = new OkHttpClient();

        JSONObject postdata = new JSONObject();
        try {
            postdata.put("Url", data);
        } catch(JSONException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Prediction-Key", "89ca51c6bfee405f8b5defe394e7033b")
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
            }

            @Override
            public void onResponse(Call call, Response response) {

                String jsonData = response.body().toString();
                try {
                    Log.e("Error", response.body().string().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JSONObject Jobject = null;
                try {
                    Jobject = new JSONObject(jsonData);
                    JSONArray Jarray = Jobject.getJSONArray("predictions");

                    JSONObject object     = Jarray.getJSONObject(0);

                   Log.e("Error", String.valueOf(object.get("tagName")));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        });
    }
   */

}