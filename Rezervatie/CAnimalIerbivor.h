#pragma once
#include "CAnimal.h"

class CAnimalIerbivor:public CAnimal
{
public:
	CAnimalIerbivor();
	CAnimalIerbivor(string& nume, int data, int greutate, string& hrana, int cantitate);
	virtual ~CAnimalIerbivor()=0;
};

