package jp.shoheisawachika.infrastructure.entity;

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
public class SbtRole {

	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String no;

	@Getter
	@Setter
    private String name;

}
