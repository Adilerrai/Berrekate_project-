package spring.berrekate.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import spring.berrekate.entities.ImageModel;
import spring.berrekate.repositories.ImageRepository;

@Service
@Transactional
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	public ImageModel createCityImages(MultipartFile file, int city_id) throws IOException {
		//public ImageModel(String name, String type, byte[] pic, int hotel_id, int restaurant_id, int touristAttraction_id, int event_id, int city_id, int user_id) {
			
		System.out.println("Ajunge sa creeze imagine pentru city?");
		

		ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(),0,0,0,0, city_id,0 );



		ImageModel savedImage = imageRepository.save(img);
		return savedImage;
	}
	
	public ImageModel createUserProfileImage(MultipartFile file, int user_id) throws IOException {
//		public ImageModel(String name, String type, byte[] pic, int hotel_id, int restaurant_id, int touristAttraction_id, int event_id, int city_id, int user_id) {
		
		ImageModel beforeImage=imageRepository.findUserImageById(user_id);
		if(beforeImage!=null)
			{
			ImageModel img = new ImageModel(beforeImage.getId(),file.getOriginalFilename(),file.getContentType(),file.getBytes());
			ImageModel savedImage = imageRepository.save(img);
			return savedImage;
			}
		else {
			ImageModel img = new ImageModel(file.getOriginalFilename(),file.getContentType(),file.getBytes(),0,0,0, 0,0,user_id);
			ImageModel savedImage = imageRepository.save(img);
			return savedImage;
		}
	}

	public ImageModel createHotelImages(MultipartFile file, int hotel_id) throws IOException {
		//apelam constuctorul de la ImageModel cu parametrii potriviti
		//public ImageModel(String name, String type, byte[] pic, int hotel_id, int restaurant_id, int touristAttraction_id, int event_id, int city_id, int user_id) {
			
		System.out.println("Ajunge sa creeze imagine pentru hotel?");
		

		ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(),hotel_id,0,0,0, 0,0 );

		ImageModel savedImage = imageRepository.save(img);

		return savedImage;
	}
	
	public ImageModel createRestaurantImages(MultipartFile file, int restaurant_id) throws IOException {
		//apelam constuctorul de la ImageModel cu parametrii potriviti
		//public ImageModel(String name, String type, byte[] pic, int hotel_id, int restaurant_id, int touristAttraction_id, int event_id, int city_id, int user_id) {
			
		System.out.println("Ajunge sa creeze imagine pentru restaurant?");
		

		ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(),0,restaurant_id,0,0, 0,0 );

		ImageModel savedImage = imageRepository.save(img);

		return savedImage;
	}
	
	//inserare imagini pentru atractiile turistice
	public ImageModel createTouristAttractionImages(MultipartFile file, int touristAttraction_id) throws IOException {
		//apelam constuctorul de la ImageModel cu parametrii potriviti
		//public ImageModel(String name, String type, byte[] pic, int hotel_id, int restaurant_id, int touristAttraction_id, int event_id, int city_id, int user_id) {
			
		System.out.println("Ajunge sa creeze imagine pentru touristAttraction?");
		

		ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(),0,0,touristAttraction_id,0, 0,0 );

		ImageModel savedImage = imageRepository.save(img);

		return savedImage;
	}
	
	//inserare imagini pentru events
	public ImageModel createEventImages(MultipartFile file, int event_id) throws IOException {



		ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes(),0,0,0,event_id, 0,0 );

		ImageModel savedImage = imageRepository.save(img);

		return savedImage;
	}

    public void deleteById(long imageID) {
		imageRepository.deleteById(imageID);
    }
}
