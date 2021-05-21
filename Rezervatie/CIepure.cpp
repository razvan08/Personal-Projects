#include "CIepure.h"
#include <iostream>
#include <fstream>
using namespace std;

CIepure::CIepure() :
	CAnimalIerbivor(), m_suprafata_minima(0) {}

CIepure::CIepure(string& nume, int data, int greutate, string& hrana, int cantitate, int suprafata_minima) :
	CAnimalIerbivor(nume, data, greutate, hrana, cantitate), m_suprafata_minima(suprafata_minima) {}

CIepure::~CIepure() {

}

void CIepure::citire(ifstream& f) {
	CAnimalIerbivor::citire(f);
	f >> m_suprafata_minima;
}

void CIepure::afisare(ofstream& g)const {
	CAnimalIerbivor::afisare(g);
	g << "Suprafata minima pe care poate locui: " << m_suprafata_minima << endl;
}