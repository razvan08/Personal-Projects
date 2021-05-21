#include "Vehicle.h"



Vehicle::Vehicle() {
	this->linie = 0;
	this->coloana = 0;
	this->distantaGoal = 0;
	this->linieGoal = 0;
	this->coloanaGoal = 0;
}

Vehicle::~Vehicle() {

}

int Vehicle::getLinie()const {
	return this->linie;
}

int Vehicle::getColoana()const {
	return this->coloana;
}

void Vehicle::setLinie(int lin) {
	this->linie = lin;
}

void Vehicle::setColoana(int col) {
	this->coloana = col;
}

int Vehicle::getDistantaGoal()const {
	return this->distantaGoal;
}

void Vehicle::setDistantaGoal(int distanta) {
	this->distantaGoal = distanta;
}

int Vehicle::getLinieGoal()const {
	return this->linieGoal;
}
void Vehicle::setLinieGoal(int linieG) {
	this->linieGoal = linieG;
}
int Vehicle::getColoanaGoal()const {
	return this->coloanaGoal;
}
void Vehicle::setColoanaGoal(int coloanaG) {
	this->coloanaGoal = coloanaG;
}