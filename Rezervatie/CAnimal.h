#pragma once
#include <iostream>
#include <string>
using namespace std;

class CAnimal
{public:
	CAnimal();
	CAnimal(string &nume,int data,int greutate,string& hrana,int cantitate);
	virtual ~CAnimal()=0;
	virtual void citire(ifstream& f);
	virtual void afisare(ofstream& g)const;
private:
	string m_nume;
	int m_data;
	int m_greutate;
	string m_hrana_preferata;
	int m_cantitate_zi;
};

