package jp.asahi.com.matometestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TotalAssetsTransitionActivity extends AppCompatActivity implements TabClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_assets_transition_activity);
        createLineChart();
    }

    @Override
    public void OnClickTabButton(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.tab_layout_home:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_registration:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_notification:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.tab_layout_setting:
                intent = new Intent(this, HomeActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ExhibitionRequestTutorialOneActivity.class);
        startActivity(intent);
    }

    private void createLineChart() {
        LineChart lineChart = (LineChart) findViewById(R.id.detail_activity_line_chart);

        lineChart.setData(createLineChartData());

        // 軸の設定
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMinimum(lineChart.getLineData().getXMin() - 1);
        xAxis.setAxisMaximum(lineChart.getLineData().getXMax() + 1);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) Math.floor(value) + "月";
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setAxisMaximum(lineChart.getLineData().getYMax() + 10000f);
        leftAxis.setAxisMinimum(lineChart.getLineData().getYMin() - 10000f);
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                String s = "";
                int price = (int) value;
                while (price > 0) {
                    if (price < 1000) {
                        s = price + s;
                        price = 0;
                    } else {
                        if (price % 1000 == 0) {
                            s = ",000" + s;
                        } else if (price % 1000 < 10) {
                            s = ",00" + price % 1000 + s;
                        } else if (price % 1000 < 100) {
                            s = ",0" + price % 1000 + s;
                        } else {
                            s = "," + price % 1000 + s;
                        }
                        price /= 1000;
                    }
                }
                return "￥" + s;
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        // 凡例の設定
        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        // 詳細の設定
        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);

        lineChart.invalidate();
        lineChart.animateX(1000);
    }

    private LineData createLineChartData() {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        ArrayList<Integer> colors = new ArrayList<>();

        yVals.add(new Entry(5, 210000));
        yVals.add(new Entry(6, 200000));
        yVals.add(new Entry(7, 230000));
        yVals.add(new Entry(8, 235000));
        yVals.add(new Entry(9, 240000));

        LineDataSet dataSet = new LineDataSet(yVals, "price");

        colors.add(ColorTemplate.COLORFUL_COLORS[0]);
        dataSet.setColors(colors);

        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(2);

        LineData data = new LineData(dataSet);
        data.setDrawValues(false);
//        data.setValueTextSize(12f);
//        data.setValueTextColor(Color.BLACK);
        return data;
    }
}
