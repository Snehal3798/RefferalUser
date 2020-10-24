package snehal.adhav.refferaluser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import snehal.adhav.refferaluser.Fragments.LoginFragment;
import snehal.adhav.refferaluser.Fragments.RegistrationFragment;
import snehal.adhav.refferaluser.extras.AppPreference;
import snehal.adhav.refferaluser.services.MyInterface;
import snehal.adhav.refferaluser.services.RetrofitClient;
import snehal.adhav.refferaluser.services.ServiceApi;


public class MainActivity extends AppCompatActivity implements MyInterface {
    FrameLayout container_fragment;
    public static AppPreference appPreference;
    public static ServiceApi serviceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appPreference=new AppPreference(this);
        container_fragment=findViewById(R.id.fragment_container);

        serviceApi= RetrofitClient.getApiClient().create(ServiceApi.class);
        if(container_fragment!=null)
        {
            if(savedInstanceState!=null)
            {

                return;
            }
            if(appPreference.getLoginStatus())
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new LoginFragment())
                        .commit();


            }else{
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new LoginFragment())
                        .commit();


            }
        }

    }
    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new RegistrationFragment())
                .addToBackStack(null)
                .commit();

    }

   /* @Override
    public void login(String name, String email, String created_at) {
        appPreference.setLoginStatus(true);
        appPreference.setDisplayName(name);
        appPreference.setDisplayemail(email);
        appPreference.setDisplaydate(created_at);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ProfileFragment())

                .commit();


    }*/


    @Override
    public void profile() {
        Intent i=new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(i);

    }
    @Override

    public void onBackPressed() {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Warning!");
        alertDialogBuilder.setMessage("Do you want to Exit?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog,int id) {


                MainActivity.this.finish();
            }


        })

                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }


}
