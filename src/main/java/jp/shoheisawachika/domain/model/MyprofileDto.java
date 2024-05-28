package jp.shoheisawachika.domain.model;

import jp.shoheisawachika.infrastructure.entity.SbtUserdata;
import jp.shoheisawachika.presentation.myprofile.MyprofileForm;
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
public class MyprofileDto {

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
    private String description;

	@Getter
	@Setter
    private int updateCount;
	
	public MyprofileDto(MyprofileForm myprofileForm) {
		this.id = myprofileForm.getId();
		this.name = myprofileForm.getName();
		this.cleartextPassword = myprofileForm.getCleartextPassword();
		this.description = myprofileForm.getDescription();
		this.updateCount = myprofileForm.getUpdateCount();
	}
	
	public MyprofileDto(SbtUserdata sbtUserdata) {
		this.id = sbtUserdata.getId();
		this.name = sbtUserdata.getName();
		this.cleartextPassword = "";
		this.description = sbtUserdata.getDescription();
		this.updateCount = sbtUserdata.getUpdateCount();
	}}
