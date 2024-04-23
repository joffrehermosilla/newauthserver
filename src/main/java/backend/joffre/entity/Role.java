package backend.joffre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import backend.joffre.enums.RoleName;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private RoleName role;

	@Override
	public String getAuthority() {
		return role.name();
	}
}
