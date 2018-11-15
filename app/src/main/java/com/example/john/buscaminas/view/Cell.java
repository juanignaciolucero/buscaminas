package com.example.john.buscaminas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import android.util.AttributeSet;
import android.view.View;

import com.example.john.buscaminas.R;
import com.example.john.buscaminas.util.MineSweeper;

public class Cell extends androidx.appcompat.widget.AppCompatImageView implements View.OnClickListener, View.OnLongClickListener {
    private boolean isBomb;
    private MineSweeper core;
    private int neighbors;
    private boolean isRevealed;
    private boolean isFlagged;
    private boolean ended;
    private int[] numbers = {R.drawable.number_0, R.drawable.number_1,
            R.drawable.number_2, R.drawable.number_3,
            R.drawable.number_4, R.drawable.number_5,
            R.drawable.number_6, R.drawable.number_7,
            R.drawable.number_8};


    private int position;

    public Cell(Context context, AttributeSet attrs, int position) {

        super(context);
        core = MineSweeper.getInstance();
        this.position = position;
        this.isRevealed = false;
        this.isFlagged = false;
        this.ended = false;
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int draw = R.drawable.button;
        if (isFlagged()) {
            if (ended && !isBomb()) {
                draw = R.drawable.bomb_wrong;
            } else {
                draw = R.drawable.flag;
            }
        } else if (isRevealed()) {
            if (!isBomb()) {
                draw = numbers[neighbors];
            } else {
                draw = R.drawable.bomb_exploded;
            }
        } else if (isBomb() && core.isEnded()) {
            draw = R.drawable.bomb_normal;
        }

        Drawable button = ContextCompat.getDrawable(getContext(), draw);
        button.setBounds(0, 0, getWidth(), getHeight());
        button.draw(canvas);
    }

    @Override
    public void onClick(View v) {
        if (!ended) {
            if (!isRevealed) {
                setRevealed();
                invalidate();
                if (neighbors == 0) {
                    core.click(position);
                }
                if (isBomb()) {
                    core.endGame();
                }
                core.checkForWin();
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (!ended) {
            if (!isRevealed()) {
                if(!isFlagged()){
                    core.setBombsLeft(core.getBombsLeft()-1);
                }else{
                    core.setBombsLeft(core.getBombsLeft()+1);
                }
                setFlagged();
                invalidate();
            }
        }
        return true;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setBomb() {

        isBomb = true;
    }

    public boolean isBomb() {

        return isBomb;
    }

    public void setNeighbors(int neighbors) {

        this.neighbors = neighbors;
    }

    public boolean isRevealed() {

        return isRevealed;
    }

    public void setRevealed() {

        isRevealed = true;
    }

    public boolean isFlagged() {

        return isFlagged;
    }

    public void setFlagged() {

        isFlagged = !isFlagged;
    }

    public void end() {

        this.ended = true;
        invalidate();
    }

    public void setCore(MineSweeper core) {

        this.core = core;
    }
}
