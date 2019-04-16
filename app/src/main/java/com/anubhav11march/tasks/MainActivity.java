package com.anubhav11march.tasks;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
//    ListView listView;
//    String[] itemnames = {"Asus Zenfone Max Pro M2"
////            "Redmi Note 6 Pro", "Asus Zenfone Max M2", "Honor 9N", "Realme 2 Pro", "Nokia 5.1 Plus", "Google Pixel 3", "Redmi 6", "Poco F1", "Apple Iphone 6", "Asus Zenfone Max Pro M1", "Realme 3", "Redmi Note 7",
////    "Samsung S10 series", "Asus Zenfone 5Z", "Oppo F11 Pro", "Samsung A50", "Samsung Galaxy On 6", "Samsung A30", "Honor 10 Lite", "redmi Note 5 Pro", "Vivo V15 Pro", "Lenovo K9"
//    };
//
//    Integer[] logo = {R.drawable.img1
//
//    };

    RecyclerView recyclerView;
    Context context;
    private List<item> items;
    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items, this);
        initializeData();
        initializeAdapter();






    }

    private void notification(){
        int nid = 0;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("A notification")
                .setContentText("You have started the task app")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId =  "YOUR_CHANNEL_ID";
            NotificationChannel channel = new NotificationChannel(channelId, "Channel human readabale titel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(nid, builder.build());
    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    private void initializeData(){
        items = new ArrayList<>();
        items.add(new item("Asus Zenfone Max Pro M1", R.drawable.img2, "@strings/oprice1", "\u20B9 9,999", "https://www.amazon.in/Certified-REFURBISHED-Asus-Zenfone-ZB601KL-4D101IN/dp/B07JNSH5X8/ref=as_sl_pc_qf_sp_asin_til?tag=muar-21&linkCode=w00&linkId=3a8c194102d78acd661a1c940d289f40&creativeASIN=B07JNSH5X8"));
        items.add(new item("Honor 9 lite", R.drawable.img3, "@strings/oprice1", "\u20B9 10,999", "https://www.google.com/search?rlz=1C1CHBF_enIN809IN809&ei=S1O0XLepH_rhz7sPvKuSyAM&q=buy+honor+9+lite&oq=buy+honor+9+lite&gs_l=psy-ab.1.0.0l6j0i22i30l4.1463935.1466965..1468334...1.0..0.298.2200.0j11j2....2..0....1..gws-wiz.......0i71j0i67j0i10j0i20i263j0i131.AtWxmiMyop4"));
        items.add(new item("Nokia 6.1", R.drawable.img4, "@strings/oprice1", "\u20B9 14,999", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=B1m0XJKACYu40PEPv6agyAI&q=buy+nokia+6.1&oq=buy+nokia+6.1&gs_l=psy-ab.3..0l10.23528.26090..26268...1.0..0.366.1979.0j7j2j1....2..0....1..gws-wiz.......0i71j35i39j0i67j0i20i263j0i13.lVbc0UlOXPk"));
        items.add(new item("Oneplus 5", R.drawable.img5, "@strings/oprice1", "\u20B9 37,999", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=JFm0XPj5BoWYvQTjm6DoDg&q=buy+oneplus+5&oq=buy+oneplus+5&gs_l=psy-ab.3..0l10.20764.21944..22364...0.0..0.176.1340.0j9....3..0....1..gws-wiz.......0i67.pYYyjl8bUTg"));
        items.add(new item("Moto G5 plus", R.drawable.img6, "@strings/oprice1", "\u20B9 14,999", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=O1m0XL31GcnSvATUuY-YAg&q=buy+moto+g5+plus&oq=buy+moto+g5+plus&gs_l=psy-ab.3..0l5j0i22i30.16039.19002..19215...1.0..0.166.1879.0j13....2..0....1..gws-wiz.......0i71j0i20i263j0i67.NavBCcX2gVo"));
        items.add(new item("Karbonn Android One", R.drawable.img7, "@strings/oprice1", "\u20B9 2,899", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=T1m0XLKMIJPMvwS0m6qoDA&q=buy+karbonn+android+one&oq=buy+karbonn+android+one&gs_l=psy-ab.3..33i22i29i30l10.14918.19226..19372...0.0..0.230.2240.0j13j1....2..0....1..gws-wiz.......0i71j0i67j0j0i22i30j0i22i10i30j33i21j33i160.MZoclgkjmjw"));
        items.add(new item("Iphone 6", R.drawable.img8, "@strings/oprice1", "\u20B9 11,999", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=Y1m0XMLiPIjOvgS4j5aADQ&q=buy+iphone+6&oq=buy+iphone+6&gs_l=psy-ab.3..0i20i263j0l9.32118.33491..33776...0.0..0.171.1248.0j8....2..0....1..gws-wiz.......0i71j0i67j0i131j0i131i67.AqO7ZwYho9Y"));
        items.add(new item("Xiaomi Redmi Note 4", R.drawable.img9, "@strings/oprice1", "\u20B9 10,999", "https://www.google.com/search?hl=en-IN&authuser=0&rlz=1C1CHBF_enIN809IN809&ei=hlm0XP2DJoWmwgPdzYNY&q=buy+xaiomi+redmi+note+4&oq=buy+xaiomi+redmi+note+4&gs_l=psy-ab.3..0i13j0i13i30l9.12250.15212..15519...0.0..0.200.3085.0j18j1......0....1..gws-wiz.......0i71j0i67j0j0i10.nNFt3QwZYlA"));



    }

    public void cshko(View view){
        Toast.makeText(this, "Opening ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, wbvw.class);
        intent.putExtra("url", "https://learning.clubcashkaro.com/");
        startActivity(intent);
    }

    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items, this);
        recyclerView.setAdapter(adapter);
    }
}




class item{
    String name;
    int logoid;
    String oprice;
    String dprice;
    String url;

    item(String name, int logoid, String oprice, String dprice, String url){
        this.name = name;
        this.logoid = logoid;
        this.dprice = dprice;
        this.oprice = oprice;
        this.url = url;
    }
}


