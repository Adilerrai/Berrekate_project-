//package spring.licenta.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import spring.licenta.dto.CommentDTO;
//import spring.licenta.jwt.MessageResponse;
//import spring.licenta.repositories.CommentRepository;
//import spring.licenta.services.CommentService;
//
//
//
//@CrossOrigin(maxAge = 3600)
//@RestController
//@RequestMapping("/comments")
//public class CommentsController {
//	@Autowired
//	private CommentService commentService;
//
//
//
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public List<CommentDTO> getAllComments() {
//		return commentService.findAll();
//	}
//
//
//	@RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET)
//	public List<CommentDTO> getAllHotelCommentsById(@PathVariable("id") int hotel_id) {
//		return commentService.findAllHotelCommentsById(hotel_id);
//	}
//
//	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
//	public List<CommentDTO> getAllEventCommentsById(@PathVariable("id") int event_id) {
//		return commentService.findAllEventCommentsById(event_id);
//	}
//	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
//	public List<CommentDTO> getAllRestaurantCommentsById(@PathVariable("id") int restaurant_id) {
//		return commentService.findAllRestaurantCommentsById(restaurant_id);
//	}
//	@RequestMapping(value = "/touristAttraction/{id}", method = RequestMethod.GET)
//	public List<CommentDTO> getAllTouristAttractionCommentsById(@PathVariable("id") int touristAttraction_id) {
//		return commentService.findAllTouristAttractionCommentsById(touristAttraction_id);
//	}
//
//	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
//	public CommentDTO getCommentById(@PathVariable("id") int id) {
//		return commentService.findCommentById(id);
//	}
//
//
//
//	  @RequestMapping(value = "/insert", method = RequestMethod.POST)
//	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	  public CommentRepository insertComment(@RequestBody CommentDTO commentDTO) {
//		  return (CommentRepository) commentService.create(commentDTO);
//	  }
//
//		@RequestMapping(value = "/edit", method = RequestMethod.PUT)
//		public ResponseEntity<?> editComment(@RequestBody CommentDTO commentDTO){
//
//			commentService.updateComment(commentDTO);
//			return ResponseEntity.ok(new MessageResponse("Hotel updated successfully!"));
//		}
//
//	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
//	public void removeComment(@PathVariable("id") int id) {
//		CommentDTO comment = commentService.findCommentById(id);
//		if (comment == null) {
//			System.out.println("Unable to delete. comment with id " + id + " not found");
//		}
//		commentService.deleteCommentById(id);
//	}
//
//
//	@RequestMapping(value = "/restaurant/statistics/{id}", method = RequestMethod.GET)
//	public List<Double> getAllRestaurantRatingsById(@PathVariable("id") int restaurant_id) {
//		return commentService.getCommentsByRatingRestaurant(restaurant_id);
//	}
//
//	@RequestMapping(value = "/touristAttraction/statistics/{id}", method = RequestMethod.GET)
//	public List<Double> getAllTouristAttractionRatingsById(@PathVariable("id") int touristAttraction_id) {
//		return commentService.getCommentsByRatingRestaurant(touristAttraction_id);
//	}
//}
