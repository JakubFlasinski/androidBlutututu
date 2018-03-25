package com.example.android.bluetoothchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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

    public PieceAdapter(Context c) {
        mContext = c;
        this.board = GameManager.getInstance().getBoard();
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
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
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
            imageView.setImageResource(field.isHighlighted() ? R.drawable.fuchsia : (field.getColour() == Colour.Black ? R.drawable.black_tile : R.drawable.white_tile));
        }

        return imageView;
    }
}