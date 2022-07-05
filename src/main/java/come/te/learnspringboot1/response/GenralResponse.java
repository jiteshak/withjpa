package come.te.learnspringboot1.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenralResponse {
	private HttpStatus status;
	private String error;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private Object data;
	

	public GenralResponse(HttpStatus status, String error, String message, Object data) {

		super();
		this.status= status;
		this.error = error;
		this.message= message;
		this.data=data ;
	}
}
