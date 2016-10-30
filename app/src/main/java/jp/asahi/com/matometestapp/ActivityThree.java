package jp.asahi.com.matometestapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        ArrayList<Item> items = new ArrayList<>();

        int images[] = {
                R.drawable.monogram,
                R.drawable.globe_master,
                R.drawable.lambskin,
                R.drawable.planet_ocean
        };

        String types[] = {
            "バッグ",
            "時計",
            "バッグ",
            "時計"
        };

        String brands[] = {
            "ルイヴィトン",
            "オメガ",
            "シャネル",
            "オメガ"
        };

        String texts[] = {
            "モノグラム",
            "グローブマスター",
            "ラムスキン",
            "プラネットオーシャン"
        };

        int prices[] = {
            240000, 350000, -1, 300000
        };

        for(int i = 0; i < images.length; ++i) {
            Item item = new Item();

            item.setImage(images[i]);
            item.setType(types[i]);
            item.setBrand(brands[i]);
            item.setText(texts[i]);
            item.setPrice(prices[i]);

            items.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this, 0, items);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id
            ) {
                TextView name = (TextView) view.findViewById(R.id.type);
                Toast.makeText(
                        ActivityThree.this,
                        Integer.toString(position) + ":" + name.getText().toString(),
                        Toast.LENGTH_SHORT
                ).show();
                onClick(view);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityFour.class);
        startActivity(intent);
    }

    static class ViewHolder {
        ImageView image;
        TextView type;
        TextView brand;
        TextView text;
        TextView price;
    }

    public class ItemAdapter extends ArrayAdapter<Item> {
        private LayoutInflater layoutInflater;

        public ItemAdapter(Context c, int id, ArrayList<Item> items){
            super(c, id, items);
            this.layoutInflater = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent){
            ViewHolder holder = new ViewHolder();

            if(convertView == null){
                convertView = layoutInflater.inflate(
                        R.layout.item_layout,
                        parent,
                        false
                );
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                holder.type = (TextView) convertView.findViewById(R.id.type);
                holder.brand = (TextView) convertView.findViewById(R.id.brand);
                holder.text = (TextView) convertView.findViewById(R.id.text);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            Item item = (Item) getItem(pos);

            holder.image.setImageResource(item.getImage());
            holder.type.setText(item.getType());
            holder.brand.setText(item.getBrand());
            holder.text.setText(item.getText());
            if(item.getPrice() != -1) {
                holder.price.setText("￥"+item.getPrice());
            } else {
                holder.price.setText("査定中");
                holder.price.setTextColor(Color.rgb(0,0,255));
            }

            return convertView;
        }
    }

    public class Item {
        private int image;
        private String type;
        private String brand;
        private String text;
        private int price;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
