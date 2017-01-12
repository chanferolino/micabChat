package org.awesomeapp.messenger;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.MimeTypeMap;

import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import im.zom.messenger.R;


public class CloudinaryManager extends AsyncTask<Object, Void, Map> {

    private static final String CLOUD_NAME = "cloud_name";
    private static final String API_KEY = "api_key";
    private static final String API_SECRET = "api_secret";

    private UploadCallBack callBack;
    private com.cloudinary.Cloudinary cloudinary;
    private Context context;

    public interface UploadCallBack{
         void onResponse(Boolean isSuccess, String URL);
    }

    public CloudinaryManager(Context context, UploadCallBack callBack) {
        super();

        this.context = context;
        this.callBack = callBack;
        initCloudinary();
    }

    @SuppressWarnings("unchecked")
    private void initCloudinary() {
        Map config = new HashMap();
        config.put(CLOUD_NAME, context.getResources().getString(R.string.cloudinary_name));
        config.put(API_KEY, context.getResources().getString(R.string.cloudinary_key));
        config.put(API_SECRET, context.getResources().getString(R.string.cloudinary_secret));
        cloudinary = new com.cloudinary.Cloudinary(config);
    }

    @Override
    protected Map doInBackground(Object... uris) {
        Map response = null;
        if (uris.length > 0) {
            Uri uri = (Uri) uris[0];
            String type = MimeTypeMap.getFileExtensionFromUrl(uri.toString() );
            Log.e("TAG","FORMAT " + type + " " + uri);
            if(type == null || type.isEmpty()){
                type = getFileExt(uri.toString());
                Log.e("TAG","FORMATer " + type);
            }
            try {
                File file = new File(uri.getPath());
                response = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            } catch (Exception e1) {
                e1.printStackTrace();
                //
                // Retrieve the file as a stream
                //
                try {
                    InputStream stream = context.getContentResolver().openInputStream(uri);
                    response = cloudinary.uploader().uploadLargeRaw(stream, ObjectUtils.asMap("format",type));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        return response;
    }

    @Override
    protected void onPostExecute(Map result){
        try {
            if (result == null) {
                callBack.onResponse(false, null);
            } else {
                callBack.onResponse(true, result.get("url").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }
}
