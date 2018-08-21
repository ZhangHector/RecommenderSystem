package edu.carleton.comp4601.computer;

import java.util.ArrayList;
import java.util.List;

import edu.carleton.comp4601.model.Review;
import edu.carleton.comp4601.model.User;
import edu.carleton.comp4601.utils.CSV;
import edu.carleton.comp4601.utils.Constants;

public class GenreComputer implements FeatureComputer {

	@Override
	public void computeFeature(User user) {
		List<Review> searchResults = new ArrayList<>();
		for (Review review : CSV.readReviws())
			if (user.getName().equals(review.getUserName()))
				searchResults.add(review);
		int numComedy = 0;
		int numDrama = 0;
		int numFamily = 0;
		int numHorror = 0;
		int numOther = 0;
		double totalComedy = 0D;
		double totalDrama = 0D;
		double totalFamily = 0D;
		double totalHorror = 0D;
		double totalOther = 0D;
		if(searchResults.size() > 0) {
			for(Review review: searchResults){
				if (review.getGenre().equals(Constants.GENRE_COMEDY)) {
					totalComedy += review.getScore();
					numComedy++;
				} else if (review.getGenre().equals(Constants.GENRE_DRAMA)) {
					totalDrama += review.getScore();
					numDrama++;					
				} else if (review.getGenre().equals(Constants.GENRE_FAMILY)) {
					totalFamily += review.getScore();
					numFamily++;					
				} else if (review.getGenre().equals(Constants.GENRE_HORROR)) {
					totalHorror += review.getScore();
					numHorror++;					
				} else if (review.getGenre().equals(Constants.GENRE_OTHER)) {
					totalOther += review.getScore();
					numOther++;					
				}
			}
			user.setComedy(numComedy == 0 ? 0d : totalComedy/numComedy);
			user.setDrama(numDrama == 0 ? 0d : totalDrama/numDrama);
			user.setFamily(numFamily == 0 ? 0d : totalFamily/numFamily);
			user.setHorror(numHorror == 0 ? 0d : totalHorror/numHorror);
			user.setOther(numOther == 0 ? 0d : totalOther/numOther);
		} else {
			//System.out.println("No Reviews Found!");
		}	
	}

	@Override
	public void computeFeatureForAll(List<User> users) {
		for(User user: users)
			computeFeature(user);				
	}

}
