#include "CAnimalIerbivor.h"

CAnimalIerbivor::CAnimalIerbivor():
  CAnimal(){}

CAnimalIerbivor::CAnimalIerbivor(string& nume, int data, int greutate, string& hrana, int cantitate) :
	CAnimal(nume, data, greutate, hrana, cantitate) {}

CAnimalIerbivor::~CAnimalIerbivor() {

}