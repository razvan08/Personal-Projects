#pragma once
#include "CAnimalCarnivor.h"

class CVulpe:public CAnimalCarnivor
{
public:
	CVulpe();
	CVulpe(string& nume, int data, int greutate, string& hrana, int cantitate, int temperatura, string& tip);
	~CVulpe();
	void citire(ifstream& f)override;
	void afisare(ofstream& g)const override;
private:
	int m_temperatura_max;
	string m_tip;
};

