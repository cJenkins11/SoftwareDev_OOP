package MediaLibrary;/*
Callum Jenkins
Title
24/09/2020 of 09, 2020
*/

public abstract class Media {

    private String mName;
    private String mDescription;

    /**
     *
     * @param mName - Media name
     * @param mDescription - Media description
     */
    public Media(String mName, String mDescription) {
        this.mName = mName;
        this.mDescription = mDescription;
    }

    /**
     *
     * @return mName - Media name
     */
    public String getmName() {
        return mName;
    }

    /**
     *
     * @param mName - New media name
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     *
     * @return mDescription - Media description
     */
    public String getmDescription() {
        return mDescription;
    }

    /**
     *
     * @param mDescription - New media description
     */
    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public abstract boolean addCategory(String mCatagory);
}
