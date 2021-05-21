#include "CLeu.h"
#include <iostream>
#include <fstream>
using namespace std;

CLeu::CLeu() :
	CAnimalCarnivor(), m_temperatura_min(0), m_tara("") {}

CLeu::CLeu(string& nume, int data, int greutate, string& hrana, int cantitate, int temperatura, string& tara) :
	CAnimalCarnivor(nume, data, greutate, hrana, cantitate), m_temperatura_min(temperatura), m_tara(tara) {}

CLeu::~CLeu() {
	
}

void CLeu::citire(ifstream& f) {
	CAnimalCarnivor::citire(f);
	f >> m_temperatura_min;
	f >> m_tara;
}

void CLeu::afisare(ofstream& g)const {
	CAnimalCarnivor::afisare(g);
	g << "Temperatura minima suportata: " << m_temperatura_min << endl;
	g << "Tara de provenienta: " << m_tara << endl;
}