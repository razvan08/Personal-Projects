#include "CVulpe.h"
#include <iostream>
#include <fstream>
using namespace std;

CVulpe::CVulpe() :
	CAnimalCarnivor(), m_temperatura_max(0), m_tip("") {}

CVulpe::CVulpe(string& nume, int data, int greutate, string& hrana, int cantitate, int temperatura, string& tip) :
	CAnimalCarnivor(nume, data, greutate, hrana, cantitate), m_temperatura_max(temperatura), m_tip(tip) {}

CVulpe::~CVulpe() {
	
}

void CVulpe::citire(ifstream& f) {
	CAnimalCarnivor::citire(f);
	f >> m_temperatura_max;
	f >> m_tip;
}

void CVulpe::afisare(ofstream& g)const {
	CAnimalCarnivor::afisare(g);
	g << "Temperatura maxima la care rezista: " << m_temperatura_max << endl;
	g << "Tipul vulpii este: " << m_tip << endl;
}