package ir.ea2.android_rx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<DataModel> dataModelList;

    CustomAdapter(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.txt_title.setText(dataModel.getTitle());

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView txt_title;

        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.layout_item_text_title);
        }
    }
}
