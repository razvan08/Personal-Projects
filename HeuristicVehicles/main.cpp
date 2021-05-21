#include "Functions.h"
#include <fstream>


int main() {

	ifstream f("Test10Input.txt");
	ofstream g("Test10Output.txt");

	int parking[100][100], goalParking[100][100];
	Vehicle vehicles[100];
	string move = "";
	string nextMove = "";
	int m, goalDistance, copyGoalDistance, VehicleToMove;
	f >> m;

	//Initializam parcarea goal la care vrem sa ajungem dupa ce mutam vehiculele
	initializeGoal(goalParking, m);
	//Initializam parcarea cu vehiculele pe pozitiile de start
	initializeParking(parking, m);
	//Initializam vehiculele la atributele initiale
	initialzeVehicles(vehicles, m);

	//Calculam cat de departe de aflam de parcarea goal
	//Distanta fata de goal reprezinta suma tuturor distantelor pentru fiecare vehicul fata de pozitia finala
    goalDistance = computeDestinationGoalSum(vehicles, m);
	
	//Retinem o copie a distantei fata de goal de la care am pornit
	copyGoalDistance = goalDistance;
	//In variabila VehicleToMove retinem pozitia vehiculului care trebuia sa faca urmatoarea miscare
	VehicleToMove = 0;
	
	//Cat timp parcarea actuala este diferita de goal executam urmatorii pasi:
	while (checkGoal(parking, goalParking, m) != true) {

		//Parcurgem toate vehiculele din parcare 
		for (int i = 1; i <= m; i++) {
			//Pentru fiecare vehicul generam cea mai buna miscare pe care o poate face la momentul respectiv
			int currentGoalDistance = generateBestVehicleOption(parking, m, vehicles[i], move, goalDistance);
			//Daca cea mai buna miscare a vehicului genereaza o distanta mai mica fata de goal
			// actualizam noua distanta fata de goal , retinem pozitia care a generat aceea solutie pentru a putea deplasa vehiculul,
			// de asemenea retinem si miscarea care trebuie executata
			if (currentGoalDistance < copyGoalDistance) {
				copyGoalDistance = currentGoalDistance;
				VehicleToMove = i;
				nextMove = move;
			}
			//Intrucat executam aceiasi pasi pentru toate vehiculele rezulta ca la finalul executiei
			// se va genera cea mai optima solutie la un anumit moment. Daca 2 miscari genereaza acelasi rezultat optim
			// algoritmul va alege pe primul generat .
		}
		goalDistance = copyGoalDistance;
		checkVehicleMove(parking, nextMove, vehicles[VehicleToMove]);
		g << nextMove << " " << VehicleToMove << endl;
	}

	g << "Matrix after all moves:" << endl;
	displayParking(parking, m,g);
	
	f.close();
	g.close();


	return 0;
}