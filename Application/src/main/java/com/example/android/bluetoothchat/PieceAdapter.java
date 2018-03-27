package com.example.android.bluetoothchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.common.chess.Colour;
import com.example.android.common.chess.Field;
import com.example.android.common.chess.GameManager;
import com.example.android.common.chess.Piece;

/**
 * Created by jakub on 25/03/2018.
 */

public class PieceAdapter extends BaseAdapter {
    private Context mContext;
    private Field[][] board;
    private Resources r;
    private int width = 720;

    public PieceAdapter(Context c, Resources r) {
        mContext = c;
        this.board = GameManager.getInstance().getBoard();
        this.r = r;
        this.width = r.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getCount() {
        return 64;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(width/9, width/9));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        int x = position/8;
        int y = position%8;
        Field field = board[x][y];
        Piece piece = field.getPiece();
        if (piece != null) {
            imageView.setImageResource(piece.getDrawableId());
        } else {
           // imageView.setImageResource(fieldDrawableId(field));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            imageView.setBackground(r.getDrawable(fieldDrawableId(field)));
        }

        return imageView;
    }

    private int fieldDrawableId(Field field) {
        if (field.isHighlighted())
            return R.drawable.fuchsia;
        else if(field.getColour() == Colour.Black)
            return R.drawable.black_tile;
        else
            return R.drawable.white_tile;
    }
}