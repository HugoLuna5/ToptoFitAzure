package lunainc.com.mx.toptofitazureapp.Connect;

import lunainc.com.mx.toptofitazureapp.Model.ResponseAzure;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({"Prediction-Key: 89ca51c6bfee405f8b5defe394e7033b", "Content-Type: application/json"})
    @POST("/customvision/v3.0/Prediction/7d757196-5f59-43bb-867b-ea364e7d54ad/classify/iterations/ToptoFit%201/url")
    Call<ResponseAzure> predictImage(@Body String b);
}
