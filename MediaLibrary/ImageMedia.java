package MediaLibrary;

import java.util.Vector;

/**
 * @author: Callum Jenkins
 * 09/10/2020
 * <p>
 * Class: ImageMedia
 */

public class ImageMedia extends Media {
    /**
     * @param mName        - Media name
     * @param mDescription - Media description
     * @param mFilePath - Media file path
     */

    private String mFilePath;
    private Vector<String> mCatagories = new Vector<String>();

    public ImageMedia(String mName, String mDescription, String mFilePath) {
        super(mName, mDescription);
        this.mFilePath = mFilePath;
    }

    public String getmFilePath() {
        return mFilePath;
    }

    public void setmFilePath(String mFilePath) {
        this.mFilePath = mFilePath;
    }

    public Vector getmCatagories() {
        return mCatagories;
    }

    public void setmCatagories(Vector<String> mCatagories) {
        this.mCatagories = mCatagories;
    }

    public enum MediaCatagories {
        PORTRAIT, LANDSCAPE, ABSTRACT
    }

    @Override
    public boolean addCategory(String mCatagory) {

        MediaCatagories[] catagories = MediaCatagories.values();

        for (int i = 0; i < MediaCatagories.values().length; i ++)
        {
            if (mCatagory.equalsIgnoreCase(String.valueOf(catagories[i])))
            {
                mCatagories.addElement(mCatagory);
                return true;
            }
        }

        return false;
    }

}
