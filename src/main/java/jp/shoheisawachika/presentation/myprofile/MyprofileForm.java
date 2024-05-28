package jp.shoheisawachika.presentation.myprofile;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyprofileForm {

	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String name;

	@Getter
	@Setter
    private String cleartextPassword;

	@Getter
	@Setter
	@Length(min=0, max=10)
    private String description;

	@Getter
	@Setter
    private int updateCount;
}
