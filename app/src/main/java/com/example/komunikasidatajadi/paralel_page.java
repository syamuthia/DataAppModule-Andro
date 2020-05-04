package com.example.komunikasidatajadi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class paralel_page extends AppCompatActivity {
    private Handler handler = new Handler();
    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series;
    private LineGraphSeries<DataPoint> series1;
    private LineGraphSeries<DataPoint> series2;
    private LineGraphSeries<DataPoint> series3;
    private int lastX = 0,lastX1 =0 , lastX2=0, lastX3=0,y=0,y1=0,y2=0,y3=0,yy=2,yy1=2,yy2=2,yy3=2,i=0;
    Switch t1,t2,t3,t4;
    TextView l1,l2,l3,l4;
    Button btnpar,btnbckp,ulangi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.paralel_page);

        t1 = findViewById(R.id.tombol1);
        t2 = findViewById(R.id.tombol2);
        t3 = findViewById(R.id.tombol3);
        t4 = findViewById(R.id.tombol4);
        l1 = findViewById(R.id.label1);
        l2 = findViewById(R.id.label2);
        l3 = findViewById(R.id.label3);
        l4 = findViewById(R.id.label4);
        btnpar = findViewById(R.id.paralelsend);
        btnbckp = findViewById(R.id.backpar);
        ulangi = findViewById(R.id.ulang);


        GraphView graph = (GraphView) findViewById(R.id.serialsignal);
        GraphView graph1 = (GraphView) findViewById(R.id.serialsignal1);
        GraphView graph2 = (GraphView) findViewById(R.id.serialsignal2);
        GraphView graph3 = (GraphView) findViewById(R.id.serialsignal3);

        series = new LineGraphSeries<DataPoint>();
        series1 = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();
        series3 = new LineGraphSeries<DataPoint>();

        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setXAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(4);
        viewport.setMinX(0);
        viewport.setMaxX(18);
        viewport.setScrollable(true);

        graph1.addSeries(series1);
        // customize a little bit viewport
        Viewport viewport1 = graph1.getViewport();
        viewport1.setYAxisBoundsManual(true);
        viewport1.setXAxisBoundsManual(true);
        viewport1.setMinY(0);
        viewport1.setMaxY(4);
        viewport1.setMinX(0);
        viewport1.setMaxX(18);
        viewport1.setScrollable(true);

        graph2.addSeries(series2);
        // customize a little bit viewport
        Viewport viewport2 = graph2.getViewport();
        viewport2.setYAxisBoundsManual(true);
        viewport2.setXAxisBoundsManual(true);
        viewport2.setMinY(0);
        viewport2.setMaxY(4);
        viewport2.setMinX(0);
        viewport2.setMaxX(18);
        viewport2.setScrollable(true);

        graph3.addSeries(series3);
        // customize a little bit viewport
        Viewport viewport3 = graph3.getViewport();
        viewport3.setYAxisBoundsManual(true);
        viewport3.setXAxisBoundsManual(true);
        viewport3.setMinY(0);
        viewport3.setMaxY(4);
        viewport3.setMinX(0);
        viewport3.setMaxX(18);
        viewport3.setScrollable(true);



     t1.setChecked(false);
        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    l1.setText("1");
                }else {
                    l1.setText("0");
                }
            }
        });

        t2.setChecked(false);
        t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    l2.setText("1");
                }else {
                    l2.setText("0");
                }
            }
        });


        t3.setChecked(false);
        t3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    l3.setText("1");
                }else {
                    l3.setText("0");
                }
            }
        });

        t4.setChecked(false);
        t4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    l4.setText("1");
                }else {
                    l4.setText("0");
                }
            }
        });




        btnpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i = 0;
                int p1 = Integer.valueOf(l1.getText().toString());
                int p2 = Integer.valueOf(l2.getText().toString());
                int p3 = Integer.valueOf(l3.getText().toString());
                int p4 = Integer.valueOf(l4.getText().toString());

                if(p1==0 && p2==0 && p3==0 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp0();
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

                else if(p1==0 && p2==0 && p3==0 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp1();

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




                else if(p1==0 && p2==0 && p3==1 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp2();
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


                else if(p1==0 && p2==0 && p3==1 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp3();
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

                else if(p1==0 && p2==1 && p3==0 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp4();
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

                else if(p1==0 && p2==1 && p3==0 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp5();
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

                else if(p1==0 && p2==1 && p3==1 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp6();
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

                else if(p1==0 && p2==1 && p3==1 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp7();
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


                else if(p1==1 && p2==0 && p3==0 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp8();
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

                else if(p1==1 && p2==0 && p3==0 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp9();
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

                else if(p1==1 && p2==0 && p3==1 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp10();
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

                else if(p1==1 && p2==0 && p3==1 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp11();
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

                else if(p1==1 && p2==1 && p3==0 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp12();
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


                else if(p1==1 && p2==1 && p3==0 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp13();
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

                else if(p1==1 && p2==1 && p3==1 && p4 ==0){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp14();
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

                else if(p1==1 && p2==1 && p3==1 && p4 ==1){
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // we add 100 new entries
                            for ( i = 0; i <= 18; i++) {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        sinyalp15();
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

        btnbckp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backp = new Intent(paralel_page.this, Home.class);
                startActivity(backp);
            }
        });


        ulangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ulangi = new Intent(paralel_page.this,paralel_page.class);
                startActivity(ulangi);
            }
        });

    }



    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph

    }

    // add random data to graph
    public void sinyalp0() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }


    public void sinyalp1() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp2() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp3() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp4() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp5() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp6() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp7() {
        series.appendData(new DataPoint(lastX++, y), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp8() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp9() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp10() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp11() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, y1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp12() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp13() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, y2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

    public void sinyalp14() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, y3), false,18);
    }

    public void sinyalp15() {
        series.appendData(new DataPoint(lastX++, yy), false,18);
        series1.appendData(new DataPoint(lastX1++, yy1), false,18);
        series2.appendData(new DataPoint(lastX2++, yy2), false,18);
        series3.appendData(new DataPoint(lastX3++, yy3), false,18);
    }

}