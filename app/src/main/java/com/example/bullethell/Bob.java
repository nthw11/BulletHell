package com.example.bullethell;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
class Bob {
    RectF mRect;
    float mBobHeight;
    float mBobWidth;
    boolean mTeleporting = false;
    Bitmap mBitmap;

    public Bob(Context context, float screenX, float screenY){
        mBobHeight = screenY / 10;
        mBobWidth = mBobHeight / 2;

        mRect = new RectF(screenX / 2,
                screenY / 2,
                (screenX / 2) + mBobWidth,
                (screenY / 2) + mBobHeight);

        // prepare the bitmap
        // load bob from his .png file
        // bob practices responsible encapsulation looking after his own resources
        mBitmap = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.bob);
    }

    boolean teleport(float newX, float newY){
        // did bob manage to teleport?
        boolean success = false;

        // move bob to the new position if not already teleporting
        if(!mTeleporting){

            // make him roughly central to the touch
            mRect.left = newX - mBobWidth / 2;
            mRect.top = newY - mBobHeight / 2;
            mRect.bottom = mRect.top + mBobHeight;
            mRect.right = mRect.left + mBobWidth;
            mTeleporting = true;
// Notify BulletHellGame that teleport
// attempt was successful
            success = true;
        }
        return success;
    }

    void setTelePortAvailable(){
        mTeleporting = false;
    }

    // return a reference to mRect
    RectF getRect(){
        return mRect;
    }

    // return a reference to bitmap
    Bitmap getBitmap(){
        return mBitmap;
    }
}
