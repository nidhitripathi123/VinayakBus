package com.nidhitripathi.vinayakbus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nidhi Tripathi on 23-02-2018.
 */

public class CustomBaseAdaptor   extends BaseAdapter {
    private Activity activity;
    // private ArrayList&lt;HashMap&lt;String, String&gt;&gt; data;
    private static ArrayList title,notice;
    private static LayoutInflater inflater = null;

    public CustomBaseAdaptor(Activity a, ArrayList b, ArrayList bod) {
        activity = a;
        this.title = b;
        this.notice=bod;

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return title.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.row_listitem, null);

        TextView title2 = (TextView) vi.findViewById(R.id.txt_ttlsm_row); // title
        String song = title.get(position).toString();
        title2.setText(song);


        TextView title22 = (TextView) vi.findViewById(R.id.txt_ttlcontact_row2); // notice
        String song2 = notice.get(position).toString();
        title22.setText(song2);

        return vi;

    }}