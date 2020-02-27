package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.GateView> {

    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public GateView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_layout,parent,false);
        GateView gateView = new GateView(view);
        return gateView;
    }

    @Override
    public void onBindViewHolder(@NonNull GateView holder, int position) {

        final User user = userList.get(position);
        holder.id.setText(""+user.getId());
        holder.name.setText(""+user.getName());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_access_alarm_black_24dp));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+user.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ViewActivity.class);
                intent.putExtra("Id",""+user.getId());
                intent.putExtra("Name",""+user.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class GateView extends RecyclerView.ViewHolder{

        TextView id,name;
        ImageView imageView;

        public GateView(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.u_id);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
        }
    }

}
