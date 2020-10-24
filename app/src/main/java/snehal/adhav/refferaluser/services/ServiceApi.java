package snehal.adhav.refferaluser.services;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import snehal.adhav.refferaluser.model.User;

public interface ServiceApi {

    @GET("userregister.php")

    Call<User> doRegisteration(
            @Query("user_name") String user_name,
            @Query("user_email") String user_email,
            @Query("user_phone") String user_phone,
            @Query("user_password") String user_password,
            @Query("confirm_password") String confirm_password

    );

    @GET("userlogin.php")
    Call<User> doLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );

    @GET("verifyotp.php")
    Call<User> doVerify(
            @Query("otp") String otp

    );
}
