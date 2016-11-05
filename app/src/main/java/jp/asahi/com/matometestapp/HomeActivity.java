package jp.asahi.com.matometestapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements TabClick {
    public static final String EXTRA_ITEM_NUM = "jp.asahi.com.matometestapp.item_num";
    public static final int TAG_KEY_OF_NUMBER_OF_VIEW = 314159265;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        ArrayList<Item> items = new ArrayList<>();


        for (int i = 0; i < TopActivityItemList.images.length; ++i) {
            Item item = new Item();

            item.setImage(TopActivityItemList.images[i]);
            item.setType(TopActivityItemList.types[i]);
            item.setBrand(TopActivityItemList.brands[i]);
            item.setText(TopActivityItemList.texts[i]);
            item.setPrice(TopActivityItemList.prices[i]);
            item.setNumber(i);

            items.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this, 0, items);
        ListView listView = (ListView) findViewById(R.id.home_activity_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id
            ) {
                onClick(view);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_ITEM_NUM, (int) v.getTag(TAG_KEY_OF_NUMBER_OF_VIEW));
        startActivity(intent);
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
                        R.layout.home_activity_item_layout,
                        parent,
                        false
                );
                holder.image = (ImageView) convertView.findViewById(R.id.home_activity_item_layout_image);
                holder.type = (TextView) convertView.findViewById(R.id.home_activity_item_layout_type);
                holder.brand = (TextView) convertView.findViewById(R.id.home_activity_item_layout_brand);
                holder.text = (TextView) convertView.findViewById(R.id.home_activity_item_layout_text);
                holder.price = (TextView) convertView.findViewById(R.id.home_activity_item_layout_price);
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
                String s = "";
                int price = item.getPrice();
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
                holder.price.setText("￥" + s);
            } else {
                holder.price.setText("査定中");
                holder.price.setTextColor(Color.rgb(0,0,255));
            }
            convertView.setTag(TAG_KEY_OF_NUMBER_OF_VIEW, item.getNumber());

            return convertView;
        }
    }

    public class Item {
        private int image;
        private String type;
        private String brand;
        private String text;
        private int price;
        private int number;

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

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
