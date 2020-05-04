package com.example.komunikasidatajadi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class serial_page extends AppCompatActivity {

    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> seriesser;
    private int lastX = 0,ulang=0,nilaid1,y=0,yy=10,i,x=3,i1;
    Button kirimser,send,reload,kembali;
    Switch inputser;
    TextView dataawal,d1,d2,d3,d4;
    String nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serial_page);
        kembali = findViewById(R.id.back);
        send = findViewById(R.id.kirimdata);
        reload = findViewById(R.id.refresh);
        kirimser = findViewById(R.id.nextserial);
        inputser = findViewById(R.id.btnserial);
        dataawal = findViewById(R.id.inputserial);
        d1 = findViewById(R.id.dig1);
        d2 = findViewById(R.id.digital2);
        d3 = findViewById(R.id.digital3);
        d4 = findViewById(R.id.digital4);


        GraphView graph = (GraphView) findViewById(R.id.paralelsignal);

        seriesser = new LineGraphSeries<DataPoint>();
        graph.addSeries(seriesser);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setXAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(20);
        viewport.setMinX(0);
        viewport.setMaxX(18);
        viewport.setScrollable(true);

        inputser.setChecked(false);
        inputser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(inputser.isChecked()){
                    dataawal.setText("1");
                    nilaid1 =1;
                }else {
                    dataawal.setText("0");
                    nilaid1=0;
                }

            }
        });


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(serial_page.this,Home.class);
                startActivity(back);
            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent segar = new Intent(serial_page.this,serial_page.class);
                startActivity(segar);
            }
        });

        kirimser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ulang==0 && nilaid1==1){
                    d1.setText("1");
                }
                if (ulang==0 && nilaid1==0){
                    d1.setText("0");
                }

                if(ulang==1 && nilaid1==1){
                    d2.setText("1");
                }
                if (ulang==1 && nilaid1==0){
                    d2.setText("0");
                }

                if(ulang==2 && nilaid1==1){
                    d3.setText("1");
                }
                if (ulang==2 && nilaid1==0){
                    d3.setText("0");
                }

                if(ulang==3 && nilaid1==1){
                    d4.setText("1");
                }
                if (ulang==3 && nilaid1==0){
                    d4.setText("0");
                }

                ulang++;
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s1 = Integer.valueOf(d1.getText().toString());
                int s2 = Integer.valueOf(d2.getText().toString());
                int s3 = Integer.valueOf(d3.getText().toString());
                int s4 = Integer.valueOf(d4.getText().toString());

                if(ulang<=3){
                    Toast.makeText(serial_page.this,"Please Enter Data!",Toast.LENGTH_LONG).show();
                }

                if(ulang > 3 && s1==0&& s2==0 && s3 == 0 && s4==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 2; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        seriesser.appendData(new DataPoint(lastX++, 0), false,18);

                                    }
                                });

                                // sleep to slow down the add of entries
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // manage error ...
                                }
                            }

                        }
                    }).start();

                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i1 = 0; i1 <= 10; i1++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                         seriesser.appendData(new DataPoint(lastX, y++), false,18);

                                    }
                                });

                                // sleep to slow down the add of entries
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    // manage error ...
                                }
                            }

                        }
                    }).start();




                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
    }

    public void bitstart(){
        seriesser.appendData(new DataPoint(lastX++, y), false,18);
    }

    public void bitstart1(){

        seriesser.appendData(new DataPoint(lastX, y++), false,18);
    }

    public void bitstart2(){
        seriesser.appendData(new DataPoint(lastX++, yy), false,18);
    }

    public void bitstart3(){
        seriesser.appendData(new DataPoint(lastX, y), false,18);
    }



}