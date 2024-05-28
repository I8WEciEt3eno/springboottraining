package jp.shoheisawachika.infrastructure.entity;

import java.util.List;

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
public class SbtUserdata {

	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String name;

	@Getter
	@Setter
    private String password;

	@Getter
	@Setter
    private String description;

	@Getter
	@Setter
    private int updateCount;

	@Getter
	@Setter
    private List<SbtRole> roles;
}
