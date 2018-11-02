package com.example.john.buscaminas;

import android.content.Context;
import android.widget.GridView;

public class Grid extends GridView {
    public Grid(Context context) {
        super(context);
        setNumColumns(MineSweeper.GRID_WIDTH);
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dimension = Math.min(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
