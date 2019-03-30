package com.example.anusirohi.constraintsdemologin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ListViewHolder> {

    private LayoutInflater mLayoutInflater;
    private ArrayList<String> countryList ;

    CountryListAdapter(Activity activity, ArrayList<String> countryList) {
//        Activity mActivity = activity;
        this.countryList = countryList;
        mLayoutInflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.row_item, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
//        holder.bindData(countryList.get(position));
        holder.text_opifex.setText(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_opifex)
        TextView text_opifex;
        @BindView(R.id.constraint_root)
        ConstraintLayout constraint_root;

        ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
