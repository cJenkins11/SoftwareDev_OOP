package MediaLibrary;

/**
 * A class to test the MediaLibrary
 */
public class MediaLibraryTest_w3 {
	/**
	 * A set of acceptance tests for MediaLibrary.
	 */
	public void acceptanceTest(MediaLibrary library){
		System.out.println("*******************");
		System.out.println("Insert Media test\n");
		// create some clearly defined test data, we can see quickly if it is in order when outputted
		/*library.addMedia(new Media("Explosion", "A short explosion sound."));
		library.addMedia(new Media("Future Legend", "David Bowie, Future Legend."));
		library.addMedia(new Media("Landscape", "A very pretty landscape, with a tree."));
		library.addMedia(new Media("Abstract", "Priceless."));
		library.addMedia(new Media("Portrait", "A business bloke."));*/
		
		// test if the media is in library and in sorted order by printing
		library.printMedia();
		System.out.println("*******************");

		System.out.println("*******************");
		System.out.println("Search library test\n");
		Media searchResult = library.findMedia("Landscape");
		if(searchResult != null){
			System.out.println("Success : Landscape found");
		}else{
			System.out.println("Fail : Landscape not found");
		}
		
		searchResult = library.findMedia("Abstract");
		if(searchResult != null){
			System.out.println("Success : Abstract found");
		}else{
			System.out.println("Fail : Landscape not found");
		}
		
		searchResult = library.findMedia("Portrait");
		if(searchResult != null){
			System.out.println("Success : Portrait found");
		}else{
			System.out.println("Fail : Portrait not found");
		}
		
		searchResult = library.findMedia("AnotherLandscape");
		if(searchResult != null){
			System.out.println("Fail : AnotherLandscape found");
			System.out.println(searchResult);
		}else{
			System.out.println("Success : AnotherLandscape not found");
		}
		
		searchResult = library.findMedia("Future Legend");
		if(searchResult != null){
			System.out.println("Success : Future Legend found");
		}else{
			System.out.println("Fail : Future Legend not found");
		}
		searchResult = library.findMedia("Explosion");
		if(searchResult != null){
			System.out.println("Success : Explosion found");
		}else{
			System.out.println("Fail : Explosion not found");
		}

		searchResult = library.findMedia("DifferentSound");
		if(searchResult != null){
			System.out.println("Fail : DifferentSound found");
			System.out.println(searchResult);
		}else{
			System.out.println("Success : DifferentSound not found");
		}
		System.out.println("*******************");
	}
}
