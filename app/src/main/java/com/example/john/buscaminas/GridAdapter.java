package com.example.john.buscaminas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridAdapter extends BaseAdapter {
    private Cell[][] matrix;
    private Context context;

    GridAdapter(Context context) {
        this.context = context;
        this.matrix = MineSweeper.MATRIZ;
    }

    @Override
    public int getCount() {
        return MineSweeper.GRID_HEIGHT * MineSweeper.GRID_WIDTH;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int x = position % MineSweeper.GRID_WIDTH;
        int y = position / MineSweeper.GRID_WIDTH;
        return matrix[x][y];
    }
}
