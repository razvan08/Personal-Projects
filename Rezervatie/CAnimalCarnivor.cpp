#include "CAnimalCarnivor.h"

CAnimalCarnivor::CAnimalCarnivor() :
	CAnimal() {}


CAnimalCarnivor::CAnimalCarnivor(string& nume, int data, int greutate, string& hrana, int cantitate) :
	CAnimal(nume, data, greutate, hrana, cantitate) {}

CAnimalCarnivor::~CAnimalCarnivor() {

}