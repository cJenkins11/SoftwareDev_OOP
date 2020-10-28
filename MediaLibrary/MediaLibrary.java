package MediaLibrary;/*
Callum Jenkins
Title
24/09/2020 of 09, 2020
*/

import java.util.stream.IntStream;

public class MediaLibrary {

    //private Media item;
    private Media[] content;

    public MediaLibrary() {
        content = new Media[1];
    }

    public void addMedia(Media mediaToAdd) {

        Media[] newContent;
        int index;
        int originalLength = content.length;

        /*
        If the last index is not null, create new mediaArray[i + 1]
         */
        if (content[originalLength - 1] != null)
        {
            newContent = new Media[originalLength + 1];

            for (int i = 0; i < originalLength; i++ )
            {
                newContent[i] = content[i];
            }
            newContent[originalLength] = mediaToAdd;
            this.content = newContent;
        }
        /*
        Else finds next null index, adds media to array at index
        */
        else
        {
            index = IntStream.range(0, originalLength)
                            .filter(j -> content[j] == null)
                            .findFirst()
                            .orElse(-1);

            if (index != -1)
            {
                content[index] = mediaToAdd;
            }
            //Else, handle error
        }
    }

    /**
     *
     * @return
     */
    public Media[] getContent() {
        return this.content;
    }

    public void printMedia() {
        for (int k = 0; k < content.length; k ++)
        {
            System.out.println("Name: " + content[k].getmName());
            System.out.println("Description: " + content[k].getmDescription());
            System.out.println(" ");
        }
    }

    public Media findMedia(String searchTerm) {

        for (int k = 0; k < content.length; k++)
        {
             if (content[k].getmName().equals(searchTerm))
             {
                 return content[k];
             }
        }
        return null;
    }

    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        //MediaLibraryTest_w3 libraryTest = new MediaLibraryTest_w3();
        MediaLibraryTest_w4 libraryTest = new MediaLibraryTest_w4();

        libraryTest.acceptanceTest(library);
    }
}
