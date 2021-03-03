package lunainc.com.mx.toptofitazureapp.Connect;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://southcentralus.api.cognitive.microsoft.com";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
