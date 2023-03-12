package com.example.imagepeoplelist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PeopleArrayAdapter extends ArrayAdapter<Person> {

    private final Context context;
    private final int layout;
    private final Person[] people;

    public PeopleArrayAdapter(Context context, int layout, Person[] people) {
        super(context, layout, people);

        this.context = context;
        this.layout = layout;
        this.people = people;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // get inflater and inflate the row layout
        LayoutInflater inflater = LayoutInflater.from(this.context);

        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, null);

        // get connected with the row layout components
        ImageView icon = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.textView);
        TextView subtitle = view.findViewById(R.id.textView2);

        // populate these components
        Person person = this.people[position];
        title.setText(person.getName());
        subtitle.setText(person.getPhone());

        // translate the image name into image resource id after removing the image extension
        String name = person.getImage();
        name = name.substring(0, name.indexOf('.'));

        @SuppressLint("DiscouragedApi")
        int imageId = this.context.getResources()
                .getIdentifier(name, "drawable", this.context.getPackageName());

        icon.setImageResource(imageId);

        return view;
    }
}
