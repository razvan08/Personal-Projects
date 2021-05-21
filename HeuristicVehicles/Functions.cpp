#include "Functions.h"

void moveVehicleUp(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;
		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setLinie(vehicle.getLinie() - 1);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;

		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);
		
}

void moveVehicleDown(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setLinie(vehicle.getLinie() + 1);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);
	     
}

void moveVehicleLeft(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setColoana(vehicle.getColoana() - 1);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);

}

void moveVehicleRight(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;
		
	    vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setColoana(vehicle.getColoana()+1);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);

}

void displayParking(int a[100][100],int dimension,ostream&g) {
	for (int i = 1;i<= dimension; i++) {
		for (int j = 1; j <= dimension; j++) {
			g<< a[i][j] << " ";
		}
		g << endl;
	}
}

void initializeParking(int a[100][100], int dimension) {
	for (int i = 1; i <= dimension; i++) {
		for (int j = 1; j <= dimension; j++) {
			if (i == dimension) {
				a[i][j] = j;
			}
			else {
				a[i][j] = 0;
			}
		}
	}
}

void initialzeVehicles(Vehicle v[10], int dimension) {
	for (int i = 1; i <= dimension; i++) {
		v[i].setLinie(dimension);
		v[i].setColoana(i);
		v[i].setLinieGoal(1);
		v[i].setColoanaGoal(dimension - i + 1);
	}

	for (int i = 1; i <= dimension; i++) {
		int distance = 0;

		distance = computeVehicleDestinationGoal(v[i].getLinie(), v[i].getColoana(), v[i].getLinieGoal(), v[i].getColoanaGoal());

		v[i].setDistantaGoal(distance);
	}

}


void jumpVehicleUp(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

	vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
	a[vehicle.getLinie()][vehicle.getColoana()] = 0;

	vehicle.setLinie(vehicle.getLinie() - 2);
	a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
	distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
	vehicle.setDistantaGoal(distance);
}
	

void jumpVehicleDown(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setLinie(vehicle.getLinie() + 2);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);
	
}

void jumpVehicleLeft(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setColoana(vehicle.getColoana() - 2);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);

}


void jumpVehicleRight(int a[100][100], Vehicle& vehicle) {
	int vehicleValue, distance;

		vehicleValue = a[vehicle.getLinie()][vehicle.getColoana()];
		a[vehicle.getLinie()][vehicle.getColoana()] = 0;

		vehicle.setColoana(vehicle.getColoana() + 2);
		a[vehicle.getLinie()][vehicle.getColoana()] = vehicleValue;
		distance = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		vehicle.setDistantaGoal(distance);

}

