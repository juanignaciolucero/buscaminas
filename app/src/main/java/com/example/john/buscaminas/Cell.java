package com.example.john.buscaminas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

public class Cell extends android.support.v7.widget.AppCompatImageView implements View.OnClickListener, View.OnLongClickListener {
    private boolean isBomb;
    private int neighbors;
    private boolean isRevealed;
    private boolean isFlagged;
    private int position;

    public Cell(Context context, AttributeSet attrs, int position) {
        super(context);
        this.position = position;
        this.isRevealed = false;
        this.isFlagged = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable boton = ContextCompat.getDrawable(getContext(), R.drawable.button);
        boton.setBounds(0, 0, getWidth(), getHeight());
        boton.draw(canvas);

        super.onDraw(canvas);
        drawImage(canvas, "button");

        if( isFlagged() ){
            drawImage(canvas, "flag");
        }else if( isRevealed() && isBomb() && !isClicked() ){
            drawImage(canvas, "bomb_normal");
        }else {
            if( isClicked() ){
                if( getValue() == -1 ){
                    drawBombExploded(canvas);
                }else {
                    drawNumber(canvas);
                }
            }else{
                drawButton(canvas);
            }
        }
    }

    private void drawImage(Canvas canvas, String resource){
        int resID = getResources().getIdentifier(resource, "drawable", getContext().getPackageName());
        Drawable drawable = getResources().getDrawable(resID);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    @Override
    public void onClick(View v) {
        if (!isRevealed) {
            setRevealed();
            invalidate();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        setFlagged();
        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dimension = Math.min(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(dimension, dimension);
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

    public int getNeighbors() {

        return neighbors;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
