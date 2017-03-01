package com.example.admin.sheradelemanttrangaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.sheradelemanttrangaction.glide_activity_to_activity.GlideActivityA;
import com.example.admin.sheradelemanttrangaction.glide_fragment_to_fragment.GlideFragmentToFragmentActivity;
import com.example.admin.sheradelemanttrangaction.picasso_activity_to_activity.PicassoActivityA;
import com.example.admin.sheradelemanttrangaction.picasso_fragment_to_fragment.PicassoFragmentToFragmentActivity;
import com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_activity.RecyclerViewActivity;
import com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_fragment.RecyclerViewToFragmentActivity;
import com.example.admin.sheradelemanttrangaction.recycler_view.recycler_view_to_viewpager.RecyclerViewToViewPagerActivity;
import com.example.admin.sheradelemanttrangaction.simple_activity_to_activity.SimpleActivityA;
import com.example.admin.sheradelemanttrangaction.simple_fragment_to_fragment.FragmentToFragmentActivity;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Months;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TIME_SERVER = "time-a.nist.gov";
    Button a_to_a, f_to_f, ga_to_ga, gf_to_gf, pa_to_pa, pf_to_f, ra_to_ra, rf_to_rf, rv_to_rv;
    int tempAttempt = 0;
/*

    @Override
    protected void onResume() {
        super.onResume();
        if (ApplicationLifecycleHandler.isInBackground){
            Toast.makeText(getApplicationContext(),"Application In Background",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Application In Forground",Toast.LENGTH_SHORT).show();
        }
    }
*/

    public static void printTimes() throws IOException {
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        //long returnTime = timeInfo.getReturnTime();   //local device time
        long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();   //server time

        //Get Current Time
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();
        Log.e("After get PrintTime..", "After get PrintTime..>>" + ts);


        Log.e("getCurrentNetworkTime", "Time from " + TIME_SERVER + ": " + returnTime/*time*/);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a_to_a = (Button) findViewById(R.id.a_to_a);
        f_to_f = (Button) findViewById(R.id.f_to_f);
        ga_to_ga = (Button) findViewById(R.id.ga_to_ga);
        gf_to_gf = (Button) findViewById(R.id.gf_to_gf);
        pa_to_pa = (Button) findViewById(R.id.pa_to_pa);
        pf_to_f = (Button) findViewById(R.id.pf_to_f);
        ra_to_ra = (Button) findViewById(R.id.ra_to_ra);
        rf_to_rf = (Button) findViewById(R.id.rf_to_rf);
        rv_to_rv = (Button) findViewById(R.id.rv_to_rv);

        a_to_a.setOnClickListener(this);
        f_to_f.setOnClickListener(this);
        ga_to_ga.setOnClickListener(this);
        gf_to_gf.setOnClickListener(this);
        pa_to_pa.setOnClickListener(this);
        pf_to_f.setOnClickListener(this);
        ra_to_ra.setOnClickListener(this);
        rf_to_rf.setOnClickListener(this);
        rv_to_rv.setOnClickListener(this);
      /*  SendfeedbackJob job = new SendfeedbackJob();
        job.execute();*/
        // Log.e("asdjkhjkfhsdf",getUTCTime()+"");
        //jodaTime();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a_to_a:
                startActivity(new Intent(MainActivity.this, SimpleActivityA.class));
                break;
            case R.id.f_to_f:
                startActivity(new Intent(MainActivity.this, FragmentToFragmentActivity.class));
                break;
            case R.id.ga_to_ga:
                startActivity(new Intent(MainActivity.this, GlideActivityA.class));
                break;
            case R.id.gf_to_gf:
                startActivity(new Intent(MainActivity.this, GlideFragmentToFragmentActivity.class));
                break;
            case R.id.pa_to_pa:
                startActivity(new Intent(MainActivity.this, PicassoActivityA.class));
                break;
            case R.id.pf_to_f:
                startActivity(new Intent(MainActivity.this, PicassoFragmentToFragmentActivity.class));
                break;
            case R.id.ra_to_ra:
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                break;
            case R.id.rf_to_rf:
                startActivity(new Intent(MainActivity.this, RecyclerViewToFragmentActivity.class));
                break;
            case R.id.rv_to_rv:
                startActivity(new Intent(MainActivity.this, RecyclerViewToViewPagerActivity.class));
                break;
        }
    }

    public String getTime() {
        try {
            //Make the Http connection so we can retrieve the time
            HttpClient httpclient = new DefaultHttpClient();
            // I am using yahoos api to get the time
            HttpResponse response = httpclient.execute(new HttpGet("http://developer.yahooapis.com/TimeService/V1/getTime?appid=YahooDemo"));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                // The response is an xml file and i have stored it in a string
                String responseString = out.toString();
                Log.d("Response", responseString);
                //We have to parse the xml file using any parser, but since i have to
                //take just one value i have deviced a shortcut to retrieve it
                int x = responseString.indexOf("<Timestamp>");
                int y = responseString.indexOf("</Timestamp>");
                //I am using the x + "<Timestamp>" because x alone gives only the start value
                Log.d("Response", responseString.substring(x + "<Timestamp>".length(), y));
                String timestamp = responseString.substring(x + "<Timestamp>".length(), y);
                // The time returned is in UNIX format so i need to multiply it by 1000 to use it
                Date d = new Date(Long.parseLong(timestamp) * 1000);
                Log.d("Response", d.toString());
                return d.toString();
            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            Log.e("Response", e.getMessage());
        } catch (IOException e) {
            Log.e("Response", e.getMessage());
        }
        return null;
    }

    public long getUTCTime() {
        long nowAsPerDeviceTimeZone = 0;
        SntpClient sntpClient = new SntpClient();

        if (sntpClient.requestTime("0.africa.pool.ntp.org", 50000)) {
            nowAsPerDeviceTimeZone = sntpClient.getNtpTime();
            /*Calendar cal = Calendar.getInstance();
            TimeZone timeZoneInDevice = cal.getTimeZone();
            int differentialOfTimeZones = timeZoneInDevice.getOffset(System.currentTimeMillis());
            nowAsPerDeviceTimeZone -= differentialOfTimeZones;*/
        }
        return nowAsPerDeviceTimeZone;
    }

    public void jodaTime() {
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");
        String dob = "2002-01-15";
        LocalTime localTime = new LocalTime();
        LocalDate localDate = new LocalDate();
        DateTime dateTime = new DateTime();
        LocalDateTime localDateTime = new LocalDateTime();
        DateTimeZone dateTimeZone = DateTimeZone.getDefault();

        System.out.println("dateFormatr : " + dateFormat.print(localDateTime));
        System.out.println("LocalTime : " + localTime.toString());
        System.out.println("localDate : " + localDate.toString());
        System.out.println("dateTime : " + dateTime.toString());
        System.out.println("localDateTime : " + localDateTime.toString());
        System.out.println("DateTimeZone : " + dateTimeZone.toString());
        System.out.println("Year Difference : " + Years.yearsBetween(DateTime.parse(dob), dateTime).getYears());
        System.out.println("Month Difference : " + Months.monthsBetween(DateTime.parse(dob), dateTime).getMonths());
    }

    private long getTimeJsop() throws Exception {
        String url = "https://time.is/Unix_time_now";
        Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
        String[] tags = new String[]{
                "div[id=time_section]",
                "div[id=clock0_bg]"
        };
        Elements elements = doc.select(tags[0]);
        for (int i = 0; i < tags.length; i++) {
            elements = elements.select(tags[i]);
        }
        return Long.parseLong(elements.text() + "000");
    }

    private class SendfeedbackJob extends AsyncTask<Void, Void, Void> {
        long serverTime = 0;

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Long tsLong = System.currentTimeMillis() / 1000;
                String ts = tsLong.toString();
                Log.e("PrintTime..", "PrintTime..>>" + ts);

                serverTime = getUTCTime();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void time) {
            //process message
            if (serverTime == 0) {
                if (tempAttempt < 3) {
                    SendfeedbackJob job = new SendfeedbackJob();
                    job.execute();
                    tempAttempt++;
                    Log.e("Server time Attempt", tempAttempt + "");
                } else {
                    Log.e("no Server time ", serverTime + "");
                }

            } else {
                Log.e("Server TIME Found", serverTime + "");
            }
        }
    }
}
