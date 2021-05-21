#pragma once
#include "CAnimalIerbivor.h"

class CIepure:public CAnimalIerbivor
{
public:
	CIepure();
	CIepure(string& nume, int data, int greutate, string& hrana, int cantitate,int suprafata_minima);
	~CIepure();
	void citire(ifstream& f)override;
	void afisare(ofstream& g)const override;
private:
	int m_suprafata_minima;
};

