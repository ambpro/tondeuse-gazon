package io.ambpro.service.machine.data;

import io.ambpro.service.machine.api.IMachine;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Surface {
	private IMachine[][] machines;
	private int ordonneeMax;
	private int abscisseMax;
	private static Surface INSTANCE = new Surface();

	public static Surface getSurface() {
		return INSTANCE;
	}

	/**
	 * Changer la postion d une tondeuse sur la surface
	 * 
	 * @param machine     : tondeuse avec sa postion actuelle
	 * @param newPosition : nouvelle position demandee
	 */
	public void changerPosition(IMachine machine, Position newPosition) {
		if (positionValide(machine.getPosition(), newPosition) && machines[machine.getPosition().getX()][machine.getPosition().getY()] == machine) {
			machines[machine.getPosition().getX()][machine.getPosition().getY()] = null;
			machine.setPosition(newPosition);
			machines[newPosition.getX()][newPosition.getY()] = machine;
		}
	}

	/**
	 * Ajouter une tondeuse sur la surface
	 * 
	 * @param machine : tondeuse a ajouter
	 */
	public void addMachine(IMachine machine) {
		Position positionTondeuse = machine.getPosition();
		if (positionValide(positionTondeuse)) {
			machines[positionTondeuse.getX()][positionTondeuse.getY()] = machine;
		}
	}

	/**
	 * Indique si la postion existe sur la surface
	 * 
	 * @param position
	 * @return : true si position valide sinon false
	 */
	private boolean positionValide(Position position) {
		if (position.getX() <= abscisseMax && position.getY() <= ordonneeMax && position.getX() >= 0
				&& position.getY() >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Indique si toutes les postions existent sur la surface
	 * 
	 * @param : List of Positions
	 * @return : true si position valide sinon false
	 */
	private boolean positionValide(Position... positions) {
		boolean positionValide = true;

		if (positions == null) {
			positionValide = false;
		} else {
			for (Position position : positions) {
				if (position.getX() >= abscisseMax || position.getY() >= ordonneeMax || position.getX() < 0 || position.getY() < 0) {
					return positionValide = false;
				}
			}
		}
		return positionValide;
	}
}
