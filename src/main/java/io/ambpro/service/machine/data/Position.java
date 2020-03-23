package io.ambpro.service.machine.data;

import io.ambpro.utils.commande.Orientation;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Position {
	private int x;
	private int y;
	private Orientation orientation;

	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.orientation;
	}
}
