package com.example.matyena.paint;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bNegro, bAzul, bVerde, bNaranja, bRojo, bRosa, bAzulOscuro, bGris;
    ImageButton pincel, borrar, nuevo, guardar;
    private Lienzo lienzo;
    float ppequeno, pmediano, pgrande, pdefecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNegro = findViewById(R.id.bNegro);
        bAzul = findViewById(R.id.bAzul);
        bVerde = findViewById(R.id.bVerde);
        bNaranja = findViewById(R.id.bNaranja);
        bRojo = findViewById(R.id.bRojo);
        bRosa = findViewById(R.id.bRosa);
        bAzulOscuro = findViewById(R.id.bAzulOscuro);
        bGris = findViewById(R.id.bGris);

        pincel = findViewById(R.id.pincel);
        borrar = findViewById(R.id.borrar);
        nuevo = findViewById(R.id.nuevo);
        guardar = findViewById(R.id.guardar);

        bNegro.setOnClickListener(this);
        bAzul.setOnClickListener(this);
        bVerde.setOnClickListener(this);
        bNaranja.setOnClickListener(this);
        bRojo.setOnClickListener(this);
        bRosa.setOnClickListener(this);
        bAzulOscuro.setOnClickListener(this);
        bGris.setOnClickListener(this);


        pincel.setOnClickListener(this);
        borrar.setOnClickListener(this);
        nuevo.setOnClickListener(this);
        guardar.setOnClickListener(this);

        lienzo = findViewById(R.id.lienzo);

        ppequeno = 10;
        pmediano = 20;
        pgrande = 30;

        pdefecto = pmediano;

    }

    @Override
    public void onClick(View view) {
        String color = null;

        switch (view.getId()){
            case R.id.bNegro:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.bAzul:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.bVerde:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.bNaranja:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.bRojo:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.bRosa:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.bAzulOscuro:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.bGris:
                color = view.getTag().toString();
                lienzo.setColor(color);
                break;

            case R.id.pincel:
                final Dialog tamanopincel = new Dialog(this);
                tamanopincel.setTitle("Tamaño del pincel:");
                tamanopincel.setContentView(R.layout.tamano_pincel);

                TextView smallBtn = tamanopincel.findViewById(R.id.tpequeno);
                smallBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPincel(ppequeno);
                        tamanopincel.dismiss();
                    }
                });
                TextView mediumBtn = tamanopincel.findViewById(R.id.tmediano);
                mediumBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPincel(pmediano);

                        tamanopincel.dismiss();
                    }
                });
                TextView largeBtn = tamanopincel.findViewById(R.id.tgrande);
                largeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(false);
                        lienzo.setTamanoPincel(pgrande);

                        tamanopincel.dismiss();
                    }
                });

                tamanopincel.show();
                break;

            case R.id.nuevo:
                final AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setMessage("¿Comenzar nuevo dibujo?");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lienzo.NuevoDibujo();
                        dialogInterface.dismiss();
                    }
                });

                newDialog.setNegativeButton("Candelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                newDialog.show();
                break;

            case R.id.borrar:

                final Dialog tamanoborrar = new Dialog(this);
                tamanoborrar.setTitle("Tamaño de borrado:");
                tamanoborrar.setContentView(R.layout.tamano_pincel);

                TextView smallBtnBorrar = tamanoborrar.findViewById(R.id.tpequeno);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(true);
                        lienzo.setTamanoPincel(ppequeno);
                        tamanoborrar.dismiss();
                    }
                });
                TextView mediumBtnBorrar = tamanoborrar.findViewById(R.id.tmediano);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(true);
                        lienzo.setTamanoPincel(pmediano);

                        tamanoborrar.dismiss();
                    }
                });
                TextView largeBtnBorrar = tamanoborrar.findViewById(R.id.tgrande);
                largeBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lienzo.setBorrado(true);
                        lienzo.setTamanoPincel(pgrande);

                        tamanoborrar.dismiss();
                    }
                });

                tamanoborrar.show();

                //lienzo.setBorrado(true);

            default:
                break;

            case R.id.guardar:
                AlertDialog.Builder guardarDibujo = new AlertDialog.Builder(this);
                guardarDibujo.setTitle("Guardar dibujo");
                guardarDibujo.setMessage("¿Quieres guardar el dibujo?");
                guardarDibujo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){


                        lienzo.setDrawingCacheEnabled(true);

                        String imgGuardada = MediaStore.Images.Media.insertImage(
                                getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString()+".png", "drawing");

                        if(imgGuardada!=null){
                            Toast savedToast = Toast.makeText(getApplicationContext(),
                                    "Dibujo guardado", Toast.LENGTH_SHORT);
                            savedToast.show();
                        }
                        else{
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "No se ha podido guardar la imagen", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                        lienzo.destroyDrawingCache();
                    }
                });
                guardarDibujo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                guardarDibujo.show();
                break;
        }
    }
}
