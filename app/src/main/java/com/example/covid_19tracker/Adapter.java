package com.example.covid_19tracker;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    int m=1;
   Context context;
    List<modelClass> countrylist;

    public Adapter(Context context, List<modelClass> countrylist)

    {
        this.context=context;
        this.countrylist=countrylist;
    }




    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
modelClass modelClass=countrylist.get(position);
if (m==1)
{
holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getCases())));
}

       else if (m==2)
        {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getRecovered())));
        }
     else   if (m==3)
        {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getDeaths())));
        }
      else
          {
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getActive())));
        }
        holder.country.setText(modelClass.getCountry());
        //holder.country.setText(modelClass.getCountry());
    }

    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cases,country;
        public ViewHolder(View itemview){
            super(itemview);
            cases=itemview.findViewById(R.id.coutrycase);
            country=itemview.findViewById(R.id.coutryname);
        }
    }

    public void filter(String charText)
    {
        Toast.makeText(context,charText, Toast.LENGTH_SHORT).show();
        if(charText.equals("cases"))
        {
            m=1;
        }
        else if(charText.equals("recovered"))
        {
            m=2;
        }
        else if(charText.equals("deaths"))
        {
            m=3;
        }
        else
        {
            m=4;
        }
        notifyDataSetChanged();
    }

}
