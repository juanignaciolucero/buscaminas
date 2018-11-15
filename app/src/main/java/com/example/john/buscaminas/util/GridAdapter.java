package com.example.john.buscaminas.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.john.buscaminas.view.Cell;

public class GridAdapter extends BaseAdapter {
    private Cell[][] matrix;
    private Context context;
    private MineSweeper core;

    public GridAdapter(Context context) {
        this.context = context;
        core = MineSweeper.getInstance();
        this.matrix = core.getMatrix();
    }

    @Override
    public int getCount() {
        return core.getGRID_HEIGHT() * core.getGRID_WIDTH();
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
        int x = position % core.getGRID_WIDTH();
        int y = position / core.getGRID_WIDTH();
        return matrix[x][y];
    }
}
