package framgia.imagemanagement;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by FRAMGIA\luu.vinh.loc on 20/10/2015.
 */
public class OnlineImageAdapter extends BaseAdapter {
    private Context mContext;
    public ArrayList<Object> listImageObj;
    private int imgId;
    private int preImgId;

    public OnlineImageAdapter(Context mContext, ArrayList<Object> listImageObj) {
        this.mContext = mContext;
        this.listImageObj = listImageObj;
        imgId = 0;
        preImgId = 0;
    }

    @Override
    public int getCount() {
        return listImageObj.size();
    }

    @Override
    public Object getItem(int position) {
        return listImageObj.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView;
        if (convertView == null) {
            imgView = new ImageView(mContext);
            // scale image
            imgView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(10, 10, 10, 10);
//            if (imgId >= listImageObj.size() - 1) {
//                currImgId = imgId;
//            } else if (currImgId > imgId) {
//                imgId = currImgId;
//            } else {
//                imgId++;
//            }
            if (listImageObj.size() > imgId) {
                GoogleImageBean imageBean = (GoogleImageBean) this.listImageObj.get(imgId);
                Picasso.with(mContext)
                    .load(imageBean.getThumbUrl())
                    .into(imgView);
                imgId++;
                Log.e("check_position_imageAd", "" + imgId);
            }
        } else {
            imgView = (ImageView) convertView;
        }
        return imgView;
    }
}