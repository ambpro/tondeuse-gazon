package org.ambpro.service.machine.data;

import org.ambpro.utils.commande.Orientation;

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
