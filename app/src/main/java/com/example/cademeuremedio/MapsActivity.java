package com.example.cademeuremedio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cademeuremedio.Model.Unidade;
import com.example.cademeuremedio.Model.UnidadeDAO;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsActivity extends AppCompatActivity implements Serializable {
    private static final String TAG = "const TAG";
    //inicializar variaveis
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    EditText editText;
    TextView textView,textView2;
    Button btnInformacoes;
    PlacesClient placesClient;
    private GoogleMap googlemap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //atribuir variavel
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        btnInformacoes = findViewById(R.id.buttonInformacoes);


        //iniciar places
        Places.initialize(getApplicationContext(),"AIzaSyBqtgH-0N2-Nd4n11UnxVN2Ojjsk4w8ytA");

        placesClient = Places.createClient(this);

        //Setar EditText nao focavel
        editText.setFocusable(false);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iniciar campo de lista do places
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS,
                        Place.Field.LAT_LNG,Place.Field.NAME,Place.Field.ID);
                //criar intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                        ,fieldList).build(MapsActivity.this);
                //iniciar ativity resultados
                startActivityForResult(intent,100);
            }
        });

        //iniciar fusedlocation
        client = LocationServices.getFusedLocationProviderClient(this);
        //checar permissoes
        if (ActivityCompat.checkSelfPermission(MapsActivity.this,
                ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //quando garantida
            //invocar metodo
            getCurrentLocation();
        } else {
            //quando a permissao neagda
            //pedir permissao
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getCurrentLocation() {
        //iniciar a task location
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                //quando sucedida
                if (location != null) {
                    //sync mapas
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            //iniciar latlng
                            LatLng latLng = new LatLng(location.getLatitude()
                                    , location.getLongitude());
                            //criar opções de marcador
                            MarkerOptions options = new MarkerOptions().position(latLng)
                                    .title("estou aqui");
                            //zoom no mapa
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                            //criar marcador no mapa
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //qaundo permissao garantida
                //invocar metodo
                getCurrentLocation();
            }
        }
    }

    // autocomplete:

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            //QUANDO SUCESSO
            //iniciar place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //setar endereço no EditText
            editText.setText(place.getAddress());
            //setar nome da localidade
            textView.setText(String.format("Nome: %s", place.getName()));
            //set latitude & long
            //textView2.setText(String.valueOf(place.getLatLng()));

            Unidade unidade = new Unidade();
            System.out.println("Maps Activity retorno place.getId(): "+place.getId());
            unidade = verifFarmacias(place.getId());

            //System.out.println("Maps Activity unidade.getNome: "+unidade.getNome());
            if(unidade != null){
                textView2.setText("Informações disponíveis");
                btnInformacoes.setVisibility(View.VISIBLE);
                btnInformacoes.setEnabled(true);

                final Unidade uni = unidade;
                btnInformacoes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent myIntent = new Intent(getBaseContext(), Farmacia.class);
                        myIntent.putExtra("unidade", uni);
                        startActivity(myIntent);
                    }
                });

            }else{
                textView2.setText("Informações não disponíveis");
                btnInformacoes.setVisibility(View.INVISIBLE);
                btnInformacoes.setEnabled(false);
            }

            //Mover o mapa para a localização:
            moveTo(place.getLatLng());

        }else if (resultCode == AutocompleteActivity.RESULT_ERROR){
            //quando der erro
            //inicar status
            Status status= Autocomplete.getStatusFromIntent(data);
            //display toast
            Toast.makeText(getApplicationContext(),status.getStatusMessage()
                    ,Toast.LENGTH_SHORT).show();
        }
    }

    protected void moveTo(final LatLng placeToMove){

        final LatLng latLng = placeToMove;
        // Add a marker in Sydney and move the camera
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                //iniciar latlng
                //criar opções de marcador
                MarkerOptions options = new MarkerOptions().position(latLng)
                        .title("estou aqui");
                //zoom no mapa
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                //criar marcador no mapa
                googleMap.addMarker(options);
            }
        });
    }

    protected Unidade verifFarmacias(String place_id){
        Unidade u = new Unidade();
        UnidadeDAO ud = new UnidadeDAO(getApplicationContext());

        u = ud.Pesquisar(place_id);

        return u;
    }



}