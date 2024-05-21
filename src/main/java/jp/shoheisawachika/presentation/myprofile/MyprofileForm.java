package jp.shoheisawachika.presentation.myprofile;

import jakarta.validation.constraints.Size;
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
	@Size(max = 10, message = "{0}は0～10桁を入力してください")
    private String description;
}