bool checkVehicleUp(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getLinie() == 1 || a[vehicle.getLinie() - 1][vehicle.getColoana()] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleDown(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getLinie() == dimension || a[vehicle.getLinie() + 1][vehicle.getColoana()] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleLeft(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getColoana() == 1 || a[vehicle.getLinie()][vehicle.getColoana() - 1] != 0) {
		return false;
	}
	else {
		return true;
	}

}

bool checkVehicleRight(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getColoana() == dimension || a[vehicle.getLinie()][vehicle.getColoana() + 1] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleJumpUp(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getLinie() <= 2 || a[vehicle.getLinie() - 1][vehicle.getColoana()] == 0
		|| (a[vehicle.getLinie() - 1][vehicle.getColoana()] != 0) && a[vehicle.getLinie() - 2][vehicle.getColoana()] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleJumpDown(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getLinie() >= dimension - 1 || a[vehicle.getLinie() + 1][vehicle.getColoana()] == 0
		|| (a[vehicle.getLinie() + 1][vehicle.getColoana()] != 0) && a[vehicle.getLinie() + 2][vehicle.getColoana()] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleJumpLeft(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getColoana() <= 2 || a[vehicle.getLinie()][vehicle.getColoana() - 1] == 0
		|| (a[vehicle.getLinie()][vehicle.getColoana() - 1] != 0) && a[vehicle.getLinie()][vehicle.getColoana() - 2] != 0) {
		return false;
	}
	else {
		return true;
	}
}

bool checkVehicleJumpRight(int a[100][100], int dimension, Vehicle& vehicle) {
	if (vehicle.getColoana() >= dimension - 1 || a[vehicle.getLinie()][vehicle.getColoana() + 1] == 0
		|| (a[vehicle.getLinie()][vehicle.getColoana() + 1] != 0) && a[vehicle.getLinie()][vehicle.getColoana() + 2] != 0) {
		return false;
	}
	else {
		return true;
	}
}

int computeDestinationGoalSum(Vehicle v[10], int dimension) {
	int sum = 0;

	for (int i = 1; i <= dimension; i++) {
		sum += v[i].getDistantaGoal();
	}
	return sum;
}

int computeVehicleDestinationGoal(int startLine, int startColumn, int endLine, int endColumn) {
	int sum = 0;
    
	sum = abs(startLine - endLine) + abs(startColumn - endColumn);

	return sum;
}


int generateBestVehicleOption(int a[100][100], int dimension, Vehicle& vehicle, string& move, int distanceGoal) {
	int copyDistance = distanceGoal;
	int actualGoal = 0;
	if (checkVehicleUp(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie() - 1, vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "UP";
		}
	}
	if (checkVehicleDown(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie() + 1, vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "DOWN";
		}
	}
	if (checkVehicleLeft(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana()-1, vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "LEFT";
		}
	}
	if (checkVehicleRight(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana() + 1, vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "RIGHT";
		}
	}
	if (checkVehicleJumpUp(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie()-2, vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "JUMPUP";
		}
	}
	if (checkVehicleJumpDown(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie()+2, vehicle.getColoana(), vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "JUMPDOWN";
		}
	}
	if (checkVehicleJumpLeft(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana()-2, vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "JUMPLEFT";
		}
	}
	if (checkVehicleJumpRight(a, dimension, vehicle) == true) {
		int nextGoal = computeVehicleDestinationGoal(vehicle.getLinie(), vehicle.getColoana()+2, vehicle.getLinieGoal(), vehicle.getColoanaGoal());
		actualGoal = distanceGoal - vehicle.getDistantaGoal() + nextGoal;

		if (actualGoal < copyDistance) {
			copyDistance = actualGoal;
			move = "JUMPRIGHT";
		}
	}
	return copyDistance;
}


bool checkGoal(int a[100][100], int b[100][100],int dimension) {
	int goodChecks = 0;
	for (int i = 1; i <= dimension; i++) {
		if (a[1][i] == b[1][i]) {
			goodChecks++;
		}
	}
	if (goodChecks == dimension) {
		return true;
	}
	else {
		return false;
	}
}

void initializeGoal(int a[100][100], int dimension) {
	for (int i = 1; i <= dimension; i++) {
		for (int j = 1; j <= dimension; j++) {
			if (i == 1) {
				a[i][j] = dimension - j + 1;
			}
			else {
				a[i][j] = 0;
			}
		}
	}
}

void checkVehicleMove(int a[100][100], string nextMove, Vehicle& vehicle) {
	if (nextMove == "UP") {
		moveVehicleUp(a, vehicle);
	}
	else if (nextMove == "DOWN") {
		moveVehicleDown(a, vehicle);
	}
	else if (nextMove == "LEFT") {
		moveVehicleLeft(a, vehicle);
	}
	else if (nextMove == "RIGHT") {
		moveVehicleRight(a, vehicle);
	}
	else if (nextMove == "JUMPUP") {
		jumpVehicleUp(a, vehicle);
	}
	else if (nextMove == "JUMPDOWN") {
		jumpVehicleDown(a, vehicle);
	}
	else if (nextMove == "JUMPLEFT") {
		jumpVehicleLeft(a, vehicle);
	}
	else if (nextMove == "JUMPRIGHT") {
		jumpVehicleRight(a, vehicle);
	}
}